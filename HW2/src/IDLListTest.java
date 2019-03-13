/**
 * @author Jerry Cheng
 * I pledge my honor that I have abided by the Stevens Honor System.
 */

import static org.junit.jupiter.api.Assertions.*;

class IDLListTest {

    @org.junit.jupiter.api.Test // Adding at head
    void add() {
        IDLList<Integer> l = new IDLList<>();
        IDLList<String> m = new IDLList<>();
        IDLList<Integer> n = new IDLList<>();
        IDLList<Character> o = new IDLList<>();
        l.add(4);
        l.add(2);
        l.add(3);
        l.add(4);
        m.add("Bob");
        m.add("Boris");
        n.add(1);
        n.add(2);
        o.add('a');
        o.add('b');
        assertEquals(l.toString(), "[4;3;2;4;]");
        assertEquals(m.toString(), "[Boris;Bob;]");
        assertEquals(n.toString(), "[2;1;]");
        assertEquals(o.toString(), "[b;a;]");
    }

    @org.junit.jupiter.api.Test // Adding at index
    void add1() {
        IDLList<Integer> l = new IDLList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        l.add(6);
        l.add(7);
        l.add(8);
        l.add(9);
        l.add(10);
        assertTrue(l.add(1, 5));
        assertTrue(l.add(5, 10));
        assertTrue(l.add(6, 9));
        assertFalse(l.add(420,6969));
    }

    @org.junit.jupiter.api.Test
    void append() {
        IDLList<Integer> l = new IDLList<>();
        IDLList<String> o = new IDLList<>();
        l.append(1);
        l.append(2);
        l.append(3);
        l.append(4);
        l.append(5);
        assertEquals(l.toString(), "[1;2;3;4;5;]");
        o.append("apple");
        o.append("pear");
        o.append("squash");
        assertEquals(o.toString(), "[apple;pear;squash;]");
        l.append(6);
        assertEquals(l.toString(), "[1;2;3;4;5;6;]");

    }

    @org.junit.jupiter.api.Test
    void get() {
        IDLList<Integer> l = new IDLList<>();
        l.append(1);
        l.append(3);
        l.append(5);
        l.append(7);
        l.append(9);
        assertEquals(l.get(1), 3);
        assertEquals(l.get(0), 1);
        assertEquals(l.get(4), 9);
    }

    @org.junit.jupiter.api.Test
    void getHead() {
        IDLList<Integer> l = new IDLList<>();
        IDLList<Integer> m = new IDLList<>();
        IDLList<Integer> n = new IDLList<>();
        l.add(1);
        l.add(2);
        m.add(3);
        m.add(4);
        n.add(5);
        n.add(6);
        assertEquals(l.getHead(), 2);
        assertEquals(m.getHead(), 4);
        assertEquals(n.getHead(), 6);
    }

    @org.junit.jupiter.api.Test
    void getLast() {
        IDLList<Integer> l = new IDLList<>();
        IDLList<Integer> m = new IDLList<>();
        IDLList<Integer> n = new IDLList<>();
        l.add(1);
        l.add(2);
        m.add(3);
        m.add(4);
        n.add(5);
        n.add(6);
        assertEquals(l.getLast(), 1);
        assertEquals(m.getLast(), 3);
        assertEquals(n.getLast(), 5);
    }

    @org.junit.jupiter.api.Test
    void size() {
        IDLList<Integer> l = new IDLList<>();
        l.add(50);
        l.add(66);
        l.add(666);
        assertEquals(l.size(), 3);
        l.add(12345);
        assertEquals(l.size(), 4);
        l.add(99999);
        assertEquals(l.size(), 5);
    }

    @org.junit.jupiter.api.Test
    void remove() { // Removes head
        IDLList<String> l = new IDLList<>();
        IDLList<String> m = new IDLList<>();
        IDLList<String> n = new IDLList<>();
        l.add("Yo");
        l.add("Yaa");
        l.add("Yeet");
        assertEquals(l.remove(), "Yeet");
        m.append("I am a banana");
        m.append("Therefore, I am a poptart");
        assertEquals(m.remove(), "I am a banana");
        n.add("Never gonna give you up");
        n.add("Never gonna let you down");
        assertEquals(n.remove(), "Never gonna let you down");
    }

    @org.junit.jupiter.api.Test
    void removeLast() {
        IDLList<Integer> l = new IDLList<>();
        IDLList<String> m = new IDLList<>();
        IDLList<String> n = new IDLList<>();
        l.append(420);
        l.append(69);
        assertEquals(l.removeLast(), 69);
        m.append("Is this the real life");
        m.append("Is this just fantasy");
        assertEquals(m.removeLast(), "Is this just fantasy");
        n.append("Salad");
        n.append("Table");
        assertEquals(n.removeLast(), "Table");
    }

    @org.junit.jupiter.api.Test
    void removeAt() {
        IDLList<Integer> l = new IDLList<>();
        l.add(0);
        l.add(5);
        l.add(10);
        l.add(15);
        l.add(20);
        assertEquals(l.removeAt(4), 0);
        assertEquals(l.removeAt(0), 20);
        assertEquals(l.removeAt(0), 15);
    }

    @org.junit.jupiter.api.Test
    void remove1() { // Removes first occurrence
        IDLList<Integer> l = new IDLList<>();
        l.add(0);
        l.add(0);
        l.add(1);
        l.add(1);
        l.add(2);
        l.add(2);
        assertTrue(l.remove(0));
        assertTrue(l.remove(2));
        assertFalse(l.remove(123));
    }

    @org.junit.jupiter.api.Test
    void toStringTest() {
        IDLList<Integer> l = new IDLList<>();
        l.add(0);
        assertEquals(l.toString(), "[0;]");
        l.add(1);
        assertEquals(l.toString(), "[1;0;]");
        l.add(100);
        assertEquals(l.toString(), "[100;1;0;]");
    }
}