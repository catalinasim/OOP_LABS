import LAB_3.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class QueueTests {
    private fun createArrayUpQueue(size: Int): ArrayUpQueue<Int> {
        return ArrayUpQueue(size)
    }

    companion object {
        @JvmStatic
        fun provideQueues(): List<Queue<Int>> {
            return listOf(
                ArrayUpQueue(3),
                ArrayDownQueue(3),
                LinkedListQueue(),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("provideQueues")
    fun testEnqueue(queue: Queue<Int>): Unit {
        queue.enqueue(1)
        queue.enqueue(2)
        queue.enqueue(3)
        assertEquals(queue.size(), 3)
    }

    @ParameterizedTest
    @MethodSource("provideQueues")
    fun testDequeue(queue: Queue<Int>) {
        queue.enqueue(1)
        queue.enqueue(2)
        queue.enqueue(3)
        var value = queue.dequeue()
        assertEquals(queue.size(), 2)
        assertEquals(value, 1)
    }

    @ParameterizedTest
    @MethodSource("provideQueues")
    fun testPeek(queue: Queue<Int>) {
        queue.enqueue(1)
        assertEquals(queue.peek(), 1)
        queue.dequeue()
        queue.enqueue(2)
        assertEquals(queue.peek(), 2)
    }

    @ParameterizedTest
    @MethodSource("provideQueues")
    fun testIsEmpty(queue: Queue<Int>) {
        assertTrue(queue.isEmpty())
        queue.enqueue(1)
        assertFalse(queue.isEmpty())
    }

    @ParameterizedTest
    @MethodSource("provideQueues")
    fun testSize(queue: Queue<Int>) {
        assertEquals(queue.size(), 0)
        queue.enqueue(1)
        assertEquals(queue.size(), 1)
        queue.enqueue(2)
        assertEquals(queue.size(), 2)
        queue.dequeue()
        assertEquals(queue.size(), 1)
    }
}