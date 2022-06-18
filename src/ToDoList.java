import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class ToDoList implements Cloneable,TaskIterable {
    private ArrayList<Task> tasksList;
    private int currentSize=0;
    private boolean bool=false;
    private Date date=null;

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

    /**
     * @throws TaskAlreadyExistsException if the task to be added is already exists
     * @param task
     */
    public void addTaskForScanning(Task task) {
        boolean isAdded = false;
        if (this.currentSize == 0) {
            this.tasksList.add(task);
            currentSize++;
            isAdded = true;
        } else {
            int size=this.currentSize;
            for (int i = 0; i <size ; i++) {
                //for each task
                if (task.getDueDate().compareTo(this.tasksList.get(i).getDueDate()) < 0 && isAdded==false) {
                    //comparing dates
                    this.tasksList.add(i, task);
                    currentSize++;
                    isAdded = true;
                } else if (task.getDueDate().compareTo(this.tasksList.get(i).getDueDate()) == 0  && isAdded==false) {
                    //comparing dates
                    if (task.getDescription().compareTo(this.tasksList.get(i).getDescription()) < 0) {
                        //comparing discriptions
                        this.tasksList.add(i, task);
                        currentSize++;
                        isAdded = true;
                    } else if (task.hashCode()==this.tasksList.get(i).hashCode()) {
                        //if the same task throw exeption
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

    /**
     * ovveride to toString in ToDoList
     * @return
     */
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

    /**
     * checks if 2 ToDoLists are equals
     * @param object
     * @return
     */
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

    /**
     * @throws  Exception if clone does not work
     * @return
     */
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
        ToDoListIterator toDoListIterator = new ToDoListIterator(this,this.date,this.bool);
        return toDoListIterator;
    }

    public void setScanningDueDate(Date date) {
        this.bool=true;
        this.date=date;
    }

}
