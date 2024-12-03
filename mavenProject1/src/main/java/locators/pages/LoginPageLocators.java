package locators.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import baseClassHRMS.BaseClass;

public class LoginPageLocators extends BaseClass{
	String Username = "vikaspk293@gmail.com";
	String Password = "Testing@1234";
	String Username1 = "vikaspk293@gmail.com";
	String Password1 = "Testing@123";
	String givenAlertMessage = "Invalid Login Credentials";
	String expectedResult = "https://skad.timetracks.us/timesheets";
	//String actualResult = driver.getCurrentUrl();
	
	@FindBy(xpath = "//*[@id=\"main-wrapper\"]/div/div/div[3]/div[1]/div/div/div/img")
	public WebElement logo;
	
	@FindBy (xpath = "//*[@id=\"main-wrapper\"]/div/div/div[3]/div[2]/div/div[1]/img")
	public WebElement LoginPageLogo;
	
	@FindBy (xpath = "//*[@id=\"main-wrapper\"]/div/div/div[3]/div[2]/div/div[2]/div")
	public WebElement LoginPageTitle;
	
	@FindBy (xpath = "//*[@id=\"main-wrapper\"]/div/div/div[2]/img")
	public WebElement ImageInTheLoginPage;
	
	@FindBy (xpath = "//*[@id=\"primary_email-error\"]")
	public WebElement UnRequiredFieldAlert;
	
	@FindBy (xpath = "//*[@id=\"password-error\"]")
	public WebElement PwdRequiredFieldAlert;
	
	@FindBy(name = "primary_email")
	public static WebElement UserName;
	
	@FindBy(id = "password")
	public static WebElement PassWord;
	
	@FindBy(xpath = "//*[@id=\"login-form\"]/div[2]/div/span[2]")
	public WebElement showPasswordToggle;
	
	@FindBy(xpath = "//*[@id=\"login-form\"]/div[3]/div[2]/div/a")
	public WebElement forgotPassWord;
	
	@FindBy (id = "remember_me")
	public WebElement KeepMeLoggedIn;
	
	@FindBy (id = "login")
	public WebElement loginButton;
	
	@FindBy (xpath = "/html/body/div[1]")
	public WebElement alertMessage;
	
	@FindBy (xpath = "/html/body/div[1]")
	public WebElement ConfirmationMessage;
	
	@FindBy (xpath = "//a[normalize-space()='Forgot Password?']")
	public WebElement forgotPassword;
	
	public LoginPageLocators() {
		PageFactory.initElements(driver, this);
	}

	public static void validUserName() {
		UserName.sendKeys(ValidUserName());
	}
	
	public static void validPassword() {
		PassWord.sendKeys(ValidPassword());
	}
	
	//InValid UserName
	public void userNameField() {
		UserName.sendKeys(Username);
	}
	
	//Invalid Password
	public void passwordField() {
		PassWord.sendKeys(Password);
	}
	
	//Valid UserName
	public void userNameField1() {
		UserName.sendKeys(Username1);
	}
	
	//Valid PassWord
	public void passWordField1() {
		PassWord.clear();
		PassWord.sendKeys(Password1);
	}
	
	//To click the Login Button
	public void loginButton() {
		loginButton.click();
	}
	
	public void clearFields() {
		UserName.clear();
		PassWord.clear();
	}
	
	// To click the Show Paasword Toggle Icon
	public void showPaaswordToggle() throws InterruptedException {
		showPasswordToggle.click();
		}
	
//	//To capture the image which is displayed in the login page.
//	public void imageInTheLoginPage() {
//		String ImageDisplayed = ImageInTheLoginPage.getAttribute("src");
//		System.out.println(ImageDisplayed);
//	}
	
	//To click the forgot password
	public void forgotPassWord() {
		 forgotPassword.click();
	}
	
	// To click the keep me logged button.
	public void keepMeLoggedIn() {
		KeepMeLoggedIn.click();
	}
}