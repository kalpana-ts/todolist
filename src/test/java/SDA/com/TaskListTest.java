package SDA.com;

import SDA.com.Task;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

class TaskListTest {
    private ArrayList<Task> taskList = new ArrayList<>( );
    String validTitle="Test Title";
    String validProject="Test Project";
    LocalDate validDueDate=LocalDate.parse("2021-12-31");
    String validStatus="Incomplete";
    @BeforeAll
    public void setUp() throws Exception{
        try{
            taskList.add(new Task(validTitle, validProject,validDueDate));
            taskList.add(new Task("Pay Bill", "Home",LocalDate.parse("2021-12-30")));
            taskList.add(new Task("Finish IP", "SDA",LocalDate.parse("2021-12-01")));

        }catch(Exception e){
            System.out.println("Following is the error on testing of SDA.com.TaskList class" );
            System.out.println(e.getMessage());
        }
    }
    @Test
    void readTasksFromFile() {
    }

    @Test
    void addTaskIntoTheList() {


    }

    @Test
    void displaySortedTasksList() {

    }

    @Test
    void displayAllTasksWithIndex() {
    }

    @Test
    void editTask() {
    }

    @Test
    void completedTaskCount() {
    }

    @Test
    void notCompletedCount() {
    }

    @Test
    void writeTaskObj() {
    }
}