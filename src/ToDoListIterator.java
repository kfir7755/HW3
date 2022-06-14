import java.util.ArrayList;

public class ToDoListIterator implements Iterable<Task>{
    @Override
    public boolean hasNext() {
    return false;
    //write code
    }
    @Override
    public Task next() {
        Task task=new Task();
        return task;
        //write code

    }
}
