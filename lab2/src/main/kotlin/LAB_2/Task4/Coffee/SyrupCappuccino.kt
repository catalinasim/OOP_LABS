package LAB_2.Task4.Coffee

import Intensity
import SyrupType

internal class SyrupCappuccino(
    private var coffeeIntensity: Intensity,
    private var milkVolume: Int,
    private var syrupType: SyrupType,
    private val coffeeType: String = "SyrupCappuccino"
) : Cappuccino(coffeeIntensity, milkVolume, coffeeType) {

    // Overrides method to include syrup details
    override fun displayCoffeeDetails() {
        super.displayCoffeeDetails()
        println("Syrup Type: $syrupType")
    }

    // Method to prepare a Syrup Cappuccino
    fun prepareSyrupCappuccino(): SyrupCappuccino {
        println("Preparing $coffeeType...")
        super.prepareCappuccino()
        println("Adding $syrupType syrup")
        return this
    }
}
