package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	Properties pro;
	public  ConfigReader() throws Exception
	
	{
		try {
			File src=new File("./Configuration/Config.property");
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception is="+e.getMessage());
		} 
	}
	public String GetChromePath(String Browsername)
	{
		String path="";
		if (Browsername.equals("googlechrome"))
		{
		 path=pro.getProperty("ChromeDriver");
		}
		if (Browsername.equals("Firefox"))
		{
		 path=pro.getProperty("FirefoxDriver");
		}
		if (Browsername.equals("IE"))
		{
		 path=pro.getProperty("IE");
		}
		return path;
	}
	public String GetAplicationUrlh()
	{
		
		return pro.getProperty("URL");
	}

}
