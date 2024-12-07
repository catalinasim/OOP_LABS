package LAB_2.Task2

fun main() {
    // Test instances of coffee types
    val basicCoffee = Coffee(Intensity.STRONG)
    basicCoffee.displayCoffeeDetails()

    val lightCappuccino = Cappuccino(Intensity.LIGHT, 250)
    lightCappuccino.displayCoffeeDetails()

    val pumpkinLatte = PumpkinSpiceLatte(Intensity.NORMAL, 250, 30)
    pumpkinLatte.displayCoffeeDetails()

    val caramelCappuccino = SyrupCappuccino(Intensity.NORMAL, 250, SyrupType.CARAMEL)
    caramelCappuccino.displayCoffeeDetails()

    val strongAmericano = Americano(Intensity.STRONG, 150)
    strongAmericano.displayCoffeeDetails()
}
