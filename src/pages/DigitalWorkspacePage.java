package pages;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;
import org.testng.annotations.*;

import BasePage.BasePage;

public class DigitalWorkspacePage extends BasePage{
	public static String DW = "DigitalWorkspacePage";
	Logger DWlog = getLogger(DW);
	@BeforeClass
	public void setUp() {
		driver = getDriver();
	}
	
	public DigitalWorkspacePage(WebDriver driver) {
		this.driver=driver;
	}
     SoftAssert softAssert = new SoftAssert();
	//Identify Events option
	By EventOption=By.xpath("//a[@href='/digital-workspace/events']");
	//Identify Add Event button
	By AddEvent=By.xpath("//*[text()='Add Event']");	
	//Identify Event Name textboxes
	By EventName=By.xpath("//input[@id='da-event-name']");
	//Identify EventDescription iframe
	By DescriptionFrame=By.xpath("//iframe[@title='Rich Text Editor, da-event-description']");
	//Identify RSVP link textbox
	By RSVPLINK = By.xpath("//input[@id='da-event-url']");
	//Identify EventEnddate textbox
    By EventEndDate = By.xpath("//input[@id='da-event-enddatepicker']");
	//Identify Event Submit button
	By EventSubmit = By.xpath("//button[contains(text(),'Submit for Approval')]");
	//Enter Event description body 
	By EventDescription = By.xpath("//body//p");
	//Identify Settings option
	By Setting=By.xpath("//a[@href='/digital-workspace/site']");
	//Identify Add Page button
	By AddPage =By.xpath("//*[text()='Add Page']");
	//Identify Page Name textbox
	By PageName =By.xpath("//input[@id='page-name']");
	//Identify Page Title textbox
    By PageTitle =By.xpath("//input[@id='page-title']");
    //Identify Page title label
    By PageURL =By.xpath("//input[@id='page-url']");
    //Identify Type of Page dropdown
    By TypeofPage =By.id("typeDropdown");
    //Identify Type of page Template1
    By Column1Template =By.xpath("//img[@alt='1 Column screenshot']");
    //Identify Save this page button
    By CreatePage =By.xpath("//button[contains(text(),'Save this page')]");
    //Identify Linked page dropdown
    By LinkedPage =By.xpath("//select[@id='pageDropdown']");
    //Identify Forms option
    By Form =By.xpath("//a[@href='/digital-workspace/forms']");
    //Identify Create New Forms button
    By NewForm =By.xpath("//a[normalize-space()='New Form']");
    //Identify Form title textbox
    By FormTitle =By.xpath("//input[@id='da-form-name']");
    //Identify Form decription textbox
    By FormDescription =By.xpath("//textarea[@id='da-form-description']");
    //Identify Send Form response email
    By FormSenDEmail =By.xpath("//input[@id='23rdOctober@veriday.com']");
    //Identify Form Submission button textbox
    By FormSubmission =By.xpath("//input[@id='da-submit-button-label']");
    //Identify page redirect website url opttion
    By pageRedirectURL =By.xpath("//input[@id='da-redirect-page-url-option']");
  //Identify page redirect website url opttion
    By pageRedirectURLTextbox =By.xpath("//input[@id='da-redirect-page-url']");
    //Identify Step1 Next button
    By Step1NextButton =By.xpath("//button[contains(text(),'Next Step')]");
    //Identify Email field of Step2
    By EmailField =By.xpath("//span[@id='emailLabelChange']");
    //Identify Checkbox field of Step2
    By CheckboxField =By.xpath("//span[@id='checkboxLabelChange']");
  //Identify Add New field option
    By AddnNewField =By.xpath("//a[contains(text(),'Add new field')]");
    //Identify selected field's label textbox
    By FieldlabelName =By.xpath("//*[@id=\"editField\"]/div/div/div[2]/div[1]/input");
    //Identify selected field is mandatory 
    By MandatoryLabel =By.xpath("//*[@id=\"editField\"]/div/div/div[2]/div[2]/label/input");
    //Identify Checkbox1 description textbox
    By CheckboxDescription1 =By.xpath("//*[@id=\"editField\"]/div/div/div[4]/input[2]");
    //Identify Checkbox2 description textbox
    By CheckboxDescription2 =By.xpath("//*[@id=\"editField\"]/div/div/div[5]/input[2]");
    //Select Checkbox1 
    By Checkbox1Selected =By.xpath("//*[@id=\"editField\"]/div/div/div[4]/input[1]");
    //Select Checkbox2
    By Checkbox2Selected =By.xpath("//*[@id=\"editField\"]/div/div/div[5]/input[1]");
    //Identify AddOption button to add checkbpxes
    By AddCheckboxOption =By.xpath("//a[contains(text(),'Add option')]");
    //Identify hide disclosure option in stage3
    By HideDisclosure =By.xpath("//input[@id='hideDisclosures']");
    //Identify show disclosure option in stage3
    By ShowDisclosure =By.xpath("//input[@id='displayDisclosures']");
    //Identify do not send email confirmation checkbox on stage4
    By DontSendEmail =By.xpath("//input[@id='da-confirm-email-not-sent']");
    //Identify New pAge popup text New Form
    By NewFormPopupVerify =By.xpath("//h2[contains(text(),'New Form')]");
    //Identify Back to Digital Workspace option
    By BacktoDW =By.xpath("//a[@href='/guest/digital-workspace']");
    //Identify already created url popup on Create New Webpage
    By AlreadyCreatedpageURL =By.xpath("//p[contains(text(),'You entered a URL that is already used, please ent')]");
    //Click on ok button for already created url popup
    By AlreadyCreatedUserOk = By.xpath("//button[contains(text(),'Ok')]");
    //Identify Get Started button on CReate New PAge
    By GetStarted = By.xpath("//*[contains(text(),'Get started!')]");
    //Identify Copy Selected Website option on Website Generator Page
    By CopySelectedWebsite = By.xpath("//*[contains(text(),'Copy Selected Website')]");
    //Identify Skip this step button on Website Generator Page
    By SkipStep = By.xpath("//*[contains(text(),'Skip this step')]");
    //Identify 'Are you sure you want to skip website cloning option on create new page
    By skipwebsitecloning = By.xpath("//h3[contains(text(),'Are you sure you want to skip website cloning?')]");
    //Identify Confirm button for Are you sure you want to skip website cloning option on create new page
    By Confirmskipwebsitecloning = By.xpath("//button[contains(text(),'Confirm')]");
    //Identify Type of page Template1 in DEMo QA environment
    By Column1TemplateDemo =By.xpath("//*[@id=\"page-edit\"]/div[3]/div/div[8]/div[1]/ul/li[1]/label/div/div/input");
    //Identify Type of page Template2 in DEMo QA environment
    By Column2TemplateDemo =By.xpath("//*[@id=\"page-edit\"]/div[3]/div/div[8]/div[1]/ul/li[2]/label/div/div/input");
    //Identify Email on Create New page of Demo QA env.
    By DemoPageEmailSelect =By.xpath("//input[@id='alisha.new@veriday.com']");
    //Identify My Website option on Digital Workspace page
    By MyWebsite =By.xpath("//h3[contains(text(),'My Website')]");
    //Identify Blog option on Digital Workspace page
    By Blog =By.xpath("//h3[contains(text(),'Blog')]");
    //Identify polls option on Digital Workspace page
    By Polls =By.xpath("//h3[contains(text(),'Polls')]");
    //Identify RecycleBin option on Digital Workspace page
    By RecycleBin =By.xpath("//h3[contains(text(),'Recycle Bin')]");
    //Identify MyProfile option on Digital Workspace page
    By MyProfile =By.xpath("//h3[contains(text(),'My Profile')]");
    //Identify Updates option on Digital Workspace page
    By Updates =By.xpath("//h3[contains(text(),'Updates')]");
    //Identify Campaign Manager option on Digital Workspace page
    By CampaignManager =By.xpath("//h3[contains(text(),'Campaign Manager')]");
    //Identify Content Collection option on Digital Workspace page
    By ContentCollection =By.xpath("//h3[contains(text(),'Content Collections')]");
    //Identify File Manager option on Digital Workspace page
    By FileManager =By.xpath("//h3[contains(text(),'File Manager')]");
    //Identify Dashboard 2.0 option on Digital Workspace page
    By Dashboard2 =By.xpath("//h3[contains(text(),'Dashboard 2.0 (Beta)')]");
  //Identify Dashboard option on Digital Workspace page
    By Dashboard =By.xpath("//h3[(text()='Dashboard')]");
    //Identify content add button the website
    By ContentAdd =By.xpath("//a[@id='da-app-add-dropdown']");
    
    
	void setEventName(String ename) {
		enterText(EventName, ename);
	}
	void setEventDescription(String edescription) {
		enterText(EventDescription,edescription);
	}
	void setRSVPLink(String rsvp) {
		enterText(RSVPLINK,rsvp);
	}
	void setEndDate(String enddate) {
		enterText(EventEndDate,enddate);
	}
	void setPageName(String pname) {
		enterText(PageName,pname);		
	}
	void setPageTitle(String ptitle) {
		enterText(PageTitle,ptitle);		
	}
	void setPageURL(String purl) {
		enterText(PageURL,purl);		
	}
	void setTypeofPage(String pagetype) {
		enterText(TypeofPage,pagetype);
	}
	void setFormTitle(String ftitle) {
		enterText(FormTitle,ftitle);
	}
	void setFormDescription(String fdescription) {
		enterText(FormDescription,fdescription);
	}
	void setFormSubmissionButonText(String fsubmission) {
		enterText(FormSubmission,fsubmission);
	}
	void setFormURL(String furl) {
		enterText(pageRedirectURLTextbox,furl);
	}
	void setEmailLabelname(String elabelname) {
		enterText(FieldlabelName,elabelname);
	}
	void setEmailRequire(String erequire) {
		enterTextwithoutclear(MandatoryLabel,erequire);
	}
	void setCheckboxLabelname(String checkboxlabelname) {
		enterText(FieldlabelName,checkboxlabelname);
	}
	void setCheckboxOption1(String checkboxoption1) {
		enterText(CheckboxDescription1,checkboxoption1);
	}
	void setCheckboxOption2(String checkboxoption2) {
		enterText(CheckboxDescription2,checkboxoption2);
	}
	void setCheckboxRequire(String crequire) {
		enterText(MandatoryLabel,crequire);
	}
	
	public void CreateNewEvent() throws Exception {
		String ename=ExcelUtils.getCellData(1, 0);
		String edescription=ExcelUtils.getCellData(1, 1);
		String rsvp=ExcelUtils.getCellData(1, 2);
		click(EventOption);
		click(AddEvent);
		setEventName(ename);
		waitAndFindElement(DescriptionFrame, Condition.isPresent, 5, 1000);
		//Thread.sleep(2000);
		//Switch to iframe
		WebElement iframeElement = driver.findElement(By.xpath("//iframe[@title='Rich Text Editor, da-event-description']"));		
		driver.switchTo().frame(iframeElement);
		click(EventDescription);
		setEventDescription(edescription);
		driver.switchTo().defaultContent();
		setRSVPLink(rsvp);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm zzz");
		//Getting current date
		Calendar cal = Calendar.getInstance();
		//Number of Days to add
	    cal.add(Calendar.DAY_OF_MONTH, 2);
		//Date after adding the days to the current date
		String newDate = sdf.format(cal.getTime());
		setEndDate(newDate);
		//EventEndDate.sendKeys(newDate);
		click(EventSubmit);
		DWlog.info("New Event Created Successfully");
		click(BacktoDW);
	}
	public void CreateNewPageinWebsite() throws Exception {
//		String pname=ExcelUtils.getCellData(1, 0);
//		String ptitle=ExcelUtils.getCellData(1, 1);
//		String purl=ExcelUtils.getCellData(1, 2);
//		String pagetype =ExcelUtils.getCellData(1, 3);
//		String linkedpagetype =ExcelUtils.getCellData(1, 4);
		click(Setting);
		click(AddPage);
		 boolean UserPresent = isElementPresent(GetStarted);
			if(UserPresent==true) {
				click(GetStarted);
				click(SkipStep);
				click(Confirmskipwebsitecloning);
			}
		String getActualpageTitle = driver.getTitle();
		softAssert.assertEquals(getActualpageTitle, "Settings - Digital Agent");
		click(TypeofPage);		
		String pagetype=ExcelUtils.getCellData(1, 4);
		selectFromText(TypeofPage, pagetype);
		String pname="";
		String ptitle="";
		String purl="";
		String linkedpagetype="";
		if(pagetype.equals("Page in My Website")) {
			 pname=ExcelUtils.getCellData(1, 0);
	         ptitle=ExcelUtils.getCellData(1, 1);
	         purl=ExcelUtils.getCellData(1, 2);
	         setPageName(pname);
			 setPageTitle(ptitle);
			 setPageURL(purl);
			 click(Column1TemplateDemo);
			 click(CreatePage);
			 boolean UserPresent1 = isElementPresent(AlreadyCreatedpageURL);
				if(UserPresent1==true) {
					DWlog.info("New Web Site can not be created because URL is already exist");
					click(AlreadyCreatedUserOk);
					click(BacktoDW);
				}
				else {
					DWlog.info("New WebSite Page Created Successfully");
					click(BacktoDW);
				}
			 
		} else if(pagetype.equals("Internal Link")) {
			 pname=ExcelUtils.getCellData(9, 0);
			 setPageName(pname);
			 linkedpagetype=ExcelUtils.getCellData(9, 1);
			 selectFromText(LinkedPage, linkedpagetype);
			 click(CreatePage);
			 DWlog.info("New Linked Page Created Successfully");
			 click(BacktoDW);
		}		
	}
	public void CreateNewForm() throws Exception{
		click(Form);
		click(NewForm);	
		Assert.assertTrue(NewFormPopupVerify.equals(NewFormPopupVerify), "New Form Popup Window is not open");
		//Thread.sleep(2000);
		String ftitle=ExcelUtils.getCellData(1, 0);
		String fdescription=ExcelUtils.getCellData(1, 1);
		String fsubmission=ExcelUtils.getCellData(1, 2);
		String furl=ExcelUtils.getCellData(1, 3);
		String elabelname=ExcelUtils.getCellData(1, 4);
		String erequire=ExcelUtils.getCellData(1, 5);
		String checkboxlabelname=ExcelUtils.getCellData(1, 6);
		String checkboxoption1=ExcelUtils.getCellData(1, 7);
		String checkboxoption2=ExcelUtils.getCellData(1, 8);
		String crequire=ExcelUtils.getCellData(1, 9);
		setFormTitle(ftitle);
		waitAndFindElement(FormDescription, Condition.isClickable, 5, 1000);
		setFormDescription(fdescription);
		//click(FormSenDEmail);
		click(DemoPageEmailSelect);
		setFormSubmissionButonText(fsubmission);
		click(pageRedirectURL);
		setFormURL(furl);
		click(Step1NextButton);
		click(EmailField);
		click(FieldlabelName);
		setEmailLabelname(elabelname);
		//click(MandatoryLabel);
		//setEmailRequire(erequire);
		click(AddnNewField);
		click(CheckboxField);
		setCheckboxLabelname(checkboxlabelname);
		click(CheckboxDescription1);		
		setCheckboxOption1(checkboxoption1);
		click(CheckboxDescription2);
		setCheckboxOption2(checkboxoption2);
		//click(MandatoryLabel);
		//setCheckboxRequire(crequire);
		click(Checkbox1Selected);
		click(Checkbox2Selected);
		//click(AddCheckboxOption);
		click(Step1NextButton);
		click(HideDisclosure);
		click(Step1NextButton);
		click(EventSubmit);
		DWlog.info("New Form with send a confirmation email Created Successfully");
		click(BacktoDW);
	}
	public void validateDWSettings() throws InterruptedException {
		click(Setting);
		Thread.sleep(2000);
		assertTrue(driver.getTitle().contains("Settings - Digital Agent"));
		DWlog.info("Settings option of Digital Workspace page is visible & working fine");
		click(BacktoDW);
	}
	public void validateDWMyWebsite() throws InterruptedException {
		click(MyWebsite);
		waitAndFindElement(ContentAdd, Condition.isDisplayed, 5000, 1);
		boolean present = isElementPresent(ContentAdd);
		if(present==true) {
			DWlog.info("My website option is visible & working fine");
		}
		click(BacktoDW);
	}
	public void validateDWBlog() throws InterruptedException {
		click(Blog);
		Thread.sleep(2000);
		assertTrue(driver.getTitle().contains("Blog - Digital Agent"));
		DWlog.info("Blog option of Digital Workspace page is visible & working fine");
		click(BacktoDW);
	}
	public void validateDWForm() throws InterruptedException {
		click(Form);
		Thread.sleep(2000);
		assertTrue(driver.getTitle().contains("Forms - Digital Agent"));
		DWlog.info("Form option of Digital Workspace page is visible & working fine");
		click(BacktoDW);
	}
	public void validateDWEvents() throws InterruptedException {
		click(EventOption);
		Thread.sleep(2000);
		assertTrue(driver.getTitle().contains("Events - Digital Agent"));
		DWlog.info("Event option of Digital Workspace page is visible & working fine");
		click(BacktoDW);
	}
	public void validateDWPolls() throws InterruptedException {
		click(Polls);
		Thread.sleep(2000);
		assertTrue(driver.getTitle().contains("Polls - Digital Agent"));
		DWlog.info("Polls option of Digital Workspace page is visible & working fine");
		click(BacktoDW);
	}
	public void validateDWRecycleBin() throws InterruptedException {
		click(RecycleBin);
		Thread.sleep(2000);
		assertTrue(driver.getTitle().contains("Recycle Bin - Digital Agent"));
		DWlog.info("Recycle Bin option of Digital Workspace page is visible & working fine");
		click(BacktoDW);
	}
	public void validateDWMyProfile() throws InterruptedException {
		click(MyProfile);
		Thread.sleep(2000);
		assertTrue(driver.getTitle().contains("My Profile - Digital Agent"));
		DWlog.info("My Profile option of Digital Workspace page is visible & working fine");
		click(BacktoDW);
	}
	public void validateDWUpdates() throws InterruptedException {
		click(Updates);
		Thread.sleep(2000);
		assertTrue(driver.getTitle().contains("Updates - Digital Agent"));
		DWlog.info("Updates option of Digital Workspace page is visible & working fine");
		click(BacktoDW);
	}
	public void validateDWCampaignManager() throws InterruptedException {
		click(CampaignManager);
		Thread.sleep(2000);
		assertTrue(driver.getTitle().contains("Campaign Manager - Digital Agent"));
		DWlog.info("Campaign Manager option of Digital Workspace page is visible & working fine");
		click(BacktoDW);
	}
	public void validateDWContentCollection() throws InterruptedException {
		click(ContentCollection);
		Thread.sleep(2000);
		assertTrue(driver.getTitle().contains("Content Collections - Digital Agent"));
		DWlog.info("Content Collection option of Digital Workspace page is visible & working fine");
		click(BacktoDW);
	}
	public void validateDWDashboard() throws InterruptedException {
		click(Dashboard);
		Thread.sleep(2000);
		assertTrue(driver.getTitle().contains("Dashboard - Digital Agent"));
		DWlog.info("Content Collection option of Digital Workspace page is visible & working fine");
		click(BacktoDW);
	}
	public void validateDWFileManager() throws InterruptedException {
		click(FileManager);
		Thread.sleep(2000);
		assertTrue(driver.getTitle().contains("File Manager - Digital Agent"));
		DWlog.info("Content Collection option of Digital Workspace page is visible & working fine");
		click(BacktoDW);
	}
	public void validateDWDashboard2() throws InterruptedException {
		click(Dashboard2);
		Thread.sleep(2000);
		assertTrue(driver.getTitle().contains("Dashboard V2 - Digital Agent"));
		DWlog.info("Content Collection option of Digital Workspace page is visible & working fine");
	}
}
