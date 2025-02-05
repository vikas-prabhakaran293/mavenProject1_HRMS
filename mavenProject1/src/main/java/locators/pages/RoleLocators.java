package locators.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClassHRMS.BaseClass;

public class RoleLocators extends BaseClass {
	WebDriverWait wait;
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	public String EntriesInfo;
	@FindBy(css = "a.nav-link.menu-link[href='#8']")
	public WebElement UserAdministrationInMenu;
	@FindBy(css = "a.nav-link[href=\"https://skad.timetracks.us/user/roles\"]")
	public WebElement RoleInMenu;
	@FindBy(id = "add_role")
	public WebElement AddRoleBtn;
	@FindBy(css = "input.form-control[name=\"user_role\"]")
	public WebElement UserRoleTextField;
	@FindBy (xpath = "/html/body/div[2]/div/div/div/div[1]/div[5]/div/div/form/div[1]/div[3]/div[2]/div/table/tbody/tr[2]/td[6]/span/div/input")
	public WebElement ManagePrjtAllBtn;
	@FindBy (xpath ="/html/body/div[2]/div/div/div/div[1]/div[5]/div/div/form/div[1]/div[3]/div[2]/div/table/tbody/tr[4]/td[6]/span/div/input")
	public WebElement ManageTaskAllBtn;
	@FindBy (xpath ="/html/body/div[2]/div/div/div/div[1]/div[5]/div/div/form/div[1]/div[3]/div[2]/div/table/tbody/tr[10]/td[4]/span/div/input")
	public WebElement ManageClientsViewBtn;
	@FindBy (xpath = "//button[@name='submit' and contains(@class, 'btn-primary-submit')]")
	public WebElement SubmitBtn;
	@FindBy (id = "swal2-title")
	public WebElement ConfMessage;
	@FindBy (name = "user-role_length")
	public WebElement ShowEntriesDrpDown;
	@FindBy (id = "user-role_info")
	public WebElement ShowEntriesDetails;
	@FindBy (id = "search")
	public WebElement SearchBar;
	@FindBy (css = "button.btn-filter-sort[type=\"button\"]")
	public WebElement ResetBtn;
	@FindBy (id = "filter")
	public WebElement FilterDrpDown;
	@FindBy (css = "button[data-id='active']")
	public WebElement ActiveInDrpDwn;
	@FindBy (css = "button[data-id='inactive']")
	public WebElement InActiveInDrpDwn;
	@FindBy (css = "button[data-id='all']")
	public WebElement AllInDrpDwn;
	@FindBy (className = "navbar-header")
	public WebElement overlay;
	@FindBy (css = "button.btn.btn-soft-secondary.dropdown[data-bs-toggle=\'dropdown\']")
	public WebElement ActionBtn;
	@FindBy (id = "role_edit54")
	public WebElement EditBtn;
	@FindBy (xpath = "/html/body/div[3]/div/div/form/div[1]/div[3]/div[2]/div/table/tbody/tr[14]/td[6]/span/div/input")
	public WebElement LeaveTypesAllBtn;
	@FindBy (css ="input[name='user_role'][placeholder='Edit user role']")
	public WebElement RoleFieldUpdate;
	@FindBy (xpath ="//div[@role='dialog']//div//div//form[@role='form']//div//div//button[@name='submit']")
	public WebElement UpdateBtn;
	
	public RoleLocators() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickUserAdministration() {
		driver.navigate().refresh();
		wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(UserAdministrationInMenu));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(UserAdministrationInMenu)));
		wait.until(ExpectedConditions.elementToBeClickable(UserAdministrationInMenu));
		UserAdministrationInMenu.click();
	}
	public void clickRole() {
		wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(RoleInMenu)));
		wait.until(ExpectedConditions.elementToBeClickable(RoleInMenu));
		RoleInMenu.click();
	}
	public void clickAddRole() {
		wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(AddRoleBtn)));
		wait.until(ExpectedConditions.elementToBeClickable(AddRoleBtn));
		AddRoleBtn.click();
	}
	public void EnterUserRole(String roleText) {
		wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(UserRoleTextField)));
		wait.until(ExpectedConditions.elementToBeClickable(UserRoleTextField));
		UserRoleTextField.click();
		UserRoleTextField.sendKeys(roleText);
	}
	public void clickManagePrjtAllBtn() throws InterruptedException {
		wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(ManagePrjtAllBtn)));
		wait.until(ExpectedConditions.elementToBeClickable(ManagePrjtAllBtn));
		ManagePrjtAllBtn.click();
		//Thread.sleep(3000);
	}
	public void clickManageTaskAllBtn() throws InterruptedException {
		wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(ManageTaskAllBtn)));
		wait.until(ExpectedConditions.elementToBeClickable(ManageTaskAllBtn));
		ManageTaskAllBtn.click();
		//Thread.sleep(3000);
	}
	public void clickManageClientsViewBtn() throws InterruptedException {
		wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		//JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollIntoView(true);",ManageClientsViewBtn);
		wait.until(ExpectedConditions.elementToBeClickable(ManageClientsViewBtn));
		ManageClientsViewBtn.click();
		Thread.sleep(3000);
	}
	public void clickSubmitBtn() {
		wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(SubmitBtn));
		//wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(SubmitBtn)));
		wait.until(ExpectedConditions.elementToBeClickable(SubmitBtn));
		SubmitBtn.click();
	}
	public void changePagination() throws InterruptedException {
		//JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollIntoView(true);",ShowEntriesDrpDown);
		wait.until(ExpectedConditions.elementToBeClickable(ShowEntriesDrpDown));
		Select Pagination = new Select(ShowEntriesDrpDown);
		Pagination.selectByIndex(2);
		Thread.sleep(3000);
	}
	public void getEntriesInfo() {
		EntriesInfo = ShowEntriesDetails.getText();
		System.out.println("The Filtered Entries: "+EntriesInfo);
	}
	public void searchRecord(String searchText) {
		driver.navigate().refresh();
		wait.until(ExpectedConditions.visibilityOf(SearchBar));
		wait.until(ExpectedConditions.elementToBeClickable(SearchBar));
		SearchBar.click();
		SearchBar.sendKeys(searchText);
	}
	public void clickResetBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(ResetBtn));
		ResetBtn.click();
	}
	public void clickFilterDrpDown() throws InterruptedException {
		executor.executeScript("arguments[0].scrollIntoView(true);",FilterDrpDown);
		wait.until(ExpectedConditions.visibilityOf(FilterDrpDown));
		wait.until(ExpectedConditions.elementToBeClickable(FilterDrpDown));
		//Thread.sleep(3000);
		if (overlay.isDisplayed()) {
		    ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='none';", overlay);
		}
		FilterDrpDown.click();
	}
	public void selectActive() {
		wait.until(ExpectedConditions.elementToBeClickable(ActiveInDrpDwn));
		ActiveInDrpDwn.click();
	}
	public void selectInActive() {
		wait.until(ExpectedConditions.elementToBeClickable(InActiveInDrpDwn));
		InActiveInDrpDwn.click();
	}
	public void selectAll() {
		wait.until(ExpectedConditions.elementToBeClickable(AllInDrpDwn));
		AllInDrpDwn.click();
	}
	public void clickActionBtn() throws InterruptedException {
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(ActionBtn));
		wait.until(ExpectedConditions.elementToBeClickable(ActionBtn));
		ActionBtn.click();
	}
	public void clickEditBtn() throws InterruptedException {
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(EditBtn));
		wait.until(ExpectedConditions.elementToBeClickable(EditBtn));
		EditBtn.click();
	}
	public void updateRole(String updateRoleTxt) {
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(RoleFieldUpdate)));
		wait.until(ExpectedConditions.visibilityOf(RoleFieldUpdate));
		wait.until(ExpectedConditions.elementToBeClickable(RoleFieldUpdate));
		RoleFieldUpdate.click();
		RoleFieldUpdate.clear();
		RoleFieldUpdate.sendKeys(updateRoleTxt);
	}
	public void clickLeaveTypesAllBtn() {
		//JavascriptExecutor executor = (JavascriptExecutor)driver;
		wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		executor.executeScript("arguments[0].scrollIntoView(true);",LeaveTypesAllBtn);
		wait.until(ExpectedConditions.elementToBeClickable(LeaveTypesAllBtn));
		LeaveTypesAllBtn.click();
	}
	public void clickUpdateBtn() {
		wait.until(ExpectedConditions.visibilityOf(UpdateBtn));
		wait.until(ExpectedConditions.elementToBeClickable(UpdateBtn));
		UpdateBtn.click();
	}
}
