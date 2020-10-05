import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Display {
    Scanner scanner = new Scanner(System.in);
    Task task;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public void welcomeMsg(){
        System.out.println("Welcome to ToDo List App" );
        System.out.println("------------------------" );
    }

    public void mainMenuDisplay(){
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

    }

    public void addMenuDisplay() throws ParseException {
            System.out.println("Please Enter Task Details");
            System.out.println("-------------------------" );
            System.out.println("Enter Title of the task:");
            String title = scanner.nextLine( );
            System.out.println("Enter description of the task: ");
            String description = scanner.nextLine( );
            System.out.println("Enter due date of the project:(dd/MM/yyyy)");
            Date dueDate = sdf.parse(scanner.nextLine());
            System.out.println("Enter the project name(Home/SDA/Kids/Others):");
            String project = scanner.next();
            task = new Task(title,description,dueDate,"No",project);

        }
}
