package pages;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

//import com.relevantcodes.extentreports.LogStatus;

import BasePage.BasePage;
import ExtentReportListener.ExtentManager;
import ExtraData.variables;
import io.qameta.allure.Step;
import pages.ExcelUtils;
import utility.ExcelDataRead;
    public class LoginPage extends BasePage {
	public static String testLogger = "LoginPage";
	public SoftAssert sassert;
	Logger Testlogger = getLogger(testLogger);
		//WebDriver driver;
	
		@BeforeClass
		public void setUp() {
			driver = getDriver();
		}

		By email=By.xpath("//input[@id='A5755:loginForm:email']");
		By password=By.xpath("//input[@id='A5755:loginForm:password']");
		By login=By.xpath("//input[@id='A5755:loginForm:login']");

		public LoginPage(WebDriver driver){
			this.driver=driver;
		}
		public void setUsername(String strUsername) {
			enterText(email, strUsername);
		}
		public void setPassword(String strPassword) {
			enterText(password, strPassword);
		}
		public void clickLogin() {
			click(login);
		}
		@Step("Login with UserName: {0} & Password: {1} to Login Page")

		public void LoginToCRM()  {
			String LoginBy;
			try {
				LoginBy = ExcelUtils.getCellData(1, 4);
			String UserName="";
			String Password="";
			if(LoginBy.equals("RBCUS")) {
				UserName = ExcelUtils.getCellData(1, 1);
				variables.Fname = UserName;
			System.out.println(variables.Fname);
				Password = ExcelUtils.getCellData(1, 2);
			} else if(LoginBy.equals("Branch")) {
				UserName = ExcelUtils.getCellData(2, 1);
				Password = ExcelUtils.getCellData(2, 2);
			}
			System.out.println("Username : "+UserName+"\nPassword : "+Password);
			setUsername(UserName);
			ExtentManager.getExtentTest().info("Username is " + UserName);
			ExtentManager.getExtentTest().info("Username Entered successfully");
			setPassword(Password);
			ExtentManager.getExtentTest().info("Password is " + Password);
			ExtentManager.getExtentTest().info("Password Entered successfully");
			Thread.sleep(1000);	
			clickLogin();
			assertTrue(driver.getTitle().equals("Digital Workspace - Digital Agent"));
			ExtentManager.getExtentTest().info("User Logged in successfully");
			Testlogger.info("Login Test Case is Successful");		
		}
			
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
}
    }
