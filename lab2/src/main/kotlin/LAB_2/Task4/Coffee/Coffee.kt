package LAB_2.Task4.Coffee

import Intensity

internal open class Coffee(
    private var intensity: Intensity,
    private val coffeeName: String = "Coffee"
) {

    // Method to display coffee details
    open fun displayCoffeeDetails() {
        println("Recipe for $coffeeName")
        println("Coffee Intensity: $intensity")
    }

    // Method to prepare coffee
    fun prepareCoffee(): Coffee {
        println("Preparing $coffeeName...")
        println("Setting intensity to $intensity")
        return Coffee(intensity, coffeeName)
    }
}
