import java.util.Date;
import java.util.Iterator;

public interface TaskIterable extends Iterable<Task> {
    public Iterator<Task> setScanningDueDate(Date date);
}