package pages;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConstantInterface {
	public static Properties prop;
//	 prop = new Properties();
//		FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/crm"
//				+ "/qa/config/config.properties");
//		prop.load(ip);
	 public static final String strURL = "http://node-1.nginx.portal.da-1.rbcus.qa.aws.veriday.net/login";
	 //public static String Path_TestData = "./src\\Veriday\\source";
	 //public static String Path_TestData  = System.getProperty("user.dir"+"\\source");
	
	 //File src = new File(Path_TestData);
     public static final String Path_TestData = "D:\\VeridayAutomationGit\\Veriday-Automation-Framework\\source";

     public static final String File_TestData = "TestData.xlsx";
     
    

}
