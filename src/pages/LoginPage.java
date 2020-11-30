package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import BasePage.BasePage;
import pages.ExcelUtils;
import utility.ExcelDataRead;
    public class LoginPage extends BasePage {
	public static String testLogger = "LoginPage";
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
		public void LoginToCRM() throws Exception {
			
			String LoginBy=ExcelUtils.getCellData(1, 4);
			String UserName="";
			String Password="";
			if(LoginBy.equals("RBCUS")) {
				UserName = ExcelUtils.getCellData(1, 1);
				Password = ExcelUtils.getCellData(1, 2);
			} else if(LoginBy.equals("Branch")) {
				UserName = ExcelUtils.getCellData(2, 1);
				Password = ExcelUtils.getCellData(2, 2);
			}
			
			//ExcelDataRead eat = new ExcelDataRead("D:\\Eclipse Workspace\\CRMtesting\\Source\\TestData.xlsx");        
	        //System.out.println(ExcelDataRead.getCellData("ExcelAdmin","loginName",2));
			
			//String sUserName=ExcelDataRead.getCellData("ExcelAdmin","uname",2);
			//String sPassword=ExcelDataRead.getCellData("ExcelAdmin","loginPassword",2);
			
			System.out.println("Username : "+UserName+"\nPassword : "+Password);
			setUsername(UserName);
			setPassword(Password);
			Thread.sleep(1000);	
			clickLogin();
			Testlogger.info("Login Test Case is Successful");
		}
		
}
