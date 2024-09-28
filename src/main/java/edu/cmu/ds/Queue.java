//Author: Manjunath K P

package edu.cmu.ds;

/**
 * The Queue class is a generic queue data structure that supports operations like enqueue, dequeue, peek, size, and isEmpty.
 * It is implemented using a linked list.
 *
 * @param <T> The type of elements stored in the queue.
 */
public class Queue<T> {

    private Node<T> head; // Reference to the first node in the queue
    private Node<T> tail; // Reference to the last node in the queue
    private int size; // Number of elements in the queue
    /**
     * Constructor to create an empty queue.
     * <p>
     * Preconditions: None.
     * Postconditions: A new Queue object is created with head and tail set to null, and size set to 0.
     * Time complexity: O(1), as it only initializes the head, tail, and size.
     */
    public Queue() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Adds a new element to the end of the queue.
     *
     * @param data Element to be added to the queue.
     *             <p>
     *             Preconditions: None.
     *             Postconditions: A new Node is created with the given data and added to the end of the queue.
     *             Time complexity: O(1), as it directly adds the element to the end of the queue.
     */
    public void enqueue(T data) {
        Node<T> newNode = new Node<T>(data);
        // If the queue is empty, set both head and tail to the new node
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            // Otherwise, add the new node to the end of the queue
            tail.next = newNode;
            tail = newNode;
        }
        // Increment the size of the queue
        size++;
    }

    /**
     * Removes and returns the element at the front of the queue.
     *
     * @return The element at the front of the queue, or null if the queue is empty.
     * <p>
     * Preconditions: None.
     * Postconditions: The element at the front of the queue is removed and returned.
     * Time complexity: O(1), as it directly removes the element from the front of the queue.
     */
    public T dequeue() {
        if (head == null) {
            return null;
        }
        T data = head.data;
        head = head.next;
        size--;
        return data;
    }

    /**
     * Returns the element at the front of the queue without removing it.
     *
     * @return The element at the front of the queue, or null if the queue is empty.
     * <p>
     * Preconditions: None.
     * Postconditions: Returns the element at the front of the queue without removing it.
     * Time complexity: O(1), as it directly returns the element at the front of the queue.
     */
    public T peek() {
        if (head == null) {
            return null;
        }
        return head.data;
    }

    /**
     * Returns the number of elements in the queue.
     *
     * @return The number of elements in the queue.
     * <p>
     * Preconditions: None.
     * Postconditions: Returns the size of the queue.
     * Time complexity: O(1), as it directly returns the size of the queue.
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the queue is empty.
     *
     * @return True if the queue is empty, false otherwise.
     * <p>
     * Preconditions: None.
     * Postconditions: Returns true if the queue is empty, false otherwise.
     * Time complexity: O(1), as it directly checks the size of the queue.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * The Node class represents a node in the linked list used to implement the queue.
     * It contains the data and a reference to the next node.
     *
     * @param <T> The type of data stored in the node.
     */
    private static class Node<T> {
        T data; // The data stored in the node
        Node<T> next; // Reference to the next node

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
            this.next = null;
        }
    }


}
