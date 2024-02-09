import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {
    DoublyLinkedList<Integer> testlist;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        testlist = new DoublyLinkedList<>();
    }

    @org.junit.jupiter.api.Test
    void add() {
        assertThrows(NullPointerException.class,() -> {
            testlist.add(null);
        });
        testlist.add(1);
        testlist.add(2);
        testlist.add(3);
        assertEquals(3,testlist.size());
    }

    @org.junit.jupiter.api.Test
    void testAdd() {
        assertThrows(NullPointerException.class,() -> {
            testlist.add(null);
        });
        assertThrows(IndexOutOfBoundsException.class,() -> {
            testlist.add(1,-1);
        });
        assertThrows(IndexOutOfBoundsException.class,() -> {
            testlist.add(1,1);
        });
        testlist.add(0,1);
        testlist.add(0,2);
        testlist.add(0,3);
        assertEquals(3,testlist.get(0));
        assertEquals(2,testlist.get(1));
        assertEquals(1,testlist.get(2));
    }

    @org.junit.jupiter.api.Test
    void clear() {
        testlist.add(0,1);
        testlist.add(0,2);
        testlist.add(0,3);
        testlist.clear();
        assertEquals(0,testlist.size());
        assertThrows(IndexOutOfBoundsException.class,() -> {
            testlist.get(0);
        });
    }

    @org.junit.jupiter.api.Test
    void contains() {
        testlist.add(0,1);
        testlist.add(0,2);
        testlist.add(0,3);
        assertTrue(testlist.contains(1));
        testlist.clear();
        assertFalse(testlist.contains(1));
    }

    @org.junit.jupiter.api.Test
    void get() {
        assertThrows(IndexOutOfBoundsException.class,() -> {
            testlist.get(-1);
        });
        testlist.add(0,1);
        testlist.add(0,2);
        testlist.add(0,3);
        assertEquals(3,testlist.get(0));
        assertEquals(2,testlist.get(1));
        assertEquals(1,testlist.get(2));
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        assertTrue(testlist.isEmpty());
        testlist.add(0,1);
        testlist.add(0,2);
        testlist.add(0,3);
        testlist.clear();
        assertTrue(testlist.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void remove() {
        assertThrows(IndexOutOfBoundsException.class,() -> {
            testlist.remove(-1);
        });
        assertThrows(IndexOutOfBoundsException.class,() -> {
            testlist.remove(0);
        });
        testlist.add(0,1);
        testlist.add(0,2);
        testlist.add(0,3);
        assertEquals(2,testlist.remove(1));
        assertEquals(3,testlist.get(0));
        assertEquals(1,testlist.get(1));
    }

    @org.junit.jupiter.api.Test
    void set() {
        assertThrows(NullPointerException.class,() -> {
            testlist.set(0,null);
        });
        assertThrows(IndexOutOfBoundsException.class,() -> {
            testlist.set(0,1);
        });
        assertThrows(IndexOutOfBoundsException.class,() -> {
            testlist.add(-1,1);
        });
        testlist.add(0,1);
        testlist.add(0,2);
        testlist.add(0,3);
        assertEquals(2,testlist.set(1,4));
        assertEquals(3,testlist.get(0));
        assertEquals(4,testlist.get(1));
        assertEquals(1,testlist.get(2));
    }

    @org.junit.jupiter.api.Test
    void size() {
        assertEquals(0,testlist.size());
        testlist.add(0,1);
        assertEquals(1,testlist.size());
        testlist.add(0,2);
        assertEquals(2,testlist.size());
        testlist.add(0,3);
        assertEquals(3,testlist.size());
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        testlist.add(0,1);
        testlist.add(0,2);
        testlist.add(0,3);
        String res = "(head) -> 3 -> 2 -> 1 -> (tail)";
        assertTrue(res.equals(testlist.toString()));
    }

    @org.junit.jupiter.api.Test
    void removeMultipleOf() {
        testlist.add(0);
        testlist.add(1);
        testlist.add(2);
        testlist.add(3);
        testlist.add(4);
        testlist.add(5);
        testlist.add(6);
        testlist.removeMultipleOf(2);
        assertEquals(4,testlist.size());
        String res = "(head) -> 0 -> 1 -> 3 -> 5 -> (tail)";
        assertTrue(res.equals(testlist.toString()));
    }

    @org.junit.jupiter.api.Test
    void swapSegment() {
        DoublyLinkedList<Integer> otherlist = new DoublyLinkedList<>();
        testlist.add(0);
        testlist.add(1);
        testlist.add(2);
        testlist.add(3);
        testlist.add(4);
        testlist.add(5);
        testlist.add(6);
        otherlist.add(7);
        otherlist.add(8);
        otherlist.add(9);
        otherlist.add(10);
        otherlist.add(11);
        otherlist.add(12);
        otherlist.add(13);
        testlist.swapSegment(otherlist, 4);
        String res = "(head) -> 7 -> 8 -> 9 -> 10 -> 11 -> 5 -> 6 -> (tail)";
        assertTrue(res.equals(testlist.toString()));
        res = "(head) -> 0 -> 1 -> 2 -> 3 -> 4 -> 12 -> 13 -> (tail)";
    }
}