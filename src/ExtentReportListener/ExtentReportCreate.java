package ExtentReportListener;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.openqa.selenium.WebDriver;
import org.testng.IReporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentReportCreate implements IReporter {
	//public ExtentReports extent;

	public void generateReport() {
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("Extent.html");
		extent.attachReporter(spark);
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("AutomationReport");
		spark.config().setReportName("Extent Report");
		
		/*
		 * ExtentTest test =extent.createTest("Login Test");
		 * test.pass("Login Test Started successfully");
		 * test.info("Login successfully"); test.pass("ID PWD entered");
		 * 
		 * 
		 * ExtentTest test1 =extent.createTest("Home Test");
		 * test1.pass("Homepage Test Started successfully");
		 * test1.info("Login successfully"); test1.pass("HomepageID PWD entered");
		 */
	
	}
}
