package baseClassHRMS;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class shanBase {

	public static WebDriver driver;
    public static Properties prop;
    //public static WebDriverWait wait;
 
    @BeforeTest
    public void TestBase() throws IOException{
        try {
            // Load the properties file
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\properties\\globalData");
            prop.load(ip);
		}
        catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    public static void browserLaunch() {
        // Check the browser type from properties
        String browserName = prop.getProperty("browser");
        if (browserName.equals("chrome")) {
             // Update with your actual path
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("FF")) {
             // Update with your actual path
            driver = new FirefoxDriver();
        } 
        else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
        }
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(prop.getProperty("url"));
    }
 
    public static void closeApp() {
        // Close the browser after test completion
            driver.quit();
    }

}
