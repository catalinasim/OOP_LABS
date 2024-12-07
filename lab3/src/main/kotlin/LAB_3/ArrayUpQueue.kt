package LAB_3

// Queue implementation using Array Up
class ArrayUpQueue<T>(
    private val initialSize: Int
) : Queue<T> {
    private val queue = arrayOfNulls<Any>(initialSize) as Array<T?>
    private var count = 0
    // Enqueue method - adds a node at the end of the queue
    override fun enqueue(node: T) {
        if (count == initialSize) {
            println("Queue is full! First empty it before proceeding.")
        } else {
            queue[count] = node
            count++
        }
    }
    // Dequeue method - returns the first node and deletes it from the queue
    override fun dequeue(): T? {
        if (count == 0) {
            println("Queue is empty!")
            return null
        } else {
            val node = queue[0]
            for (i in 0 until count - 1) {
                queue[i] = queue[i + 1]
            }
            queue[count - 1] = null
            count--
            return node
        }
    }
    // Peek method - returns the first element of the queue
    override fun peek(): T? {
        return queue[0]
    }
    // isEmpty method - checks if a queue is empty
    override fun isEmpty(): Boolean {
        return count == 0
    }
    // size method - returns the size of the queue
    override fun size(): Int {
        return count
    }
}