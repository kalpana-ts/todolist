import java.util.Scanner;

/** Main Class with main method of the project
 * @author Kalpana TS
 * @version 1.0
 * @Date 07/10/2020
 */


public class Main {
    // A string to hold the data file name which contains all tasks and their details
    public static String fileName = "tasks.obj";

    /**
     * main method to run the command line based To Do List application
     * @param args array of String holding command line parameters
     */
    public static void main(String[] args) {
        TaskList taskList = new TaskList();
        int choice = -5;

        try {
            Scanner scanner = new Scanner(System.in);
            taskList.readTasksFromFile(fileName);

            Display.welcomeMsg();

            while (choice != 4) {
                    Display.mainMenu( );

                    choice = readAndValidateChoice();

                    switch(choice){
                        case 1:
                            Display.listAllMenuDisplay();
                            taskList.displaySortedTasksList(readAndValidateChoice());
                            break;
                        case 2:
                            taskList.readNewTasksFromUser();
                            break;
                        case 3:
                            taskList.displayAllTasksWithIndex();
                            Display.displayEditTaskSelection();
                            taskList.editTask(scanner.nextLine());
                            break;
                        case 4:
                            taskList.writeTaskObj(fileName);
                            break;
                        default:
                            Display.wrongChoice();
                    }
            }
        }catch(Exception e){
            System.out.println("Parse Exception");
        }
    }
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
