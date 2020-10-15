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
    private boolean status;
    private String project;

    public Task(String title, String project, LocalDate dueDate) {
        this.setTitle(title);
        this.setDueDate(dueDate);
        this.setProject(project);
        this.status = false;
    }

    public void setTitle(String title) throws NullPointerException {
        if( title==null || title.trim().equals(""))
            throw new NullPointerException( "Title cannot be empty" );
        this.title = title.trim();
    }

    public String getTitle(){
        return this.title;
    }



    public void setDueDate(LocalDate dueDate) throws DateTimeException {
        //Throw DateTimeException if the date is past date
        if(dueDate.compareTo(LocalDate.now())>0)
            throw new DateTimeException("The entered date is past already,not allowed!!");

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

    public void setStatus(boolean status){
        this.status = status;
    }

    public boolean getStatus(){
        return this.status;
    }

    @Override
    public String toString(){
        return project + "      "  + title + "        " + dueDate + "        " + status;
    }

}
