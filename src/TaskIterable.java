import java.util.Date;

public interface TaskIterable extends Iterable<Task> {
    public boolean setScanningDueDate(Date date);
}