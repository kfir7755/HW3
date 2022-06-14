import java.util.Date;

public class Task implements Cloneable {
    private final String description;
    private Date date;

    public Task(String description, Date date) {
        this.description = description;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
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
    public Task clone() {
        try {
            Task task = new Task(this.description, new Date(this.date.getTime()));
            return task;
        } catch (Exception e) {
            return null;
        }
    }
}

