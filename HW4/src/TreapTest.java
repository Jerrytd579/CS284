/**
 * Jerry Cheng
 * I pledge my honor that I have abided by the Stevens Honor System.
 */

import static org.junit.jupiter.api.Assertions.*;

class TreapTest {

    @org.junit.jupiter.api.Test
    void add() {
        // Testing the add method
        Treap<Integer> testTree = new Treap<Integer>();
        testTree.add(4, 19);
        testTree.add(2, 31);
        testTree.add(6, 70);
        testTree.add(1, 84);
        testTree.add(3, 12);
        testTree.add(5, 83);
        assertTrue(testTree.add(7, 26));
        assertFalse(testTree.add(7, 26));
        assertTrue(testTree.add(8, 49));
        assertFalse(testTree.add(8, 49));
        assertFalse(testTree.add(1, 94));
    }

    @org.junit.jupiter.api.Test
    void delete() {
        // Testing the delete method
        Treap<Integer> testTree = new Treap<Integer>();
        testTree.add(4, 19);
        testTree.add(2, 31);
        testTree.add(6, 70);
        testTree.add(1, 84);
        testTree.add(3, 12);
        testTree.add(5, 83);
        assertTrue(testTree.delete(3));
        assertFalse(testTree.delete(69));
    }

    @org.junit.jupiter.api.Test
    void find() {
        // Testing the find method
        Treap<Integer> testTree = new Treap<Integer>();
        testTree.add(4, 19);
        testTree.add(2, 31);
        testTree.add(6, 70);
        testTree.add(1, 84);
        testTree.add(3, 12);
        testTree.add(5, 83);
        assertTrue(testTree.find(6));
        assertTrue(testTree.find(4));
        assertTrue(testTree.find(1));
        assertFalse(testTree.find(420));
        assertFalse(testTree.find(69));
        assertFalse(testTree.find(12345));
    }

}