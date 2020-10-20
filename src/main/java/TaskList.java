import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
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
    // An array list of task objects
    private ArrayList<Task> taskList;

    /**
     * creating an TaskList object
     */
    public TaskList() {
        taskList = new ArrayList<>( );
    }

    /**
     *This method is to read the Tasks from the data file
     * @param fileName a String which holds the name of the file
     */

    public void readTasksFromFile(String fileName) {
        try {
            if (!Files.isReadable(Paths.get(fileName))) {
                System.out.println(Display.RED_TEXT + " The data file does not exist, Creating a new data file " + Display.RESET_TEXT);
            }
            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream stream = new ObjectInputStream(file);

            // read tasks from the stream
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
     * Method which reads Task details from the user and adds
     * into the Tasks list.
     */
    public void readNewTasksFromUser(){
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("\n Please Enter Task Details");
            System.out.println(" -------------------------");
            System.out.print("\n Enter Title of the task: ");
            String title = scanner.nextLine( );
            System.out.print("\n Enter due date(yyyy-MM-dd): ");
            LocalDate dueDate = LocalDate.parse(scanner.nextLine( ));
            System.out.print("\n Enter the project name(Home/SDA/Kids/Others): ");
            String project = scanner.nextLine();

            this.taskList.add(new Task(title, project, dueDate));
            System.out.println(Display.GREEN_TEXT + "\n Task added to the list successfully" + Display.RESET_TEXT);

        } catch (Exception e) {
            System.out.println(Display.RED_TEXT + " Task not added! Entered data is not valid \n" + e + Display.RESET_TEXT);
        }
    }

    /**
     * Method to display all the Task from list in the sorted order
     * It either sorts the task by due date or by Project name
     * @param choice choice chosen by the user whether to sort the list by date or project
     */
    public void displaySortedTasksList(String choice) {
        Display.printIterator('-', 75);
        System.out.println("Total Tasks = " + taskList.size( ) +
                "\t\t" + Display.GREEN_TEXT + "Tasks Completed = " + completedTaskCount( ) + "\t\t" +
                Display.RED_TEXT + " Tasks Not Completed = " + notCompletedCount( ) + Display.RESET_TEXT);
        Display.printIterator('-', 75);

        if (choice.equals("2")) {
            String lineFormat = "%-20s %-35s %-13s %-10s";

            if (taskList.size( ) > 0) {
                System.out.println( );
                System.out.printf((lineFormat) + "%n", "Project", "Title", "DueDate", "Completed");
                System.out.printf((lineFormat) + "%n", "-------", "------", "--------", "-------");
            } else {
                System.out.println(Display.RED_TEXT + "Task list is empty" + Display.RESET_TEXT);
            }

            List<Task> sortedTaskList = taskList.stream( )
                    .sorted(Comparator.comparing(Task::getProject))
                    .collect((Collectors.toList( )));

            for (Task task : sortedTaskList)
                System.out.printf((lineFormat) + "%n", task.getProject( ), task.getTitle( ), task.getDueDate( ), task.getStatus( ) ? "Yes" : "No");
            System.out.println( );
        } else {
            String lineFormat = "%-13s %-35s %-20s %-10s";

            if (taskList.size() > 0) {
                System.out.println( );
                System.out.printf((lineFormat) + "%n", "DueDate", "Title", "Project", "Completed");
                System.out.printf((lineFormat) + "%n", "-------", "-----", "-------", "---------");
            } else {
                System.out.println(Display.RED_TEXT + "Task list is empty" + Display.RESET_TEXT);
            }

            List<Task> sortedTaskList = taskList.stream( )
                    .sorted(Comparator.comparing(Task::getDueDate))
                    .collect((Collectors.toList( )));

            for (Task task : sortedTaskList)
                System.out.printf((lineFormat) + "%n", task.getDueDate( ), task.getTitle( ), task.getProject( ), task.getStatus( ) ? "Yes" : "No");
            System.out.println( );
        }
    }

    /**
     * Displays all the tasks with index
     * @return a boolean true if list has tasks ; false if list is empty
     */
    public boolean displayAllTasksWithIndex(){
        String lineFormat = "%-5s %-35s %-20s %-13s %-10s";
        if (taskList.size( ) > 0) {
            System.out.println("\n Task List : " );
            System.out.printf((lineFormat) + "%n", "Num", "Title", "Project", "DueDate", "Completed");
            System.out.printf((lineFormat) + "%n", "---", "-----", "-------", "-------", "---------");
        } else {
            System.out.println(Display.RED_TEXT + "\n Task list is empty" + Display.RESET_TEXT);
            return false;
        }
        for (Task task : taskList)
            System.out.printf((lineFormat) + "%n",taskList.indexOf(task)+1, task.getTitle( ), task.getProject( ), task.getDueDate( ), task.getStatus( ) ? "Yes" : "No");
        System.out.println( );
        return true;
    }


    /**
     * shows edit task menu and get the choice from the user to dot he appropriate action
     * @param taskChoice task number selected by the user to update(edit)
     * @throws NullPointerException when user doesn't enter any task number
     */
    public void editTask(String taskChoice) throws NullPointerException{
        try{
            // Checking the if the taskChoice given is not null or empty
            if(taskChoice.trim().equals("")){
                throw new NullPointerException("Empty Task Number: Returning to main menu");
            }
            int taskIndex = Integer.parseInt(taskChoice) -1;
            if(taskIndex < 0 || taskIndex > taskList.size()){
                throw new ArrayIndexOutOfBoundsException("Task selected is not in the List:returning to main menu");
            }

            Task task = taskList.get(taskIndex);

            System.out.println("\nSelected task is  :"+ taskChoice + "\n" + task );


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
                    System.out.println(Display.GREEN_TEXT + "\nTask Number "+ taskChoice + " is removed from the List"+Display.RESET_TEXT);
                    break;
                default:
                    System.out.println(Display.RED_TEXT + "Unexpected choice : Returning to main menu " + choice + Display.RESET_TEXT);
            }
        }catch (Exception e) {
            System.out.println(Display.RED_TEXT + e.getMessage() + Display.RESET_TEXT);
        }
    }

    /**
     * Reads the tasks details from user to edit the task
     * @param task chosen by user to edit
     */
    private void readTasksFromUserToUpdate(Task task) {
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.println("Enter Task Details to Update:");

            System.out.print("Task Title(Press enter if you do not want to change the title): " );
            String title = scanner.nextLine();
            if(!title.trim().equals(""))
                task.setTitle(title);

            System.out.print("Project Name(Press enter if you do not want to change the project): " );
            String project = scanner.nextLine();
            if(!project.trim().equals(""))
                task.setProject(project);

            System.out.print("Due Date[yyyy-MM-dd] (Press enter if you do not want to change the due date): " );
            String dueDate = scanner.nextLine();
            if(!dueDate.trim().equals("")) {
                task.setDueDate(LocalDate.parse(dueDate));
                task.markTaskInComplete();
            }


            System.out.println(Display.GREEN_TEXT+ "Task updated successfully " + Display.RESET_TEXT );

        }catch(Exception e){
            System.out.println(Display.RED_TEXT+ "Task not Updated:"+ e.getMessage() + Display.RESET_TEXT );
        }
    }


    /**
     * to count number of completed tasks
     * @return number completed
     */
    public int completedTaskCount(){
        int count = 0;
        for (Task task : taskList) {
            if (task.getStatus( ))
                count++;
        }
        return count;
    }

    /**
     * to count number of incomplete tasks
     * @return number not completed
     */
    public int notCompletedCount() {
        int count = 0;
        for (Task task : taskList) {
            if (!task.getStatus( ))
                count++;
        }
        return count;
    }


    /**
     * This method is to write all tasks added by the user into the data file
     * @param filename in which data is to be written
     */
    public void writeTaskObj(String filename) {
        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream output = new ObjectOutputStream(file);

            output.writeObject(taskList);
            output.close( );
            file.close( );

            System.out.println("Tasks saved to the file");

        } catch (IOException e) {
            System.out.println("File doesn't found" + e);

        }
    }
}