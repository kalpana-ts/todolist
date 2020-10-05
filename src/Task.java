import java.time.LocalDate;
import java.util.Date;

public class Task {
    private String title;
    private String description;
    private Date dueDate;
    private String status; //try boolean
    private String project;
    TaskList tl = new TaskList();

    public Task(){

    }

    public Task(String title, String description,Date dueDate,String status,String project){
                this.title = title;
                this.description = description;
                this.dueDate = dueDate;
                this.status = status;
                this.project = project;
                tl.addTask(this);
    }

    public void setTaskTitle(String title){
        this.title = title;
    }

}
