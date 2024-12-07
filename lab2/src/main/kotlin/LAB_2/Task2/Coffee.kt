package LAB_2.Task2

import Intensity

open class Coffee(
    protected var intensity: Intensity,
    protected val coffeeType: String = "Coffee"
) {

    // Base method to print coffee details
    open fun displayCoffeeDetails() {
        println("Preparing: $coffeeType")
        println("Intensity level: $intensity")
    }
}