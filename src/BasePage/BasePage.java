/**
* BasePage.java		v1.0 03/04/2018
 * 
 * This project is the assignment of 2nd week of automation on boarding training
 * This project is used to search the flight and verify search result of searched flight 
 * 
 */

package BasePage;

import static org.testng.Assert.assertEquals;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;

import BasePage.BasePage;
import ExtentReportListener.ExtentReportCreate;
import createObject.CreateObject;
import pages.ConstantInterface;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


/**
 * @version 1.0
 * @created : 03/12/2020
 * @author Sumit Soni
 *
 *         BasePage class contains all the required utilities which can be used
 *         in entire project
 */
public class BasePage extends ExtentReportCreate {

	public String browser = null;
	public String url = null;

	public static WebDriver driver;
	Wait<WebDriver> wait;
	public int MAX_TIMEOUT = 150;
	public int POLLING_MAX_TIME_IN_MILLISEC = 400;
	public static String projectDirectory = System.getProperty("user.dir");
	public static Properties locator;
	public static String testDataFile;
	public static String objectFile;
	public static String loggerPropertiesFile;
	//public static String testLogger = "TestVeriday";
	public static String pageObjectLogs = "BasePage";
	public Properties pageObject = null;	
	ExtentReportCreate objExtentReportCreate = new ExtentReportCreate();
	//public ExtentTest extentTest;
	//public ExtentReports extent;
	public CreateObject co;

	public static Logger pageObjectLogs1 = Logger.getLogger(pageObjectLogs);
	//public Screenshot objScreenshot;

	protected enum Condition {
		isDisplayed, isClickable, isPresent
	}
//
//	/**
//	 * 		This method is used to clean maven report folder before execution
//	 */
//	@BeforeSuite
//	public void cleanReportFolder()
//	{
//		Arrays.stream(new File(projectDirectory+"\\target\\surefire-reports\\html\\").listFiles()).forEach(File::delete);
//	}

	
	/**
	 * 
	 * @param browserType
	 *            specify the browser on which test will be executed
	 * @param appURL
	 *            URL on which user wants to navigate
	 * @param jsonFile
	 *            TestData file
	 * @param propertiesFile
	 *            element locators file
	 * @param loggerProperties
	 *            logger's property files
	 * 
	 * 
	 * 
	 *         This method is used to initialize required parameters which are used
	 *         to initialize the test
	 */
	@Parameters({ "browserType", "appURL", "loggerProperties" })
	@BeforeClass(alwaysRun = true)
	public void initializeTestBaseSetup(String browserType, String appURL, String loggerProperties) {
		//driver = getDriver();
		browser = browserType;
		url = appURL;
		loggerPropertiesFile = loggerProperties;
		PropertyConfigurator.configure(projectDirectory + "\\loggerProperties\\" + loggerPropertiesFile.trim());
     	setDriver(browser, url);
	    co = new CreateObject(driver);
	    pageObjectLogs1.info("This is Before Class method");
	}
//	@BeforeClass(alwaysRun = true)
//	public void setUp() {
//		driver = getDriver();
//		co = new CreateObject(driver);
//		System.out.println("Launching google chrome with new profile..");
//		System.setProperty("webdriver.chrome.driver",projectDirectory + "\\drivers\\chromedriver.exe");
//		ChromeOptions chromeoptions = new ChromeOptions();
//		chromeoptions.setAcceptInsecureCerts(true);
//		chromeoptions.addArguments("enable-automation");
//		chromeoptions.addArguments("--window-size=1920,1080");
//		chromeoptions.addArguments("--no-sandbox");
//		chromeoptions.addArguments("--disable-extensions");
//		chromeoptions.addArguments("--dns-prefetch-disable");
//		chromeoptions.addArguments("--disable-gpu");
//		chromeoptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//		driver = new ChromeDriver(chromeoptions); 
//		
//		//Disable *****Chrome is being controlled by automated test software*****
//		
//		//ChromeOptions options = new ChromeOptions(); 
//		//chromeoptions.addArguments("disable-infobars"); 
//		
//		//Open Chrome Browser
//		//driver=new ChromeDriver();
//		driver.manage().window().maximize();
//		logger.info("Browser Opened");
//		driver.get(ConstantInterface.strURL);
//		
//	}
	/**
	 * 
	 * @param browserType
	 *            browser name (ie: fireFox, Chrome etc..)
	 * @param appURL
	 *            URL in which user wants to navigate
	 * 
	 *            This method is used to instantiate desired driver for desired
	 *            browser
	 */
	public void setDriver(String browserType, String appURL) {
		System.err.println(browserType);
		switch (browserType.toLowerCase()) {
		case "chrome":
			driver = initChromeDriver(appURL);
			break;
		case "firefox":
			driver = initFirefoxDriver(appURL);
			break;
		case "ie":
			driver = initIEDriver(appURL);
			break;

		default:
			driver = initChromeDriver(appURL);
			break;
		}
	}

	/**
	 * 
	 * @return active driver instance of desired browser
	 * 
	 *         This method is used to get active driver instance of the browser on
	 *         which user will execute the tests
	 */
	public WebDriver getDriver() {
		return BasePage.driver;
	}

	/**
	 * 
	 * @param appURL
	 * @return active instance of chrome driver
	 * 
	 *         This method is used to initialize driver form chrome driver and set
	 *         required properties to perform the same and navigate to the required
	 *         URL
	 */
	private static WebDriver initChromeDriver(String appURL) {
		System.out.println("Launching google chrome from BasePage....");
		pageObjectLogs1.info("Launching google chrome from BasePage....");
		System.setProperty("webdriver.chrome.driver", projectDirectory + "\\drivers\\chromedriver.exe");
		ChromeOptions chromeoptions = new ChromeOptions();
		chromeoptions.setAcceptInsecureCerts(true);
		WebDriver driver = new ChromeDriver(chromeoptions);		
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}

	/**
	 * 
	 * @param appURL
	 *            URL on which user wants to redirect
	 * @return active instance of firefox driver
	 * 
	 *         This method is used to initialize driver form firefox driver and set
	 *         required properties to perform the same and navigate to the required
	 *         URL
	 */
	private static WebDriver initFirefoxDriver(String appURL) {
		System.out.println("Launching Firefox browser..");
//		System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		System.setProperty("webdriver.gecko.driver", projectDirectory + "\\drivers\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}
	

	private static WebDriver initIEDriver(String appURL) {
		System.out.println("Launching IE browser..");
		
		/*
		 * DesiredCapabilities cap =new DesiredCapabilities();
		 * cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		 * System.setProperty("webdriver.ie.driver", projectDirectory +
		 * "\\drivers\\IEDriverServer.exe"); WebDriver driver=new
		 * InternetExplorerDriver(cap);
		 */
		//InternetExplorerOptions options = new InternetExplorerOptions();
		//options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		//options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		WebDriver driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);		
		driver.navigate().to("javascript:document.getElementById('overridelink').click()");
		//driver.get("javascript:document.getElementById('overridelink').click();");
		return driver;
	}

	/**
	 * 
	 * @param by
	 *            element locator of desired element
	 * @param timeOut
	 *            max waiting time (in seconds)
	 * @param pollingTime
	 *            max polling time for re-attempt to search for an element
	 * @return desired webelement
	 * 
	 *         This method is used located and get element which is displayed on the
	 *         screen
	 */
	public WebElement findVisibleElement(By by, int timeOut, int pollingTime) {
		return waitAndFindElement(by, Condition.isDisplayed, timeOut, pollingTime);
	}

	/**
	 * 
	 * @param by
	 *            element locator of desired element
	 * @return desired webelement
	 * 
	 *         This method is used located and get element which is displayed on the
	 *         screen
	 */
	public WebElement findVisibleElement(By by) {
		return waitAndFindElement(by, Condition.isDisplayed, MAX_TIMEOUT, POLLING_MAX_TIME_IN_MILLISEC);
	}

	/**
	 * 
	 * @param by
	 *            element locator of desired element
	 * @param timeOut
	 *            max waiting time (in seconds)
	 * @param pollingTime
	 *            max time for re-attempt to search for an element (in milliseconds)
	 * @return desired webelement
	 * 
	 *         This method is used located and get element which is present in DOM
	 */
	public WebElement findPresentElement(By by, int timeOut, int pollingTime) {
		return waitAndFindElement(by, Condition.isPresent, timeOut, pollingTime);
	}

	/**
	 * 
	 * @param by
	 *            element locator of desired element
	 * @return desired webelement
	 * 
	 *         This method is used located and get element which is is present in
	 *         DOM screen
	 */
	public WebElement findPresentElement(By by) {
		return waitAndFindElement(by, Condition.isPresent, MAX_TIMEOUT, POLLING_MAX_TIME_IN_MILLISEC);
	}
	
	public boolean isElementPresent(By by) {
		  try {
		    driver.findElement(by);
		    return true;
		  }
		catch (org.openqa.selenium.NoSuchElementException e) {
		    return false;
		  }
		}

	/**
	 * 
	 * @param by
	 *            element locator of desired element
	 * @param timeOut
	 *            max waiting time (in seconds)
	 * @param pollingTime
	 *            max time for re-attempt to search for an element (in milliseconds)
	 * @return desired webelement
	 * 
	 *         This method is used located and get element which is clickable and
	 *         displayed on the screen
	 */
	public WebElement findClickableElement(By by, int timeOut, int pollingTime) {
		return waitAndFindElement(by, Condition.isClickable, timeOut, pollingTime);
	}

	/**
	 * 
	 * @param by
	 *            element locator of desired element
	 * @return desired webelement
	 * 
	 *         This method is used located and get element which is clickable and
	 *         displayed on the screen
	 */
	public WebElement findClickableElement(By by) {
		return waitAndFindElement(by, Condition.isClickable, MAX_TIMEOUT, POLLING_MAX_TIME_IN_MILLISEC);
	}

	/**
	 * 
	 * @param by
	 *            element locator of desired element
	 * @param condition
	 *            enum of required state
	 * @param timeOut
	 *            max waiting time (in seconds)
	 * @param pollingTime
	 *            max time for re-attempt to search for an element (in milliseconds)
	 * @return desired webelement
	 * 
	 *         This method is used to find element based on the condition passed in
	 *         parameter Condition
	 */
	public WebElement waitAndFindElement(By by, Condition condition, int timeOutInSeconds, int pollingInMilliSeconds) {
		
		 do {
	        } while (!isAjaxCallCompleted());

		WebElement element = null;
		//logger.info(getDriver());
		//logger.info(" " + timeOutInSeconds + pollingInMilliSeconds);
		wait = new FluentWait(getDriver()).withTimeout((long) timeOutInSeconds, TimeUnit.SECONDS).pollingEvery((long) pollingInMilliSeconds, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class);
		switch (condition) {
		case isClickable:
			element = (WebElement) wait.until(ExpectedConditions.elementToBeClickable(by));
			break;
		case isDisplayed:
			element = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			break;
		case isPresent:
			element = (WebElement) wait.until(ExpectedConditions.presenceOfElementLocated(by));
			break;
		default:
			break;
		}

		return highlightElement(element);
	}
	
	/**
	 * 
	 * @return true if all ajax and js are loaded with in max time limit limit otherwise false
	 */
	 public boolean isAjaxCallCompleted() {
	        WebDriverWait wait = new WebDriverWait(driver,  MAX_TIMEOUT);
	        wait.ignoring(StaleElementReferenceException.class);
	        try {
	            return ((Boolean) wait.until(new ExpectedCondition<Boolean>() {
	                public Boolean apply(WebDriver inDriver) {
	                    boolean z = isJQueryLoaded() && isJSLoaded();
	                    return Boolean.valueOf(z);
	                }

	                public String toString() {
	                    return "Waiting for Ajax call to be completed";
	                }
	            })).booleanValue();
	        } catch (TimeoutException e) {
	            return false;
	        }
	    }

	 	/**
	 	 * 
	 	 * @return true if all js are loaded with in max time limit limit otherwise false
	 	 */
	 public boolean isJSLoaded() {
	        return ((JavascriptExecutor) driver).executeScript("return document.readyState", new Object[0]).toString().equals("complete");
	    }

	    /**
	     * 
	     * @return true if all jquery are loaded with in max time limit limit otherwise false
	     */
	 public boolean isJQueryLoaded() {
	        try {
	            return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active", new Object[0])).longValue() == 0;
	        } catch (Exception e) {
	            return true;
	        }
	    }


	/**
	 * 
	 * @param element
	 * @return desired element
	 * 
	 *         This method is used tom mark red box around the desired element
	 */
	public WebElement highlightElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='2px solid red'",
				new Object[] { element });
		return element;
	}

	/**
	 * 
	 * @param by
	 *            element locator of an element of which user wants to extract the
	 *            text
	 * @return fetched String
	 * 
	 *         This method is used to fetch text of an webelement
	 */
	public String getText(By by) {
		return findVisibleElement(by).getText();
	}

	/**
	 * 
	 * @param by
	 *            element locator of an element at which user wants to enter the
	 *            text
	 * @param textToBeEnter
	 * 
	 *            this method is used to enter the text in any inputbox/textarea
	 */
	public void enterText(By by, String textToBeEnter) {
		WebElement inputBox = findVisibleElement(by);
		inputBox.click();
		inputBox.clear();
		inputBox.sendKeys(textToBeEnter);
	}
	public void enterTextwithoutclear(By by, String textToBeEnter) {
		WebElement inputBox = findVisibleElement(by);
		inputBox.click();
		inputBox.sendKeys(textToBeEnter);
	}

	/**
	 * 
	 * @param by
	 *            element locator of an element at which user wants to select from
	 *            dropdown
	 * @param selectFromText
	 * 
	 *            this method is used to select from dropdown by visible text
	 */
	public void selectFromText(By by, String textToSelect) {
		Select drp=new Select(driver.findElement(by));
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
		drp.selectByVisibleText(textToSelect);
	}
	
	/**
	 * 
	 * @param by
	 *            element locator of an element at which user wants to select from
	 *            javascript Menu
	 * @param selectFromText
	 * 
	 *            this method is used to select from Javascript Menu by visible text
	 */
	public void selectFromJS(By by, String textToSelect) {
		try {
				Thread.sleep(1000);
				Actions act=new Actions(driver);
				WebElement wb=driver.findElement(by);
				act.moveToElement(wb).build().perform();
				wb.sendKeys(textToSelect);
				act.sendKeys(Keys.ENTER).build().perform();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param by
	 *            element locator of an element at which user wants to select
	 *            time
	 * @param timeFromText
	 * 
	 *            this method is used to select time
	 */
	public void selectTime(By by, String timeToSelect) {
		try {
			//Actions a=new Actions(driver);
			WebElement drp=driver.findElement(by);
			//drp.sendKeys(Keys.TAB);
			//a.moveToElement(drp).build().perform();
			drp.click();
			Thread.sleep(1000);
			drp.sendKeys(Keys.CONTROL + "a");
			drp.sendKeys(timeToSelect);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param by
	 *            element locator of an element at which user wants to select
	 *            date
	 * @param timeFromText
	 * 
	 *            this method is used to select date
	 */
	public void selectDate(By by, String dateToSelect) {
		try {
			WebElement stdate=driver.findElement(by);
			stdate.click();
			Thread.sleep(1000);
			stdate.sendKeys(Keys.CONTROL + "a");
			stdate.sendKeys(dateToSelect);
		
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void getPageTitle(By by,String expectedPageTitle) {
		String actualTitle = driver.getTitle();
		String expectedTitle = "";
		assertEquals(expectedTitle,actualTitle);
	}
	/**
	 * 
	 * @param by
	 *            element locator of an element where we need verification
	 * 
	 *            This method is used to verify page
	 */
	public void verifyWithLabel(By by,String expected) {
		WebElement wblabel=driver.findElement(by);
		String actual=wblabel.getText();
		Assert.assertEquals(actual, expected);
	}
	/**
	 * 
	 * @param by
	 *            element locator of an element on which user wants to click
	 * 
	 *            This method is used to perform click on element
	 */
	public void click(By by) {
		findClickableElement(by).click();
	}

	/**
	 * 
	 * @param by
	 *            element locator for which user wants to check its visibility
	 * @return true or false
	 * 
	 *         This method is used to check weather the element is displayed on page
	 *         or not
	 */
	public boolean isElementDisplayed(By by) {
		try {
			return findVisibleElement(by, 3, 100).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 
	 * @param timeSeconds
	 *            time in seconds
	 * 
	 *            This method is used to hold the script upto desired seconds
	 */
	public void implicitWait(int timeSeconds) {
		driver.manage().timeouts().implicitlyWait(timeSeconds, TimeUnit.SECONDS);
	}

	/**
	 * 
	 * @param timeMilliSeconds
	 *            time in milliseconds
	 * 
	 *            This method is used to hold the script upto desired seconds
	 * 
	 */
	public void waitInMilliSeconds(int timeMilliSeconds) {
		driver.manage().timeouts().implicitlyWait(timeMilliSeconds, TimeUnit.MILLISECONDS);
	}

	/**
	 * 
	 * @param by
	 *            common element locator for all the elements
	 * @return int (count)
	 * 
	 *         This method is used to get count of an elements with same locators
	 *         which are present on screen
	 */
	public int getElementCount(By by) {
		return driver.findElements(by).size();
	}



	/**
	 * 
	 * @param loggerName
	 *            name of the logger
	 * @return desired logger instance
	 * 
	 *         This method is used to get desired logger's instance which later user
	 *         will use for logging purpose
	 */
	public Logger getLogger(String loggerName) {
		Logger logger = Logger.getLogger(loggerName.trim());
		return logger;
	}

	/**
	 * 
	 * 
	 *         This method is used to scroll to the top of the page
	 */
	public void scrollToTop() {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,-350)", "");
	}

	/**
	 * 
	 * @param by
	 *            element locator of an element till which user wants to scroll
	 * 
	 *            This method is used to scroll to the specific element
	 */
	public void scrollToElement(By by) {
		getElement(by);
		WebElement element = getElement(by);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		waitInMilliSeconds(400);
	}

	/**
	 * 
	 * @param by
	 *            element locator of an element
	 * @return desired web element
	 * 
	 *         Note : Use this method for the element at which user get stale
	 *         element exception
	 */
	public WebElement getElement(By by) {
		final WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(by)));

		return findVisibleElement(by);
	}

	/**
	 * This method is used to terminate all the browsers
	 */
	
	@AfterSuite
	public void tearDown() {
		this.driver.quit();
	}
//	public  void captureScreenshot(ITestResult result,String extension)
//	{
//		if(ITestResult.FAILURE==result.getStatus())
//		{
//		try 
//		{
//		// Create refernce of TakesScreenshot
//		TakesScreenshot ts=(TakesScreenshot)driver;
//		 
//		// Call method to capture screenshot
//		File source=ts.getScreenshotAs(OutputType.FILE);
//		// Open the current date and time
//		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
//
//		//Copy the screenshot on the desire location with different name using current date and time
//		FileUtils.copyFile(source, new File("./Screenshots/" + result.getName()+" "+timestamp+extension));
//		 
//		// Copy files to specific location here it will save all screenshot in our project home directory and
//		// result.getName() will return name of test case so that screenshot name will be same
//		//FileUtils.copyFile(source, new File("./Screenshots/"+result.getName()+".png"));
//		 
//		System.out.println("Screenshot taken");
//		} 
//		catch (Exception e)
//		{
//		 
//		System.out.println("Exception while taking screenshot "+e.getMessage());
//		} 	
//		}
//	}
	public static String getScreenshot() throws IOException{
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		//TakesScreenshot ts = (TakesScreenshot) driver;
		//File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder
		//String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName+ ".png";
		//File finalDestination = new File(destination);
		//FileUtils.copyFile(source, finalDestination);
		//return destination;
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + "image" + dateName+ ".png";
		FileUtils.copyFile(source, new File(path));
		return path;
	}
	public static String getScreenshotBase64() throws IOException{
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + "image" + dateName+ ".png";
		FileUtils.copyFile(source, new File(path));
		byte[] imageBytes = IOUtils.toByteArray(new FileInputStream(path)); 
		return Base64.getEncoder().encodeToString(imageBytes);
	}
	public static String getBase64() throws IOException{
		 
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
	}
	
	@BeforeTest(alwaysRun = true)
	public void setExtent() throws IOException{
	 // extent = new ExtentReports(); 
	 // ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/PassedExtentReport.html");
	 // ExtentSparkReporter failspark = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/FailedExtent.html").filter().statusFilter().as(new Status [] {Status.FAIL}).apply();
	 // failspark.config().setDocumentTitle("Failed Tests");
	 // extent.attachReporter(spark);
	 // extent.attachReporter(failspark);
	 // final File CONF = new File("extentconfig.xml");
	 // ExtentSparkReporter spark = new ExtentSparkReporter("target/spark/spark.html");
	 // spark.loadXMLConfig(CONF);
	  //spark.config().setTheme(Theme.DARK);
	 // spark.config().setDocumentTitle("AutomationReport");
	//  spark.config().setReportName("Extent Report");
	 
		//extent.flush();
		ExtentReportCreate.generateReport();
	}
	@AfterTest(alwaysRun = true)
	public void endReport() throws EmailException, IOException{
		//ExtentReports extent = new ExtentReports();
		//extent.flush();
		//Desktop.getDesktop().browse(new File(System.getProperty("user.dir")+"/test-output/PassedExtentReport.html").toURI());
		//Desktop.getDesktop().browse(new File(System.getProperty("user.dir")+"/test-output/FailedExtent.html").toURI());
	//	extent.close();
		//SendEmail();
		//driver.quit();
		ExtentReportCreate.flushReports();
	}

	/*
	 * @AfterMethod(alwaysRun = true) public void tearDown(ITestResult result)
	 * throws IOException, EmailException {
	 * 
	 * if (result.getStatus() == ITestResult.FAILURE) {
	 * extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getName()); //
	 * to add name in extent report extentTest.log(LogStatus.FAIL,
	 * "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in
	 * extent report String screenshotPath = getScreenshot(driver,
	 * result.getName()); System.out.println("ScreenshotPath is " + screenshotPath
	 * ); extentTest.log(LogStatus.FAIL,
	 * extentTest.addScreenCapture(screenshotPath));
	 * System.out.println("ScreenshotPath is added to report"); //
	 * extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath));
	 * //to add screencast/video in extent report } else if (result.getStatus() ==
	 * ITestResult.SKIP) { extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " +
	 * result.getName()); } else if (result.getStatus() == ITestResult.SUCCESS) {
	 * extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName()); }
	 * extent.endTest(extentTest); // ending test and ends the current test and
	 * prepare to create html report }
	 */
	public void SendEmail() throws EmailException {
		// Create the attachment
		  EmailAttachment attachment = new EmailAttachment();
		  attachment.setPath(System.getProperty("user.dir")+"/test-output/Extent.html");
		  attachment.setDisposition(EmailAttachment.ATTACHMENT);
		  attachment.setDescription("Veriday Test Execution Report");
		  attachment.setName("Veriday Automation Test Execution Report");

		  // Create the email message
		  MultiPartEmail email = new MultiPartEmail();
		  email.setHostName("smtp.gmail.com");
		  email.setSSLOnConnect(true);
		  email.setSmtpPort(465);
		  email.setAuthenticator(new DefaultAuthenticator("sumitsoni691@gmail.com", "Sumit@123"));
		  email.addTo("sumit.soni@veriday.com", "Sumit Soni");
		  email.setFrom("sumitsoni691@gmail.com", "Me");
		  email.setSubject("Veriday Automation Test Execution Report");
		  email.setMsg("Veriday Automation Test Execution Report");

		  // add the attachment
		  email.attach(attachment);

		  // send the email
		  email.send();
	}
	
//	@AfterTest
//	public void resultDetails(ITestResult testResult) {
//		if (testResult.getStatus() == ITestResult.FAILURE) {
//			takeScreenShot(testResult.getName() + "Test1");
//		}  else if (testResult.getStatus() == ITestResult.SUCCESS){
//			
//		}
//	}
//	
//	public void takeScreenShot(String imageName) {
//		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		try {
//			FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "/FailureImages/" + imageName + ".png"));
//		} catch (IOException e) {
//			System.out.println(e.getMessage());
//		}
//	}
//    public void failed() {
//	   File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//	   try {
//	   FileUtils.copyFile(scrFile, new File("C:\\Users\\sumit.soni\\Downloads\\CRMtesting_02_11_2018\\CRMtesting\\Scrrenshot\\testfailure.jpg"));
//	   } catch(IOException e) {
//		   e.printStackTrace();
//	   }
//   }
	/*
	@AfterSuite
	
	public void openResult() {
		System.setProperty("webdriver.chrome.driver", projectDirectory + "\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(projectDirectory+"\\target\\surefire-reports\\html\\index.html");
		driver.manage().window().maximize();
		driver.navigate().refresh();
	} */
}
