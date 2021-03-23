package pages;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.google.inject.spi.Element;

import BasePage.BasePage;
import ExtentReportListener.ExtentManager;
import ExtraData.variables;
import io.qameta.allure.Step;

public class UserManagerPage extends BasePage {

	public static String usermanager1 = "UserManagerPage";
	Logger usermanagerlog = getLogger(usermanager1);
	public SoftAssert softAssert = new SoftAssert();
	
	@BeforeClass
	public void setUp() {
		driver = getDriver();
	}
	
	public UserManagerPage(WebDriver driver) {
		this.driver=driver;
	}
      String AlertText;
	//Identify UserManager option
	By usermanager=By.xpath("//a[@href='/user-manager']");	
	//Identify CreateSingleUser button
	By createsingleuser=By.xpath("//button[contains(text(),'Create Single User')]");	
	//Identify AccountEmail
	By AccountEmail=By.xpath("//input[@id='emailField']");
	//Identify FirstName
	By FirstName=By.xpath("//input[@id='firstNameField']");
	//Identify lastName
	By LastName=By.xpath("//input[@id='lastNameField']");
	//Identify Jobtitle1
	By JobTitle=By.xpath("//input[@id='user-title-filter']");
	//Identify Jobtitle2
	By JobTitle2=By.xpath("//input[@id='user-title-filter1']");
	//Identify PhoneNumber
	By PhoneNumber=By.xpath("//*[@id=\"da-phones-container\"]/div/div[1]/div/input[1]");
	//Identify SAve&Activate button
	By SaveUser=By.xpath("//button[contains(text(),'Save & Activate')]");
	//Identify PhoneNumber textbox
	By Primarymember=By.xpath("//*[@id=\"primaryMemberRadio\"]");
	//Identify Location dropdown
	By Location=By.xpath("//select[@id='branchSelector']");
	//Identify TeamName textbox
	By TeamName = By.xpath("//input[@id='teamNameField']");
	//Identify TeamUser radobutton
	By Teammember = By.xpath("//input[@id='teamMemberRadio']");
	//Identify TeamUser radobutton
	By ReviewerUser = By.xpath("//input[@id='reviewerRadio']");
    //Identify SearchusertextBox
	By SearchUser = By.xpath("//input[@id='searchUsers']");
	//Identify SearchuserButton
	By SearchUserButton = By.xpath("//button[contains(text(),'Search Users')]");
	//Identify UserManageractions
	By SearchUserAction = By.xpath("//select[@id='user-manager-actions']");
	//Identify Go button
	By GoButton = By.xpath("//*[text()='Go']");
	//Identify modal popup of already created user modal window
	By AlreadyCreatedUserModal = By.xpath("//body/div[@id='da-message']/div[3]");
	//Identify ok button of already created user modal window
	By AlreadyCreatedUserOk = By.xpath("//button[contains(text(),'Ok')]");
	//Identify Back button of Create New User
	By Back = By.xpath("//button[contains(text(),'Back')]");
	//Identify Province license for DEMo QA Primary User
	By StatesofRegistration = By.xpath("//input[@id='provincial-list']");
	//identify error while creating user
	By UserCreationError = By.xpath("//p[contains(text(),'Sorry, an unexpected error occurred. Please contac')]");
	//identify saving option after clicking on save button of user creation
	By UserSave = By.xpath("//div[@class='modal-body alert-success']");
	
	public String append;
	public String uemail;
		
	void setAccountEmail(String uemail) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmm");
		//Getting current date
		Calendar cal = Calendar.getInstance();
		//Number of Days to add
	    cal.add(Calendar.DAY_OF_MONTH, 2);
		//Date after adding the days to the current date
		String newDate = sdf.format(cal.getTime());
		//String append;
		append = this.uemail+newDate+"@gmail.com";
		this.uemail=append;
		usermanagerlog.info("Email of the user is" +this.uemail);
		enterText(AccountEmail, this.uemail);
	}
	String setFName(String fname) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmm");
		//Getting current date
		Calendar cal = Calendar.getInstance();
		//Number of Days to add
	    cal.add(Calendar.DAY_OF_MONTH, 2);
		//Date after adding the days to the current date
		String newDate = sdf.format(cal.getTime());
		//String append;
		append = fname+newDate;
		fname=append;
		usermanagerlog.info("First Name of the user is " + fname);
	    enterText(FirstName, fname);
		return fname;
	}
	String setLName(String lname) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmm");
		//Getting current date
		Calendar cal = Calendar.getInstance();
		//Number of Days to add
	    cal.add(Calendar.DAY_OF_MONTH, 2);
		//Date after adding the days to the current date
		String newDate = sdf.format(cal.getTime());
		//String append;
		append = lname+newDate;
		lname=append;
		usermanagerlog.info("Last Name of the user is " + lname);
	    enterText(LastName, lname);
		return lname;
	}
	void setJobtitle(String jtitle) {
	    enterText(JobTitle, jtitle);
	}
	void setJobtitle2(String jtitle2) {
	    enterText(JobTitle2, jtitle2);
	}
	void setPhoneNumber(String phone) {
		enterText(PhoneNumber,String.valueOf(phone) );
	}
	void setLocation(String location11) {
		enterText(Location,location11);
	}
	String setTeamName(String tname) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmm");
		//Getting current date
		Calendar cal = Calendar.getInstance();
		//Number of Days to add
	    cal.add(Calendar.DAY_OF_MONTH, 2);
		//Date after adding the days to the current date
		String newDate = sdf.format(cal.getTime());
		//String append;
		append = tname+newDate;
		tname=append;
		usermanagerlog.info("Team name is " + tname);
		enterText(TeamName,tname);
		return tname;
	}
	void setSearchUser(String searchuser1) {
		enterText(SearchUser,searchuser1);
	}
	void setSearchUserAction(String searchuseraction) {
		enterText(SearchUserAction,searchuseraction);
	}
	void setStatesofRegistration(String sregistration) {
		enterText(StatesofRegistration,sregistration);
	}
	
	
	public void CreatePrimaryUser() throws Exception {
		uemail=ExcelUtils.getCellData(1, 0);
		String fname=ExcelUtils.getCellData(1, 1);		
		String lname=ExcelUtils.getCellData(1, 2);
		String jtitle=ExcelUtils.getCellData(1, 3);
		String jtitle2=ExcelUtils.getCellData(1, 4);
		String phone=ExcelUtils.getCellData(1, 5);
		String location11=ExcelUtils.getCellData(1, 6);
		String sregistration=ExcelUtils.getCellData(1, 7);
		click(usermanager);
		//Assert.assertEquals("User Manager - Digital Agent", driver.getTitle());
		click(createsingleuser);
		//To identify User Creation text on User Creation Page
		WebElement UserCreationLabel = driver.findElement(By.xpath("//*[@id=\"edit-user-container\"]/h2"));
		Assert.assertTrue(UserCreationLabel.isDisplayed(),"New Primary user can not be created");
		setAccountEmail(uemail);
		ExtentManager.getExtentTest().info("Email Entered successfully " + uemail);
		String fname1 =setFName(fname);
		ExtentManager.getExtentTest().info("FirstName Entered successfully " +  fname1);
		String lname1=setLName(lname);
		ExtentManager.getExtentTest().info("LastName Entered successfully " +  lname1);
		setJobtitle(jtitle);
		ExtentManager.getExtentTest().info("Jobtitle Entered successfully " +  jtitle);
		setJobtitle2(jtitle2);
		ExtentManager.getExtentTest().info("Jobtitle2 Entered successfully " +  jtitle2);
		setPhoneNumber(phone);
		ExtentManager.getExtentTest().info("Phone Number Entered successfully " +  phone);
		click(Primarymember);
		click(Location);
		selectFromText(Location,location11);
		ExtentManager.getExtentTest().info("Location Entered successfully " +  location11);
	    click(Location);
	    setStatesofRegistration(sregistration);	   
	    ExtentManager.getExtentTest().info("State Registrayion Entered successfully " +  sregistration);
	    waitAndFindElement(SaveUser, Condition.isClickable, 3, 1000);
	    scrollToTop();	
	    //ExtentManager.getExtentTest().pass("Primary User test screenshot",MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		click(SaveUser);
		ExtentManager.getExtentTest().pass("Primary User test screenshot",MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		usermanagerlog.info("New Primary User Is created");
		Thread.sleep(2000);
		assertTrue(driver.getTitle().contains("User Manager - Digital Agent"));
		ExtentManager.getExtentTest().info("Primary User is created with First Name " +  fname1 + "Last Name " +  lname1 + "Email " + uemail );
		usermanagerlog.info("New Primary User Is created");
		boolean present = isElementPresent(AlreadyCreatedUserModal);
		if(present==true) {
			usermanagerlog.info("Sorry, this account already exists.");
			click(AlreadyCreatedUserOk);
			waitAndFindElement(Back, Condition.isClickable, 2, 1000).click();
			ExtentManager.getExtentTest().info("Primary User account already exists. ");
			ExtentManager.getExtentTest().pass("Primary User test screenshot",MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		}
		/*
		 * boolean usercreation = isElementPresent(UserCreationError);
		 * if(usercreation==true) { usermanagerlog.
		 * info("Sorry, an unexpected error occurred. Please contact your system administrator for assistance."
		 * ); click(AlreadyCreatedUserOk); waitAndFindElement(Back,
		 * Condition.isClickable, 2, 1000).click(); }
		 */
	
		}
	@Step("Create a New Team User with email {uemail}")
	public void CreateTeamUser() throws Exception {
		//Thread.sleep(2000);
		uemail=ExcelUtils.getCellData(1, 0);
		String fname=ExcelUtils.getCellData(1, 1);
		String lname=ExcelUtils.getCellData(1, 2);
		String jtitle=ExcelUtils.getCellData(1, 3);
		String jtitle2=ExcelUtils.getCellData(1, 4);
		String phone=ExcelUtils.getCellData(1, 5);
		String tname=ExcelUtils.getCellData(1, 6);
		String location11=ExcelUtils.getCellData(1, 7);
		String sregistration=ExcelUtils.getCellData(1, 8);
		boolean present = isElementPresent(createsingleuser);
		if(present==true) {
			System.out.println("CreateSingleUSer Option is visible "+ present);
			//click(usermanager);
			click(createsingleuser);
			//Thread.sleep(5000);
			click(Teammember);
			setAccountEmail(uemail);
			ExtentManager.getExtentTest().info("Email Entered successfully " + uemail);
			String fname1=setFName(fname);
			ExtentManager.getExtentTest().info("FirstName Entered successfully " +  fname1);
			String lname1=setLName(lname);
			ExtentManager.getExtentTest().info("LastName Entered successfully " +  lname1);
			setJobtitle(jtitle);
			ExtentManager.getExtentTest().info("Jobtitle Entered successfully " +  jtitle);
			setJobtitle2(jtitle2);
			ExtentManager.getExtentTest().info("Jobtitle2 Entered successfully " +  jtitle2);
			setPhoneNumber(phone);
			ExtentManager.getExtentTest().info("Phone Number Entered successfully " +  phone);
			//setLocation(location11);		
			//enterText(PhoneNumber,String.valueOf(PNumber));
			click(Location);
			selectFromText(Location,location11);
			ExtentManager.getExtentTest().info("Location Entered successfully " +  location11);
		    click(Location);
			//Select location1 = new Select(driver.findElement(By.id("branchSelector")));
			//location1.selectByIndex(2);
		    click(Location);
		    String tname1=setTeamName(tname);
		    ExtentManager.getExtentTest().info("Team Name Entered successfully " +  tname1);
		    setStatesofRegistration(sregistration);	
		    ExtentManager.getExtentTest().info("State Registrayion Entered successfully " +  sregistration);
		    waitAndFindElement(SaveUser, Condition.isClickable, 3, 1000);
		    scrollToTop();
			click(SaveUser);
			ExtentManager.getExtentTest().pass("Team User test screenshot",MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
			assertTrue(driver.getTitle().contains("User Manager - Digital Agent"));
			MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build();
			usermanagerlog.info("New Team User Is created");
			Thread.sleep(2000);
			boolean UserPresent = isElementPresent(AlreadyCreatedUserModal);
			if(UserPresent==true) {
				usermanagerlog.info("Sorry, this account already exists.");
				click(AlreadyCreatedUserOk);
				waitAndFindElement(Back, Condition.isClickable, 2, 1000).click();
				ExtentManager.getExtentTest().info("Team User account already exists. ");
				ExtentManager.getExtentTest().pass("Team User test screenshot",MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
			}
		}
		else {
		click(usermanager);
		click(createsingleuser);
		//Thread.sleep(5000);
		click(Teammember);
		setAccountEmail(uemail);
		ExtentManager.getExtentTest().info("Email Entered successfully " + uemail);
		String fname1=setFName(fname);
		ExtentManager.getExtentTest().info("FirstName Entered successfully " +  fname1);
		String lname1=setLName(lname);
		ExtentManager.getExtentTest().info("LastName Entered successfully " +  lname1);
		setJobtitle(jtitle);
		ExtentManager.getExtentTest().info("Jobtitle Entered successfully " +  jtitle);
		setJobtitle2(jtitle2);
		ExtentManager.getExtentTest().info("Jobtitle2 Entered successfully " +  jtitle2);
		setPhoneNumber(phone);
		ExtentManager.getExtentTest().info("Phone Number Entered successfully " +  phone);
		//setLocation(location11);		
		//enterText(PhoneNumber,String.valueOf(PNumber));
		click(Location);
		selectFromText(Location,location11);
		ExtentManager.getExtentTest().info("Location Entered successfully " +  location11);
	    click(Location);
		//Select location1 = new Select(driver.findElement(By.id("branchSelector")));
		//location1.selectByIndex(2);
	    click(Location);
	    String tname1=setTeamName(tname);
	    ExtentManager.getExtentTest().info("Team Name Entered successfully " +  tname1);
	    setStatesofRegistration(sregistration);	
	    ExtentManager.getExtentTest().info("State Registrayion Entered successfully " +  sregistration);
	    waitAndFindElement(SaveUser, Condition.isClickable, 3, 1000);
	    scrollToTop();
		click(SaveUser);
		MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build();
		usermanagerlog.info("New Team User Is created");
		Thread.sleep(2000);
		boolean UserPresent = isElementPresent(AlreadyCreatedUserModal);
		if(UserPresent==true) {
			usermanagerlog.info("Sorry, this user account already exists.");
			click(AlreadyCreatedUserOk);
			waitAndFindElement(Back, Condition.isClickable, 2, 1000).click();
			ExtentManager.getExtentTest().info("Team User account already exists. ");
			ExtentManager.getExtentTest().pass("Team User test screenshot",MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		}
		}
		}
	
	public void SearchUser1() throws Exception {
		//String searchuser1=ExcelUtils.getCellData(1, 0);
		String searchuser1=uemail;
		Thread.sleep(2000);
		boolean present = isElementPresent(SearchUser);
		if(present==true) {
		//click(usermanager);
		click(SearchUser);
		setSearchUser(searchuser1);
		ExtentManager.getExtentTest().info("Search User Name Entered successfully " +  searchuser1);
		click(SearchUserButton);
		ExtentManager.getExtentTest().pass("Search User test screenshot",MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		usermanagerlog.info("User is Searched Successfully");
		}
		else {
			click(usermanager);
			click(SearchUser);
			setSearchUser(searchuser1);
			click(SearchUserButton);
			ExtentManager.getExtentTest().pass("Search User test screenshot",MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
			usermanagerlog.info("User is Searched Successfully");
		}
	}
	public void ImpersonateUser() throws Exception{
		boolean present = isElementPresent(SearchUser);
		if(present==true) {
		//click(usermanager);
		click(SearchUser);
		//String searchuser1=ExcelUtils.getCellData(1, 0);
		String searchuser1=uemail;
		//String searchuseraction=ExcelUtils.getCellData(1, 1);
		setSearchUser(searchuser1);
		click(SearchUserButton);		
		click(SearchUserAction);
		//setSearchUserAction(searchuseraction);
		//selectFromText(SearchUserAction,searchuseraction);
		Select action1 = new Select(driver.findElement(By.id("user-manager-actions")));
		action1.selectByIndex(0);
		click(GoButton);
		ExtentManager.getExtentTest().pass("Impersonate User test screenshot",MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		usermanagerlog.info("User Is Impersonated Successfully");}		
		else {
			click(usermanager);
			click(SearchUser);
			String searchuser1=ExcelUtils.getCellData(1, 0);
			setSearchUser(searchuser1);
			click(SearchUserButton);
			//setSearchUserAction(searchuseraction);
			waitAndFindElement(SearchUserAction, Condition.isClickable, 5, 1000);
			click(SearchUserAction);
			Select action1 = new Select(driver.findElement(By.id("user-manager-actions")));
			action1.selectByIndex(0);	
			click(GoButton);
			ExtentManager.getExtentTest().pass("Impersonate User test screenshot",MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
			usermanagerlog.info("User Is Impersonated Successfully");
		}
	}
}
