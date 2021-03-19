package test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

//import com.tests.LoginTest;

import BasePage.BasePage;
import ExtentReportListener.ExtentReportCreate;
import pages.*;

//@Listeners(CustomListener.class)
public class TestVeriday extends BasePage {

	@Test(groups = { "Regression" }, priority = 0, enabled = true)
	public void loginTest() throws Exception {
		ExtentTest test = extent.createTest("Login Test").assignCategory("Regression").assignDevice("Chrome 89");
     	test.pass(MarkupHelper.createLabel("Login Test Started successfully", ExtentColor.GREEN));
		ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData, "Login");
		co.objLogin.LoginToCRM();
		System.out.println(test.getStatus());
		if(test.getStatus().getName().equals("Pass")) {
			assertTrue(driver.getTitle().contains("Digital Workspace - Digital Agent"));
		test.pass(MarkupHelper.createLabel("Login Test Ended successfully", ExtentColor.GREEN));
		test.pass("Login Test screenshot", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		}
		else{			
		test.fail("Login Test failed screenshot", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		test.fail(MarkupHelper.createLabel("Login Unsuccessfull", ExtentColor.RED));
		}		
	}

	@Test(groups = { "Regression" }, priority = 1, enabled = false)
	public void CreatePrimaryUserTest() throws Exception {
		ExtentTest test = extent.createTest("Create Primary User Test").assignCategory("Regression").assignDevice("Chrome 89");
		test.pass(MarkupHelper.createLabel("Create Primary User Test Started successfully", ExtentColor.GREEN));
		// Assigning Excel file Data
		ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData, "CreateUser");
		co.objUserManager.CreatePrimaryUser();
		test.pass(MarkupHelper.createLabel("Primary User created successfully", ExtentColor.GREEN));
		test.pass("Primary User test screenshot",
		MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		test.pass(MarkupHelper.createLabel("Create Primary User Test Started successfully", ExtentColor.GREEN));
	}

	@Test(groups = { "Regression" }, priority = 2, enabled =false)
	public void CreateTeamUserTest() throws Exception {
		// Assigning Excel file Data
		ExtentTest test = extent.createTest("Create Team User Test").assignCategory("Regression").assignDevice("Chrome 89");
		ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData, "CreateTeamUser");
		test.pass(MarkupHelper.createLabel("Create Team User Test Started successfully", ExtentColor.GREEN));
		co.objUserManager.CreateTeamUser();
		test.pass(MarkupHelper.createLabel("Team User created successfully", ExtentColor.GREEN));
		test.pass("Team User test screenshot",MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		test.pass(MarkupHelper.createLabel("Team User test ended successfully", ExtentColor.GREEN));
	}

	@Test(groups = { "Regression" }, priority = 3, enabled = false)
	public void SearchUserTest() throws Exception {
		ExtentTest test = extent.createTest("Search User Test").assignCategory("Regression").assignDevice("Chrome 89");
		// Assigning Excel file Data
		ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData, "Login");
		// co.objLogin.LoginToCRM();
		test.pass(MarkupHelper.createLabel("Search Team User Test Started successfully", ExtentColor.GREEN));
		ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData, "SearchUser");
		co.objUserManager.SearchUser1();
		test.pass("Search User test screenshot",MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		test.pass(MarkupHelper.createLabel("Search Team User Test Ended successfully", ExtentColor.GREEN));
	}

	@Test(groups = { "Regression" }, priority = 4, enabled = false)
	public void ImpersonateUserTest() throws Exception {
		// extentTest = extent.startTest("ImpersonateUserTest");
		ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData, "Login");
		// co.objLogin.LoginToCRM();
		// Assigning Excel file Data
		ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData, "SearchUser");
		co.objUserManager.ImpersonateUser();

	}

	@Test(groups = { "Regression" }, priority = 5, enabled = false)
	public void CreateNewEventTest() throws Exception {
		// extentTest = extent.startTest("CreateNewEventTest");
		// ExcelUtils.setExcelFile(ConstantInterface.Path_TestData +
		// ConstantInterface.File_TestData,"Login");
		// co.objLogin.LoginToCRM();
		// ExcelUtils.setExcelFile(ConstantInterface.Path_TestData +
		// ConstantInterface.File_TestData,"SearchUser");
		// co.objUserManager.ImpersonateUser();
		// Assigning Excel file Data
		ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData, "NewEventDetails");
		co.objDigitalWorkspacePage.CreateNewEvent();
	}

	@Test(groups = { "Regression" }, priority = 6, enabled = false)
	public void CreateNewWebPageTest() throws Exception {
		// extentTest = extent.startTest("CreateNewPageTest");
		// Assert.assertTrue(false);
		// ExcelUtils.setExcelFile(ConstantInterface.Path_TestData +
		// ConstantInterface.File_TestData,"Login");
		// co.objLogin=new LoginPage(driver);
		// co.objLogin.LoginToCRM();
		ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData, "SearchUser");
		// co.objUserManager.ImpersonateUser();
		ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData, "CreateNewPage");
		// Assigning Excel file Data
		co.objDigitalWorkspacePage.CreateNewPageinWebsite();
	}

	@Test(groups = { "Regression" }, priority = 7, enabled = false)
	public void CreateNewFormTest() throws Exception {
		// extentTest = extent.startTest("CreateNewFormTest");
		// Assert.assertTrue(false);
		ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData, "SearchUser");
		// co.objUserManager.ImpersonateUser();
		// ExcelUtils.setExcelFile(ConstantInterface.Path_TestData +
		// ConstantInterface.File_TestData,"CreateNewPage");
		// Assigning Excel file Data
		ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData, "CreateNewForm");
		co.objDigitalWorkspacePage.CreateNewForm();
	}

	@Test(groups = { "Regression" }, priority = 8, enabled = false)
	public void ValidateHomePgaeOptions() throws Exception {
		// extentTest = extent.startTest("ValidateHomepage");
		co.objHomePage.validateAdminHQ();
		co.objHomePage.validateUserManager();
		co.objHomePage.validateQueues();
		co.objHomePage.validateOrganizationalGroups();
		;
	}

	@Test(groups = { "Regression" }, priority = 9, enabled = false)
	public void ValidateAdminHQOptions() throws Exception {
		// extentTest = extent.startTest("ValidateAdminHQOptions");
		co.objHomePage.validateHubManager();
		co.objHomePage.validateGlobalSettings();
		co.objHomePage.validateEmailTemplates();
		co.objHomePage.validateMaintenance();
	}

	@Test(groups = { "Regression" }, priority = 10, enabled = false)
	public void ValidateDigitalWorkSpaceOptions() throws Exception {
		// extentTest = extent.startTest("ValidateDigitalWorkSpaceOptions");
		ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData, "SearchUser");
		co.objUserManager.SearchUser1();
		ExcelUtils.setExcelFile(ConstantInterface.Path_TestData + ConstantInterface.File_TestData, "SearchUser");
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
