import java.util.Arrays;
import java.util.Random;

public class Heap<E extends Comparable<E>> {
    // Data fields
    private E[] data;
    private int last;

    // Constructors
    private Heap(int size) {
        data = (E[]) new Comparable[size];
        last = 0;
    }

    // Methods
    private void swap(int i, int j) {
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public void add(E item) {
        data[last] = item;
        int current = last;
        int parent = (current - 1) / 2;

        while(parent >= 0 && data[parent].compareTo(data[current])>0) {
            swap(parent,current);
            current = parent;
            parent = (current - 1) / 2;
        }

        last++;
    }
    public String toString() {
        return Arrays.toString(data);
    }

    public static void main(String[] args) {
        Heap<Integer> h = new Heap<>(20);
        Random r = new Random();

        for (int i = 0; i < 10; i++) {
            h.add(r.nextInt(100));
        }
        System.out.println(h);
    }
}