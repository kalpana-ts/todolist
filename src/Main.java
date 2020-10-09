/** Main Class with main method of the project
 * @author Kalpana TS
 * @version 1.0
 * @Date 07/10/2020
 */

import java.text.ParseException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);

        Display display = new Display( );
        int choice = 0;
        try {

        //    Task task = new Task( );
            TaskList taskList = new TaskList();


            display.welcomeMsg();

            while (choice != 5) {
                    display.mainMenuDisplay( );
                    choice = scanner.nextInt();

                    switch(choice){
                        case 1:
                            display.listAllMenuDisplay();
                            display.diplayAllTasks();
                            break;
                        case 2:
                            taskList.readNewTasks();
                            taskList.writeTaskObj();
                            break;
                        case 3:
                            System.out.println("-yet to Write edit method" );
                            break;
                        case 4:
                            System.out.println("yet to write Remove method" );
                            break;
                        case 5:
                            taskList.writeTaskObj();
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
