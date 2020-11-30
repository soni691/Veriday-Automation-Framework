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

}
