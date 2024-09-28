package edu.cmu.ds;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    private Stack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new Stack<>();
    }

    @Test
    void testPushAndPop() {
        stack.push(10);
        stack.push(20);
        stack.push(30);

        assertEquals(30, stack.pop()); // Last in, first out
        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());
    }

    @Test
    void testPeek() {
        stack.push(100);
        stack.push(200);

        assertEquals(200, stack.peek()); // Peek should return the top element without removing it
        assertEquals(200, stack.pop());  // The top element should still be popped correctly
        assertEquals(100, stack.peek());
    }

    @Test
    void testSize() {
        assertEquals(0, stack.size());
        stack.push(5);
        assertEquals(1, stack.size());
        stack.push(10);
        assertEquals(2, stack.size());
        stack.pop();
        assertEquals(1, stack.size());
    }

    @Test
    void testIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.push(50);
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    void testPopOnEmptyStack() {
        assertNull(stack.pop()); // Should return null when popping from an empty stack
    }

    @Test
    void testPeekOnEmptyStack() {
        assertNull(stack.peek()); // Should return null when peeking an empty stack
    }
}