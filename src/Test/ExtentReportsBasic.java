package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.toolsqa.com.pages.LoginPageNew;

import Helper.BrowserFactory;
import utility.ConfigReader;

public class ExtentReportsBasic {
	 static LoginPageNew loginpage;
	 static WebDriver driver;
	 static ConfigReader config;
	 public static void main(String[] args) throws Exception {
	        // start reporters
		 config=new ConfigReader();
	        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
	        // create ExtentReports and attach reporter(s)
	        ExtentReports extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	     // creates a toggle for the given test, adds all log events under it    
	        ExtentTest test = extent.createTest("facebook test one", "this is a test for login on facebook");
	        driver=	BrowserFactory.startBrowser("googlechrome");
	        test.log(Status.INFO,"starting test case");
			 loginpage=PageFactory.initElements(driver, LoginPageNew.class);
			 driver.get(config.GetAplicationUrlh());
			 test.pass("navigate to facebook");
			 loginpage.LoginToFacebook("0544753360","aloni200426880#");
			 test.pass("enter user and password");
			 loginpage.ClickToLoginButton();
			 test.fail("click on ligin button");
			 driver.quit();
			 test.pass("close browser");
			 test.info("test completed");
			 extent.flush();
}  
}
