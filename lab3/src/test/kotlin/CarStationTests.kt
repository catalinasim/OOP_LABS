import LAB_3.*
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.random.Random
import kotlin.test.Test

class CarStationTests {

    private fun createElectricCarWithPeopleQueue(): Queue<Car> {
        val carArray = ArrayUpQueue<Car>(3)
        for (i in 0 until 3) {
            val car = Car(
                id = Random.nextInt(1000, 9999),
                type = CarTypes.ELECTRIC,
                passengers = PassengerTypes.PEOPLE,
                isDining = Random.nextBoolean(),
                consumption = Random.nextInt(0, 50)
            )
            carArray.enqueue(car)
        }
        return carArray
    }

    private fun createGasCarWithRobotsQueue(): Queue<Car> {
        val carArray = ArrayDownQueue<Car>(3)
        for (i in 0 until 3) {
            val car = Car(
                id = Random.nextInt(1000, 9999),  // Assign unique ID
                type = CarTypes.GAS,
                passengers = PassengerTypes.ROBOTS,
                isDining = Random.nextBoolean(),
                consumption = Random.nextInt(0, 50)
            )
            carArray.enqueue(car)
        }
        return carArray
    }

    private fun createGasCarWithPeopleQueue(): Queue<Car> {
        val carArray = LinkedListQueue<Car>()
        for (i in 0 until 3) {
            val car = Car(
                id = Random.nextInt(1000, 9999),
                type = CarTypes.GAS,
                passengers = PassengerTypes.PEOPLE,
                isDining = Random.nextBoolean(),
                consumption = Random.nextInt(0, 50)
            )
            carArray.enqueue(car)
        }
        return carArray
    }

    private fun createElectricPeopleCarStation(): CarStation {
        val carArray = createElectricCarWithPeopleQueue()
        return CarStation(PeopleDinner(), ElectricStation(), carArray)
    }

    private fun createGasRobotCarStation(): CarStation {
        val carArray = createGasCarWithRobotsQueue()
        return CarStation(RobotDinner(), GasStation(), carArray)
    }

    private fun createGasPeopleCarStation(): CarStation {
        val carArray = createGasCarWithPeopleQueue()
        return CarStation(PeopleDinner(), GasStation(), carArray)
    }

    @Test
    fun testElectricCarStation() {
        val carStation = createElectricPeopleCarStation()
        carStation.serveCars()
        assertEquals(carStation.getQueue().size(), 0)
        carStation.addCar(
            Car(
                id = 4,
                type = CarTypes.ELECTRIC,
                passengers = PassengerTypes.PEOPLE,
                isDining = Random.nextBoolean(),
                consumption = Random.nextInt(0, 50)
            )
        )
        assertEquals(carStation.getQueue().size(), 1)
    }

    @Test
    fun testGasCarStation() {
        val carStation = createGasRobotCarStation()
        carStation.serveCars()
        assertEquals(carStation.getQueue().size(), 0)
        carStation.addCar(
            Car(
                id = 4,
                type = CarTypes.GAS,
                passengers = PassengerTypes.ROBOTS,
                isDining = Random.nextBoolean(),
                consumption = Random.nextInt(0, 50)
            )
        )
        assertEquals(carStation.getQueue().size(), 1)
        var CarStation2 = createGasPeopleCarStation()
        CarStation2.serveCars()
        assertEquals(CarStation2.getQueue().size(), 0)
        CarStation2.addCar(
            Car(
                id = 4,
                type = CarTypes.GAS,
                passengers = PassengerTypes.PEOPLE,
                isDining = Random.nextBoolean(),
                consumption = Random.nextInt(0, 50)
            )
        )
        assertEquals(CarStation2.getQueue().size(), 1)
    }
}