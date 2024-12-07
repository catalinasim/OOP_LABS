package LAB_3

class ElectricStation : Refuelable {
    override fun refuel(carId: String) {
        println("Refueling electric car #$carId.")
        // Increment the number of electric cars served
        Refuelable.incrementElectricCarsCount()
    }
}