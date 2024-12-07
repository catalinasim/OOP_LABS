package LAB_2.Task4.Coffee

import Intensity
import LAB_2.Task4.CoffeeType
import SyrupType

class Barista(
    private val availableCoffee: List<CoffeeType>,
    private val availableIntensities: List<Intensity>,
    private val availableSyrups: List<SyrupType>
) {
    // Generic method to take user input for a list of options
    private fun <T> takeUserInput(prompt: String, options: List<T>): T {
        println(prompt)
        options.forEachIndexed { index, option ->
            println("${index + 1}. $option")
        }
        var choice: Int
        do {
            println("Please choose a number between 1 and ${options.size}.")
            choice = readlnOrNull()?.toIntOrNull() ?: -1
        } while (choice !in 1..options.size)
        return options[choice - 1]
    }

    // Methods for specific order customizations
    private fun takeCoffeeKind(): CoffeeType =
        takeUserInput("What kind of coffee would you like?", availableCoffee)

    private fun takeIntensity(): Intensity =
        takeUserInput("What intensity would you like?", availableIntensities)

    private fun takeSyrupType(): SyrupType =
        takeUserInput("What kind of syrup would you like?", availableSyrups)

    private fun takeAmount(prompt: String): Int {
        var amount: Int
        do {
            println(prompt)
            amount = readlnOrNull()?.toIntOrNull() ?: -1
        } while (amount <= 0)
        return amount
    }

    private fun takeMillilitersOfWater(): Int =
        takeAmount("How many milliliters of water would you like?")

    private fun takeMillilitersOfMilk(): Int =
        takeAmount("How many milliliters of milk would you like?")

    private fun takeMilligramsOfPumpkinSpice(): Int =
        takeAmount("How many milligrams of pumpkin spice would you like?")

    // Internal method to take coffee orders
    internal fun takeOrder(): Coffee? {
        println("Welcome to the Coffee Shop!")
        val coffeeKind = takeCoffeeKind()
        val coffeeIntensity = takeIntensity()

        return when (coffeeKind) {
            CoffeeType.AMERICANO -> {
                val mlOfWater = takeMillilitersOfWater()
                Americano(coffeeIntensity, mlOfWater).prepareAmericano()
            }
            CoffeeType.CAPPUCCINO -> {
                val mlOfMilk = takeMillilitersOfMilk()
                Cappuccino(coffeeIntensity, mlOfMilk).prepareCappuccino()
            }
            CoffeeType.PUMPKIN_SPICE_LATTE -> {
                val mlOfMilk = takeMillilitersOfMilk()
                val mgOfPumpkinSpice = takeMilligramsOfPumpkinSpice()
                PumpkinSpiceLatte(coffeeIntensity, mlOfMilk, mgOfPumpkinSpice).preparePumpkinSpiceLatte()
            }
            CoffeeType.SYRUP_CAPPUCCINO -> {
                val mlOfMilk = takeMillilitersOfMilk()
                val syrup = takeSyrupType()
                SyrupCappuccino(coffeeIntensity, mlOfMilk, syrup).prepareSyrupCappuccino()
            }
        }
    }

    // Public method to say a wish
    fun sayWish() {
        val messages = listOf(
            "Have a brew-tiful day!",
            "Take life one sip at a time!",
            "May your coffee be strong and your day be smooth!",
            "Have a frappé-tastic day!"
        )
        println(messages.random())
    }
}
