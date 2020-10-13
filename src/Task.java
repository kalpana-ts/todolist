import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
/** This Class is a model for task object.
 * It contains all the fields and methods to update a task.
 * @author Kalpana TS
 * @version 1.0
 * @Date 07/10/2020
 */


/*To be done
    Check empty and null values in set methods
    find what to do on else part

 */

public class Task implements Serializable {
    private String title;
    private String description;
    private Date dueDate;
    private String status; //try boolean
    private String project;
  //  TaskList tl;

  /*  public Task(){

    }*/

    public Task(String title, String description,Date dueDate,String status,String project){
                this.title = title;
                this.description = description;
                this.dueDate = dueDate;
                this.status = status;
                this.project = project;
         //       tl.addTask(this);
    }

    public void setTitle(String title){
        if( title==null || title.trim().equals(""))
            this.title = title;
        //else
        //    System.out.println("Please Enter title" );
    }

    public String getTitle(){
        return this.title;
    }

    public void setDescription(String description){

        this.description = description;
    }

    public String getDescription(){

        return this.description;
    }

    public void setDueDate(Date dueDate){

        this.dueDate = dueDate;
    }

    public Date getDueDate(){
        return this.dueDate;
    }

    public void setProject(String project){
        this.project = project;
    }

    public String getProject(){
        return this.project;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return this.status;
    }

    @Override
    public String toString(){
        return title + " " + description + " " + dueDate + " " + status + " " + project;
    }

}
