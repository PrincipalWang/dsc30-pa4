import static org.junit.jupiter.api.Assertions.*;

class MyQueueTest {
    @org.junit.jupiter.api.Test
    public void totalTest() {
        MyQueue<Integer> queue1 = new MyQueue<>();
        MyQueue<Integer> queue2 = new MyQueue<>();
        MyQueue<Integer> queue3 = new MyQueue<>();
        assertTrue(queue1.isEmpty());
        assertTrue(queue2.isEmpty());
        assertTrue(queue3.isEmpty());
        assertEquals(0,queue1.size());
        queue1.enqueue(1);
        assertEquals(1,queue1.peek());
        assertEquals(1,queue1.size());
        queue1.enqueue(2);
        assertEquals(1,queue1.peek());
        assertEquals(2,queue1.size());
        assertEquals(1,queue1.dequeue());
        assertEquals(2,queue1.peek());
        assertEquals(2,queue1.dequeue());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            queue1.dequeue();
        });
        queue1.enqueue(3);
        assertEquals(3,queue1.dequeue());
    }
}