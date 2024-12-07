package LAB_3

// Queue implementation using Array Down
class ArrayDownQueue<T>(
    private val initialSize: Int
) : Queue<T> {
    private val queue: Array<T?> = arrayOfNulls<Any>(initialSize) as Array<T?>
    private var free = initialSize
    // Enqueue method - adds a node at the end of the queue
    override fun enqueue(node: T) {
        if (free == 0) {
            println("Queue is full! First empty it before proceeding.")
        } else {
            queue[initialSize - free] = node
            free--
        }
    }
    // Dequeue method - returns the first node and deletes it from the queue
    override fun dequeue(): T? {
        if (free == initialSize) {
            println("Queue is empty!")
            return null
        } else {
            val node = queue[0]
            for (i in 0 until initialSize - free - 1) {
                queue[i] = queue[i + 1]
            }
            queue[initialSize - free - 1] = null
            free++
            return node
        }
    }
    // Peek method - returns the first element of the queue
    override fun peek(): T? {
        return if (free == initialSize) null else queue[0]
    }
    // isEmpty method - checks if a queue is empty
    override fun isEmpty(): Boolean {
        return free == initialSize
    }
    // size method - returns the size of the queue
    override fun size(): Int {
        return initialSize - free
    }
}