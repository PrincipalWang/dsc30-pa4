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
    DoublyLinkedList<T> MyQueue;

    /**
     * Constructor of MyQueue
     */
    public MyQueue() {
        MyQueue = new DoublyLinkedList<>();
    }

    /**
     * Check if MyQueue is empty
     *
     * @return if MyQueue is empty
     */
    public boolean isEmpty() {
        return MyQueue.isEmpty();
    }

    /**
     * Get size of MyQueue
     *
     * @return size of MyQueue
     */
    public int size() {
        return MyQueue.size();
    }

    /**
     * Add an element to MyQueue
     *
     * @param data data added
     */
    public void enqueue(T data) {
        MyQueue.add(data);
    }

    /**
     * Remove element at head
     *
     * @return data removed
     */
    public T dequeue() {
        return MyQueue.remove(0);
    }

    /**
     * Get data at head
     *
     * @return data at head
     */
    public T peek() {
        return MyQueue.get(0);
    }
}