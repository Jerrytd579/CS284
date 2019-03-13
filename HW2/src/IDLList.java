/**
 * @author: Jerry Cheng
 * I pledge my honor that I have abided by the Stevens Honor System.
 */

import java.util.ArrayList;

public class IDLList<E> {

    private class Node<E> {
        // Data fields
        private E data;
        private Node<E> next;
        private Node<E> prev;

        // Constructors
        Node(E elem) {
            data=elem;
            next=null;
            prev=null;
        }

        Node(E elem, Node<E> prev, Node<E> next) {
            data=elem;
            this.next=next;
            this.prev = prev;
        }
    }

    // Data fields
    private Node<E> head;
    private Node<E> tail;
    private int size;
    private ArrayList<Node<E>> indices;

    // Constructor
    /**
     * IDLList creates an empty double linked list
     */
    public IDLList() {
        head = null;
        tail = null;
        size = 0;
        indices = new ArrayList<Node<E>>();
    }

    // Methods
    /**
     * Adds elem at position index (counting from wherever head is). Uses index
     * for fast access.
     * @param index The index to store the data
     * @param elem The data to be stored
     * @return true if the data is successfully indexed, false if not
     */
    public boolean add(int index, E elem) {
        if(size == 0 || index > size) {
            return false;
        }

        if(index == 0) {
            this.add(elem);
            return true;
        }

        if(index == size) {
            this.append(elem);
            return true;
        }

        Node<E> indexNode = indices.get(index);
        Node<E> prevNode = indexNode.prev;
        Node<E> newNode = new Node<E>(elem, prevNode, indexNode);

        prevNode.next = newNode;
        indexNode.prev = newNode;
        indices.add(index, newNode);
        size++;
        return true;
    }

    /**
     * Adds elem at the head (i.e. it becomes the first element of the list).
     * @param elem The data to be added
     * @return true if the data is successfully indexed
     */
    public boolean add(E elem){
        Node<E> newNode = new Node<E>(elem);

        if(size == 0) {
            head = newNode;
            tail = newNode;
            size++;
            indices.add(0, newNode);
            return true;
        }

        else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
            size++;
            indices.add(0, newNode);
            return true;
        }
    }

    /**
     * Adds item elem as the new last element of the list (i.e. at the tail).
     * @param elem Data to be appended
     * @return true if successful
     */
    public boolean append(E elem){
        if(size == 0) {
            return this.add(elem);
        }

        Node<E> newNode = new Node<E>(elem);
        Node<E> oldTail = tail;
        oldTail.next = newNode;
        tail = newNode;
        tail.prev = oldTail;
        size++;
        indices.add(newNode);
        return true;
    }

    /**
     * Returns the object at position index from the head. It uses the index
     * for fast access. Indexing starts from 0, thus get(0) returns the head
     * element of the list.
     * @param index
     * @return the data at given index
     */
    public E get (int index){
        if(index > size) {
            throw new IllegalArgumentException();
        }
        return this.indices.get(index).data;
    }

    /**
     * Gets the first object.
     * @return the object at the head.
     */
    public E getHead (){
        if(size == 0) {
            throw new IllegalStateException("Size is 0!");
        }
        return this.head.data;
    }

    /**
     * Gets the last object.
     * @return the object at the tail
     */
    public E getLast (){
        if(size == 0) {
            throw new IllegalStateException("Size is 0!");
        }
        return this.tail.data;
    }

    /**
     * Gets the size.
     * @return the list size.
     */
    public int size(){
        return this.size;
    }

    /**
     * Removes and returns the element at the head.
     * @return the element at the head.
     */
    public E remove (){
        if (size == 0) {
            throw new IllegalStateException();
        }

        E data = head.data;

        if (size == 1) {
            head = null;
            tail = null;
        }

        else {
            head = head.next;
            head.prev = null;
        }

        size--;
        indices.remove(0);
        return data;
    }

    /**
     * Removes and returns the element at the tail
     * @return the element at the tail
     */
    public E removeLast (){
        if (size == 0) {
            throw new IllegalStateException();
        }
        E data = tail.data;

        if (size == 1) {
            head = null;
            tail = null;
        }

        else {
            tail = tail.prev;
            tail.next = null;
        }
        return data;
    }

    /**
     * Removes and returns the element at the index index.
     * @param index the index where the element is located
     * @return returns the element at index
     */
    public E removeAt (int index){
        if (size == 0 || index > size) {
            throw new IllegalArgumentException();
        }
        if(index == 0) {
            return this.remove();
        }
        if(index == size - 1) {
            return this.removeLast();
        }

        Node<E> elem = indices.get(index);
        E data = elem.data;

        elem.prev.next = elem.next;
        elem.next.prev = elem.prev;

        size--;
        indices.remove(index);
        return data;
    }

    /**
     * Removes the first occurence of elem in the list and returns true. Returns false if elem is
     * not in the list.
     * @param elem element to be removed
     * @return true if elem is successfully removed, false otherwise
     */
    public boolean remove (E elem){
        if(size == 0) {
            return false;
        }
        Node<E> current = head;
        while(current != null) {
            if(current.data == elem) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                return true;
            }
            current = current.next;
        }
        return false;
    }


    /**
     * Presents a string representation of the list
     * @return s as a string
     */
    public String toString(){
        Node<E> current = head;
        StringBuilder s = new StringBuilder();
        s.append("[");
        while(current != null) {
            s.append(current.data.toString() + ";");
            current = current.next;
        }
        s.append("]");
        return s.toString();
    }

    //*********************************************************
    public static void main(String[] args) {
        IDLList<Integer> l = new IDLList<>();
//        l.add(3);
//        l.add(4);
//        l.add(5);
//        l.add(7);
//        l.append(8);
//        System.out.println(l);
//        System.out.println(l.get(3));
//        System.out.println(l.size());
//        System.out.println(l.getHead());
//        System.out.println(l.getLast());
//        l.remove();
//        l.removeLast();
//        System.out.println(l);
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        l.removeAt(2);
        System.out.println(l);

    }
}
