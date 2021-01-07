package com.AudiV1.testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.AudiV1.pageObjects.LoginPage;
import com.AudiV1.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass
{
    @Test(dataProvider="LoginData")
	public void loginDDT(String user, String pwd) throws IOException, InterruptedException
	{
    	LoginPage lp= new LoginPage(driver);
    	lp.setUserName(user);
    	logger.info("user name provided");
    	lp.setPassword(pwd);
    	logger.info("password provided");
    	lp.clickSubmit();
    	Thread.sleep(3000);
    	
    	if(isAlertPresent()==true)
    	{
    		captureScreen(driver, "loginDDT");
    		driver.switchTo().alert().accept();
    		driver.switchTo().defaultContent(); // to focus on the browser
    		Assert.assertTrue(false);
    		logger.warn("Login failed");
    	}
    	else
    	{
    		Assert.assertTrue(true);
    		logger.info("Login passed");
    		lp.clickLogout();
    		Thread.sleep(3000);
    		driver.switchTo().alert().accept(); // to close the logout alert
    		driver.switchTo().defaultContent(); 
    	}
    	
	}
    
    @DataProvider(name="LoginData")
    String [][] getData() throws IOException
    {
    	String path= System.getProperty("user.dir")+"/src/test/java/com/AudiV1/testData/TestData.xlsx";
    	int rownum = XLUtils.getRowCount(path, "Sheet1");
    	int colcount = XLUtils.getCellCount(path, "Sheet1", 1); //excel row 0 is header and will be reading from row 1
    	
    	String logindata[][]= new String[rownum][colcount];
    	
    	for(int i=1;i<=rownum;i++)
    	{
    		for(int j=0;j<colcount;j++)
    		{
    			logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
    			
    		}
    	}
    	return logindata;
    }
}
