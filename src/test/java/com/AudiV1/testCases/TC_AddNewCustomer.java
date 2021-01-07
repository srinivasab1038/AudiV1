package com.AudiV1.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.AudiV1.pageObjects.AddCustomerPage;
import com.AudiV1.pageObjects.LoginPage;

public class TC_AddNewCustomer extends BaseClass
{
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
	LoginPage lp = new LoginPage(driver);
	lp.setUserName(username);
	logger.info("User name is provided");
	lp.setPassword(password);
	logger.info("Password is provided");
	lp.clickSubmit();
	Thread.sleep(3000);
	logger.info("Logged in");
	//Thread.sleep(5000);
	
	AddCustomerPage addcust = new AddCustomerPage(driver);
	Thread.sleep(3000);
	addcust.clickNewCustomer();
	logger.info("Providing Customer details...");
	addcust.customername("Srini");
	logger.info("customername is entered");
	addcust.Gender("male");
	logger.info("Gender is selected");
	Thread.sleep(3000);
	addcust.dob("12","27","1990");
	logger.info("dob is entered");
	Thread.sleep(3000);
	addcust.address("India");
	logger.info("address is entered");
	addcust.city("Bang");
	logger.info("city is entered");
	addcust.state("Kar");
	logger.info("state is entered");
	addcust.pin("560043");
	logger.info("pin is entered");
	addcust.mobileNumber("2646836382");
	logger.info("mobileNumber is entered");
	String email= randomString()+"@gmail.com";
	addcust.email(email);
	logger.info("email is entered");
	addcust.password("2355732sgf");
	logger.info("password is entered");
	Thread.sleep(1000);
	addcust.submit();
	
    Thread.sleep(3000);
	
    logger.info("Validation Started.......");
    boolean res= driver.getPageSource().contains("Customer Registered Successfully!!!");
    
    if(res==true)
    {
    	Assert.assertTrue(true);
    	logger.info("Test case passed...");
    }
    else
    {
    	logger.info("Test case failed...");
    	captureScreen(driver,"addNewCustomer");
    	Assert.assertTrue(false);
    }
    
	}
	
	
}
