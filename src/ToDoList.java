import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class ToDoList implements Cloneable,TaskIterable {
    private ArrayList<Task> tasksList;
    private int currentSize;

    public ToDoList() {
        this.tasksList = new ArrayList<Task>();
        currentSize = 0;

    }

    //throws
    public void addTask(Task task) {
        boolean isAdded = false;
        if (this.currentSize == 0) {
            this.tasksList.add(task);
            currentSize++;
            isAdded = true;
        } else {
            for (int i = 0; i < currentSize; i++) {
                if (task.getDate().compareTo(this.tasksList.get(i).getDate()) < 0) {
                    this.tasksList.add(i, task);
                    currentSize++;
                    isAdded = true;
                } else if (task.getDate().compareTo(this.tasksList.get(i).getDate()) == 0) {
                    if (task.getDescription().compareTo(this.tasksList.get(i).getDescription()) < 0) {
                        this.tasksList.add(i, task);
                        currentSize++;
                        isAdded = true;
                    } else if (task.getDescription().compareTo(this.tasksList.get(i).getDescription()) == 0) {
                        throw new TaskAlreadyExistsException();
                    }
                }
            }
            if (isAdded == false) {
                this.tasksList.add(task);
                currentSize++;
            }
        }
    }

    public ArrayList<Task> getTasksList() {
        return tasksList;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    @Override
    public String toString() {
        String str="[";
        for (int i = 0; i <this.currentSize ; i++) {
            str+=this.tasksList.get(i).toString();
        }
        str+="]";
        return str;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ToDoList)) {
            return false;
        }
        if (((ToDoList) object).currentSize != this.currentSize) {
            return false;
        }
        for (int i = 0; i < currentSize; i++) {
            if (!this.tasksList.get(i).equals(((ToDoList) object).tasksList.get(i))) {
                return false;
            }
        }
        return true;

    }

    @Override
    public ToDoList clone() {
        try {
            ToDoList toDoList = new ToDoList();
            for (int i = 0; i < this.currentSize; i++) {
                toDoList.addTask(this.tasksList.get(i).clone());
            }
            return toDoList;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Iterator<Task> iterator() {
        ToDoListIterator toDoListIterator = new ToDoListIterator(this);
        return toDoListIterator;
    }

    public ToDoList setScanningDueDate(Date date) {
        if (date == null) {


        } else {

        }
    }



}
