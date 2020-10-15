
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
    //Constant fields to fix the color of the text accordingly
    public static final String RED_TEXT = "\u001B[31m";
    public static final String GREEN_TEXT = "\u001B[32m";
    public static final String RESET_TEXT = "\u001B[0m";


    public static void welcomeMsg(){
        System.out.println("Welcome to ToDo List App" );
        System.out.println("------------------------" );
    }
  //To display main menu

    public static void mainMenuDisplay(){
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
    public static void listAllMenuDisplay(){
        System.out.println("View all Tasks");
        System.out.println("______________");
        System.out.println("Select an option:");
        System.out.println("1. View Tasks by Date");
        System.out.println("2. View Tasks by Project");
        System.out.println(" Your Choice[1-2]: ");
    }

    public static void showMessage(String message) {
        System.out.println(">>> " + message);
    }

    /**
     * The seperator method is used to print a character for particular number of times(count)
     * This is used to format the display
     *
     * @param character a character to be printed(eg. '-','=')
     * @param count it represents how many times the character is to be printed
     */
    public static void seperator(char character,int count){
        for(int index=0; index<count; index++)
            System.out.print( character);
        System.out.println();
    }
}
