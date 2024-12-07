package LAB_3

interface Queue<T> {
    fun enqueue(node: T)
    fun dequeue(): T?
    fun peek(): T?
    fun isEmpty(): Boolean
    fun size(): Int
}