import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Array;
import java.util.ArrayList;

// ArrayList of Task object
public class TaskList {
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
            output.close();
            file.close();

            System.out.println("Tasks saved to the file" );


        }catch(IOException e){
            System.out.println("File doesn't found" + e );
        }
    }

}
