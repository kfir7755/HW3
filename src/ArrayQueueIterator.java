import java.util.Iterator;

public class ArrayQueueIterator<E extends Cloneable> implements Iterator {
    private final int head;
    private final int size;
    private int currentSize = 0;

    public ArrayQueueIterator(int head, int size) {
        this.head=head;
        this.size=size;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public E next() {
        return null;
    }
}
