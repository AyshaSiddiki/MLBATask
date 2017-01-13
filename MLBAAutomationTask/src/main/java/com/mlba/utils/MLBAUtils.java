package com.mlba.utils;

import java.io.File;


import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.mlba.test.BaseTest;

public class MLBAUtils extends BaseTest
{
	WebDriver driver;
	
	public MLBAUtils(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		log.info("Elements has initialized");
	}
	Logger	log	= Logger.getLogger(MLBAUtils.class);
	
	public WebElement webElement(WebElement element)
	{
		log.info(element + " is initialized");
		return element;
	}
	
	
	
	public void screenShot() throws Throwable
	{
		   File sf=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(sf, new File("./image/shot"+Math.random()*2000+".png"),true);
	        log.info("Took the screen shot");
	}
	
	public void waitForElement(int time) throws InterruptedException
	{
		Thread.sleep(time);
	}
}
