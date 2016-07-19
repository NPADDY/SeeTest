//package <set your test package>;
import com.experitest.client.*;
import org.junit.*;
/**
 *
*/
public class Test1 {
    private String host = "localhost";
    private int port = 8889;
    private String projectBaseDirectory = "C:\\Users\\34275\\workspace\\project2";
    protected Client client = null;

    @Before
    public void setUp(){
        client = new Client(host, port, true);
        client.setProjectBaseDirectory(projectBaseDirectory);
        client.setReporter("xml", "reports", "SimpleLoginScript");
    }

    @Test
    public void testSimpleLoginScript(){
        client.setDevice("adb:SAMSUNG-SGH-I317");
        client.launch("com.example.a34275.simplelogin/.LoginActivity", true, false);
        client.verifyElementFound("TEXT", "SimpleLogin", 0);
        client.verifyElementFound("TEXT", "Email", 0);
        client.click("NATIVE", "xpath=//*[@id='email']", 0, 1);
        client.sendText("foo@example.com");
        client.click("NATIVE", "xpath=//*[@text='']", 0, 1);
        client.sendText("hi");
        client.verifyElementFound("TEXT", "SIGN IN OR REGISTER", 0);
        client.click("NATIVE", "xpath=//*[@text='Sign in or register']", 0, 1);
        if(client.applicationClose("com.example.a34275.simplelogin")){
            // If statement
        }
    }

    @After
    public void tearDown(){
        // Generates a report of the test case.
        // For more information - https://docs.experitest.com/display/public/SA/Report+Of+Executed+Test
        client.generateReport(false);
        // Releases the client so that other clients can approach the agent in the near future. 
        client.releaseClient();
    }
}
