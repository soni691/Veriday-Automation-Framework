package pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
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
                                  //*[@id="editField"]/div/div/div[2]/div[2]/label/input
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
		Thread.sleep(2000);
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
	}
	public void CreateNewPageinWebsite() throws Exception {
//		String pname=ExcelUtils.getCellData(1, 0);
//		String ptitle=ExcelUtils.getCellData(1, 1);
//		String purl=ExcelUtils.getCellData(1, 2);
//		String pagetype =ExcelUtils.getCellData(1, 3);
//		String linkedpagetype =ExcelUtils.getCellData(1, 4);
		click(Setting);
		click(AddPage);
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
			 click(Column1Template);
			 click(CreatePage);
			 DWlog.info("New WebSite Page Created Successfully");
		} else if(pagetype.equals("Internal Link")) {
			 pname=ExcelUtils.getCellData(9, 0);
			 setPageName(pname);
			 linkedpagetype=ExcelUtils.getCellData(9, 1);
			 selectFromText(LinkedPage, linkedpagetype);
			 click(CreatePage);
			 DWlog.info("New Linked Page Created Successfully");
		}		
	}
	public void CreateNewForm() throws Exception{
		click(Form);
		click(NewForm);	
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
		click(FormSenDEmail);
		setFormSubmissionButonText(fsubmission);
		click(pageRedirectURL);
		setFormURL(furl);
		click(Step1NextButton);
		click(EmailField);
		click(FieldlabelName);
		setEmailLabelname(elabelname);
		click(MandatoryLabel);
		setEmailRequire(erequire);
		click(AddnNewField);
		click(CheckboxField);
		setCheckboxLabelname(checkboxlabelname);
		click(CheckboxDescription1);		
		setCheckboxOption1(checkboxoption1);
		click(CheckboxDescription2);
		setCheckboxOption2(checkboxoption2);
		click(MandatoryLabel);
		setCheckboxRequire(crequire);
		click(AddCheckboxOption);
	}

}
