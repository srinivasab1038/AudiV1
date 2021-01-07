package com.AudiV1.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.AudiV1.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{

	@Test
	public void loginTest() throws IOException, InterruptedException
	{
		//driver.get(baseURL); This is moved to base class
		logger.info("URL is opened");
	
		driver.manage().window().maximize();
		
		LoginPage lp = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.findElement(By.linkText("I understand the risks and wish to continue")).click();
		
	    boolean res= driver.getPageSource().contains("Visiting an untrustworthy website has been prevented");
	    if(res==true)
	    {
	    	Assert.assertTrue(true);
	    	logger.info("Warning message displayed...");
	    	driver.findElement(By.xpath("//a[normalize-space()='Show details']")).click();
	    	driver.findElement(By.xpath("//a[contains(text(),'I understand the risks and wish to proceed to the ')]")).click();
	    	Alert alert= driver.switchTo().alert();
	    	alert.accept();
    		driver.switchTo().defaultContent(); 
	    	Thread.sleep(3000);
	    	
	    	if(isAlertPresent()==true)
	    	{
	    		driver.switchTo().alert().accept();
	    		driver.switchTo().defaultContent();      // to focus on the browser
	    		logger.info("Login page displayed"); 
	    	}
	    	else
	    	{
	    		Assert.assertTrue(true);
	    		logger.info("Login page displayed"); 
	    	}

	    }
	    else
	    {
	    	logger.info("Login page displayed");
	    	lp.setUserName(username);
	 		logger.info("User name is entered");
	 		lp.setPassword(password);
	 		logger.info("Password is entered");
	 		lp.clickSubmit();
	 		logger.info("Clicked submit");
	    }
	   
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else
		{
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
	}
}
