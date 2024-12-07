package LAB_2.Task3

import Intensity

class Americano(
    private var coffeeIntensity: Intensity,
    private var waterVolume: Int,
    private val coffeeType: String = "Americano"
) : Coffee(coffeeIntensity, coffeeType) {

    // Overrides the method to include water details
    override fun displayCoffeeDetails() {
        super.displayCoffeeDetails()
        println("Water Volume: $waterVolume ml")
    }

    // Method to prepare an Americano
    fun prepareAmericano(): Americano {
        println("Preparing $coffeeType...")
        println("Coffee Intensity: $coffeeIntensity")
        println("Adding $waterVolume ml of water")
        return this
    }
}
