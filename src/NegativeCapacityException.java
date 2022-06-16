/** NegativeCapacityException
 * unchecked exception that is being thrown while the user tries to create an ArrayQueue with a negative size
 * */
public class NegativeCapacityException extends QueueException{
    public NegativeCapacityException() {}
    public NegativeCapacityException(String message) {
        super(message);
    }
    public NegativeCapacityException(String message, Throwable cause) {
        super(message, cause);
    }
}


