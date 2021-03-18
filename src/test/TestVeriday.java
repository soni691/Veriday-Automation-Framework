package test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//import com.tests.LoginTest;

import BasePage.BasePage;
import BasePage.CustomListener;
import ExtentReportListener.ExtentReportCreate;
import createObject.CreateObject;
import pages.*;
import utility.ExcelDataRead;
import dashboard.Dashboard;

//@Listeners(CustomListener.class)
public class TestVeriday extends BasePage {

	@Test(groups = {"Regression"},priority=0,enabled= true)
	public void loginTest() throws Exception {
		extentTest = extent.startTest("loginTest");
		//Assigning Excel file Data
		ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData,"Login");
		//Login Method
		co.objLogin.LoginToCRM();
	}
	@Test(groups = {"Regression"},priority=1,enabled= false)
	public void CreatePrimaryUserTest() throws Exception {
		extentTest = extent.startTest("CreatePrimaryUserTest");
		//ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData,"Login");
		//Assigning Excel file Data
		ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData,"CreateUser");
		co.objUserManager.CreatePrimaryUser();

	}
	@Test(groups = {"Regression"},priority=2,enabled= false)
	public void CreateTeamUserTest() throws Exception {
		extentTest = extent.startTest("CreateTeamUserTest");
		//ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData,"Login");
		//objLogin=new LoginPage(driver);
		//objLogin.LoginToCRM();
		//Assigning Excel file Data
		ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData,"CreateTeamUser");
		co.objUserManager.CreateTeamUser();	
	}
	@Test(groups = {"Regression"},priority=3,enabled= false)
	public void SearchUserTest() throws Exception {
		extentTest = extent.startTest("SearchUserTest");
		//Assigning Excel file Data
		ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData,"Login");
		//co.objLogin.LoginToCRM();
		ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData,"SearchUser");
		co.objUserManager.SearchUser1();

	}
	@Test(groups = {"Regression"},priority=4,enabled= false)
	public void ImpersonateUserTest() throws Exception {
		extentTest = extent.startTest("ImpersonateUserTest");
		ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData,"Login");
		//co.objLogin.LoginToCRM();
		//Assigning Excel file Data
		ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData,"SearchUser");
		co.objUserManager.ImpersonateUser();

	}
	@Test(groups = {"Regression"},priority=5,enabled= false)
	public void CreateNewEventTest() throws Exception {
		extentTest = extent.startTest("CreateNewEventTest");
		//ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData,"Login");
		//co.objLogin.LoginToCRM();
		//ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData,"SearchUser");
		//co.objUserManager.ImpersonateUser();
		//Assigning Excel file Data
		ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData,"NewEventDetails");
		co.objDigitalWorkspacePage.CreateNewEvent();
	}
	@Test(groups = {"Regression"},priority=6,enabled= false)	
	public void CreateNewWebPageTest() throws Exception {
		extentTest = extent.startTest("CreateNewPageTest");
		//Assert.assertTrue(false);
		//ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData,"Login");
		//	co.objLogin=new LoginPage(driver);
		//	co.objLogin.LoginToCRM();
		ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData,"SearchUser");
		//co.objUserManager.ImpersonateUser();
		ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData,"CreateNewPage");
		//Assigning Excel file Data
		co.objDigitalWorkspacePage.CreateNewPageinWebsite();
	}	
	@Test(groups = {"Regression"},priority=7,enabled= false)	
	public void CreateNewFormTest() throws Exception {
		extentTest = extent.startTest("CreateNewFormTest");
		//Assert.assertTrue(false);
		ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData,"SearchUser");
		//co.objUserManager.ImpersonateUser();
		//ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData,"CreateNewPage");
		//Assigning Excel file Data
		ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData,"CreateNewForm");
		co.objDigitalWorkspacePage.CreateNewForm();
	}
	  
	  @Test(groups = {"Regression"},priority=8,enabled= false) 
	  public void ValidateHomePgaeOptions() throws Exception { 
	  extentTest = extent.startTest("ValidateHomepage");
	  co.objHomePage.validateAdminHQ();
	  co.objHomePage.validateUserManager();
	  co.objHomePage.validateQueues();
	  co.objHomePage.validateOrganizationalGroups();; 
	  }
	  
	  @Test(groups = {"Regression"},priority=9,enabled= false) 
	  public void ValidateAdminHQOptions() throws Exception
	  { 
      extentTest = extent.startTest("ValidateAdminHQOptions");
	  co.objHomePage.validateHubManager();
	  co.objHomePage.validateGlobalSettings();
	  co.objHomePage.validateEmailTemplates();
	  co.objHomePage.validateMaintenance();
	  }
	  @Test(groups = {"Regression"},priority=10,enabled= false) 
	  public void ValidateDigitalWorkSpaceOptions() throws Exception
	  { 
      extentTest = extent.startTest("ValidateDigitalWorkSpaceOptions");
      ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData,"SearchUser");
	  co.objUserManager.SearchUser1();
	  ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData,"SearchUser");
	  co.objUserManager.ImpersonateUser();
	  co.objDigitalWorkspacePage.validateDWSettings();
	  co.objDigitalWorkspacePage.validateDWMyWebsite();
	  co.objDigitalWorkspacePage.validateDWBlog();
	  co.objDigitalWorkspacePage.validateDWForm();
	  co.objDigitalWorkspacePage.validateDWEvents();
	  co.objDigitalWorkspacePage.validateDWPolls();
	  co.objDigitalWorkspacePage.validateDWRecycleBin();
	  co.objDigitalWorkspacePage.validateDWMyProfile();
	  co.objDigitalWorkspacePage.validateDWUpdates();
	  co.objDigitalWorkspacePage.validateDWCampaignManager();
	  co.objDigitalWorkspacePage.validateDWContentCollection();
	  co.objDigitalWorkspacePage.validateDWDashboard();
	  co.objDigitalWorkspacePage.validateDWFileManager();
	  co.objDigitalWorkspacePage.validateDWDashboard2();
	  }
	  
	  @Test(groups = {"Regression"},priority=10,enabled= false) 
	  public void CreateGroup() throws Exception
	  { 
      extentTest = extent.startTest("CreateUpdateGroup");
      ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData,"NewGroup");
      co.objHomePage.CreateNewGroup();
	  }
	  @Test(groups = {"Regression"},priority=11,enabled= false) 
	  public void CreateUpdateGroup() throws Exception
	  { 
      extentTest = extent.startTest("CreateUpdateGroup");
      ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData,"NewGroup");
      co.objHomePage.CreateNewGroup();
      co.objHomePage.UpdateGroup();
	  }
	  @Test(groups = {"Regression"},priority=12,enabled= false) 
	  public void DeleteGroup() throws Exception
	  { 
      extentTest = extent.startTest("DeleteNewGroup");
      ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData,"NewGroup");
      co.objHomePage.CreateNewGroup();
      co.objHomePage.DeleteGroup();
	  }
	  @Test(groups = {"Regression"},priority=13,enabled= true) 
	  public void CreateRegion() throws Exception
	  { 
      extentTest = extent.startTest("CreateNewRegion");
      ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData,"NewGroup");
      co.objHomePage.CreateNewGroup();
      co.objHomePage.CreateNewRegion();
     // co.objHomePage.UpdateRegion();
      co.objHomePage.CreateNewBranch();
     // co.objHomePage.UpdateBranch();
	  }
	 
}
