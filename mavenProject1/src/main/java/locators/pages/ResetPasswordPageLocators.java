package locators.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClassHRMS.BaseClass;

public class ResetPasswordPageLocators extends BaseClass {
	String Username2 = "vikaspk2934@gmail.com";
	String Username = "vikaspk293@gmail.com";
	String Password = "Testing@1234";
	String Username1 = "vikaspk293@gmail.com";
	String Password1 = "Testing@123";
	
	@FindBy (xpath = "//img[@src='https://skad.timetracks.us/img/forgot-password/forgot-icon-top.svg']")
	public WebElement ResetPasswordPageLogo;
	
	@FindBy (xpath = "//div[@class='fs-24 font-weight-500 fc-primary']")
	public WebElement ResetPasswordPageTitle;
	
	@FindBy(name = "primary_email")
	public WebElement UserName;
	
	@FindBy (xpath = "//button[normalize-space()='Reset Password']")
	public WebElement ResetPasswordButton;
	
	@FindBy (xpath = "//*[@id=\"primary_email-error\"]")
	public WebElement UnRequiredFieldAlert;
	
	@FindBy (id = "swal2-title")
	public WebElement otpSentPopup;
	
	@FindBy (id = "swal2-title")
	public WebElement ErrorPopup;
	
	@FindBy (xpath = "//*[@id=\"swal2-html-container\"]")
	public WebElement ErrorMessageoftheErrorPopup;
	
	@FindBy (xpath = "//button[normalize-space()='OK']")
	public WebElement ErrorPopupOKbutton;
	
	@FindBy (xpath = "//button[normalize-space()='Cancel']")
	public WebElement ErrorPopupCancelButton;
	
	@FindBy (xpath = "//a[normalize-space()='Login']")
	public WebElement GoBackToLogin;
	
	public ResetPasswordPageLocators() {
		PageFactory.initElements(driver, this);
	}
	
	public void userNameField() {
		UserName.sendKeys(Username);
	}
	
	//to click the Reset Password Button
		public void resetPassword() {
			ResetPasswordButton.click();
		}
		
		//To click the OK button in the error popup
		public void errorPopupOKbutton() {
			ErrorPopupOKbutton.click();
		}
		
		//To click the Cancel button in the error popup
		public void errorPopupCancelButton() {
			ErrorPopupCancelButton.click();
		}
		
		// To click the Go Back To Login Button
		public void goBackToLogin() {
			GoBackToLogin.click();
		}
		
		// Invalid User Name
		public void incorrectUserName() {
			UserName.sendKeys(Username2);
		}
}
