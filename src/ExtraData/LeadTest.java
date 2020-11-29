package ExtraData;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeadTest {

	static WebDriver driver;
	
	
	  public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		  System.setProperty("webdriver.chrome.driver","D:\\Eclipse Workspace\\CRMtesting\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://192.168.4.253:1732/Accounts/Login");
		
		driver.findElement(By.xpath("//input[@ng-model='UserName']")).sendKeys("yaxisowner");
		driver.findElement(By.xpath("//input[@ng-model='password']")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@class='btn btn-outline-light btn-primary']")).click();
		
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//i[@class='fas fa-ticket-alt']")).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(text(),'Lead')]")).click();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@data-original-title='Add Lead']")).click();
	
		Thread.sleep(3000);
		WebElement wb= driver.findElement(By.xpath("//h5[@id='addNewTicketLabel']"));
		StringBuffer ticket=new StringBuffer(wb.getText());
		ticket.delete(0, 11);
		System.out.println("Ticket number is "+ticket);
		
		driver.findElement(By.name("leadfirstname")).sendKeys("Extra First");
		driver.findElement(By.name("leadlastname")).sendKeys("Extra Last");
		driver.findElement(By.id("dateofbirth")).sendKeys("01-01-1994");
		driver.findElement(By.xpath("//label[@for='opt_male']")).click();
		driver.findElement(By.xpath("//label[@for='opt_married']")).click();
		driver.findElement(By.name("leademailaddress")).sendKeys("extraperson@gmail.com");
		driver.findElement(By.name("leadcontactno")).sendKeys("9898989898");
		driver.findElement(By.xpath("//button[@ng-disabled='btn_leadsubmit']")).click();
		
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	
		WebDriverWait wait=new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("selectservice_0")));
		
		Select service=new Select(driver.findElement(By.id("selectservice_0")));
		service.selectByVisibleText("Canada Student Visa");
				
		Select assignto=new Select(driver.findElement(By.id("reportingto")));
		assignto.selectByVisibleText("Jigar Patel");

		Select status=new Select(driver.findElement(By.id("status")));
		status.selectByVisibleText("Assigned");

		Select priority=new Select(driver.findElement(By.id("priority")));
		priority.selectByVisibleText("Medium");		
		
		//driver.findElement(By.id("ticketduedate_0")).sendKeys("25-10-2018");
		
		Select LeadType=new Select(driver.findElement(By.id("leadtype")));
		LeadType.selectByVisibleText("Inquiry");
		
		Select LeadSource=new Select(driver.findElement(By.id("leadsource")));
		LeadSource.selectByVisibleText("Web");
		
		driver.findElement(By.id("leadscore")).sendKeys("8");
		driver.findElement(By.xpath("//textarea[@id='leadnotes']")).sendKeys("Created on 22 October");
		//driver.findElement(By.xpath("//button[@ng-disabled='btn_leadsubmit']")).click();
		
		
		
	} 

}
