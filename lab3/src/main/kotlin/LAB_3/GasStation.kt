package LAB_3

class GasStation : Refuelable {
    override fun refuel(carId: String) {
        println("Refueling gas car #$carId.")
        // Increment the number of gas cars served
        Refuelable.incrementGasCarsCount()
    }
}