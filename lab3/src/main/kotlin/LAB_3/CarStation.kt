package LAB_3

class CarStation(
    private var dinningService: Dineable,
    private var refuellingService: Refuelable,
    private var queue: Queue<Car>,
) {
    // method to serve a car
    fun serveCars() {
        while (queue.size() > 0) {
            var car = queue.dequeue()
            if (car != null) {
                if (car.isDining) {
                    dinningService.serveDinner(car.id.toString())
                }
                refuellingService.refuel(car.id.toString())
            }

        }
    }
    // method to add a car to a queue
    fun addCar(car: Car) {
        queue.enqueue(car)
    }
    // getter for queue
    fun getQueue(): Queue<Car> {
        return queue
    }
    // getter for refuellingService
    fun getRefuellingService(): Refuelable {
        return refuellingService
    }
    // getter for dinningService
    fun getDinningService(): Dineable {
        return dinningService
    }
}