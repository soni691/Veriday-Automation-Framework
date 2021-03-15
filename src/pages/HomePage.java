package pages;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;

import BasePage.BasePage;

public class HomePage extends BasePage {
	public static String homepageoption = "Homepage";
	Logger homepageoptionlog = getLogger(homepageoption);

	@BeforeClass
	public void setUp() {
		driver = getDriver();
	}

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	// Identify Admin HQ option
	By AdminHQ = By.xpath("//h3[contains(text(),'Admin HQ')]");
	// Identify UserManager option
	By usermanager = By.xpath("//a[@href='/user-manager']");
	// Identify Queues option
	By queues = By.xpath("//h3[contains(text(),'Queues')]");
	// Identify Organizational Groups option
	By ogroups = By.xpath("//h3[contains(text(),'Organizational Groups')]");
	// Identify Back to Digital Workspace option
	By dworkspace = By.xpath("//a[normalize-space()='Back to Digital Workspace']");
	// Identify Hub Manager option  of Admin HQ page
	By hubmanager = By.xpath("//a[contains(text(),'Hub Manager')]");
	// Identify Global Setting option  of Admin HQ page
	By globalsetting = By.xpath("//a[contains(text(),'Global Settings')]");
	// Identify Maintenance option of Admin HQ page
	By etemplate = By.xpath("//a[contains(text(),'Email Templates')]");
	// Identify Maintenance option of Admin HQ page
	By maintenance = By.xpath("//a[contains(text(),'Maintenance')]");
	// Identify Search for a hub button Admin HQ page
	By searchHub = By.xpath("//button[contains(text(),'Search for a Hub')]");
	// Identify Profile Configuration label of Global Settings page
	By pconfiguration = By.xpath("//a[@id='profile-settings-tab-label']");
	// Identify Add Template button of Email Template page
	By addtemplate = By.xpath("//button[normalize-space()='Add Template']");
	// Identify Add Template button of Email Template page
	By reindexcontentdata = By.xpath("//button[contains(text(),'Reindex Content Data')]");
	// Identify New button of Organization Groups page
	By NewGroup = By.xpath("//button[contains(text(),'+ New')]");
	// Identify New Group button of Organization Groups page
	By CreateGroup = By.xpath("//a[normalize-space()='Group']");
	// Identify Group Name text input field of Organization Groups page
	By GroupName = By.xpath("//input[@id='newGroupName']");
	// Identify Save Changes button of Organization Groups page
	By SaveChange = By.xpath("//button[contains(text(),'Save Changes')]");
	// Identify Search button to find group of Organization Groups page
	By GroupSearch = By.xpath("//button[(text()='Search')]");
	// Identify group search text field to find group name of Organization Groups page
	By GroupSearchName = By.xpath("//input[@id='search-organization-value']");
	// Identify Organization group saved popup of Organization Groups page
	By GroupSavedPopup = By.xpath("//p[text()='Organizational Group Saved']");
	// Identify Organization group search text of Organization Groups page
	By GroupSearchText = By.xpath("//button[@class='btn btn-search-organizations']");
	// Identify searched group of Organization Groups page
	By SelectGroup = By.xpath("//td[@class='name-label']");
	// Identify Group edit button of Organization Groups page
	By EditGroup = By.xpath("//button[contains(text(),'Edit')]");
	// Identify Group attribute of Organization Groups page
	By GroupAttribute = By.xpath("//select[@id='attribute-value']");
	// Identify Delete button to delete a group of Organization Groups page
	By DeleteGroup = By.xpath("//button[contains(text(),'Delete')]");
	// Identify Textbox to enter DELETE text to delete a group of Organization Groups page
	By DeleteText = By.xpath("//input[@id='da-action-confirm-input']");
	// Identify Confrim button to delete a group of Organization Groups page
	By DeleteConfirm = By.xpath("//button[contains(text(),'Confirm')]");
	// Identify Organization group delete popup of Organization Groups page
		By GroupDeletePopup = By.xpath("//p[text()='Organizational Group Deleted']");
		
		
		
	public String append;
	public String gname;
	
		//Method to enter New Group Name
		void setGroupName(String gname) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmm");
			//Getting current date
			Calendar cal = Calendar.getInstance();
			//Number of Days to add
		    cal.add(Calendar.DAY_OF_MONTH, 2);
			//Date after adding the days to the current date
			String newDate = sdf.format(cal.getTime());
			System.out.println(newDate);
			//String append;
			this.gname = gname+newDate;
			//gname=append;
		    enterText(GroupName, this.gname);
		    System.out.println(gname);
		}
		//Method to search Group Name
		void searchGroupName() {
			enterText(GroupSearchName, gname);
		}
	
	

	public void validateAdminHQ() throws InterruptedException {
		click(AdminHQ);
		Thread.sleep(2000);
		// Assert.assertEquals("Admin HQ - Digital Agent", driver.getTitle());
		assertTrue(driver.getTitle().contains("Admin HQ - Digital Agent"));
		homepageoptionlog.info("AdminHQ option is visible & working fine");
		waitAndFindElement(dworkspace, Condition.isClickable, 2, 1000).click();
		click(dworkspace);
	}

	public void validateUserManager() throws InterruptedException {
		click(usermanager);
		Thread.sleep(2000);
		// Assert.assertEquals("Admin HQ - Digital Agent", driver.getTitle());
		assertTrue(driver.getTitle().contains("User Manager - Digital Agent"));
		homepageoptionlog.info("User manager option is visible & working fine");
		waitAndFindElement(dworkspace, Condition.isClickable, 2, 1000).click();
		click(dworkspace);
	}

	public void validateQueues() throws InterruptedException {
		click(queues);
		Thread.sleep(2000);
		// Assert.assertEquals("Admin HQ - Digital Agent", driver.getTitle());
		assertTrue(driver.getTitle().contains("Queues - Digital Agent"));
		homepageoptionlog.info("Queues option is visible & working fine");
		waitAndFindElement(dworkspace, Condition.isClickable, 2, 1000).click();
		click(dworkspace);
	}

	public void validateOrganizationalGroups() throws InterruptedException {
		click(ogroups);
		Thread.sleep(2000);
		// Assert.assertEquals("Admin HQ - Digital Agent", driver.getTitle());
		assertTrue(driver.getTitle().contains("Organizational Groups - Digital Agent"));
		homepageoptionlog.info("Organizational Groups option is visible & working fine");
		waitAndFindElement(dworkspace, Condition.isClickable, 2, 1000).click();
		click(dworkspace);
	}
	public void validateHubManager() throws InterruptedException {
		click(AdminHQ);
		//Thread.sleep(2000);
		waitAndFindElement(searchHub, Condition.isDisplayed, 5000, 1);
		boolean present = isElementPresent(searchHub);
		if(present==true) {
			homepageoptionlog.info("Hub Manager option is visible & working fine");
		}	
	}
	public void validateGlobalSettings() throws InterruptedException {
		click(globalsetting);
		//Thread.sleep(2000);
		waitAndFindElement(pconfiguration, Condition.isDisplayed, 5000, 1);
		boolean present = isElementPresent(pconfiguration);
		if(present==true) {
			homepageoptionlog.info("Global Settings option is visible & working fine");
		}	
	}
	public void validateEmailTemplates() throws InterruptedException {
		click(etemplate);
		//Thread.sleep(2000);
		waitAndFindElement(addtemplate, Condition.isDisplayed, 5000, 1);
		boolean present = isElementPresent(addtemplate);
		if(present==true) {
			homepageoptionlog.info("Email Template option is visible & working fine");
		}	
	}
	public void validateMaintenance() throws InterruptedException {
		click(maintenance);
		//Thread.sleep(2000);
		waitAndFindElement(reindexcontentdata, Condition.isDisplayed, 5000, 1);
		boolean present = isElementPresent(reindexcontentdata);
		if(present==true) {
			homepageoptionlog.info("Maintenance option is visible & working fine");
		}	
	}
	public void CreateNewGroup() throws Exception {
		click(ogroups);
		Thread.sleep(2000);
		assertTrue(driver.getTitle().contains("Organizational Groups - Digital Agent"));
		waitAndFindElement(NewGroup, Condition.isDisplayed, 5000, 1);
		click(NewGroup);
		click(CreateGroup);
		gname=ExcelUtils.getCellData(1, 0);
		setGroupName(gname);
		homepageoptionlog.info("New Group Is created with Name " + gname);
		click(SaveChange);
		waitAndFindElement(GroupSavedPopup, Condition.isDisplayed, 3000, 1);
		System.out.println("Group Is created");
			
	}
	public void UpdateGroup() throws Exception {
		click(GroupSearch);
		click(GroupSearchName);
		enterText(GroupSearchName, gname);
		click(GroupSearchText);
		click(SelectGroup);
		click(EditGroup);
		click(GroupAttribute);
		selectFromText(GroupAttribute, "Regional");
		click(GroupAttribute);
		click(SaveChange);
		homepageoptionlog.info("New Group Is created with Name " + gname);
		waitAndFindElement(GroupSavedPopup, Condition.isDisplayed, 3000, 1);
	}
	public void DeleteGroup() throws Exception {
		click(GroupSearch);
		click(GroupSearchName);
		enterText(GroupSearchName, gname);
		click(GroupSearchText);
		click(SelectGroup);
		click(EditGroup);
		click(DeleteGroup);
		click(DeleteText);
		enterText(DeleteText, "DELETE");
		click(DeleteConfirm);
		waitAndFindElement(GroupDeletePopup, Condition.isDisplayed, 3000, 1);
		homepageoptionlog.info("New Group Is Deleted with Name " + gname);
		waitAndFindElement(dworkspace, Condition.isClickable, 2, 1000).click();
		click(dworkspace);
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
	}
}
