import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;

public class ArrayQueue<E extends MyCloneable> implements Queue<E> {
    protected int size=0;
    protected int head=0;
    protected Cloneable[] arr;
    protected final int maxCapacity;

    public ArrayQueue( int maxCapacity) {
            if (maxCapacity < 0) {throw new NegativeCapacityException();}
            this.maxCapacity = maxCapacity;
            this.arr= new Cloneable[maxCapacity];
    }

    public void enqueue(E element){
        if (this.size==this.maxCapacity) { throw new QueueOverflowException();}
        this.arr[(this.head+this.size)%this.maxCapacity]=element;
        this.size++;
    }

    public E dequeue(){
        if (isEmpty()) {throw new EmptyQueueException();}
        Cloneable removed =this.arr[head];
        this.arr[this.head]=null;
        this.head=(this.head+1)%this.maxCapacity;
        this.size--;
        return (E) removed;
    }
    public E peek(){
        if (isEmpty()) {throw new EmptyQueueException();}
        return (E) this.arr[head];
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty(){
        return this.size==0;
    }

    @Override
    public ArrayQueue<E> clone() {
        try {
            ArrayQueue aq = new ArrayQueue(this.maxCapacity);
            aq.head=this.head;
            aq.size=this.size;
            for (int i=0; i<this.size;i++) {
                aq.arr[(aq.head+i)%aq.maxCapacity]= (Cloneable) MyCloneable.class.getMethod("clone")
                        .invoke(this.arr[(head+i)%aq.maxCapacity]);
            }
            return aq;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = new ArrayQueueIterator(this);
        return iterator;
    }
}
