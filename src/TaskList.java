import java.io.*;
import java.sql.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;
/** This class contains the actual Task List as an arraylist
 *
 * @author Kalpana TS
 *
 * To be done
    Indexing
    Finished and pending count
 */



// ArrayList of Task object
public class TaskList {

    private ArrayList<Task> taskList;


    public TaskList(){
        taskList = new ArrayList<>();
    }

    public void addTask(Task t){
        this.taskList.add(t);
    }

    public boolean writeTaskObj(String filename){
        try{
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream output = new ObjectOutputStream(file);

            output.writeObject(taskList);
         //   System.out.println(taskList );

            output.close();
            file.close();

            System.out.println("Tasks saved to the file" );
            return true;


        }catch(IOException e){
            System.out.println("File doesn't found" + e );
            return false;
        }
    }

    //showing without sorting feature, reading from file.. not done yet
    public ArrayList<Task> readTasksFromFile(){
    //    ArrayList<Task> list = new ArrayList<>();
        try{
            FileInputStream file = new FileInputStream( "tasks.obj");
            ObjectInputStream stream = new ObjectInputStream(file);

            // read thing from the stream
            taskList = (ArrayList<Task>) stream.readObject();

            stream.close();
            file.close();
        }
        catch(IOException  e)
        {
            System.out.println("File doesn't found " +  e);
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("problems inside the file " + e);
        }

        return taskList;
    }

    public void diplayAllTasks(){
        for(Task t:taskList){
                 System.out.println(t.toString() );
                }
    }

    //Read new tasks from user
    public void readNewTasks()  {
        try {
            Scanner scanner = new Scanner(System.in);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println("Please Enter Task Details");
            System.out.println("-------------------------");
            System.out.println("Enter Title of the task:");
            String title = scanner.nextLine( );
            System.out.println("Enter description of the task: ");
            String description = scanner.nextLine( );
            System.out.println("Enter due date of the project:(yyyy-MM-dd)");

            LocalDate dueDate = LocalDate.parse(scanner.nextLine( ));
            System.out.println("Enter the project name(Home/SDA/Kids/Others):");
            String project = scanner.next( );
            this.taskList.add(new Task(title, description, dueDate, "No", project));
        }catch(Exception e){
            System.out.println("Task not added! Please enter the correct date format." );
        }
    }
    //Tasks List Display
    public void displayTasks(){

    }

}
