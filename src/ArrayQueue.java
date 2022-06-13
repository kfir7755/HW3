public class ArrayQueue<E extends MyCloneable> implements Queue<E> {
    private int size=0;
    private int head=0;
    private Cloneable[] arr;
    private final int maxCapacity;

    public ArrayQueue( int maxCapacity) {
            if (maxCapacity < 0) {throw new NegativeCapacityException();}
            this.maxCapacity = maxCapacity;
            this.arr= new Cloneable[maxCapacity];
    }

    public void enqueue(E element){
        if (this.size==this.maxCapacity) { throw new QueueException();}
        this.arr[(this.head+this.size)%this.maxCapacity]=element;
        this.size++;
    }

    public E dequeue(){
        if (isEmpty()) {throw new EmptyQueueException();}
        Cloneable removed =this.arr[head];
        this.arr[this.head]=null;
        this.head=(this.head+1)%this.maxCapacity;
        return (E) removed;
    }
    public E peek(){
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
        return null;
    }
}
