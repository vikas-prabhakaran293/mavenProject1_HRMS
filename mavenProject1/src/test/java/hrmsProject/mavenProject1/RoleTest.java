package hrmsProject.mavenProject1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClassHRMS.BaseClass;
import locators.pages.LoginPageLocators;
import locators.pages.RoleLocators;
import locators.pages.TimesheetLocators;

public class RoleTest extends BaseClass{
	public LoginPageLocators loginPageLocators;
	public RoleLocators roleLocators;
	public WebDriverWait wait;
	@BeforeClass
	public void launchBrowser() {
		browserLaunch();
		loginPageLocators = new LoginPageLocators();
		roleLocators = new RoleLocators();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	@Test(priority = 1)
	public void doLogin() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlToBe("https://skad.timetracks.us/"));
		loginPageLocators.loginApplication();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlToBe("https://skad.timetracks.us/dashboard"));
		String actualResult = driver.getCurrentUrl();
		String expectedResult = "https://skad.timetracks.us/dashboard";
		Assert.assertEquals(actualResult, expectedResult);
		System.out.println(actualResult);
	}
	@Test(priority = 2)
	public void navigateToRolePage() throws InterruptedException {
		//driver.switchTo().alert().dismiss();
		roleLocators.clickUserAdministration();
		Thread.sleep(3000);
		roleLocators.clickRole();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlToBe("https://skad.timetracks.us/user/roles"));
		String actualResult = driver.getCurrentUrl();
		String expectedResult = "https://skad.timetracks.us/user/roles";
		Assert.assertEquals(actualResult, expectedResult);
		System.out.println(actualResult);
	}
	@Test(priority = 3)
	public void CountOfTheRecords() throws InterruptedException{
		roleLocators.changePagination();
		roleLocators.clickFilterDrpDown();
		roleLocators.selectAll();
		Thread.sleep(3000);
		System.out.println("The count of All Records: "+(roleLocators.ShowEntriesDetails).getText());
		
		roleLocators.clickFilterDrpDown();
		roleLocators.selectActive();
		//wait.until(ExpectedConditions.visibilityOf(roleLocators.ShowEntriesDetails));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(roleLocators.ShowEntriesDetails)));
		Assert.assertTrue((roleLocators.ShowEntriesDetails).isDisplayed());
		Thread.sleep(3000);
		System.out.println("The count of Active Records: "+(roleLocators.ShowEntriesDetails).getText());
		
		roleLocators.clickFilterDrpDown();
		roleLocators.selectInActive();
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(roleLocators.ShowEntriesDetails)));
		Assert.assertTrue((roleLocators.ShowEntriesDetails).isDisplayed());
		Thread.sleep(3000);
		System.out.println("The count of In Active Records: "+(roleLocators.ShowEntriesDetails).getText());
		
		roleLocators.clickFilterDrpDown();
		roleLocators.selectActive();
	}

	@Test(priority = 4)
	public void AddNewRole() throws InterruptedException{
		roleLocators.clickAddRole();
		roleLocators.EnterUserRole("Test Role 1");
		roleLocators.clickManagePrjtAllBtn();
		roleLocators.clickManageTaskAllBtn();
		roleLocators.clickManageClientsViewBtn();
		roleLocators.clickSubmitBtn();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(roleLocators.ConfMessage));
		Assert.assertTrue((roleLocators.ConfMessage).isDisplayed());
		System.out.println((roleLocators.ConfMessage).getText());
	}
	@Test(priority = 5)
	public void CountOfTheSearchedRecords() throws InterruptedException{
		roleLocators.searchRecord("Test");
		Thread.sleep(3000);
		roleLocators.getEntriesInfo();
		roleLocators.clickResetBtn();
	}
	@Test(priority = 6)
	public void EditRole() throws InterruptedException {
		roleLocators.searchRecord("Test");
		roleLocators.clickActionBtn();
		roleLocators.clickEditBtn();
		roleLocators.updateRole("Test Sample Role");
		roleLocators.clickLeaveTypesAllBtn();
		roleLocators.clickUpdateBtn();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(roleLocators.ConfMessage));
		Assert.assertTrue((roleLocators.ConfMessage).isDisplayed());
		System.out.println((roleLocators.ConfMessage).getText());
	}
	@AfterClass
	public void closeBrowser() {
		closeApp();
	}
}
