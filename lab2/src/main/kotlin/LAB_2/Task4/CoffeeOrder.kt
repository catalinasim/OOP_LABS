package LAB_2.Task4

import Intensity

data class CoffeeOrder(
    val coffeeType: String,
    val intensity: Intensity,
    val mlOfWater: Int = 0,
    val mlOfMilk: Int = 0,
    val mgOfPumpkinSpice: Int = 0
)