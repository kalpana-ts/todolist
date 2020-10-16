import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * This class contains the actual Task List as an arraylist
 *
 * @author Kalpana TS
 * @version 1.0
 * @Date 07/10/2020
 */


public class TaskList {

    private ArrayList<Task> taskList;


    public TaskList() {
        taskList = new ArrayList<>( );
    }

    /**
     *
     */

    public void readTasksFromFile(String fileName) {
        //    ArrayList<Task> list = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream stream = new ObjectInputStream(file);

            // read thing from the stream
            taskList = (ArrayList<Task>) stream.readObject( );

            stream.close( );
            file.close( );
        } catch (IOException e) {
            System.out.println("File doesn't found " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("problems inside the file " + e);
        }

    }

    /**
     * @param choice
     */
    public void displaySortedTasksList(int choice) {
        Display.separator('-', 75);
        System.out.println("Total Tasks = " + taskList.size( ) +
                "\t\t" + Display.GREEN_TEXT + "Tasks Completed = " + completedTaskCount( ) + "\t\t" +
                Display.RED_TEXT + " Tasks Not Completed = " + notCompletedCount( ) + Display.RESET_TEXT);
        Display.separator('-', 75);

        if (taskList.size( ) == 0) {
            System.out.println(Display.RED_TEXT + "Task list is empty" + Display.RESET_TEXT);
            return;
        }

        if (choice == 2) {
            String lineFormat = "%-20s %-35s %-13s %-10s";
            System.out.println(String.format(lineFormat, "Project", "Title", "DueDate", "Completed"));
            System.out.println(String.format(lineFormat, "-------", "------", "--------", "-------"));

            List<Task> sortedTaskList = taskList.stream( )
                    .sorted(Comparator.comparing(Task::getProject))
                    .collect((Collectors.toList( )));

            for (Task task : sortedTaskList)
                System.out.println(String.format(lineFormat, task.getProject( ), task.getTitle( ), task.getDueDate( ), task.getStatus( ) ? "Yes" : "No"));
            System.out.println( );
        } else {
            String lineFormat = "%-13s %-35s %-20s %-10s";
            System.out.println(String.format(lineFormat, "DueDate", "Title", "Project", "Completed"));
            System.out.println(String.format(lineFormat, "-------", "-----", "-------", "---------"));

            List<Task> sortedTaskList = taskList.stream( )
                    .sorted(Comparator.comparing(Task::getDueDate))
                    .collect((Collectors.toList( )));

            for (Task task : sortedTaskList)
                System.out.println(String.format(lineFormat, task.getDueDate( ), task.getTitle( ), task.getProject( ), task.getStatus( ) ? "Yes" : "No"));
            System.out.println( );
        }
    }

    public void displayAllTasksWithIndex(){
        String lineFormat = "%-5s %-35s %-20s %-13s %-10s";
        if (taskList.size( ) == 0) {
            System.out.println(Display.RED_TEXT + "Task list is empty" + Display.RESET_TEXT);
            return;
        }
        System.out.println(String.format(lineFormat, "Num", "Title", "Project", "DueDate", "Completed"));
        System.out.println(String.format(lineFormat, "---", "-----", "-------", "-------", "---------"));

        for (Task task : taskList)
            System.out.println(String.format(lineFormat,taskList.indexOf(task)+1, task.getTitle( ), task.getProject( ), task.getDueDate( ), task.getStatus( ) ? "Yes" : "No"));
        System.out.println( );
    }

    //Read new tasks from user
    public boolean readNewTasksFromUser(){
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Please Enter Task Details");
            System.out.println("-------------------------");
            System.out.println("Enter Title of the task:");
            String title = scanner.nextLine( );
            System.out.println("Enter due date(yyyy-MM-dd): ");
            LocalDate dueDate = LocalDate.parse(scanner.nextLine( ));
            System.out.println("Enter the project name(Home/SDA/Kids/Others):");
            String project = scanner.nextLine( );

            this.taskList.add(new Task(title, project, dueDate));
            System.out.println("Task added to the list successfully");

            return true;

        } catch (Exception e) {
            System.out.println("Task not added!");
            return false;
        }
    }
    /**
     * @param taskChoice
     * @throws NullPointerException
     */
    public void editTask(String taskChoice) throws NullPointerException{
        try{
            // Checking the if the taskChoice given is not null or empty
            if(taskChoice.trim().equals("") || taskChoice == null ){
                throw new NullPointerException("Empty Task Number: Returning to main menu");
            }
            int taskIndex = Integer.parseInt(taskChoice) -1;
            if(taskIndex <= 0 || taskIndex > taskList.size()){
                throw new ArrayIndexOutOfBoundsException("Task selected is not in the List:returning to main menu");
            }

            Task task = taskList.get(taskIndex);

            System.out.println("Selected task is  :"+ task );

            Display.editTaskMenu();
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();
            switch(choice) {
                case "1":
                    task.markTaskCompleted();
                    System.out.println(Display.GREEN_TEXT+"Task Number " + taskChoice + " marked as done"+Display.RESET_TEXT );
                    break;
                case "2":
                    readTasksFromUserToUpdate(task);
                    break;
                case "3":
                    taskList.remove(task);
                    System.out.println(Display.GREEN_TEXT + "Task Number "+ taskChoice + " is removed from the List");
                    break;
                default:
                    System.out.println(Display.RED_TEXT + "Unexpected value: " + choice + Display.RESET_TEXT);
            }
        }catch (Exception e) {
            System.out.println(Display.RED_TEXT + e.getMessage() + Display.RESET_TEXT);
        }
    }

    private void readTasksFromUserToUpdate(Task task) {
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.println("Enter Task Details to Update:");

            System.out.print("Task Title(Press enter if you do not want to change the title): " );
            String title = scanner.nextLine();
            if(!(title.trim().equals("") || title == null))
                task.setTitle(title);

            System.out.print("Project Name(Press enter if you do not want to change the project): " );
            String project = scanner.nextLine();
            if(!(project.trim().equals("") || project == null))
                task.setProject(project);

            System.out.print("Due Date[yyyy-MM-dd] (Press enter if you do not want to change the due date): " );
            String dueDate = scanner.nextLine();
            if(!(dueDate.trim().equals("") || dueDate == null))
                task.setDueDate(LocalDate.parse(dueDate));

            System.out.println(Display.GREEN_TEXT+ "Task updated successfully " + Display.RESET_TEXT );

        }catch(Exception e){
            System.out.println(Display.RED_TEXT+ "Task not Update :"+ e.getMessage() + Display.RESET_TEXT );
        }
    }


    /**
     * @return
     */
    public int completedTaskCount(){
        int count = 0;
        for (Task task : taskList) {
            if (task.getStatus( ))
                count++;
        }
        return count;
    }

    public int notCompletedCount() {
        int count = 0;
        for (Task task : taskList) {
            if (!task.getStatus( ))
                count++;
        }
        return count;
    }


    public void writeTaskObj(String filename) {
        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream output = new ObjectOutputStream(file);

            output.writeObject(taskList);
            output.close( );
            file.close( );

            System.out.println("Tasks saved to the file");
            return;
        } catch (IOException e) {
            System.out.println("File doesn't found" + e);
            return;
        }
    }
}