package pages;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;

import BasePage.BasePage;
//import BasePage.BasePage.Condition;

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
	By queues = By.xpath("//h3[normalize-space()='Queues']");
	// Identify Organizational Groups option
	By ogroups = By.xpath("//h3[normalize-space()='Organizational Groups']");
	// Identify Back to Digital Workspace option
	By dworkspace = By.xpath("//a[normalize-space()='Back to Digital Workspace']");

	public void validateAdminHQ() throws InterruptedException {
		click(AdminHQ);
		Thread.sleep(2000);
		//Assert.assertEquals("Admin HQ - Digital Agent", driver.getTitle());
		assertTrue(driver.getTitle().contains("Admin HQ - Digital Agent"));
		homepageoptionlog.info("AdminHQ option is visible & working fine");
		waitAndFindElement(dworkspace, Condition.isClickable, 2, 1000).click();
		click(dworkspace);
	}
	public void validateUserManager() throws InterruptedException {
		click(usermanager);
		Thread.sleep(2000);
		//Assert.assertEquals("Admin HQ - Digital Agent", driver.getTitle());
		assertTrue(driver.getTitle().contains("User Manager - Digital Agent"));
		homepageoptionlog.info("User manager option is visible & working fine");
		waitAndFindElement(dworkspace, Condition.isClickable, 2, 1000).click();
		click(dworkspace);
	}
	public void validateQueues() throws InterruptedException {
		click(queues);
		Thread.sleep(2000);
		//Assert.assertEquals("Admin HQ - Digital Agent", driver.getTitle());
		assertTrue(driver.getTitle().contains("Queues - Digital Agent"));
		homepageoptionlog.info("Queues option is visible & working fine");
		waitAndFindElement(dworkspace, Condition.isClickable, 2, 1000).click();
		click(dworkspace);
	}
	public void validateOrganizationalGroups() throws InterruptedException {
		click(ogroups);
		Thread.sleep(2000);
		//Assert.assertEquals("Admin HQ - Digital Agent", driver.getTitle());
		assertTrue(driver.getTitle().contains("Organizational Groups - Digital Agent"));
		homepageoptionlog.info("Organizational Groups option is visible & working fine");
		waitAndFindElement(dworkspace, Condition.isClickable, 2, 1000).click();
		click(dworkspace);
	}

}
