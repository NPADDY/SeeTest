//package <set your test package>;
import com.experitest.client.*;
import org.junit.*;
/**
 *
*/
public class Multiply {
    private String host = "localhost";
    private int port = 8889;
    private String projectBaseDirectory = "C:\\Users\\34275\\workspace\\Calculator";
    protected Client client = null;

    @Before
    public void setUp(){
        client = new Client(host, port, true);
        client.setProjectBaseDirectory(projectBaseDirectory);
        client.setReporter("xml", "reports", "Mulitply");
    }

    @Test
    public void testMulitply(){
        client.setDevice("adb:SAMSUNG-SGH-I317");
        if(client.install("C:\\JenkinsLab\\workspace\\Calculator\\app\\build\\outputs\\apk\\app-debug.apk", true, false)){
           //  If statement
        }
        client.launch("com.cmdann.cmdanncalculator/.Calculator", true, false);
        client.click("NATIVE", "xpath=//*[@text='8']", 0, 1);
        client.sleep(2000);
        client.click("NATIVE", "xpath=//*[@text='6']", 0, 1);
        client.sleep(2000);
        client.click("NATIVE", "xpath=//*[@text='x']", 0, 1);
        client.sleep(2000);
        client.click("NATIVE", "xpath=//*[@text='4']", 0, 1);
        client.sleep(2000);
        client.click("NATIVE", "xpath=//*[@text='=']", 0, 1);
        client.sleep(1000);
        client.click("NATIVE", "xpath=//*[@text='C']", 0, 1);
        client.sleep(1000);
        if(client.applicationClose("com.cmdann.cmdanncalculator")){
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
