package baseClassHRMS;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;

public class BaseClass1 {

	public static WebDriver driver;
	public static Properties prop;
	public static ExtentReports extent;
	
	@BeforeTest
    public void loadConfig() throws IOException {
        //if (driver == null) {
		try {
			prop = new Properties();
            FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\properties\\globalData");
            System.out.println(file);
            prop.load(file);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}	
	     //@Parameters("browser")
         public  static void browserLaunch(){  
            String browserName1 = prop.getProperty("browser");
            System.out.println(browserName1);
            if (browserName1.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            } else if (browserName1.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            }
            else if (browserName1.equalsIgnoreCase("IE")) {
                driver = new InternetExplorerDriver();
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.get(prop.getProperty("url"));
         }
//	     public String validLoginCredentials() {
//	    	 String userName1 = prop.getProperty("validUserName");
//	    	 return userName1;
//	     }
//	     public String invalidLoginCredentials() {
//	    	 String userName1 = prop.getProperty("validUserName");
//	    	 return userName1;
//	     }
         
	     public void closeApp() {
	    	 if (driver != null) {
	             driver.quit();
	         }
	     }

}
