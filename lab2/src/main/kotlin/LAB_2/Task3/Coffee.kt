package LAB_2.Task3

import Intensity

open class Coffee(
    private var intensity: Intensity,
    private val coffeeName: String = "Coffee"
) {
    // Method to display coffee details
    open fun displayCoffeeDetails() {
        println("Recipe for $coffeeName")
        println("Coffee intensity: $intensity")
    }

    // Method to prepare coffee
    fun prepareCoffee(): Coffee {
        println("Preparing $coffeeName...")
        println("Setting intensity to $intensity")
        return Coffee(intensity, coffeeName)
    }
}
