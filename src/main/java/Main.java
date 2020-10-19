import java.util.Scanner;

/** Main Class with main method of the project
 * @author Kalpana TS
 * @version 1.0
 * @Date 07/10/2020
 */


public class Main {
    // A string variable to hold the data file name.
    public static String fileName = "tasks.obj";

    /**
     * main method to run the command line based To Do List application
     * @param args array of String holding command line parameters
     */
    public static void main(String[] args) {
        // An object to hold all tasks and its details
        TaskList taskList = new TaskList();
        //To store choice chosen by the user
        int choice = -5;

        try {
            Scanner scanner = new Scanner(System.in);
            //Reading old tasks data from the data file. If it is the first time
            //of running the application , a message will be displayed.
            taskList.readTasksFromFile(fileName);

            //To display the welcome message
            Display.welcomeMsg();

            while (choice != 4) {

                    Display.mainMenu(taskList.notCompletedCount(), taskList.completedTaskCount());
                    // Reading the choice from user and validating it
                    choice = readAndValidateChoice();
                    boolean  listHasTasks;

                    switch(choice){
                        case 1:
                            Display.listAllMenuDisplay();
                            taskList.displaySortedTasksList(scanner.nextLine());
                            break;
                        case 2:
                            taskList.readNewTasksFromUser();
                            break;
                        case 3:
                            listHasTasks = taskList.displayAllTasksWithIndex();
                            if(listHasTasks) {
                                Display.displayEditTaskSelection( );
                                taskList.editTask(scanner.nextLine( ));
                            }
                            break;
                        case 4:
                            taskList.writeTaskObj(fileName);
                            Display.goodByeMessage();
                            break;
                        default:
                            Display.wrongChoice();
                    }
            }

        }catch(Exception e){
            System.out.println("Exception Caught: " + e);
            System.out.println("Writing unsaved data in to the file" );
            taskList.writeTaskObj(fileName);
            System.out.println("The application quits with error");
        }
    }


    /** Reading the choice from user using scanner nad validating it as a number
     * @return returning the user's choice
     */
    public static int readAndValidateChoice(){
        Scanner sc = new Scanner(System.in);
        int choice=50;
        do {

            if(choice<=0)
             System.out.println("Please enter a number between 1 to 4!");

            while (!sc.hasNextInt()) {
                System.out.println("That's not a number!");
                sc.next();
            }
            choice = sc.nextInt();
        } while (choice <= 0);
        return choice;
    }
}
