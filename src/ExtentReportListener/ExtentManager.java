package ExtentReportListener;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {
	/**
	 * Private constructor to avoid external instantiation
	 */
	private ExtentManager() {}

	private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>() ;

	/**
	 * Returns the thread safe {@link com.aventstack.extentreports.ExtentTest} instance fetched from ThreadLocal variable.
	 * @author Amuthan Sakthivel
	 * Jan 21, 2021
	 * @return Thread safe {@link com.aventstack.extentreports.ExtentTest} instance.
	 */
	public static ExtentTest getExtentTest() { //default --> it can be only accessed within the package --> private packages
		return extTest.get();
	}

	/**
	 * Set the {@link com.aventstack.extentreports.ExtentTest} instance to thread local variable
	 * 
	 * @author Amuthan Sakthivel
	 * Jan 21, 2021
	 * @param test {@link com.aventstack.extentreports.ExtentTest} instance that needs to saved from Thread safety issues.<p>
	 * TODO Disallow null assignment and call unload method instead. 
	 */
	static void setExtentTest(ExtentTest test) {
		extTest.set(test);
	}

	/**
	 * Calling remove method on Threadlocal variable ensures to set the default value to Threadlocal variable.
	 * It is much safer than assigning null value to ThreadLocal variable.
	 * @author Amuthan Sakthivel
	 * Jan 21, 2021
	 */
	static void unload() {
		extTest.remove();
	}

}
