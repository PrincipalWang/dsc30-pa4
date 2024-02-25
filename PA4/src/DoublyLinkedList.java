/*
 * NAME: Chen Wang
 * PID: A17090044
 */

import java.util.AbstractList;

/**
 * DoublyLinkedList Implementation
 * @author Chen Wang
 * @since 2/8/2024
 */
public class DoublyLinkedList<T> extends AbstractList<T> {

    /* DLL instance variables */
    private int nelems;
    private Node head;
    private Node tail;

    /**
     * Node for chaining together to create a linked list
     */
    protected class Node {

        /* Node instance variables */
        T data;
        Node next;
        Node prev;

        /**
         * Constructor to create singleton Node
         *
         * @param element  Element to add, can be null
         */
        private Node(T element) {
            data = element;
            next = null;
            prev = null;
        }

        /**
         * Constructor to create singleton link it between previous and next
         *
         * @param element  Element to add, can be null
         * @param nextNode successor Node, can be null
         * @param prevNode predecessor Node, can be null
         */
        private Node(T element, Node nextNode, Node prevNode) {
            data = element;
            next = nextNode;
            prev = prevNode;
        }

        /**
         * Set the element
         *
         * @param element new element
         */
        public void setElement(T element) {
            data = element;
        }

        /**
         * Accessor to get the Nodes Element
         *
         * @return the Nodes Element
         */
        public T getElement() {
            return data;
        }

        /**
         * Set the next node in the list
         *
         * @param n new next node
         */
        public void setNext(Node n) {
            next = n;
        }

        /**
         * Get the next node in the list
         *
         * @return the successor node
         */
        public Node getNext() {
            return next;
        }

        /**
         * Set the previous node in the list
         *
         * @param p new previous node
         */
        public void setPrev(Node p) {
            prev = p;
        }


        /**
         * Accessor to get the prev Node in the list
         *
         * @return predecessor node
         */
        public Node getPrev() {
            return prev;
        }

        /**
         * Remove this node from the list.
         * Update previous and next nodes
         */
        public void remove() {
            if(prev != null){
                prev.next = next;
            }
            if(next != null){
                next.prev = prev;
            }
        }
    }

    /**
     * Creates a new, empty doubly-linked list.
     */
    public DoublyLinkedList() {
        nelems = 0;
        head = new Node(null);
        tail = new Node(null);
        head.setNext(tail);
        tail.setPrev(head);
    }

    /**
     * Add an element to the end of the list
     *
     * @param element data to be added
     * @return whether or not the element was added
     * @throws NullPointerException if data received is null
     */
    @Override
    public boolean add(T element) throws NullPointerException {
        if(element == null){
            throw new NullPointerException();
        }
        Node newNode = new Node(element,tail,tail.getPrev());
        tail.getPrev().setNext(newNode);
        tail.setPrev(newNode);
        nelems++;
        return true;
    }


    /**
     * Adds an element to a certain index in the list, shifting exist elements
     * create room. Does not accept null values.
     *
     * @param element data to be added
     * @param index position to be added
     * @throws IndexOutOfBoundsException if index is outside the range [0, size]
     * @throws NullPointerException if data received is null
     */
    @Override
    public void add(int index, T element)
            throws IndexOutOfBoundsException, NullPointerException {
        if(element == null){
            throw new NullPointerException();
        }
        if(index < 0 || index > nelems){
            throw new IndexOutOfBoundsException();
        }
        Node currNode = head;
        for(int i = 0 ; i < index ; i++){
            currNode = currNode.getNext();
        }
        Node newNode = new Node(element,currNode.getNext(),currNode);
        currNode.getNext().setPrev(newNode);
        currNode.setNext(newNode);
        nelems++;
    }

    /**
     * Clear the linked list
     */
    @Override
    public void clear() {
        head.setNext(tail);
        tail.setPrev(head);
        nelems = 0;
    }

    /**
     * Determine if the list contains the data element anywhere in the list.
     *
     * @param element element to be searched
     * @return whether element is found
     */
    @Override
    public boolean contains(Object element) {
        T data = (T) element;
        Node currNode = head;
        while(currNode != tail){
            if(currNode.getElement() == data){
                return true;
            }
            currNode = currNode.getNext();
        }
        return false;
    }

    /**
     * Retrieves the element stored with a given index on the list.
     *
     * @param index position of the data
     * @return data found
     * @throws IndexOutOfBoundsException if index is outside the range [0, size - 1]
     */
    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if(index < 0 || index > nelems-1){
            throw new IndexOutOfBoundsException();
        }
        Node currNode = head;
        for(int i = 0; i < index; i++){
            currNode = currNode.getNext();
        }
        return currNode.getNext().getElement();
    }

    /**
     * Helper method to get the Nth node in our list
     *
     * @param index position of the Node
     * @return Node found
     */
    private Node getNth(int index) {
        Node currNode = head;
        for(int i = 0; i < index; i++){
            currNode = currNode.getNext();
        }
        return currNode.getNext();
    }

    /**
     * Determine if the list empty
     *
     * @return empty or not
     */
    @Override
    public boolean isEmpty() {
        return nelems == 0;
    }

    /**
     * Remove the element from position index in the list
     *
     * @param index position of data to be removed
     * @return data removed
     * @throws IndexOutOfBoundsException if index is outside the range [0, size - 1]
     */
    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        if(index < 0 || index > nelems-1){
            throw new IndexOutOfBoundsException();
        }
        Node currNode = this.getNth(index);
        T res = currNode.getElement();
        Node prevNode = currNode.getPrev();
        Node nextNode = currNode.getNext();
        prevNode.setNext(nextNode);
        nextNode.setPrev(prevNode);
        nelems--;
        return res;
    }

    /**
     * Set the value of an element at a certain index in the list.
     *
     * @param index position of data to be changed
     * @param element new data
     * @return previous data
     * @throws IndexOutOfBoundsException if index is outside the range [0, size - 1]
     * @throws NullPointerException - if data received is null
     */
    @Override
    public T set(int index, T element)
            throws IndexOutOfBoundsException, NullPointerException {
        if(element == null){
            throw new NullPointerException();
        }
        if(index < 0 || index > nelems-1){
            throw new IndexOutOfBoundsException();
        }
        Node currNode = this.getNth(index);
        T res = currNode.getElement();
        currNode.setElement(element);
        return res;
    }

    /**
     * Retrieves the amount of elements that are currently on the list.
     *
     * @return the amount of elements that are currently on the list
     */
    @Override
    public int size() {
        return nelems;
    }

    /**
     * String representation of this list in the form of:
     * "[(head) -> elem1 -> elem2 -> ... -> elemN -> (tail)]"
     *
     * @return string representation of this list
     */
    @Override
    public String toString() {
        Node currNode = head.getNext();
        String res = "[(head) -> ";
        while(currNode != tail){
            res += currNode.getElement();
            res += " -> ";
            currNode = currNode.getNext();
        }
        res += "(tail)]";
        return res;
    }

    /**
     * Remove nodes whose index is a multiple of base
     *
     * @param base base of index of elements to be removed
     */
    public void removeMultipleOf(int base) {
        int time = nelems / base;
        for(int i = 1; i <= time; i++){
            this.remove(i*base - (i-1));
        }
    }

    /**
     * Swap the nodes between index [0, splitIndex] of two lists
     *
     * @param other the other list to be swaped
     * @param splitIndex index of datas
     */
    public void swapSegment(DoublyLinkedList<T> other, int splitIndex) {
        Node thiscurr = this.getNth(splitIndex);
        Node othercurr = other.getNth(splitIndex);

        Node thisheadnext = this.head.getNext();
        this.head.setNext(other.head.getNext());
        this.head.getNext().setPrev(this.head);
        other.head.setNext(thisheadnext);
        other.head.getNext().setPrev(other.head);

        Node thiscurrnext = thiscurr.getNext();
        thiscurr.setNext(othercurr.next);
        thiscurr.getNext().setPrev(thiscurr);
        othercurr.setNext(thiscurrnext);
        othercurr.getNext().setPrev(othercurr);
    }

}
