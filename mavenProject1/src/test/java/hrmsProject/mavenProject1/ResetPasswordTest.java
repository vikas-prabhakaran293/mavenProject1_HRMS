package hrmsProject.mavenProject1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClassHRMS.BaseClass;
import locators.pages.LoginPageLocators;
import locators.pages.ResetPasswordPageLocators;

public class ResetPasswordTest extends BaseClass {
	public LoginPageLocators loginPageLocators;
	public ResetPasswordPageLocators resetPasswordPageLocators;
	
	@BeforeClass
	public void launchBrowser() {
		browserLaunch();
		loginPageLocators = new LoginPageLocators();
		resetPasswordPageLocators = new ResetPasswordPageLocators();
}
	@Test (priority = 1)
	public void resetPasswordPageLogo(){
		loginPageLocators.forgotPassWord();
		Assert.assertTrue((resetPasswordPageLocators.ResetPasswordPageLogo).isDisplayed());
		System.out.println("Reset Password Page Logo was displayed in the Reset Password Page...!");
		String ResetPasswordLogo = resetPasswordPageLocators.ResetPasswordPageLogo.getAttribute("src");
		System.out.println(ResetPasswordLogo);
	}
	
	@Test (priority = 2)
	public void resetPasswordPageTitle() throws InterruptedException {
		//loginPageLocators.forgotPassWord();
		Assert.assertTrue((resetPasswordPageLocators.ResetPasswordPageTitle).isDisplayed());
		System.out.println((resetPasswordPageLocators.ResetPasswordPageTitle).getText());
		Thread.sleep(2000);
		resetPasswordPageLocators.goBackToLogin();
	}
	
	@Test (priority = 3)
	public void goBackToLogin() throws InterruptedException {
		loginPageLocators.forgotPassWord();
		Thread.sleep(3000);
		String actualResult = driver.getCurrentUrl();
		String expectedResult = "https://skad.timetracks.us/forgot-password";
		Assert.assertEquals(actualResult, expectedResult);
		System.out.println("Redirected to the Reset password page");
		resetPasswordPageLocators.goBackToLogin();
		System.out.println("Again Redirected to the Login Page");
	}
	
	@Test (priority = 4)
	public void resetPwdRequiredfieldAlertMessage() throws InterruptedException {
		loginPageLocators.forgotPassWord();
		Thread.sleep(3000);
		String actualResult = driver.getCurrentUrl();
		String expectedResult = "https://skad.timetracks.us/forgot-password";
		Assert.assertEquals(actualResult, expectedResult);
		System.out.println("Redirected to the Reset password page");
		resetPasswordPageLocators.resetPassword();
		Assert.assertTrue((resetPasswordPageLocators.UnRequiredFieldAlert).isDisplayed());
		System.out.println((resetPasswordPageLocators.UnRequiredFieldAlert).getText());
		resetPasswordPageLocators.goBackToLogin();
	}
	
	@Test (priority = 5)
	public void invalidEmailID() throws InterruptedException {
		loginPageLocators.forgotPassWord();
		Thread.sleep(3000);
		//loginPageLocators.UserName.clear();
		//loginPageLocators.forgotPassWord();
		//Thread.sleep(3000);
		String actualResult = driver.getCurrentUrl();
		String expectedResult = "https://skad.timetracks.us/forgot-password";
		Assert.assertEquals(actualResult, expectedResult);
		System.out.println("Redirected to the Reset password page");
		resetPasswordPageLocators.incorrectUserName();
		resetPasswordPageLocators.resetPassword();
		Assert.assertTrue((resetPasswordPageLocators.ErrorPopup).isDisplayed());
		System.out.println((resetPasswordPageLocators.ErrorPopup).getText());
		Assert.assertTrue((resetPasswordPageLocators.ErrorMessageoftheErrorPopup).isDisplayed());
		System.out.println((resetPasswordPageLocators.ErrorMessageoftheErrorPopup).getText());
		resetPasswordPageLocators.errorPopupOKbutton();
		resetPasswordPageLocators.goBackToLogin();
	}
	
	@Test (priority = 6)
	public void clickCancelButtonWhichIsInTheErrorPopup() throws InterruptedException {
		loginPageLocators.forgotPassWord();
		Thread.sleep(3000);
		String actualResult = driver.getCurrentUrl();
		String expectedResult = "https://skad.timetracks.us/forgot-password";
		Assert.assertEquals(actualResult, expectedResult);
		System.out.println("Redirected to the Reset password page");
		resetPasswordPageLocators.incorrectUserName();
		resetPasswordPageLocators.resetPassword();
		Assert.assertTrue((resetPasswordPageLocators.ErrorPopup).isDisplayed());
		System.out.println((resetPasswordPageLocators.ErrorPopup).getText());
		Assert.assertTrue((resetPasswordPageLocators.ErrorMessageoftheErrorPopup).isDisplayed());
		System.out.println((resetPasswordPageLocators.ErrorMessageoftheErrorPopup).getText());
		resetPasswordPageLocators.errorPopupCancelButton();
		Thread.sleep(2000);
		resetPasswordPageLocators.goBackToLogin();
	}
	
	@Test (priority = 7)
	public  void forgotPassword() throws InterruptedException {
//		Assert.assertTrue((loginPageLocators.forgotPassword).isDisplayed());
//		Thread.sleep(3000);
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//WebElement element = wait.until(ExpectedConditions.elementToBeClickable((WebElement) loginPageLocators.forgotPassWord()));
		//loginPageLocators.clearFields();
		loginPageLocators.forgotPassWord();
		Thread.sleep(3000);
		String actualResult = driver.getCurrentUrl();
		String expectedResult = "https://skad.timetracks.us/forgot-password";
		Assert.assertEquals(actualResult, expectedResult);
		System.out.println("Redirected to the Reset password page");
		resetPasswordPageLocators.userNameField();
		resetPasswordPageLocators.resetPassword();
		Assert.assertTrue((resetPasswordPageLocators.otpSentPopup).isDisplayed());
		System.out.println((resetPasswordPageLocators.otpSentPopup).getText());
	}
	
	@AfterClass
	public void closeBrowser() {
		closeApp();
	}
}
