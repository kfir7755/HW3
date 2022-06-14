import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class ToDoList implements Cloneable,TaskIterable {
    private ArrayList<Task> tasksList;
    private int currentSize=0;

    public ToDoList() {
        this.tasksList = new ArrayList<Task>();
    }

    public void addTask(Task other) {
        for (Task task :this){
            if (other.hashCode()==task.hashCode()) {
                throw new TaskAlreadyExistsException();
            }
        }
        this.tasksList.add(other);
            currentSize++;
    }


    //throws
    public void addTaskForScanning(Task task) {
        boolean isAdded = false;
        if (this.currentSize == 0) {
            this.tasksList.add(task);
            currentSize++;
            isAdded = true;
        } else {
            int size=this.currentSize;
            for (int i = 0; i <size ; i++) {
                if (task.getDueDate().compareTo(this.tasksList.get(i).getDueDate()) < 0 && isAdded==false) {
                    this.tasksList.add(i, task);
                    currentSize++;
                    isAdded = true;
                } else if (task.getDueDate().compareTo(this.tasksList.get(i).getDueDate()) == 0  && isAdded==false) {
                    if (task.getDescription().compareTo(this.tasksList.get(i).getDescription()) < 0) {
                        this.tasksList.add(i, task);
                        currentSize++;
                        isAdded = true;
                    } else if (task.hashCode()==this.tasksList.get(i).hashCode()) {
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
            if(i==this.currentSize-1) {
                str+="("+this.tasksList.get(i).toString()+")";
            }
            else {
                str += "("+this.tasksList.get(i).toString()+ ")" + ", ";
            }
        }
        str+="]";
        return str;
    }

    @Override
    public boolean equals(Object object) {
        if(object==null) {return false;}
        if (!(object instanceof ToDoList)) {
            return false;
        }
        if (((ToDoList) object).currentSize != this.currentSize) {
            return false;
        }
        for (int i = 0; i < this.currentSize; i++) {
            for (int j=0; j<((ToDoList) object).currentSize;j++) {
                if (this.tasksList.get(i).equals(((ToDoList) object).tasksList.get(j))) {
                    break;
                }
                if(j==this.currentSize-1) {
                    return false;
                }
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

    public Iterator<Task> setScanningDueDate(Date date) {
            Iterator<Task> iterator= new ScansToDoListIterator(this, date);
            return iterator;
    }

}
