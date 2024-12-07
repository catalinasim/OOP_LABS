package LAB_3

import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import java.io.File

fun main() = runBlocking {
    val stationsList = buildList {
        add(CarStation(PeopleDinner(), ElectricStation(), ArrayDownQueue(10)))
        add(CarStation(RobotDinner(), ElectricStation(), ArrayUpQueue(10)))
        add(CarStation(PeopleDinner(), GasStation(), LinkedListQueue()))
        add(CarStation(RobotDinner(), GasStation(), LinkedListQueue()))
    }

    val semaphore = Semaphore(stationsList)
    val jsonQueue = LinkedListQueue<String>()
    val queueMutex = Mutex()

    // Coroutine for handling JSON files and adding to queue
    val jsonHandlerJob = launch {
        while (isActive) {
            queueMutex.withLock {
                val folder = File("src/main/resources/Lab3/queue")
                folder.listFiles { file -> file.extension == "json" }?.forEach { file ->
                    val jsonContent = file.readText()
                    println("Adding car from file: ${file.name}")
                    jsonQueue.enqueue(jsonContent)
                    file.delete()
                }
            }
            delay(1000L)
        }
    }

    // Coroutine for serving cars
    val carServingJob = launch {
        while (isActive) {
            val carsToServeQueue = LinkedListQueue<String>()
            queueMutex.withLock {
                while (!jsonQueue.isEmpty()) {
                    jsonQueue.dequeue()?.let { carsToServeQueue.enqueue(it) }
                }
            }

            semaphore.serveCars(carsToServeQueue)
            semaphore.getCarStationList().forEach { carStation ->
                carStation.serveCars()
            }

            delay(7000L)
        }
    }

    joinAll(jsonHandlerJob, carServingJob)
}