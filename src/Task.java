import java.util.Date;

public class Task {
    private String title;
    private String description;
    private Date dueDate;
    private String status; //try boolean
    private String project;

    public Task(){

    }

    public Task(String title, String description,Date dueDate,String status,String project){
                this.title = title;
                this.description = description;
                this.dueDate = dueDate;
                this.status = status;
                this.project = project;
    }

    public void setTaskTitle(String title){
        this.title = title;
    }

}
