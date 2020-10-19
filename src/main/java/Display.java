/** This class contains all the codes to display as menu
 * @author Kalpana TS
 * @version 1.0
 * @Date 07/10/2020
 */

public class Display {
    //Constant fields to fix the color of the text accordingly
    public static final String RED_TEXT = "\u001B[31m";
    public static final String GREEN_TEXT = "\u001B[32m";
    public static final String RESET_TEXT = "\u001B[0m";


    /**
     *This method prints Welcome Message when a user starts the application
     */
    public static void welcomeMsg(){
        System.out.println(GREEN_TEXT+ "Welcome to ToDo List App" );
        System.out.println("------------------------" + RESET_TEXT);
    }


    /**
     *This is the main menu of the application with all the options
     */
    public static void mainMenu(){
        System.out.println("\n MAIN MENU");
        System.out.println(" __________");
        System.out.println(" \n Select an Option:");
        System.out.println(" 1. View tasks List(View by Date/View by Project)");
        System.out.println(" 2. Add a new task");
        System.out.println(" 3. Edit a task(Mark as Done/Remove/update)");
        System.out.println(" 4. Save and Quit");

        System.out.print(" Your Choice[1-4]: ");

    }

    /**
     * To display the Menu for View tasks
     */
    public static void listAllMenuDisplay(){
        System.out.println("\nView all Tasks");
        System.out.println("______________");
        System.out.println("Select an option:");
        System.out.println("1. View Tasks by Date");
        System.out.println("2. View Tasks by Project");
        System.out.print(" Your Choice[1-2]: ");
    }

    /**
     * This is edit task menu
     */
    public static void editTaskMenu(){
        System.out.println("\nEdit a Task");
        System.out.println("-----------");
        System.out.println("Select an option");
        System.out.println("1. Mark as Done");
        System.out.println("2. Edit a selected task" );
        System.out.println("3. Remove a task" );
        System.out.println("4. Exit (Go back to Main menu)" );
        System.out.print("Enter your choice[1-4]: ");
    }

    /**
     * This is to ask the user which task is to be edited
     */
    public static void displayEditTaskSelection(){
        System.out.print(GREEN_TEXT+ "\nEnter the task number to edit and press enter:"+RESET_TEXT);
    }

    /**
     * The print Iterator method is used to print a character for particular number of times(count)
     * This is used to format the display
     *
     * @param character a character to be printed(eg. '-','=')
     * @param count it represents how many times the character is to be printed
     */
    public static void printIterator(char character, int count){
        for(int index=0; index<count; index++)
            System.out.print( character);
        System.out.println();
    }

    /**
     * This displays a warning message when user enters a wrong choice
     */
    public static void wrongChoice() {
        System.out.println(RED_TEXT);
        System.out.println("Incorrect choice: Please enter a valid choice");
        System.out.print(RESET_TEXT);
    }
}
