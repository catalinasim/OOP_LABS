import LAB_3.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test

class SemaphoreTests {

    private fun initializeList(): Queue<String> {
        val text = LinkedListQueue<String>()
        text.enqueue("{\"id\": 1, \"type\": \"GAS\", \"passengers\": \"PEOPLE\", \"isDining\": true, \"consumption\": 45}")
        text.enqueue("{\"id\": 2, \"type\": \"GAS\", \"passengers\": \"PEOPLE\", \"isDining\": true, \"consumption\": 37}")
        text.enqueue("{\"id\": 3, \"type\": \"ELECTRIC\", \"passengers\": \"ROBOTS\", \"isDining\": false, \"consumption\": 45}")
        text.enqueue("{\"id\": 4, \"type\": \"ELECTRIC\", \"passengers\": \"PEOPLE\", \"isDining\": false, \"consumption\": 19}")
        text.enqueue("{\"id\": 5, \"type\": \"ELECTRIC\", \"passengers\": \"ROBOTS\", \"isDining\": true, \"consumption\": 17}")
        return text
    }

    @BeforeEach
    fun clearGlobalVariables() {
        // Reset global counters to 0
        Dineable.peopleCount = 0
        Dineable.robotCount = 0
        Refuelable.electricCarsCount = 0
        Refuelable.gasCarsCount = 0
    }

    private fun intializeCarStations(): List<CarStation> {
        val stationsList = buildList {
            add(CarStation(PeopleDinner(), ElectricStation(), ArrayDownQueue(10)))
            add(CarStation(RobotDinner(), ElectricStation(), ArrayUpQueue(10)))
            add(CarStation(PeopleDinner(), GasStation(), LinkedListQueue()))
            add(CarStation(RobotDinner(), GasStation(), LinkedListQueue()))
        }
        return stationsList
    }

    @Test
    fun testGasCarStations() {
        var initialString = initializeList()
        var stations = intializeCarStations()
        var semaphore = Semaphore(stations)
        semaphore.serveCars(initialString)
        stations[2].serveCars()
        stations[3].serveCars()
        assertEquals(Refuelable.gasCarsCount, 2)
    }

    @Test
    fun testElectricCarStations() {
        var initialString = initializeList()
        var stations = intializeCarStations()
        var semaphore = Semaphore(stations)
        semaphore.serveCars(initialString)
        stations[0].serveCars()
        stations[1].serveCars()
        assertEquals(Refuelable.electricCarsCount, 3)
    }

    @Test
    fun testPeopleCarStations() {
        var initialString = initializeList()
        var stations = intializeCarStations()
        var semaphore = Semaphore(stations)
        semaphore.serveCars(initialString)
        stations[0].serveCars()
        stations[2].serveCars()
        assertEquals(Dineable.peopleCount, 2)
    }

    @Test
    fun testRobotsCarStations() {
        var initialString = initializeList()
        var stations = intializeCarStations()
        var semaphore = Semaphore(stations)
        semaphore.serveCars(initialString)
        stations[1].serveCars()
        stations[3].serveCars()
        assertEquals(Dineable.robotCount, 1)
    }


}