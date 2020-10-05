

/** Main Class with main method of the project.
 * @author KalpanaTS
 *
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> taskList = new ArrayList<Task>(  );

        Task task = new Task();
        int choice = 0;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        String title,description,status,project;
        Date dueDate;

        while(choice!=5 || choice!=6 ) {
            System.out.println(" MAIN MENU");
            System.out.println(" __________");
            System.out.println(" \n Select an Option:");
            System.out.println(" 1. List tasks");
            System.out.println(" 2. Add a new task");
            System.out.println(" 3. Edit task");
            System.out.println(" 4. Remove a task");
            System.out.println(" 5. Save and Quit");
            System.out.println(" 6. Quit without saving");
            System.out.println(" Your Choice[1-6]: ");

            choice = scanner.nextInt( );
            if(choice == 2){
                System.out.println("Please Enter Task Details " );
                System.out.println("Enter Title of the task:" );
                title = scanner.next();
                //task.setTaskTitle(scanner.next());
                System.out.println("Enter description of the task: " );
                description = scanner.next();
                System.out.println("Enter due date of the project:(dd/MM/yyyy)" );
                String dueDatestr = scanner.nextLine();
                dueDate = sdf.parse(dueDatestr);

            }
        }

    }
}
