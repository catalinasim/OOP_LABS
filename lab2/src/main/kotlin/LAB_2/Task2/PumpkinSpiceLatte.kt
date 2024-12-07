package LAB_2.Task2

import Intensity

class PumpkinSpiceLatte(
    coffeeIntensity: Intensity,
    milkVolume: Int,
    private val pumpkinSpiceAmount: Int,
    coffeeName: String = "PumpkinSpiceLatte"
) : Cappuccino(coffeeIntensity, milkVolume, coffeeName) {

    // Overrides displayCoffeeDetails to include pumpkin spice details
    override fun displayCoffeeDetails() {
        super.displayCoffeeDetails()
        println("Pumpkin Spice Amount: $pumpkinSpiceAmount mg")
    }
}