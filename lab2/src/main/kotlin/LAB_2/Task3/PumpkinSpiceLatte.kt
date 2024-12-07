package LAB_2.Task3

import Intensity

class PumpkinSpiceLatte(
    private var coffeeIntensity: Intensity,
    private var milkVolume: Int,
    private var pumpkinSpiceAmount: Int,
    private val coffeeType: String = "PumpkinSpiceLatte"
) : Cappuccino(coffeeIntensity, milkVolume, coffeeType) {

    // Overrides the method to include pumpkin spice details
    override fun displayCoffeeDetails() {
        super.displayCoffeeDetails()
        println("Pumpkin Spice Amount: $pumpkinSpiceAmount mg")
    }

    // Method to prepare a Pumpkin Spice Latte
    fun preparePumpkinSpiceLatte(): PumpkinSpiceLatte {
        println("Preparing $coffeeType...")
        super.prepareCappuccino()
        println("Adding $pumpkinSpiceAmount mg of pumpkin spice")
        return this
    }
}
