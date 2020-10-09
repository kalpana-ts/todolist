import java.io.*;
import java.sql.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
/* To be done
Indexing
Finished and pending count



 */



// ArrayList of Task object
public class TaskList {
    Scanner scanner = new Scanner(System.in);
    private ArrayList<Task> taskList;


    public TaskList(){
        taskList = new ArrayList<>();
    }

    public void addTask(Task t){
        this.taskList.add(t);
    }

    public void writeTaskObj(){
        try{
            FileOutputStream file = new FileOutputStream("tasks.txt");
            ObjectOutputStream output = new ObjectOutputStream(file);

            output.writeObject(taskList);
         //   System.out.println(taskList );

            output.close();
            file.close();

            System.out.println("Tasks saved to the file" );


        }catch(IOException e){
            System.out.println("File doesn't found" + e );
        }
    }

    //showing without sorting feature, reading from file.. not done yet
    public ArrayList<Task> listAllTask(){
        ArrayList<Task> list = new ArrayList<>();
        try{
            FileInputStream file = new FileInputStream( "tasks.txt");
            ObjectInputStream stream = new ObjectInputStream(file);

            // read thing from the stream
            list = (ArrayList<Task>) stream.readObject();

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

        return list;
    }
    //Read new tasks from user
    public void readNewTasks() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Please Enter Task Details");
        System.out.println("-------------------------" );
        System.out.println("Enter Title of the task:");
        String title = scanner.nextLine( );
        System.out.println("Enter description of the task: ");
        String description = scanner.nextLine( );
        System.out.println("Enter due date of the project:(dd/MM/yyyy)");
        Date dueDate = sdf.parse(scanner.nextLine());
        System.out.println("Enter the project name(Home/SDA/Kids/Others):");
        String project = scanner.next();
       this.taskList.add(new Task(title,description,dueDate,"No",project));

    }
    //Tasks List Display
    public void displayTasks(){

    }

}
