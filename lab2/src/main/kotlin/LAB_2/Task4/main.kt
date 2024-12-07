package LAB_2.Task4

import LAB_2.Task4.Coffee.Barista

fun main() {
    // Initialize available coffee types, intensities, and syrups
    val coffeeTypes = listOf(
        CoffeeType.AMERICANO,
        CoffeeType.CAPPUCCINO,
        CoffeeType.PUMPKIN_SPICE_LATTE,
        CoffeeType.SYRUP_CAPPUCCINO
    )
    val coffeeIntensities = listOf(Intensity.LIGHT, Intensity.NORMAL, Intensity.STRONG)
    val syrupTypes = listOf(
        SyrupType.VANILLA,
        SyrupType.CARAMEL,
        SyrupType.COCONUT,
        SyrupType.POPCORN,
        SyrupType.CHOCOLATE,
        SyrupType.MACADAMIA
    )

    // Initialize barista with options
    val barista = Barista(coffeeTypes, coffeeIntensities, syrupTypes)

    // Take the first order
    println("Welcome! Let's take your order.")
    val order = barista.takeOrder()
    order?.displayCoffeeDetails()

    // Loop for additional orders
    var wish = "yes"
    while (wish.lowercase() != "no") {
        println("Would you like anything else? Type 'yes' to order or 'no' to finish.")
        wish = readlnOrNull()?.lowercase() ?: "no"

        if (wish == "yes") {
            val additionalOrder = barista.takeOrder()
            additionalOrder?.displayCoffeeDetails()
        }
    }

    // Finalize the interaction
    barista.sayWish()
    println("Thank you for your visit!")
}