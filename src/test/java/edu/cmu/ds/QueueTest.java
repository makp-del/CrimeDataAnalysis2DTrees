package edu.cmu.ds;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    private Queue<Integer> queue;

    @BeforeEach
    void setUp() {
        queue = new Queue<>();
    }

    @Test
    void testEnqueueAndDequeue() {
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        assertEquals(10, queue.dequeue()); // First in, first out
        assertEquals(20, queue.dequeue());
        assertEquals(30, queue.dequeue());
    }

    @Test
    void testPeek() {
        queue.enqueue(15);
        queue.enqueue(25);

        assertEquals(15, queue.peek()); // Peek should return the front element without removing it
        assertEquals(15, queue.dequeue()); // The front element should still be dequeued correctly
        assertEquals(25, queue.peek());
    }

    @Test
    void testSize() {
        assertEquals(0, queue.size());
        queue.enqueue(5);
        assertEquals(1, queue.size());
        queue.enqueue(10);
        assertEquals(2, queue.size());
        queue.dequeue();
        assertEquals(1, queue.size());
    }

    @Test
    void testIsEmpty() {
        assertTrue(queue.isEmpty());
        queue.enqueue(100);
        assertFalse(queue.isEmpty());
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    void testDequeueOnEmptyQueue() {
        assertNull(queue.dequeue()); // Should return null when dequeuing from an empty queue
    }

    @Test
    void testPeekOnEmptyQueue() {
        assertNull(queue.peek()); // Should return null when peeking an empty queue
    }
}