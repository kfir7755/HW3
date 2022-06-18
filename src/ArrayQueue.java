import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Idea behind the ArrayQueue:
 * we can't use loops or move the elements inside the Queue array, so instead we have an attribute for the index of
 * the head in the Queue array, and we will increment it every time we remove an element from the array. We are using %
 * operator to limit the number of elements in the Queue array to it's given max capacity and not less than that
 *
 * ArrayQueue objects attributes:
 * size - the size of the Queue
 * head - the index of the head of the Queue
 * arr - array for the ArrayQueue that has all the elements of the Queue in it
 * maxCapacity - the max size of the Queue. it's also the size of the arr Array
 */
public class ArrayQueue<E extends MyCloneable> implements Queue<E> {
    protected int size=0;
    protected int head=0;
    protected Cloneable[] arr;
    protected final int maxCapacity;

    /**
     * constructor for ArrayQueue
     * @param maxCapacity is the max number of Cloneable objects in the Queue
     */
    public ArrayQueue( int maxCapacity) {
            if (maxCapacity < 0) {throw new NegativeCapacityException();}
            this.maxCapacity = maxCapacity;
            this.arr= new Cloneable[maxCapacity];
    }

    /**
     * add a Cloneable object to the Queue tail
     * @param element the Cloneable object to be added
     */
    public void enqueue(E element){
        if (this.size==this.maxCapacity) { throw new QueueOverflowException();}
        this.arr[(this.head+this.size)%this.maxCapacity]=element;
        this.size++;
    }

    /**
     * remove the first object that has entered to the Queue and wasn't removed yet and return it
     * @return the Cloneable object that is the head of the Queue and that was removed
     */
    public E dequeue(){
        if (isEmpty()) {throw new EmptyQueueException();}
        Cloneable removed =this.arr[head];
        this.arr[this.head]=null;
        this.head=(this.head+1)%this.maxCapacity;
        this.size--;
        return (E) removed;
    }

    /**
     * show the object in the head of the Queue without removing it from the Queue
     * @return the Cloneable object that is the head of the Queue
     */
    public E peek(){
        if (isEmpty()) {throw new EmptyQueueException();}
        return (E) this.arr[head];
    }

    /** returns the size of the Queue*/
    public int size() {
        return this.size;
    }

    /** returns True if the Queue is empty, else return False*/
    public boolean isEmpty(){
        return this.size==0;
    }

    /**
     *  a function the makes a deep cloning of the Queue
     * @throws Exception that might occur while cloning
     * @return the deep copy of the clone
     */
    @Override
    public ArrayQueue<E> clone() {
        try {
            ArrayQueue aq = new ArrayQueue(this.maxCapacity);
            if (this.size==0) {
                return aq;
            }
            else{
                aq.head=this.head;
                aq.size=this.size;
                for (int i=0; i<this.size;i++) {
                    aq.arr[(aq.head + i) % aq.maxCapacity] = (Cloneable) this.arr[head].getClass()
                            .getMethod("clone").invoke(this.arr[(head + i) % aq.maxCapacity]);
                }
            }
            return aq;
        } catch (Exception e) {
            return null;
        }
    }

    /** returns iterator of the ArrayQueue*/
    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = new ArrayQueueIterator(this);
        return iterator;
    }
}
