package dashboard;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Dashboard {

	public WebDriver driver;
	public static String loggerPropertiesFile;
	public static String testLogger = "Aussizz";	
	public static String projectDirectory = System.getProperty("user.dir");
	
	protected enum Condition {
		isDisplayed, isClickable, isPresent
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

	public void tearDown() {
		driver.quit();
	}
	
	
}
