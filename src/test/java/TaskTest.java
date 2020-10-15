
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Test class for Task model class
 *
 * Implemented unit testing for all the methods of Task class
 * @author Kalpana
 * @version 1.0
 * @since 2020-10-15
 */

public class TaskTest {
    Task task;

    String validTitle="Test Title";
    String validProject="Test Project";
    LocalDate validDueDate=LocalDate.parse("2021-12-31");
    String validStatus="Incomplete";

    /**
     * This method will execute before executing any Test.
     * This method will initialize the task object with valid test parameters.
     * @throws Exception
     */

    @BeforeEach
    public void setUp() throws Exception{
        try{
            task = new Task(validTitle, validProject, validDueDate, validStatus);
        }catch(Exception e){
            System.out.println("Following is the error on testing of Task class" );
            System.out.println(e.getMessage());
        }
    }
    /**
     * Assert the task.getTitle() return the correct title
     */
    @Test
    public void testValidTitle() {
        assertEquals(validTitle,task.getTitle());
    }

    /**
     * Assert the task.getDueDate() return the correct Date
     */
    @Test
    public void testValidDueDate() {
        assertEquals(validDueDate,task.getDueDate());
    }

    /**
     * Assert the task.getProject() return the correct project
     */
    @Test
    public void testValidProject() {
        assertEquals(validProject,task.getProject());
    }

}