package LAB_2.Task2

import Intensity
import SyrupType

class SyrupCappuccino(
    coffeeIntensity: Intensity,
    milkVolume: Int,
    private val syrupType: SyrupType,
    coffeeName: String = "SyrupCappuccino"
) : Cappuccino(coffeeIntensity, milkVolume, coffeeName) {

    // Overrides displayCoffeeDetails to include syrup details
    override fun displayCoffeeDetails() {
        super.displayCoffeeDetails()
        println("Type of Syrup: $syrupType")
    }
}