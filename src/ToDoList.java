import java.util.ArrayList;

public class ToDoList {
    private ArrayList<Task> tasksList;
    private int currentSize;

    public ToDoList() {
        this.tasksList = new ArrayList<Task>();
        currentSize=0;

    }
    public void addTask(Task task){
        boolean isAdded=false;
        if (this.currentSize==0){
            this.tasksList.add(task);
            currentSize++;
            isAdded=true;
        }else{
            for (int i = 0; i < currentSize; i++) {
                if (task.getDate().compareTo(this.tasksList.get(i).getDate())<0){
                    this.tasksList.add(i,task);
                    currentSize++;
                    isAdded=true;
                }else if (task.getDate().compareTo(this.tasksList.get(i).getDate())==0){
                    if (task.getDescription().compareTo(this.tasksList.get(i).getDescription())<0){
                        this.tasksList.add(i,task);
                        currentSize++;
                        isAdded=true;
                    }else if (task.getDescription().compareTo(this.tasksList.get(i).getDescription())==0){
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
}
