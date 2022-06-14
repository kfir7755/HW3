import java.util.Iterator;

public class ArrayQueueIterator<E extends Cloneable> implements Iterator {
    private final int head;
    private final int size;
    private final int maxCapacity;
    private Cloneable arr[];
    private int currentSize = 0;

    public ArrayQueueIterator(ArrayQueue arrayQueue) {
        this.head=arrayQueue.head;
        this.size=arrayQueue.size;
        this.arr=arrayQueue.arr;
        this.maxCapacity=arrayQueue.maxCapacity;
    }

    @Override
    public boolean hasNext() {
        if (currentSize<this.size && this.arr[(this.head+this.currentSize)%this.maxCapacity]!=null) {
            return true;
        }
        this.currentSize=0;
        return false;
    }

    @Override
    public E next() {
        return (E) this.arr[(this.head+this.currentSize++)%this.maxCapacity];
    }
}
