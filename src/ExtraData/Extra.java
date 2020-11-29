package ExtraData;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Extra {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
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
		/*
		driver.findElement(By.xpath("//button[@data-original-title='Add Lead']")).click();
		Thread.sleep(3000);
		WebElement wb= driver.findElement(By.xpath("//h5[@id='addNewTicketLabel']"));
		StringBuffer ticket=new StringBuffer(wb.getText());
		ticket.delete(0, 11);
		System.out.println("Ticket number is "+ticket);
		*/
		String ticket1="TKT1810220077";
		
		List<WebElement> columns=driver.findElements(By.xpath("//div[@class='table-responsive ng-scope']/table[@class='table table-striped']/child::tbody/child::tr/child::td"));
		for(WebElement actual:columns) {
			String s=actual.getText();
			System.out.println(s);
			if(s.equals(ticket1)) {
				actual.click();
				//driver.findElement(By.xpath("")).click();
				break;
			}
		}
//		driver.close();
		
		
		
		
		
		
	}

}
