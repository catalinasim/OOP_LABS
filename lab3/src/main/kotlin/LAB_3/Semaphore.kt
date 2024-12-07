package LAB_3

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

class Semaphore(
    private var carStationList: List<CarStation>,
) {
    // getter for carStationList
    fun getCarStationList(): List<CarStation> {
        return carStationList
    }

    private val mapper = jacksonObjectMapper()
    // method to deserialize the json into cars
    private fun mapCar(text: String): Car {
        val car: Car = mapper.readValue(text)
        return car
    }
    // method to iterate through a list of jsons and deserialize the cars
    private fun readMultipleCars(stringCarQueue: Queue<String>): Queue<Car> {
        val carQueue = LinkedListQueue<Car>()
        for (i in 0 until stringCarQueue.size()) {
            val carString = stringCarQueue.dequeue() ?: continue
            carQueue.enqueue(mapCar(carString))
        }
        return carQueue
    }
    // method to guide the cars to their respective station
    private fun guideCar(car: Car) {
        if (car.type == CarTypes.ELECTRIC && car.passengers == PassengerTypes.PEOPLE) {
            carStationList.find {
                it.getRefuellingService() is ElectricStation && it.getDinningService() is PeopleDinner
            }?.addCar(car)
        }

        if (car.type == CarTypes.GAS && car.passengers == PassengerTypes.PEOPLE) {
            carStationList.find {
                it.getRefuellingService() is GasStation && it.getDinningService() is PeopleDinner
            }?.addCar(car)
        }

        if (car.type == CarTypes.ELECTRIC && car.passengers == PassengerTypes.ROBOTS) {
            carStationList.find {
                it.getRefuellingService() is ElectricStation && it.getDinningService() is RobotDinner
            }?.addCar(car)
        }

        if (car.type == CarTypes.GAS && car.passengers == PassengerTypes.ROBOTS) {
            carStationList.find {
                it.getRefuellingService() is GasStation && it.getDinningService() is RobotDinner
            }?.addCar(car)
        }
    }
    // method to serve the cars
    fun serveCars(stringCarQueue: Queue<String>) {
        val processedQueue = readMultipleCars(stringCarQueue)
        while (processedQueue.size() > 0) {
            val car = processedQueue.dequeue() ?: continue
            guideCar(car)
        }
    }
}