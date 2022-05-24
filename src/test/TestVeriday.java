package test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

//import com.tests.LoginTest;

import BasePage.BasePage;
import ExtentReportListener.ExtentManager;
import ExtentReportListener.ExtentReportCreate;
import pages.*;

//@Listeners(CustomListener.class)
public class TestVeriday extends BasePage {

	@Test(groups = { "Regression" }, priority = 0, enabled = true)
	public void loginTest() throws Exception {
		//ExtentTest test = extent.createTest("Login Test").assignCategory("Regression").assignDevice("Chrome 89");
		ExtentReportCreate.createTest("Login Test", "Regression", "Chrome 89");
     	ExtentManager.getExtentTest().pass(MarkupHelper.createLabel("Login Test Started successfully", ExtentColor.GREEN));
		ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData, "Login");
		co.objLogin.LoginToCRM();
		System.out.println(ExtentManager.getExtentTest().getStatus());
		if(ExtentManager.getExtentTest().getStatus().getName().equals("Pass")) {
			ExtentManager.getExtentTest().pass(MarkupHelper.createLabel("Login Test Ended successfully", ExtentColor.GREEN));
			ExtentManager.getExtentTest().pass("Login Test screenshot", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		}
		else if(ExtentManager.getExtentTest().getStatus().getName().equals("Fail")){			
			ExtentManager.getExtentTest().fail("Login Test failed screenshot", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
			ExtentManager.getExtentTest().fail(MarkupHelper.createLabel("Login Unsuccessfull", ExtentColor.RED));
		}		
	}

	@Test(groups = { "Regression" }, priority = 1, enabled = true)
	public void CreatePrimaryUserTest() throws Exception {
		ExtentReportCreate.createTest("Create Primary User Test", "Regression", "Chrome 89");
     	ExtentManager.getExtentTest().pass(MarkupHelper.createLabel("Create Primary User Started successfully", ExtentColor.GREEN));
		// Assigning Excel file Data
		ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData, "CreateUser");
		co.objUserManager.CreatePrimaryUser();
		ExtentManager.getExtentTest().pass(MarkupHelper.createLabel("Primary User created successfully", ExtentColor.GREEN));
		ExtentManager.getExtentTest().pass(MarkupHelper.createLabel("Create Primary User Test Ended successfully", ExtentColor.GREEN));
	}

	@Test(groups = { "Regression" }, priority = 2, enabled =true)
	public void CreateTeamUserTest() throws Exception {
		// Assigning Excel file Data
		ExtentReportCreate.createTest("Create Team User Test", "Regression", "Chrome 89");
     	ExtentManager.getExtentTest().pass(MarkupHelper.createLabel("Create Team User test started successfully", ExtentColor.GREEN));
		ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData, "CreateTeamUser");
		co.objUserManager.CreateTeamUser();
		ExtentManager.getExtentTest().pass(MarkupHelper.createLabel("Team User created successfully", ExtentColor.GREEN));
		ExtentManager.getExtentTest().pass("Team User test screenshot",MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		ExtentManager.getExtentTest().pass(MarkupHelper.createLabel("Create Team User test ended successfully", ExtentColor.GREEN));
	}

	@Test(groups = { "Regression" }, priority = 3, enabled = true)
	public void SearchUserTest() throws Exception {
		ExtentReportCreate.createTest("Search User Test", "Regression", "Chrome 89");
     	ExtentManager.getExtentTest().pass(MarkupHelper.createLabel("Search User test Started successfully", ExtentColor.GREEN));
		// Assigning Excel file Data
		ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData, "Login");
		// co.objLogin.LoginToCRM();
		//ExtentManager.getExtentTest().pass(MarkupHelper.createLabel("Search User Test Started successfully", ExtentColor.GREEN));
		ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData, "SearchUser");
		co.objUserManager.SearchUser1();		
		ExtentManager.getExtentTest().pass(MarkupHelper.createLabel("Search User Test Ended successfully", ExtentColor.GREEN));
	}

	@Test(groups = { "Regression" }, priority = 4, enabled = true)
	public void ImpersonateUserTest() throws Exception {
		ExtentReportCreate.createTest("Impersonate User Test", "Regression", "Chrome 89");
		// extentTest = extent.startTest("ImpersonateUserTest");
		ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData, "Login");
		// co.objLogin.LoginToCRM();
		// Assigning Excel file Data
		ExtentManager.getExtentTest().pass(MarkupHelper.createLabel("Impersonate User Test Started successfully", ExtentColor.GREEN));
		//ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData, "SearchUser");
		co.objUserManager.ImpersonateUser();		
		ExtentManager.getExtentTest().pass(MarkupHelper.createLabel("Impersonate User Test Ended successfully", ExtentColor.GREEN));

	}

	@Test(groups = { "Regression" }, priority = 5, enabled = false)
	public void CreateNewEventTest() throws Exception {
		ExtentReportCreate.createTest("Create New Event Test", "Regression", "Chrome 89");
		// Assigning Excel file Data
		ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData, "NewEventDetails");
		ExtentManager.getExtentTest().pass(MarkupHelper.createLabel("Create New Event Test Started successfully", ExtentColor.GREEN));
		co.objDigitalWorkspacePage.CreateNewEvent();
		ExtentManager.getExtentTest().pass("Create New Event test screenshot",MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		ExtentManager.getExtentTest().pass(MarkupHelper.createLabel("Create New Event Test Ended successfully", ExtentColor.GREEN));

	}
	@Test(groups = { "Regression" }, priority = 6, enabled = false)
	public void CreateNewWebSiteTest() throws Exception {
		ExtentReportCreate.createTest("Create New Web Page Test", "Regression", "Chrome 89");
     	ExtentManager.getExtentTest().pass(MarkupHelper.createLabel("Create New Web Site test", ExtentColor.GREEN));
		//ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData, "SearchUser");
		// co.objUserManager.ImpersonateUser();
		ExtentManager.getExtentTest().pass(MarkupHelper.createLabel("Create New Web Site Test Started successfully", ExtentColor.GREEN));
		ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData, "NewEventDetails");
		//ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData, "CreateWebSite");
		// Assigning Excel file Data
		co.objDigitalWorkspacePage.CreateNewWebsite();
		ExtentManager.getExtentTest().pass("Create New Web Site test screenshot",MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		ExtentManager.getExtentTest().pass(MarkupHelper.createLabel("Create New Web Site Test Ended successfully", ExtentColor.GREEN));
	}

	@Test(groups = { "Regression" }, priority = 7, enabled = false)
	public void CreateNewWebPageTest() throws Exception {
		ExtentReportCreate.createTest("Create New Web Page Test", "Regression", "Chrome 89");
     	ExtentManager.getExtentTest().pass(MarkupHelper.createLabel("Create New Web Page test", ExtentColor.GREEN));
		//ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData, "SearchUser");
		// co.objUserManager.ImpersonateUser();
		ExtentManager.getExtentTest().pass(MarkupHelper.createLabel("Create New Web Page Test Started successfully", ExtentColor.GREEN));
		ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData, "CreateNewPage");
		// Assigning Excel file Data
		co.objDigitalWorkspacePage.CreateNewPageinWebsite();
		ExtentManager.getExtentTest().pass("Create New Web Page test screenshot",MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		ExtentManager.getExtentTest().pass(MarkupHelper.createLabel("Create New Web Page Test Ended successfully", ExtentColor.GREEN));
	}

	@Test(groups = { "Regression" }, priority = 8, enabled = false)
	public void CreateNewFormTest() throws Exception {
		ExtentReportCreate.createTest("Create New Form Test", "Regression", "Chrome 89");
     	ExtentManager.getExtentTest().pass(MarkupHelper.createLabel("Create New Form test", ExtentColor.GREEN));
		// Assigning Excel file Data
		ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData, "CreateNewForm");
		ExtentManager.getExtentTest().pass(MarkupHelper.createLabel("Create New Form Test Started successfully", ExtentColor.GREEN));
		co.objDigitalWorkspacePage.CreateNewForm();
		ExtentManager.getExtentTest().pass("Create New Form test screenshot",MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		ExtentManager.getExtentTest().pass(MarkupHelper.createLabel("Create New Form Test Ended successfully", ExtentColor.GREEN));
	}

	@Test(groups = { "Regression" }, priority = 9, enabled = false)
	public void ValidateHomePgaeOptions() throws Exception {
		ExtentReportCreate.createTest("Validate HomePage option Test", "Regression", "Chrome 89");
     	ExtentManager.getExtentTest().pass(MarkupHelper.createLabel("Validate AdminHQ option test started successfully", ExtentColor.GREEN));
		co.objHomePage.validateAdminHQ();
		ExtentManager.getExtentTest().pass("Validate AdminHQ option test screenshot",MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		ExtentManager.getExtentTest().pass(MarkupHelper.createLabel("Validate AdminHQ test ended successfully", ExtentColor.GREEN));
		ExtentManager.getExtentTest().pass(MarkupHelper.createLabel("Validate User Manager option test started successfully", ExtentColor.GREEN));
		co.objHomePage.validateUserManager();
		ExtentManager.getExtentTest().pass("Validate User Manager option test screenshot",MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		ExtentManager.getExtentTest().pass(MarkupHelper.createLabel("Validate User Manager option test ended successfully", ExtentColor.GREEN));
		ExtentManager.getExtentTest().pass(MarkupHelper.createLabel("Validate Queues option test started successfully", ExtentColor.GREEN));
		co.objHomePage.validateQueues();
		ExtentManager.getExtentTest().pass("Validate Queues option test screenshot",MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		ExtentManager.getExtentTest().pass(MarkupHelper.createLabel("Validate Queues option test ended successfully", ExtentColor.GREEN));
		ExtentManager.getExtentTest().pass(MarkupHelper.createLabel("Validate Organizational Groups option test started successfully", ExtentColor.GREEN));
		co.objHomePage.validateOrganizationalGroups();
		ExtentManager.getExtentTest().pass("Validate Organizational Groups option test screenshot",MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		ExtentManager.getExtentTest().pass(MarkupHelper.createLabel("Validate Organizational Groups option test ended", ExtentColor.GREEN));
	}

	@Test(groups = { "Regression" }, priority = 10, enabled = false)
	public void ValidateAdminHQOptions() throws Exception {
		ExtentReportCreate.createTest("Validate AdinHQ option Test", "Regression", "Chrome 89");
		ExtentManager.getExtentTest().pass(MarkupHelper.createLabel("Validate Hub Manager option test started successfully", ExtentColor.GREEN));
		co.objHomePage.validateHubManager();
		ExtentManager.getExtentTest().pass("Validate Hub Manager option test screenshot",MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		ExtentManager.getExtentTest().pass(MarkupHelper.createLabel("Validate Hub Manager option test ended successfully", ExtentColor.GREEN));
		ExtentManager.getExtentTest().pass(MarkupHelper.createLabel("Validate Global Settings option test started successfully", ExtentColor.GREEN));
		co.objHomePage.validateGlobalSettings();
		ExtentManager.getExtentTest().pass("Validate Global Settings option test screenshot",MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		ExtentManager.getExtentTest().pass(MarkupHelper.createLabel("Validate Global Settings option test ended successfully", ExtentColor.GREEN));
		ExtentManager.getExtentTest().pass(MarkupHelper.createLabel("Validate Email Templates option test started successfully", ExtentColor.GREEN));
		co.objHomePage.validateEmailTemplates();
		ExtentManager.getExtentTest().pass("Validate Email Templates option test screenshot",MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		ExtentManager.getExtentTest().pass(MarkupHelper.createLabel("Validate Email Templates option test ended successfully", ExtentColor.GREEN));
		ExtentManager.getExtentTest().pass(MarkupHelper.createLabel("Validate Maintenance option test started successfully", ExtentColor.GREEN));
		co.objHomePage.validateMaintenance();
		ExtentManager.getExtentTest().pass("Validate Maintenance option test screenshot",MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		ExtentManager.getExtentTest().pass(MarkupHelper.createLabel("Validate Maintenance option test ended successfully", ExtentColor.GREEN));
	}

	@Test(groups = { "Regression" }, priority = 10, enabled = false)
	public void ValidateDigitalWorkSpaceOptions() throws Exception {
		// extentTest = extent.startTest("ValidateDigitalWorkSpaceOptions");
		ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData, "SearchUser");
		co.objUserManager.SearchUser1();
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

	@Test(groups = { "Regression" }, priority = 10, enabled = false)
	public void CreateGroup() throws Exception {
		// extentTest = extent.startTest("CreateUpdateGroup");
		ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData, "NewGroup");
		co.objHomePage.CreateNewGroup();
	}

	@Test(groups = { "Regression" }, priority = 11, enabled = false)
	public void CreateUpdateGroup() throws Exception {
		// extentTest = extent.startTest("CreateUpdateGroup");
		ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData, "NewGroup");
		co.objHomePage.CreateNewGroup();
		co.objHomePage.UpdateGroup();
	}

	@Test(groups = { "Regression" }, priority = 12, enabled = false)
	public void DeleteGroup() throws Exception {
		// extentTest = extent.startTest("DeleteNewGroup");
		ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData, "NewGroup");
		co.objHomePage.CreateNewGroup();
		co.objHomePage.DeleteGroup();
	}

	@Test(groups = { "Regression" }, priority = 13, enabled = false)
	public void CreateRegion() throws Exception {
		// extentTest = extent.startTest("CreateNewRegion");
		ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData, "NewGroup");
		co.objHomePage.CreateNewGroup();
		co.objHomePage.CreateNewRegion();
		// co.objHomePage.UpdateRegion();
		co.objHomePage.CreateNewBranch();
		// co.objHomePage.UpdateBranch();
	}

}
