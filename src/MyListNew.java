public class MyListNew<E> {
    // Data fields
    private E[] data;
    private int free;

    // Constructor
    MyListNew(int length) {
        data = (E[]) new Object[length];
        free=0;
    }

    // Methods
    public int size() {
        return free;
    }

    public boolean isEmpty() {
        return free == 0;
    }

    public boolean add(E item) {
        if (free==data.length) {
            throw new IllegalStateException();
        }

        data[free]=item;
        free++;
        return true;
    }

    public boolean add(E item, int index) {
        if (free == data.length) {
            throw new IllegalStateException();
        }
        if (index < 0 || index > free) {
            throw new IllegalArgumentException();
        }
    }
}
