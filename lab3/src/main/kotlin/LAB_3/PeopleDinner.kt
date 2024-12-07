package LAB_3

class PeopleDinner : Dineable {
    override fun serveDinner(carId: String) {
        println("Serving dinner to people in car #$carId.")
        // Increment the number of people served
        Dineable.incrementPeopleCount()
    }
}