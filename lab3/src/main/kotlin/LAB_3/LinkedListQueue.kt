package LAB_3

class LinkedListQueue<T> : Queue<T> {
    private var front: Node<T>? = null
    private var back: Node<T>? = null
    private var size: Int = 0
    // Enqueue method - adds a node at the end of the queue
    override fun enqueue(node: T) {
        val newNode = Node(node)
        if (back == null) {
            front = newNode
            back = newNode
        } else {
            newNode.next = back
            back = newNode
        }
        size++
    }
    // Dequeue method - returns the first node and deletes it from the queue
    override fun dequeue(): T? {
        val nodeToReturn = front
        if (nodeToReturn == null) {
            println("Queue is empty")
            return null
        }
        if (front == back) {
            front = null
            back = null
        } else {
            var node = back
            while (node?.next != front) {
                node = node?.next
            }
            front = node
            front?.next = null
        }
        size--
        return nodeToReturn.data
    }

    // Peek method - returns the first element of the queue
    override fun peek(): T? {
        return front?.data
    }
    // isEmpty method - checks if a queue is empty
    override fun isEmpty(): Boolean {
        return size == 0
    }
    // size method - returns the size of the queue
    override fun size(): Int {
        return size
    }

}