package ExtentReportListener;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import com.aventstack.extentreports.ExtentReports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import org.testng.IReporter;

public class ExtentReportCreate implements IReporter {
	public ExtentReportCreate() {};
	protected static ExtentReports extent;

	public static void generateReport() throws IOException {
		if(Objects.isNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/PassedExtentReport.html");
			extent.attachReporter(spark);
			final File CONF = new File("extentconfig.xml");
			spark.loadXMLConfig(CONF);
			//spark.config().setTheme(Theme.STANDARD);
		//	spark.config().setDocumentTitle("TMB Report");
			//spark.config().setReportName("Youtube Training");
		}
}
	public static void flushReports() throws IOException{
		if(Objects.nonNull(extent)) {
			extent.flush();
			Desktop.getDesktop().browse(new File(System.getProperty("user.dir")+"/test-output/PassedExtentReport.html").toURI());
		}
			}
	public static void createTest(String testcasename) {
		extent.createTest(testcasename);
	}
	
}