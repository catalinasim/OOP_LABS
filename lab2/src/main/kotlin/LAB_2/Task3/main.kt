package LAB_2.Task3

fun main() {
    // Test data
    val coffeeList: List<Coffee> = listOf(
        SyrupCappuccino(Intensity.NORMAL, 150, SyrupType.VANILLA),
        PumpkinSpiceLatte(Intensity.STRONG, 200, 50),
        Americano(Intensity.NORMAL, 200),
        Cappuccino(Intensity.NORMAL, 150)
    )

    // Iterate through the coffee list and display details
    for (coffee in coffeeList) {
        println("${coffee.javaClass.simpleName} Details")
        coffee.displayCoffeeDetails()
        println() // Add an empty line for better readability
    }
}