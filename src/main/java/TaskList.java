import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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

    /*public void addTask(Task t){
        this.taskList.add(t);
    }*/

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

    public void displayAllTasks(int choice){
        Display.seperator('-',75);
        System.out.println("Total Tasks = " + taskList.size() +
                "\t\t"+Display.GREEN_TEXT +"Tasks Completed = " + completedTaskCount() + "\t\t" +
                Display.RED_TEXT + " Tasks Not Completed = " + notCompletedCount() + Display.RESET_TEXT);
        Display.seperator('-',75);

        if(taskList.size()==0){
            System.out.println("Task list is empty" );
            return;
        }

        if(choice == 2){
            String lineFormat = "%-20s %-35s %-13s %-10s";
            System.out.println(String.format(lineFormat,"Project","Title","DueDate","Completed"));
            System.out.println(String.format(lineFormat,"-------","------","--------","-------"));

            List<Task> sortedTaskList = taskList.stream()
                    .sorted(Comparator.comparing(Task::getProject))
                    .collect((Collectors.toList()));

            for(Task task:sortedTaskList)
                System.out.println(String.format(lineFormat,task.getProject(),task.getTitle(),task.getDueDate(),task.getStatus()?"Yes":"No"));
        }else{
            String lineFormat = "%-13s %-35s %-20s %-10s";
            System.out.println(String.format(lineFormat,"DueDate","Title","Project","Completed"));
            System.out.println(String.format(lineFormat,"-------","------","--------","-------"));

            List<Task> sortedTaskList = taskList.stream()
                    .sorted(Comparator.comparing(Task::getDueDate))
                    .collect((Collectors.toList()));
            for(Task task:sortedTaskList)
                System.out.println(String.format(lineFormat,task.getDueDate(),task.getTitle(),task.getProject(),task.getStatus()?"Yes":"No"));
        }
    }

    public int completedTaskCount(){
        // to be implemented
        int count=0;
        for(Task task:taskList){
            if(task.getStatus())
                count++;
        }
        return count;
    }

    public int notCompletedCount(){
        int count=0;
        for(Task task:taskList){
            if(!task.getStatus())
                count++;
        }
        return count;
    }

    //Read new tasks from user
    public boolean readNewTasks()  {
        try {
            Scanner scanner = new Scanner(System.in);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println("Please Enter Task Details");
            System.out.println("-------------------------");
            System.out.println("Enter Title of the task:");
            String title = scanner.nextLine( );
            System.out.println("Enter due date of the project:(yyyy-MM-dd)");
            LocalDate dueDate = LocalDate.parse(scanner.nextLine( ));
            System.out.println("Enter the project name(Home/SDA/Kids/Others):");
            String project = scanner.next( );

            this.taskList.add(new Task(title, project, dueDate));
            System.out.println("Task is added successfully" );
            return true;

        }catch(Exception e){
            System.out.println("Task not added! Please enter the correct date format." );
            return false;
        }
    }

}