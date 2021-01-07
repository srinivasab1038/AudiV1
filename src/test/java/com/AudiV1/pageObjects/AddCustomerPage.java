package com.AudiV1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage 
{
	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(how=How.XPATH, using ="/html[1]/body[1]/div[3]/div[1]/ul[1]/li[2]/a[1]")
	@CacheLookup
	WebElement lnkNewCustomer;
	
	@FindBy( how= How.NAME, using ="name")
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy(how= How.NAME, using ="rad1")
	@CacheLookup
	WebElement btnGender;
	
	@FindBy(how= How.ID_OR_NAME, using="dob")
	@CacheLookup
	WebElement txtdob;
	
	@FindBy(how= How.NAME, using ="addr")
	@CacheLookup
	WebElement txtAddress;
	
	@FindBy(how= How.NAME, using ="city")
	@CacheLookup
	WebElement txtCity;
	
	@FindBy(how= How.NAME, using ="state")
	@CacheLookup
	WebElement txtState;
	
	@FindBy(how= How.NAME, using ="pinno")
	@CacheLookup
	WebElement txtPin;
	
	@FindBy(how= How.NAME, using ="telephoneno")
	@CacheLookup
	WebElement txtMobileNumber;
	
	@FindBy(how= How.NAME, using = "emailid")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(how= How.NAME, using ="password")
	@CacheLookup
	WebElement txtxPassword;
	
	@FindBy(how= How.XPATH, using = "//input[@value='Submit']")
	@CacheLookup
	WebElement btnSubmit;
	
	@FindBy(how= How.XPATH, using = "//input[@value='Reset']")
	@CacheLookup
	WebElement btnReset;
	
	public void clickNewCustomer()
	{
		lnkNewCustomer.click();
	}
	
	public void customername(String cname)
	{
		txtCustomerName.sendKeys(cname);	
	}
	
	public void Gender(String cgender)
	{
		btnGender.sendKeys(cgender);
	}
	
	public void dob(String mm, String dd, String yy) throws InterruptedException
	{
		txtdob.sendKeys(mm);
		Thread.sleep(1000);
		txtdob.sendKeys(dd);
		Thread.sleep(1000);
		txtdob.sendKeys(yy);
		Thread.sleep(1000);
	}
	
	public void address(String caddress)
	{
		txtAddress.sendKeys(caddress);
	}
	
	public void city(String ccity)
	{
		txtCity.sendKeys(ccity);
	}
	
	public void state(String cstate)
	{
		txtState.sendKeys(cstate);
	}
	
	public void pin(String cpin)
	{
		txtPin.sendKeys(String.valueOf(cpin));
	}
	
	public void mobileNumber(String cMobileNumber)
	{
		txtMobileNumber.sendKeys(String.valueOf(cMobileNumber));
	}
	
	public void email(String cemail)
	{
		txtEmail.sendKeys(cemail);
	}
	
	public void password(String cpassword)
	{
		txtxPassword.sendKeys(cpassword);
	}
	
	public void submit()
	{
		btnSubmit.click();
	}
	
}
