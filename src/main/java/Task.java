import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/** This Class is a model for task object.
 * It contains all the fields and methods to update a task.
 * @author Kalpana TS
 * @version 1.0
 * @Date 07/10/2020
 */


/* To be done
    Check empty and null values in set methods
    find what to do on else part

 */

public class Task implements Serializable {

    private String title;
    private LocalDate dueDate;
    private String status; //try boolean
    private String project;

    public Task(String title, String project, LocalDate dueDate, String status){
        this.title = title;
        this.dueDate = dueDate;
        this.project = project;
        this.status = status;

    }

    public void setTitle(String title){
        if( title==null || title.trim().equals(""))
            this.title = title;
        this.title = title.trim();
    }

    public String getTitle(){
        return this.title;
    }



    public void setDueDate(LocalDate dueDate) throws DateTimeException {
        //Throw DateTimeException if the date is past date
        if(dueDate.compareTo(LocalDate.now())>0){
            throw new DateTimeException("The entered date is past already");
        }
        //Save dueDate in the yyyy-MM-dd format
        DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.dueDate = LocalDate.parse(dueDate.format(formattedDate));
    }

    public LocalDate getDueDate(){
        return this.dueDate;
    }

    public void setProject(String project){

        this.project = project.trim();
    }

    public String getProject(){
        return this.project;
    }

    public void setStatus(String status){
        this.status = status.trim();
    }

    public String getStatus(){
        return this.status;
    }

    @Override
    public String toString(){
        return title + " "  + dueDate + " " + status + " " + project;
    }

}
