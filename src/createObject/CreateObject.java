package createObject;

import org.openqa.selenium.WebDriver;

import BasePage.BasePage;
import pages.DigitalWorkspacePage;
import pages.HomePage;
import pages.LoginPage;
import pages.UserManagerPage;

public class CreateObject extends BasePage {
	
	public LoginPage objLogin;
	public UserManagerPage objUserManager;
	public DigitalWorkspacePage objDigitalWorkspacePage;
	public BasePage objBasePage;
	public HomePage objHomePage;
	
	public CreateObject(WebDriver driver) {
		objBasePage = new BasePage();
		objLogin = new LoginPage(driver);
		objUserManager = new UserManagerPage(driver) ;
		objDigitalWorkspacePage=new DigitalWorkspacePage(driver);
		objHomePage = new HomePage(driver);
	}
}
