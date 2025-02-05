package hrmsProject.mavenProject1;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClassHRMS.BaseClass;
import locators.pages.LoginPageLocators;
import locators.pages.TimesheetLocators;

public class TimesheetTest extends BaseClass {
	public LoginPageLocators loginPageLocators;
	public TimesheetLocators timesheetLocators;
	public HrmsLoginTest hrmsLoginTest;
	WebDriverWait wait;

	@BeforeClass
	public void launchBrowser() {
		browserLaunch();
		loginPageLocators = new LoginPageLocators();
		timesheetLocators = new TimesheetLocators();
		hrmsLoginTest = new HrmsLoginTest();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	@Test(priority = 1)
	public void doLogin() throws InterruptedException {
		loginPageLocators.loginApplication();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlToBe("https://skad.timetracks.us/dashboard"));
		String actualResult = driver.getCurrentUrl();
		String expectedResult = "https://skad.timetracks.us/dashboard";
		Assert.assertEquals(actualResult, expectedResult);
		System.out.println(actualResult);
	}
	@Test(priority = 2)
	public void navigateToTimesheet() throws InterruptedException {
		timesheetLocators.clickTimeSheet();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlToBe("https://skad.timetracks.us/timesheets"));
		String actualResult = driver.getCurrentUrl();
		String expectedResult = "https://skad.timetracks.us/timesheets";
		Assert.assertEquals(actualResult, expectedResult);
		System.out.println(actualResult);
	}
	@Test(priority = 3)
	public void todayToggle() {
		//timesheetLocators.clickTodayToggle();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(timesheetLocators.TodayToggle));
		Assert.assertTrue((timesheetLocators.TodayToggle).isDisplayed());
		System.out.println("Today Toggle was displayed");
		timesheetLocators.clickWeeklyToggle();
	}
	@Test(priority = 4) 
	public void weeklyToggle() throws InterruptedException{

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(timesheetLocators.WeeklyToggle));
		Assert.assertTrue((timesheetLocators.WeeklyToggle).isDisplayed());
		//timesheetLocators.clickWeeklyToggle();
		System.out.println("Weekly Toggle was displayed"); 
		timesheetLocators.clickTodayToggle();
	} 
	@Test(priority = 5)
	public void getRequiredfieldAlertMessage() {
		timesheetLocators.clickStartTaskButton();
		Assert.assertTrue((timesheetLocators.RequiredAlertProjectDropdown).isDisplayed());
		Assert.assertTrue((timesheetLocators.RequiredAlertTaskDropdown).isDisplayed());
		System.out.println((timesheetLocators.RequiredAlertProjectDropdown).getText());
		System.out.println((timesheetLocators.RequiredAlertTaskDropdown).getText());
	} 
	@Test (priority = 6)
	public void punchIN() throws InterruptedException {
		timesheetLocators.selectProjectDropdown();
		timesheetLocators.selectTaskDropdown();
		timesheetLocators.selectSubTaskDrpDwn();
		timesheetLocators.enterNotes();
		timesheetLocators.clickStartTaskButton();
		Thread.sleep(3000);
		timesheetLocators.clickStartTaskButton();
		Thread.sleep(3000);
	}
	@Test (priority = 7)
	public void addTask() throws InterruptedException {
		timesheetLocators.clickAddTask();
		Thread.sleep(4000);
		timesheetLocators.EnterTaskDetails("A- One", "www", "Test Sub Task", "Test Content");
		timesheetLocators.SetStartandEndTime("07", "16", "20", "07", "18", "00");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(timesheetLocators.AddTaskConfmMsg));
		Assert.assertTrue((timesheetLocators.AddTaskConfmMsg).isDisplayed());
		System.out.println((timesheetLocators.AddTaskConfmMsg).getText());
	}
	@Test (priority = 8)
	public void viewNotesofTheTask() {
		timesheetLocators.ViewTheNotes();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(timesheetLocators.ViewNotesDiscription));
		Assert.assertTrue((timesheetLocators.ViewNotesDiscription).isDisplayed());
		System.out.println((timesheetLocators.ViewNotesDiscription).getText());
		timesheetLocators.CloseTheNotes();
	}
	@Test (priority = 9)
	public void EditTheTask() throws InterruptedException {
		timesheetLocators.ClickActionBtn();
		timesheetLocators.ClickTaskEditBtn();
		wait.until(ExpectedConditions.visibilityOf(timesheetLocators.EditTaskLabel));
		Assert.assertTrue((timesheetLocators.EditTaskLabel).isDisplayed());
		System.out.println((timesheetLocators.EditTaskLabel).getText());
		timesheetLocators.UpdateNotesField();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(timesheetLocators.AddTaskConfmMsg));
		Assert.assertTrue((timesheetLocators.AddTaskConfmMsg).isDisplayed());
		System.out.println((timesheetLocators.AddTaskConfmMsg).getText());
	}
	@Test (priority = 10)
	public void DeleteTask() {
		timesheetLocators.ClickActionBtn();
		timesheetLocators.dltTask();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(timesheetLocators.AddTaskConfmMsg));
		Assert.assertTrue((timesheetLocators.AddTaskConfmMsg).isDisplayed());
		System.out.println((timesheetLocators.AddTaskConfmMsg).getText());
	}

	@Test (priority = 11)
	public void GetTimesheetOfUser() throws InterruptedException {
		timesheetLocators.SelectDepartment();
		timesheetLocators.SelectMember();
		Thread.sleep(3000);
		timesheetLocators.clickResetBtn();
		Thread.sleep(4000);
	}
	@Test (priority = 12)
	public void addDupTask() throws InterruptedException {
		timesheetLocators.clickAddTask();
		Thread.sleep(4000);
		timesheetLocators.EnterTaskDetails("A- One", "www", "Test Sub Task", "Test Content");
		timesheetLocators.SetStartandEndTime("07", "12", "20", "07", "14", "00");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(timesheetLocators.DupAddAlertMessage));
		Assert.assertTrue((timesheetLocators.DupAddAlertMessage).isDisplayed());
		System.out.println((timesheetLocators.DupAddAlertMessage).getText());
	}

	@AfterClass
	public void closeBrowser() {
		closeApp();
	}
}
