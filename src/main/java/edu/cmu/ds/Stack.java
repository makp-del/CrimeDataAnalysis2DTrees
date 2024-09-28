//Author: Manjunath K P

package edu.cmu.ds;

/**
 * The Stack class is a generic stack data structure that supports operations like push, pop, peek, size, and isEmpty.
 * It is implemented using a linked list.
 *
 * @param <T> The type of elements stored in the stack.
 */
public class Stack<T> {

    private Node<T> top; // Reference to the top node in the stack
    private int size; // Number of elements in the stack
    /**
     * Constructor to create an empty stack.
     * <p>
     * Preconditions: None.
     * Postconditions: A new Stack object is created with top set to null, and size set to 0.
     * Time complexity: O(1), as it only initializes the top and size.
     */
    public Stack() {
        top = null;
        size = 0;
    }

    /**
     * Adds a new element to the top of the stack.
     *
     * @param data Element to be added to the stack.
     *             <p>
     *             Preconditions: None.
     *             Postconditions: A new Node is created with the given data and added to the top of the stack.
     *             Time complexity: O(1), as it directly adds a new node to the top.
     */
    public void push(T data) {
        Node<T> newNode = new Node<T>(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    /**
     * Removes and returns the element at the top of the stack.
     *
     * @return The element at the top of the stack, or null if the stack is empty.
     * <p>
     * Preconditions: None.
     * Postconditions: The top element is removed from the stack and returned.
     * Time complexity: O(1), as it directly removes the top element.
     */
    public T pop() {
        if (top == null) {
            return null;
        }
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    /**
     * Returns the element at the top of the stack without removing it.
     *
     * @return The element at the top of the stack, or null if the stack is empty.
     * <p>
     * Preconditions: None.
     * Postconditions: Returns the top element without removing it.
     * Time complexity: O(1), as it directly returns the top element.
     */
    public T peek() {
        if (top == null) {
            return null;
        }
        return top.data;
    }

    /**
     * Returns the number of elements in the stack.
     *
     * @return Number of elements in the stack.
     * <p>
     * Preconditions: None.
     * Postconditions: Returns the size of the stack.
     * Time complexity: O(1), as it directly returns the size.
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the stack is empty.
     *
     * @return True if the stack is empty, false otherwise.
     * <p>
     * Preconditions: None.
     * Postconditions: Returns true if the stack is empty, false otherwise.
     * Time complexity: O(1), as it directly checks the size.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * The Node class represents a node in the linked list used to implement the stack.
     * It contains the data and a reference to the next node.
     *
     * @param <T> The type of data stored in the node.
     */
    private static class Node<T> {
        private final T data; // The data stored in the node
        private Node<T> next; // Reference to the next node

        /**
         * Constructor to create a new node with the given data.
         *
         * @param data Data to be stored in the node.
         *             <p>
         *             Preconditions: None.
         *             Postconditions: A new Node is created with the given data and null next pointer.
         *             Time complexity: O(1), as it only sets two instance variables.
         */
        public Node(T data) {
            this.data = data;
        }
    }

}
