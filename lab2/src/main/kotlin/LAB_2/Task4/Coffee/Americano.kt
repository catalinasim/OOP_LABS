package LAB_2.Task4.Coffee

import Intensity

internal class Americano(
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
        super.prepareCoffee()
        println("Adding $waterVolume ml of water")
        return this
    }
}
