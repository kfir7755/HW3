import java.util.Iterator;

public class ArrayQueueIterator<E extends Cloneable> implements Iterator {
    private final int head;
    private final int size;
    private final int length;
    private Cloneable arr[];
    private int currentSize = 0;

    public ArrayQueueIterator(int head, int size, Cloneable[] arr) {
        this.head=head;
        this.size=size;
        this.arr=arr;
        this.length=arr.length;
    }

    @Override
    public boolean hasNext() {
        if (this.arr[(this.head+1+this.currentSize)%this.length]!=null && currentSize<this.size) {
            return true;
        }
        return false;
    }

    @Override
    public E next() {
        return (E) this.arr[(this.head+this.currentSize++)%length];
    }
}
