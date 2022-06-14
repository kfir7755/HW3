import java.util.Date;

public interface TaskIterable extends Iterable<Task> {
    public ToDoList setScanningDueDate(Date date);
}