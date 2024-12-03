package hrmsProject.mavenProject1;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClassHRMS.BaseClass;
import locators.pages.LoginPageLocators;

public class HrmsLoginTest extends BaseClass {
	public LoginPageLocators loginPageLocators;
	
	@BeforeClass
	public void launchBrowser() {
		browserLaunch();
		loginPageLocators = new LoginPageLocators();
	}
	
	@Test (priority = 1)
	public void logo() {
		Assert.assertTrue((loginPageLocators.logo).isDisplayed());
		System.out.println("Logo is displayed in the Web Page");
	}
	
	@Test (priority = 2)
	public void loginPageLogo() {
//		d
		System.out.println("com");
		Assert.assertTrue((loginPageLocators.LoginPageLogo).isDisplayed());
	System.out.println("Login Page Logo is displayed in the Web Page");
	}
	
	@Test (priority = 3)
	public void loginPageTitle() {
		Assert.assertTrue((loginPageLocators.LoginPageTitle).isDisplayed());
		System.out.println((loginPageLocators.LoginPageTitle).getText());
	}
	
	@Test (priority = 4)
	public void imageInTheLoginPage() {
		Assert.assertTrue((loginPageLocators.ImageInTheLoginPage).isDisplayed());
		System.out.println("Image was displayed in the login page...!");
		String ImageDisplayed = loginPageLocators.ImageInTheLoginPage.getAttribute("src");
		System.out.println(ImageDisplayed);
	}
	
	@Test (priority = 5)
	public void keepMeLoggedIn() {
		loginPageLocators.keepMeLoggedIn();
		if((loginPageLocators.KeepMeLoggedIn).isSelected()){
			System.out.println("Keep me logged in was selected");
		}
		else {
			System.out.println("Keep me logged in was not selected");
		}
	}
	
	@Test (priority = 6)
	public void forgotPasswordDisplayed() {
		Assert.assertTrue((loginPageLocators.forgotPassword).isDisplayed());
		System.out.println((loginPageLocators.forgotPassword).getText());
	}
	
	@Test (priority = 7)
	public void showPasswordIcon() throws InterruptedException {
		loginPageLocators.userNameField();
		loginPageLocators.passwordField();
		loginPageLocators.loginButton();
		Thread.sleep(3000);
		loginPageLocators.showPaaswordToggle();
		String initialType = loginPageLocators.PassWord.getAttribute("type");
		System.out.println(initialType);
		loginPageLocators.showPaaswordToggle();
		Thread.sleep(3000);
		String toggledType = loginPageLocators.PassWord.getAttribute("type");
		System.out.println(toggledType);
		if (toggledType.equals("text")) {
            System.out.println("Password visibility is enabled.");
        } else {
            System.out.println("Password visibility is disabled.");
        }
	}
	
	@Test (priority = 8)
	public void invalidCredentials() throws InterruptedException {
		loginPageLocators.clearFields();
		loginPageLocators.userNameField();
		loginPageLocators.passwordField();
		loginPageLocators.loginButton();
		Thread.sleep(2000);
		String givenAlertMessage = "Invalid Login Credentials";
		Assert.assertTrue((loginPageLocators.alertMessage).isDisplayed());
		System.out.println((loginPageLocators.alertMessage).getText());
		if (loginPageLocators.alertMessage.equals(givenAlertMessage)) {
			System.out.println("Both alert messages were same");
		}
		else {
			System.out.println("alertMessage and givenAlertMessage was mismatched");
		}
		System.out.println("Login done successfully");
	}
	
	@Test (priority = 9)
	public void validCredentials() throws InterruptedException {
		loginPageLocators.clearFields();
		LoginPageLocators.validUserName();
		LoginPageLocators.validPassword();
//		loginPageLocators.userNameField1();
//		loginPageLocators.passWordField1();
		loginPageLocators.keepMeLoggedIn();
		loginPageLocators.loginButton();
		Thread.sleep(2000);
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		Assert.assertTrue((loginPageLocators.ConfirmationMessage).isDisplayed());
		System.out.println((loginPageLocators.ConfirmationMessage).getText());
		Thread.sleep(3000);
		String actualResult = driver.getCurrentUrl();
		String expectedResult = "https://skad.timetracks.us/timesheets";
		Assert.assertEquals(actualResult, expectedResult);
     	System.out.println("Logged in successfully");
		//loginPageLocators.getCurrentURL();	
	}
	
	@AfterClass
	public void closeBrowser() {
		closeApp();
	}
	
}
