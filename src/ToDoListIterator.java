import java.util.ArrayList;
import java.util.Iterator;

public class ToDoListIterator implements Iterator<Task> {
private int currentIndex=0;
private int size;
private ArrayList<Task> tasksList;
private boolean specialIterate=false;
    public ToDoListIterator(ToDoList toDoList) {
        this.size=toDoList.getCurrentSize();
        this.tasksList=toDoList.getTasksList();
    }

    public ToDoListIterator(ToDoList toDoList, boolean bool) {
        this.size=toDoList.getCurrentSize();
        this.tasksList=toDoList.getTasksList();
        this.specialIterate=bool;
    }

    @Override
    public boolean hasNext() {
    return this.currentIndex<this.size;

    }
    @Override
    public Task next() {
        Task task=this.tasksList.get(this.currentIndex);
        return task;
    }
}
