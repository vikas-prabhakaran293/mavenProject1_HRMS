package locators.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import baseClassHRMS.BaseClass;

public class TimesheetLocators extends BaseClass{
	public  WebDriverWait wait;

	@FindBy(xpath = "//a[@href='https://skad.timetracks.us/timesheets']")
	public WebElement TimesheetInMenu;
	@FindBy(css = "a.col-auto.fs-12.font-weight-500.btn-today.btn-timesheet[data-tp='dailyTimesheet']")
	public WebElement TodayToggle;
	@FindBy(css = "a.col-auto.fs-12.font-weight-500.btn-weekly.btn-timesheet[data-tp='weeklyTimesheet']")
	public WebElement WeeklyToggle;
	@FindBy(xpath = "//input[@placeholder='Search']")
	public WebElement SearchBar;
	@FindBy(id = "department_list")
	public WebElement DepartmentDropdown;
	@FindBy(id = "dep_members")
	public WebElement MemberDropdown;
	@FindBy(xpath = "//button[@class='fs-12 font-weight-500 fc-secondary buttonreset btn-filter-sort no_radius timesheet-reset-btn']")
	public WebElement ResetBtn;
	@FindBy(id = "project_id")
	public WebElement ProjectDropdown;
	@FindBy(id = "project_id-error")
	public WebElement RequiredAlertProjectDropdown;
	@FindBy(id = "job_id")
	public WebElement TaskDropdown;
	@FindBy(id = "job_id-error")
	public WebElement RequiredAlertTaskDropdown;
	@FindBy(id = "sub_job_id")
	public WebElement SubtaskDropdown;
	@FindBy(xpath = "//form[@id='add_timesheets_top_form']//input[@placeholder='Enter notes here...']")
	public WebElement NotesField;
	@FindBy(id = "add_project_id")
	public WebElement AddTask_projdrpdown;
	@FindBy(id = "add_job_id")
	public WebElement AddTask_Taskdrpdown;
	@FindBy(id = "add_sub_job_id")
	public WebElement AddTask_SubTaskdrpdown;
	@FindBy(id = "notes")
	public WebElement AddTask_Notes;
	@FindBy(xpath = "//*[@id=\"add_timesheets_top_form\"]/div/div[5]/div/button")
	public WebElement StartTaskButton;
	@FindBy (xpath = "//button[@class='col-auto fs-14 font-weight-600 btn-add-task ps-0 pe-0']")
	public WebElement AddTaskButton;
	@FindBy (id = "start_time")
	public WebElement StartTime;
	@FindBy (id = "stop_time")
	public WebElement StopTime;
	@FindBy (css = "input.numInput.flatpickr-hour[aria-label='Hour'][type='number']")
	public List<WebElement> SelectHours;
	@FindBy (css = "input.numInput.flatpickr-minute[aria-label='Minute'][type='number']")
	public List<WebElement> SelectMinutes;
	@FindBy (css = "input.numInput.flatpickr-second[type='number']")
	public List<WebElement> SelectSeconds;
	@FindBy (css = "span.flatpickr-am-pm[title='Click to toggle']")
	public List<WebElement> SelectAMandPM;
	@FindBy (name = "total_hours")
	public WebElement TotalHours;
	@FindBy (id = "addTimesheetBtn")
	public WebElement AddTaskSubmitbtn;
	@FindBy (id = "swal2-title")
	public WebElement AddTaskConfmMsg;
	@FindBy (xpath = "//span[@class='cursor-pointer task_notes_popup']")
	public WebElement ViewNotes;
	@FindBy (css = "span.btn-discard[data-bs-dismiss='modal']")
	public WebElement ViewNotesDiscardBtn;
	@FindBy (id = "task_description")
	public WebElement ViewNotesDiscription;
	@FindBy (xpath = "//tbody/tr[2]/td[11]/div[1]/button[1]")
	public WebElement ActionButton;
	@FindBy (xpath = "//ul[@class='dropdown-menu table_action dropdown-menu-end justify-content-start flex-column widthfitcontent actionblock-custom show']//span[@class='fs-12 font-weight-500 fc-secondary ctledit'][normalize-space()='Edit']")
	public WebElement TaskEditBtn;
	@FindBy (xpath = "//span[normalize-space()='Edit Task']")
	public WebElement EditTaskLabel;
	@FindBy (id = "edit_notes")
	public WebElement EditTaskNotes;
	@FindBy (name = "task_status_check")
	public WebElement TaskCompletedCheckBox;
	@FindBy (xpath = "//form[@id='edit_timesheets_modal_form']//span[@class='d-block w-100 text-center'][normalize-space()='Submit']")
	public WebElement EditTaskSubmitBtn;
	@FindBy (xpath = "input.swal2-input[type=\"text\"]")
	public WebElement EdtTaskConfMsg;
	@FindBy (xpath ="//ul[@class='dropdown-menu table_action dropdown-menu-end justify-content-start flex-column widthfitcontent actionblock-custom show']//span[@class='fs-12 font-weight-500 fc-secondary ctldelete'][normalize-space()='Delete']")
	public WebElement DltTaskBtn;
	@FindBy (css ="input.swal2-input[type=\"text\"]")
	public WebElement DltConfmText;
	@FindBy (css ="button.btn_ok[type=\"button\"]")
	public WebElement DltOkBtn;
	@FindBy (css ="input.select2-search__field[type=\"search\"][role=\"searchbox\"]")
	public WebElement DepartmentDrpDwnSearch;
	@FindBy (css ="button.btn_ok[type=\"button\"]")
	public WebElement MemberDrpDwnSearch;
	@FindBy(id = "swal2-html-container")
	public WebElement DupAddAlertMessage;

	public TimesheetLocators() {
		PageFactory.initElements(driver, this);
	}

	public void clickTimeSheet() {
		driver.navigate().refresh();
		wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(TimesheetInMenu)));
		wait.until(ExpectedConditions.elementToBeClickable(TimesheetInMenu));
		TimesheetInMenu.click();
	}

	public void clickTodayToggle() {
		wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(TodayToggle));
		TodayToggle.click();
	}

	public void clickWeeklyToggle() {
		wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(WeeklyToggle));
		WeeklyToggle.click();
	}

	public void clickStartTaskButton() {
		wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(StartTaskButton));
		StartTaskButton.click();
	}

	public void selectProjectDropdown() {
		Select project =new Select(ProjectDropdown);
		project.selectByVisibleText("22026_Creek_Vista_Heights_HEA01");
	}

	public void selectTaskDropdown() {
		Select Task =new Select(TaskDropdown);
		Task.selectByVisibleText("Task for Sample");
	}
	public void selectSubTaskDrpDwn() {
		Select SubTask =new Select(SubtaskDropdown);
		SubTask.selectByVisibleText("Sample Sub Task");
	}

	public void enterNotes() {
		NotesField.sendKeys("Test Content");
	}

	public void clickAddTask() throws InterruptedException {
		wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollIntoView(true);",AddTaskButton);
		wait.until(ExpectedConditions.elementToBeClickable(AddTaskButton));
		AddTaskButton.click();
	}

	public void EnterTaskDetails(String projectName, String taskName, String subTaskName, String notes) {
		{
			// Select Project
			wait.until(ExpectedConditions.elementToBeClickable(AddTask_projdrpdown));
			Select project = new Select(AddTask_projdrpdown);
			project.selectByVisibleText(projectName);

			// Select Task
			wait.until(ExpectedConditions.elementToBeClickable(AddTask_Taskdrpdown));
			Select task = new Select(AddTask_Taskdrpdown);
			task.selectByVisibleText(taskName);

			//Select Sub Task
			wait.until(ExpectedConditions.elementToBeClickable(AddTask_SubTaskdrpdown));
			Select subTask = new Select(AddTask_SubTaskdrpdown);
			subTask.selectByVisibleText(subTaskName);

			// Enter Notes
			AddTask_Notes.sendKeys(notes);
		}
	}

	public void SetStartandEndTime(String startHour, String startMinute, String startSecond, String stopHour, String stopMinute, String stopSecond) { 
		try {

			// Set Start Time
			StartTime.click();
			Thread.sleep(2000);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(SelectHours));
			//wait.until(ExpectedConditions.elementToBeClickable(SelectHours));
			SelectHours.get(0).clear();
			SelectHours.get(0).sendKeys(startHour);

			//wait.until(ExpectedConditions.elementToBeClickable(SelectMinutes));
			SelectMinutes.get(0).clear();
			SelectMinutes.get(0).sendKeys(startMinute);

			//wait.until(ExpectedConditions.elementToBeClickable(SelectSeconds));
			SelectSeconds.get(0).clear();
			SelectSeconds.get(0).sendKeys(startSecond);
			SelectAMandPM.get(0).click();

			// Set Stop Time
			StopTime.click();
			//wait.until(ExpectedConditions.elementToBeClickable(SelectHours));
			SelectHours.get(1).clear();
			SelectHours.get(1).sendKeys(stopHour);

			//wait.until(ExpectedConditions.elementToBeClickable(SelectMinutes));
			SelectMinutes.get(1).clear();
			SelectMinutes.get(1).sendKeys(stopMinute);

			//wait.until(ExpectedConditions.elementToBeClickable(SelectSeconds));
			SelectSeconds.get(1).clear();
			SelectSeconds.get(1).sendKeys(stopSecond);
			SelectAMandPM.get(1).click();
			TotalHours.click();

			// Submit Task
			AddTaskSubmitbtn.click();
		} catch (Exception e) {
			System.out.println("An error occurred while adding a task: " + e.getMessage());
		}   
	} 
	public void getAddTaskConfmMsg() {
		AddTaskConfmMsg.getText();
	}

	public void ViewTheNotes() {
		driver.navigate().refresh();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(ViewNotes));
		ViewNotes.click();
	}
	public void CloseTheNotes() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(ViewNotesDiscardBtn));
		ViewNotesDiscardBtn.click();
	}
	public void ClickActionBtn() {
		driver.navigate().refresh();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollIntoView(true);",ActionButton);
		wait.until(ExpectedConditions.elementToBeClickable(ActionButton));
		ActionButton.click();
	}
	public void ClickTaskEditBtn() {
		wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollIntoView(true);",TaskEditBtn);
		wait.until(ExpectedConditions.elementToBeClickable(TaskEditBtn));
		TaskEditBtn.click();
	}
	public void UpdateNotesField() {
		EditTaskNotes.click();
		EditTaskNotes.clear();
		EditTaskNotes.sendKeys("Updated Test Content");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(EditTaskSubmitBtn));
		EditTaskSubmitBtn.click();
	}
	//	    public void editTaskSubmitBtn() {
	////	    	WebElement EditTasksubmitBtn = driver.findElement(By.cssSelector("button.btn-primary-submit"));
	////	    	JavascriptExecutor js = (JavascriptExecutor) driver;
	////	    	js.executeScript("arguments[0].click();", EditTasksubmitBtn);
	//	    Actions actions = new Actions(driver);
	//	    WebElement submitButton = driver.findElement(By.cssSelector("button.btn-primary-submit"));
	//	    actions.moveToElement(submitButton).click().perform();
	//	    }
	public void dltTask() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollIntoView(true);",EditTaskSubmitBtn);
		//wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(DltTaskBtn));
		DltTaskBtn.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(AddTaskConfmMsg));
		Assert.assertTrue((AddTaskConfmMsg).isDisplayed());
		System.out.println((AddTaskConfmMsg).getText());
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(DltConfmText));
		DltConfmText.click();
		DltConfmText.sendKeys("YES");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(DltOkBtn));
			DltOkBtn.click(); 
			// Exit the loop if successful
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is stale, retrying...");
		}

	}

	public void SelectDepartment() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollIntoView(true);",DepartmentDropdown);
		// Scroll to the bottom (just for demonstration)
		executor.executeScript("window.scrollTo(0, document.body.scrollHeight);");

		// Scroll up to the top of the page
		executor.executeScript("window.scrollTo(0, 0);");
		wait.until(ExpectedConditions.elementToBeClickable(DepartmentDropdown));
		Select Department =new Select(DepartmentDropdown);
		Department.selectByIndex(9);
		//System.out.println("Selected option: " + ((WebElement) Department).getAttribute("value"));
	}
	public void SelectMember() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(MemberDropdown));
		Select Members =new Select(MemberDropdown);
		Members.selectByIndex(1);
		//System.out.println("Selected option: " + ((WebElement) Members).getAttribute("value"));
	}
	public void clickResetBtn() {
		ResetBtn.click();
	}

}