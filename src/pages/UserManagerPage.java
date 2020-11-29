package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import com.google.inject.spi.Element;

import BasePage.BasePage;

public class UserManagerPage extends BasePage {
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
		
	void setAccountEmail(String uemail) {
		enterText(AccountEmail, uemail);
	}
	void setFName(String fname) {
	    enterText(FirstName, fname);
	}
	void setLName(String lname) {
	    enterText(LastName, lname);
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
	void setTeamName(String tname) {
		enterText(TeamName,tname);
	}
	void setSearchUser(String searchuser1) {
		enterText(SearchUser,searchuser1);
	}
	void setSearchUserAction(String searchuseraction) {
		enterText(SearchUserAction,searchuseraction);
	}
	
	
	public void CreatePrimaryUser() throws Exception {
		String uemail=ExcelUtils.getCellData(1, 0);
		String fname=ExcelUtils.getCellData(1, 1);
		String lname=ExcelUtils.getCellData(1, 2);
		String jtitle=ExcelUtils.getCellData(1, 3);
		String jtitle2=ExcelUtils.getCellData(1, 4);
		String phone=ExcelUtils.getCellData(1, 5);
		String location11=ExcelUtils.getCellData(1, 6);
		click(usermanager);
		click(createsingleuser);
		Thread.sleep(5000);
		setAccountEmail(uemail);
		setFName(fname);
		setLName(lname);
		setJobtitle(jtitle);
		setJobtitle2(jtitle2);
		setPhoneNumber(phone);
		click(Primarymember);
		click(Location);
		selectFromText(Location,location11);
	    click(Location);
	   //JavascriptExecutor jse = (JavascriptExecutor)driver;
		//jse.executeScript("window.scrollBy(0,-250)");
		//Thread.sleep(5000);
		click(SaveUser);
		Thread.sleep(2000);
		//waitAndFindElement(AlreadyCreatedUserModal, Condition.isPresent, 2, 1000);
		boolean present = isElementPresent(AlreadyCreatedUserModal);
		if(present==true) {
			System.out.println("Sorry, this account already exists.");
			click(AlreadyCreatedUserOk);
			waitAndFindElement(Back, Condition.isClickable, 2, 1000).click();
		}
	
		}
	public void CreateTeamUser() throws Exception {
		//Thread.sleep(2000);
		//waitAndFindElement(createsingleuser, Condition.isPresent, 30, 8000);
		String uemail=ExcelUtils.getCellData(1, 0);
		String fname=ExcelUtils.getCellData(1, 1);
		String lname=ExcelUtils.getCellData(1, 2);
		String jtitle=ExcelUtils.getCellData(1, 3);
		String jtitle2=ExcelUtils.getCellData(1, 4);
		String phone=ExcelUtils.getCellData(1, 5);
		String tname=ExcelUtils.getCellData(1, 6);
		String location11=ExcelUtils.getCellData(1, 7);
		boolean present = isElementPresent(createsingleuser);
		if(present==true) {
			System.out.println("CreateSingleUSer Option is visible "+ present);
			//System.out.println("Sorry, this account already exists.");
			//click(usermanager);
			click(createsingleuser);
			//Thread.sleep(5000);
			click(Teammember);
			setAccountEmail(uemail);
			setFName(fname);
			setLName(lname);
			setJobtitle(jtitle);
			setJobtitle2(jtitle2);
			setPhoneNumber(phone);
			//setLocation(location11);		
			//enterText(PhoneNumber,String.valueOf(PNumber));
			click(Location);
			selectFromText(Location,location11);
		    click(Location);
			//Select location1 = new Select(driver.findElement(By.id("branchSelector")));
			//location1.selectByIndex(2);
		    click(Location);
		    setTeamName(tname);
		    JavascriptExecutor jse = (JavascriptExecutor)driver;
		 	jse.executeScript("window.scrollBy(0,-250)");
			click(SaveUser);
			Thread.sleep(2000);
			boolean UserPresent = isElementPresent(AlreadyCreatedUserModal);
			if(UserPresent==true) {
				System.out.println("Sorry, this account already exists.");
				click(AlreadyCreatedUserOk);
				waitAndFindElement(Back, Condition.isClickable, 2, 1000).click();
			}
		}
		else {
		click(usermanager);
		click(createsingleuser);
		//Thread.sleep(5000);
		click(Teammember);
		setAccountEmail(uemail);
		setFName(fname);
		setLName(lname);
		setJobtitle(jtitle);
		setJobtitle2(jtitle2);
		setPhoneNumber(phone);
		//setLocation(location11);		
		//enterText(PhoneNumber,String.valueOf(PNumber));
		click(Location);
		selectFromText(Location,location11);
	    click(Location);
		//Select location1 = new Select(driver.findElement(By.id("branchSelector")));
		//location1.selectByIndex(2);
	    click(Location);
	    setTeamName(tname);
	    JavascriptExecutor jse = (JavascriptExecutor)driver;
	 	jse.executeScript("window.scrollBy(0,-250)");
		click(SaveUser);
		Thread.sleep(2000);
		boolean UserPresent = isElementPresent(AlreadyCreatedUserModal);
		if(UserPresent==true) {
			System.out.println("Sorry, this user account already exists.");
			click(AlreadyCreatedUserOk);
			waitAndFindElement(Back, Condition.isClickable, 2, 1000).click();
		}
		}
		}
	
	public void SearchUser1() throws Exception {
		String searchuser1=ExcelUtils.getCellData(1, 0);
		Thread.sleep(2000);
		boolean present = isElementPresent(SearchUser);
		if(present==true) {
		//click(usermanager);
		click(SearchUser);
		setSearchUser(searchuser1);
		click(SearchUserButton);
		}
		else {
			click(usermanager);
			click(SearchUser);
			setSearchUser(searchuser1);
			click(SearchUserButton);
		}
	}
	public void ImpersonateUser() throws Exception{
		boolean present = isElementPresent(SearchUser);
		if(present==true) {
		//click(usermanager);
		click(SearchUser);
		String searchuser1=ExcelUtils.getCellData(1, 0);
		//String searchuseraction=ExcelUtils.getCellData(1, 1);
		setSearchUser(searchuser1);
		click(SearchUserButton);		
		click(SearchUserAction);
		//setSearchUserAction(searchuseraction);
		//selectFromText(SearchUserAction,searchuseraction);
		Select action1 = new Select(driver.findElement(By.id("user-manager-actions")));
		action1.selectByIndex(0);
		click(GoButton);}
		else {
			click(usermanager);
			click(SearchUser);
			String searchuser1=ExcelUtils.getCellData(1, 0);
			setSearchUser(searchuser1);
			click(SearchUserButton);
			//setSearchUserAction(searchuseraction);
			waitAndFindElement(SearchUserAction, Condition.isClickable, 5, 1000);
			click(SearchUserAction);
			//Thread.sleep(2000);
			
			//String searchuseraction=ExcelUtils.getCellData(1, 1);
			//selectFromText(SearchUserAction,searchuseraction);
			//System.out.println("User Action is "+ searchuseraction);
			Select action1 = new Select(driver.findElement(By.id("user-manager-actions")));
			action1.selectByIndex(0);	
			click(GoButton);
		}
	}
}
