import java.util.Date;

public class Task implements Cloneable {
    private final String description;
    private Date date;

    public Task(String description, Date date) {
        this.description = description;
        this.date = date;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Task)){
            return false;
        }
        if(this.hashCode()==obj.hashCode() && this.date.compareTo(((Task) obj).date)==0) {
            return true;
        }
        else return false;
    }

    @Override
    public int hashCode() {
        return this.description.hashCode();
    }

    @Override
    public String toString(){
        return "("+this.description + "," + this.date + ")";
    }

    @Override
    public Task clone(){
        Task task= new Task(this.description, this.date);
    }
}
