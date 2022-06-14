import java.util.ArrayList;
import java.util.Iterator;

public class ToDoListIterator implements Iterator<Task> {
private int currentIndex=0;
private int size;
private ArrayList<Task> tasksList;

    public ToDoListIterator(ToDoList toDoList) {
        this.size=toDoList.getCurrentSize();
        this.tasksList=toDoList.getTasksList();
    }

    @Override
    public boolean hasNext() {
    return this.currentIndex<this.size;

    }
    @Override
    public Task next() {
        Task task=this.tasksList.get(this.currentIndex++);
        return task;
    }
}
