package LAB_2.Task4.Coffee

import Intensity

// TODO how to unset origin remote
// TODO add new origin remote that is a repository of Catalina

internal open class Cappuccino(
    private var intensity: Intensity,
    private var milkVolume: Int,
    private val coffeeType: String = "Cappuccino"
) : Coffee(intensity, coffeeType) {

    // Overrides method to include milk details
    override fun displayCoffeeDetails() {
        super.displayCoffeeDetails()
        println("Milk Volume: $milkVolume ml")
    }

    // Method to prepare a Cappuccino
    fun prepareCappuccino(): Cappuccino {
        println("Preparing $coffeeType...")
        super.prepareCoffee()
        println("Adding $milkVolume ml of milk")
        return this
    }
}