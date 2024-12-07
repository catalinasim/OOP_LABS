package LAB_2.Task2

import Intensity

class Americano(
    coffeeIntensity: Intensity,
    private val waterVolume: Int,
    coffeeType: String = "LAB_2.Task2.Americano"
) : Coffee(coffeeIntensity, coffeeType) {

    // Overrides printCoffeeDetails to include water details
    override fun displayCoffeeDetails() {
        super.displayCoffeeDetails()
        println("Water Volume: $waterVolume ml")
    }
}