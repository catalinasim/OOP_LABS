package LAB_3

class RobotDinner : Dineable {
    override fun serveDinner(carId: String) {
        println("Serving dinner to robots in car #$carId.")
        // Increment the number of robots served
        Dineable.incrementRobotCount()
    }
}