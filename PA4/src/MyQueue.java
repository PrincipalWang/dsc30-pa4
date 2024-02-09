/*
    Name: Chen Wang
    PID:  A17090044
 */

/**
 * MyQueue Implementation
 *
 * @author Chen Wang
 * @since 2/8/2024
 */

public class MyQueue<T> implements MyQueueInterface<T> {
    DoublyLinkedList<T> myQueue;

    /**
     * Constructor of MyQueue
     */
    public MyQueue() {
        myQueue = new DoublyLinkedList<>();
    }

    /**
     * Check if MyQueue is empty
     *
     * @return if MyQueue is empty
     */
    public boolean isEmpty() {
        return myQueue.isEmpty();
    }

    /**
     * Get size of MyQueue
     *
     * @return size of MyQueue
     */
    public int size() {
        return myQueue.size();
    }

    /**
     * Add an element to MyQueue
     *
     * @param data data added
     */
    public void enqueue(T data) {
        myQueue.add(data);
    }

    /**
     * Remove element at head
     *
     * @return data removed
     */
    public T dequeue() {
        return myQueue.remove(0);
    }

    /**
     * Get data at head
     *
     * @return data at head
     */
    public T peek() {
        return myQueue.get(0);
    }
}
