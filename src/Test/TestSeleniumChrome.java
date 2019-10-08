package Test;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.toolsqa.com.pages.LoginPageNew;

import Helper.BrowserFactory;
import utility.ConfigReader;

public class TestSeleniumChrome {
	 ConfigReader config;
	 LoginPageNew loginpage;
	 WebDriver driver;
	 ExtentHtmlReporter htmlReporter;
	 ExtentTest test;
	 ExtentReports extent;
	 @Before
		public void SeTup() throws Exception
		{
		  htmlReporter = new ExtentHtmlReporter("extent.html");
		   extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	         test = extent.createTest("toolsqa test one", "this is a test for login on toolsqa");
		 config=new ConfigReader();
		
			 driver=BrowserFactory.startBrowser("googlechrome");
			 Thread.sleep(6000);
			 test.log(Status.INFO,"starting test case");
			 loginpage=PageFactory.initElements(driver, LoginPageNew.class);
			driver.get(config.GetAplicationUrlh());
			test.pass("navigate to toolsqa");
			System.out.println("setup is ready");
		}
	@Test
	
	public void TestChrome() throws Exception
	{
		
		/*driver.findElement(By.id("email")).sendKeys("gfgtgtr");*/
		
		loginpage.LoginToFacebook("oshri","aloni");
		 test.pass("enter first name and last name");
		loginpage.ClickToLoginButton();
		test.pass("click on ligin button");
		Thread.sleep(8000);
		loginpage.ChooseMale();
		test.pass("Choose male");
		Thread.sleep(8000);
		loginpage.ChooseFemale();
		test.pass("Choose Fmale");
		/*loginpage.CheckLogin();
		test.pass("chek if login");*/
		Thread.sleep(8000);
		loginpage.YearsOfExperience();
		test.pass("Choose Expries");
		Thread.sleep(4000);
		loginpage.PressDate();
		test.pass("press date");
		Thread.sleep(4000);
		loginpage.ChooseProfession();
		test.pass("Choose Profession Manual Tester");
		Thread.sleep(4000);
		loginpage.ChooseFile();
		test.pass("Choose file in computer");
		Thread.sleep(4000);
		loginpage.ClickToText();
		test.pass("Click To Text");
		Thread.sleep(4000);
		loginpage.ChooseAutomationTool();
		test.pass("Click To Text");
		Thread.sleep(4000);
		loginpage.ChooseContinents(1);
		test.pass("Choose Continents");
		Thread.sleep(4000);
		loginpage.ContinentsMultipleSelect("Antarctica");
		test.pass("Choose Continents – Multiple Select");
		Thread.sleep(8000);
	}
	@After
	public void EndTest() throws Exception
	{
		System.out.println("setup is succes");
		driver.quit();
		 test.pass("close browser");
		 test.info("test completed");
		 extent.flush();
	}
	

}
