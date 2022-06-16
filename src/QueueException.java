/** QueueException
 * unchecked exception which is the super class for every exception that is thrown from the ArrayQueue class methods
 */
public class QueueException extends RuntimeException{
    public QueueException() {}
    public QueueException(String message) {
        super(message);
    }
    public QueueException(String message, Throwable cause) {
        super(message, cause);
    }
}
