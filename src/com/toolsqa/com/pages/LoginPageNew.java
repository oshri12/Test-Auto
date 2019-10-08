package com.toolsqa.com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class LoginPageNew {
	
	WebDriver driver;
	WebElement uploadElement;
	public LoginPageNew (WebDriver _driver)
	{
		this.driver=_driver;
		
	}
	@FindBy(how=How.NAME,using="firstname")
	WebElement firstname;
	@FindBy(how=How.ID,using="lastname")
	WebElement lastname;
	@FindBy(how=How.ID,using="buttonwithclass")
	WebElement btnsubmit;
	@FindBy(how=How.XPATH,using="//*[@id=\"sex-1\"]")
	WebElement female;
	@FindBy(how=How.XPATH,using="//*[@id=\"sex-0\"]")
	WebElement male;
	@FindBy(how=How.NAME,using="exp")
	List <WebElement> Checkslist;
	@FindBy(how=How.XPATH,using="//*[@id=\"datepicker\"]")
	WebElement date;
	@FindBy(how=How.LINK_TEXT,using="Selenium Automation Hybrid Framework")
	WebElement linkHybridFrameworkt;
	@FindBy(how=How.LINK_TEXT,using="Test File to Download")
	WebElement linktestDownload;
	@FindBy(how=How.NAME,using="profession")
	List <WebElement> Checkslistprofession;
	@FindBy(how=How.NAME,using="tool")
	List <WebElement> Checkslisttool;


	/*List <WebElement> d= driver.findElements(By.name("exp"));*/
	
	public void LoginToFacebook(String uid,String pass)
	{

	
		this.firstname.sendKeys(uid);
		this.lastname.sendKeys(pass);
		
		
	}

	public void ClickToLoginButton() {
		// TODO Auto-generated method stub
		this.btnsubmit.click();
	}
	public void ChooseMale()
	{

	if(!male.isSelected())
	
		this.male.click();
	
	else
		System.out.println("chek box already selected");
	}
	
	public void ChooseFemale()
	{

	if(!female.isSelected())
	
		this.female.click();
	
	else
		System.out.println("chek box already selected");
	
	}
	
	public void YearsOfExperience()
	{
		for(WebElement selectLi: Checkslist)
	    {
			
	            selectLi.click();
	        
	    }
	}
	public void ChooseFile()
	{
	    
		 uploadElement=driver.findElement(By.xpath("//*[@id=\"photo\"]"));
		 
	     // enter the file path onto the file-selection input field
        uploadElement.sendKeys("C:\\Users\\oshri\\Downloads\\Oshri-Aloni cv (1).docx");

        
	        
	    
	}
	public void PressDate()
	{
	    
		this.date.sendKeys("03/10/2019");     
	    
	}
	public void ClickToText()
	{
	    
		this.linkHybridFrameworkt.click();     
		this.linktestDownload.click(); 
	    
	}
	/*public void ChooseProfessionManualTester()
	{
		for(WebElement selectLipro: Checkslistprofession)
	    {
			if(selectLipro.isSelected())
			selectLipro.click();
			
			
	    }
		driver.findElement(By.id("profession-0")).click();
	}*/
	public void ChooseProfession()
	{
		for(WebElement selectLipro: Checkslistprofession)
	    {
			ReseChekboxtList(Checkslistprofession);
			selectLipro.click();

	    }
		
	}
	public void ChooseAutomationTool ()
	{
		for(WebElement selectLit: Checkslisttool)
	    {
			ReseChekboxtList(Checkslisttool);
			selectLit.click();

	    }
		
	}
	
	public void ReseChekboxtList(List <WebElement> Checkslis)
	{
		
		for(WebElement selectLi: Checkslis)
	    {
			if(selectLi.isSelected() )
				selectLi.click();

	    }
	}
	
      public void ChooseContinents(int indeContinents)
	{
    	Select continents=new Select(driver.findElement(By.xpath("//*[@id=\"continents\"]")));
		continents.selectByIndex(indeContinents);
	}

     public void ContinentsMultipleSelect(String txtContinents)
  	{
      	Select continents=new Select(driver.findElement(By.id("continentsmultiple")));
  		continents.deselectByVisibleText(txtContinents);
  	}
}
