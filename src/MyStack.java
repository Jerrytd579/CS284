import java.util.EmptyStackException;

public class MyStack<E> {

    private class Node<E> {
        private E data;
        private Node<E> next;

//        Node(E data) {
//            this.data = data;
//        }

        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> top;
    private int size;

    public int getSize() {
        return size;
    }

    public void push(E item) {
        Node<E> newNode = new Node<E>(item, top);
        top = newNode;
        size++;
    }

    public E peek() {
        if(top == null) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public E pop() {
        if(top == null) {
            throw new EmptyStackException();
        }
        E saved = top.data;
        top = top.next;
        size--;
        return saved;
    }

    public static class Heap {
    }
}
