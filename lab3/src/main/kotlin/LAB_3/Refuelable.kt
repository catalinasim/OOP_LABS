package LAB_3

interface Refuelable {
    // companion object to store count of electric and gas cars served across all stations
    companion object {
        var electricCarsCount = 0
        fun incrementElectricCarsCount() {
            electricCarsCount++
        }
        var gasCarsCount = 0
        fun incrementGasCarsCount() {
            gasCarsCount++
        }
    }
    // method definition for refuel
    fun refuel(carId: String)
}