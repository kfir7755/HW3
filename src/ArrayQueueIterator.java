import java.util.Iterator;
/**
 * ArrayQueueIterator objects attributes:
 * size - the size of the Queue
 * head - the index of the head of the Queue
 * arr - array for the ArrayQueue that has all the elements of the Queue in it
 * maxCapacity - the max size of the Queue. it's also the size of the arr Array
 * currentSize - the number of items in the Queue we've already iterated
 */
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
/** returns True if there are elements in the ArrayQueue we can iterate and haven't iterated yet. else returns false */
    @Override
    public boolean hasNext() {
        if (this.currentSize<this.size && this.arr[(this.head+this.currentSize)%this.maxCapacity]!=null) {
            return true;
        }
        this.currentSize=0;
        return false;
    }
/** returns the next element of the ArrayQueue */
    @Override
    public E next() {
        return (E) this.arr[(this.head+this.currentSize++)%this.maxCapacity];
    }
}
