package LAB_2.Task2

import Intensity

open class Cappuccino(
    coffeeIntensity: Intensity,
    private val milkAmount: Int,
    coffeeName: String = "Cappuccino"
) : Coffee(coffeeIntensity, coffeeName) {

    // Overrides displayCoffeeDetails to include milk details
    override fun displayCoffeeDetails() {
        super.displayCoffeeDetails() // Use the correct method name
        println("Milk Volume: $milkAmount ml")
    }
}