package Helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import utility.ConfigReader;


public  class BrowserFactory {
	static Properties pro;
	static WebDriver driver;
	static ConfigReader config;
	public static WebDriver startBrowser(String Browsername) throws Exception
	{
		
		config=new ConfigReader();
		if (Browsername.equals("googlechrome"))
		{
						

			System.setProperty("webdriver.chrome.driver",  config.GetChromePath("googlechrome"));			
		//	System.setProperty("webdriver.chrome.driver", "C:/Users/oshri/Desktop/selenium/chromedriver.exe");
			// pro.getProperty("ChromeDriver");
			 driver=new ChromeDriver();
		}
		else if(Browsername.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", config.GetChromePath("Firefox"));			
			driver=new FirefoxDriver();
			// pro.getProperty("FirefoxDriver");
			
		}
		else if(Browsername.equals("explorer"))
		{
			System.setProperty("webdriver.gecko.driver", config.GetChromePath("IE"));			
			driver=new InternetExplorerDriver();
			 pro.getProperty("ChromeDriver");
			
		}
		
		
		return driver;
	}
	
}
