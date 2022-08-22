import org.junit.runner.*;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;

/**
 * RunLocalTest
 * 
 * A class that runs all JUnit tests for the project
 */
public class RunLocalTest {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestCase.class);
        if (result.wasSuccessful()) {
            System.out.println("Excellent - Tests ran successfully");
        } else {
            for (Failure failure : result.getFailures()) {
                System.out.println(failure.toString());
            }
        }
    }
    
    /**
    * TestCase
    * 
    * A place-holder class to run all the relevant JUnit Tests
    */
    @RunWith(Suite.class)
    @Suite.SuiteClasses({ClientTest.class, CommentTest.class, CommentComponentTest.class,
        GUITest.class, PostTest.class, PostComponentTest.class, ProtocolTest.class,
        ServerTest.class, UserTest.class})
    public static class TestCase { }
}
