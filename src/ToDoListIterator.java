import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class ToDoListIterator implements Iterator<Task> {
private int currentIndex=0;
private int size;
private ArrayList<Task> tasksList;
private ArrayList<Task> sortedTasksList;
private Date date;
private boolean bool;

    public ToDoListIterator(ToDoList toDoList ,Date date, boolean bool) {
        this.size=toDoList.getCurrentSize();
        this.tasksList=toDoList.getTasksList();
        this.sortedTasksList=sortList(this.tasksList);
        this.date=date;
        this.bool=bool;
    }

    private ArrayList<Task> sortList(ArrayList<Task> tasksList) {
        ToDoList sortedToDoList= new ToDoList();
        for (Task task : tasksList) {
            sortedToDoList.addTaskForScanning(task);
        }
        return sortedToDoList.getTasksList();
    }

    @Override
    public boolean hasNext() {
        if (this.date==null) {
            return this.currentIndex < this.size;
        }
        else return this.currentIndex < this.size && sortedTasksList.get(currentIndex).getDueDate()
                .compareTo(this.date) < 0;
    }
    @Override
    public Task next() {
        if (bool = false) {
            Task task = this.tasksList.get(this.currentIndex++);
            return task;
        }
        else {
            Task task=this.sortedTasksList.get(this.currentIndex++);
            return task;
        }
    }
}
