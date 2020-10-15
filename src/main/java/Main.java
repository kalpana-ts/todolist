import java.text.ParseException;
import java.util.Scanner;

/** Main Class with main method of the project
 * @author Kalpana TS
 * @version 1.0
 * @Date 07/10/2020
 */


public class Main {
    // A string to hold the data file name which contains all tasks and their details
    public static String filename = "tasks.obj";

    /**
     * main method to run the command line based To Do List application
     * @param args array of String holding command line parameters
     */
    public static void main(String[] args) {

        int choice = 0;
        try {

        //    Task task = new Task( );
            Scanner scanner = new Scanner(System.in);
            TaskList taskList = new TaskList();
            taskList.readTasksFromFile();

            Display.welcomeMsg();

            while (choice != 5) {
                    Display.mainMenuDisplay( );

                    choice = scanner.nextInt();

                    switch(choice){
                        case 1:
                            Display.listAllMenuDisplay();
                            taskList.displayAllTasks(scanner.nextInt());
                            break;
                        case 2:
                            taskList.readNewTasks();
                            break;
                        case 3:
                            System.out.println("-yet to Write edit method" );
                            break;
                        case 4:
                            System.out.println("yet to write Remove method" );
                            break;
                        case 5:
                            taskList.writeTaskObj(filename);
                            break;


                        default:
                            System.out.println("End of the program" );


                    }
            }
        }catch(Exception e){
            System.out.println("Parse Exception");
        }
    }
}
