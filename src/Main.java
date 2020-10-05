/** Main Class with main method of the project
 * @author Kalpana TS
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {




    public static void main(String[] args) throws ParseException {
        try {
          Scanner scanner = new Scanner(System.in);

          Display display = new Display( );

            Task task = new Task( );
            TaskList tL = new TaskList();

            int choice = 0;
            display.welcomeMsg();

            while (choice!=6) {
                    display.mainMenuDisplay( );
                    choice = scanner.nextInt();

                    switch(choice){
                        case 1:
                            System.out.println("yet to Write a displayList Menu and call it");
                            break;
                        case 2:
                            display.addMenuDisplay();
                            break;
                        case 3:
                            System.out.println("-yet to Write edit method" );
                            break;
                        case 4:
                            System.out.println("yet to write Remove method" );
                            break;
                        case 5:
                            tL.writeTaskObj();
                            break;
                        case 6:
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
