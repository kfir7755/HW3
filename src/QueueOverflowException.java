/** QueueOverflowException
 * unchecked exception that is being thrown while the user tries to add an element to the ArrayQueue while the
 * ArrayQueue size is already in its max size
 */
public class QueueOverflowException extends QueueException{
    public QueueOverflowException() {}
    public QueueOverflowException(String message) {
        super(message);
    }
    public QueueOverflowException(String message, Throwable cause) {
        super(message, cause);
    }
}
