/** EmptyQueueException
 * unchecked exception that is being thrown while the user tries to peek an element from the ArrayQueue or remove
 * an element while the ArrayQueue is empty
 * */
public class EmptyQueueException extends QueueException{
    public EmptyQueueException() {}
    public EmptyQueueException(String message) {
        super(message);
    }
    public EmptyQueueException(String message, Throwable cause) {
        super(message, cause);
    }
}