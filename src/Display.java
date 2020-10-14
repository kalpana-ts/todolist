
import java.util.ArrayList;

/* To be implemented
  Welcome message
  Bye message
  Edit task menu
  toString overriding
  Incorrect option message
  Try to implement colors || add in milestones


 */

public class Display {

    TaskList taskList = new TaskList();



    public void welcomeMsg(){
        System.out.println("Welcome to ToDo List App" );
        System.out.println("------------------------" );
    }
  //To display main menu

    public void mainMenuDisplay(){
        System.out.println(" MAIN MENU");
        System.out.println(" __________");
        System.out.println(" \n Select an Option:");
        System.out.println(" 1. View tasks List");
        System.out.println(" 2. Add a new task");
        System.out.println(" 3. Edit task");
        System.out.println(" 4. Remove a task");
        System.out.println(" 5. Save and Quit");

        System.out.println(" Your Choice[1-5]: ");

    }
    //To display the Menu for View tasks
    public void listAllMenuDisplay(){
        System.out.println("View all Tasks");
        System.out.println("______________");
        System.out.println("Select an option:");
        System.out.println("1. View Tasks by Date");
        System.out.println("2. View Tasks by Project");
        System.out.println(" Your Choice[1-2]: ");
    }
    public void showMessage(String message) {

        System.out.println(">>> " + message);

    }



   //    public void diplayAllTasks(){
   //     ArrayList<Task> taskArrayList=taskList.listAllTask();

  //      System.out.println(taskArrayList);
   //     for(Task t:taskArrayList){
   //         System.out.println(t.toString() );
   //     }
   //   System.out.println(taskArrayList.get(0).toString());

    //    }
}
