package com.mlba.test;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.mlba.utils.MLBAUtils;

public class BaseTest
{
	public WebDriver driver;
	FileInputStream fileInputStream;
	public Properties properties;
	Logger log;

	@BeforeMethod
	public void openBroweser() throws Throwable 
	{
		log = Logger.getLogger(BaseTest.class);
		DOMConfigurator.configure("log4j.xml");
		fileInputStream = new FileInputStream("config.properties");
	    properties = new Properties();
		properties.load(fileInputStream);
		if (properties.getProperty("browser").equals("firefox"))
		{
			log.info("Browser is initializing");
			System.setProperty("webdriver.gecko.driver",
			"./driver/geckodriver");
			driver = new FirefoxDriver();
			
		}
		else if (properties.getProperty("browser").equals("chrome"))
		{
	System.setProperty("webdriver.chrome.driver",
				"./driver/chromedriver");
			
			driver = new ChromeDriver();
		}
		driver.get(properties.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void closeBrowser(ITestResult result) throws Throwable 
	{
		if (result.getStatus() == result.FAILURE)
		{
			MLBAUtils customUtils= new MLBAUtils(driver);
			customUtils.screenShot();
		}
		driver.quit();
	}
}
