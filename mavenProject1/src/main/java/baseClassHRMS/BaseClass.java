package baseClassHRMS;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import locators.pages.LoginPageLocators;

public class BaseClass {
	public static WebDriver driver;
	public static Properties property;
	static long startTime;
	static long endTime;
	public static LoginPageLocators loginPage;
  
	@BeforeTest
	public void loadConfig() throws IOException{
	try {
		property = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\properties\\globalData");
		property.load(file);
	} 
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

	public static void browserLaunch() {
		String browserName = property.getProperty("browser");		
		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		startTime = System.currentTimeMillis();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(property.getProperty("url"));
		try {
			loginPage = new LoginPageLocators();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public WebElement waitForElementToBeVisible(WebElement element) {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	        return wait.until(ExpectedConditions.visibilityOf(element));
	    } catch (TimeoutException e) {
	        System.out.println("Element not visible within timeout: " + element.toString());
	        throw e;
	    }
	}
	
	public static String ValidUserName() {
		String userName = property.getProperty("username");
		return userName;
	}
	public static String ValidPassword() {
		String passWord = property.getProperty("Password");
		return passWord;
	}
	
	public  static void closeApp() {
		driver.quit();
		/*
		 * endTime = System.currentTimeMillis(); long totalTime = startTime + endTime;
		 * System.out.println(totalTime);
		 */
	}
	
}
