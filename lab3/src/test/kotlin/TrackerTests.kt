import LAB_3.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TrackerTests {

    @BeforeEach
    fun clearGlobalVariables() {
        // Reset global counters to 0
        Dineable.peopleCount = 0
        Dineable.robotCount = 0
        Refuelable.electricCarsCount = 0
        Refuelable.gasCarsCount = 0
    }

    @Test
    fun testPeopleTracker() {
        val peopleDinner1 = PeopleDinner()
        val peopleDinner2 = PeopleDinner()
        peopleDinner1.serveDinner("1")
        peopleDinner2.serveDinner("2")
        peopleDinner1.serveDinner("3")
        peopleDinner2.serveDinner("4")
        val robotDinner1 = RobotDinner()
        robotDinner1.serveDinner("1")
        assertEquals(Dineable.peopleCount, 4)
    }

    @Test
    fun testRobotTracker() {
        val robotDinner1 = RobotDinner()
        val robotDinner2 = RobotDinner()
        robotDinner1.serveDinner("1")
        robotDinner2.serveDinner("2")
        robotDinner1.serveDinner("3")
        val peopleDinner1 = PeopleDinner()
        peopleDinner1.serveDinner("1")
        assertEquals(Dineable.robotCount, 3)
    }

    @Test
    fun testElectricCarTracker() {
        val electricStation1 = ElectricStation()
        val electricStation2 = ElectricStation()
        val gasStation1 = GasStation()
        electricStation1.refuel("1")
        electricStation2.refuel("2")
        electricStation1.refuel("3")
        gasStation1.refuel("4")
        assertEquals(Refuelable.electricCarsCount, 3)
    }

    @Test
    fun testGasCarTracker() {
        val gasStation1 = GasStation()
        val gasStation2 = GasStation()
        val electricStation1 = ElectricStation()
        gasStation1.refuel("1")
        gasStation2.refuel("2")
        gasStation1.refuel("3")
        electricStation1.refuel("4")
        assertEquals(Refuelable.gasCarsCount, 3)
    }

}