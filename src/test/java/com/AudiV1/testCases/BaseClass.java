package com.AudiV1.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;

//import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.AudiV1.utilities.ReadConfig;

public class BaseClass 
{
//Below code is written in simple way by reading from ReadConfig using Properties file
/*public String baseURL="https://demo.guru99.com/v4/";
public String username="mngr257797";
public String password="qYzepUt";
public String homepagetitle="Guru99 Bank Manager HomePage";
public static WebDriver driver;

public static Logger logger;

@BeforeClass
public void setup()
{
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
	driver = new ChromeDriver();
	
	//logger=Logger.getLogger(Test.class.getName());
	logger=Logger.getLogger("AudiV1");
	PropertyConfigurator.configure("Log4j.properties");
}

@AfterClass
public void tearDown()
{
	driver.quit();
}*/

ReadConfig readconfig = new ReadConfig();

public String baseURL=readconfig.getApplicationURL();
public String username=readconfig.getUsername();
public String password=readconfig.getPassword();
public String homepagetitle=readconfig.getHomepageTitle();
public static WebDriver driver;

public static Logger logger;

@Parameters("browser") //Parameter is used to use the value in xml file
@BeforeClass
public void setup(String br)
{
	//logger=Logger.getLogger(Test.class.getName());
	logger=Logger.getLogger("AudiV1");
	PropertyConfigurator.configure("Log4j.properties");
	
	if(br.equals("chrome"))
	{
	System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
	driver = new ChromeDriver();
	}
	else if(br.equals("firefox"))
	{
	System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
	driver = new FirefoxDriver();
	}
	else if(br.equals("ie"))
	{
	System.setProperty("webdriver.ie.driver", readconfig.getIEPath());
	driver = new InternetExplorerDriver();
	}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get(baseURL);
	driver.manage().window().maximize();
}

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+ "/Screenshots/" +tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot Taken");
	}
	
	public boolean isAlertPresent() //user defined method to check alert is present or not
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public String randomString()
	{
	  String generatedstring = RandomStringUtils.randomAlphabetic(5);
	  return(generatedstring);
	}
	
	public String randonNum()
	{
	  String generatednum= RandomStringUtils.randomNumeric(6);
	  return(generatednum);
	}
}

