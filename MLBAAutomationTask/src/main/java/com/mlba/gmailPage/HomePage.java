package com.mlba.gmailPage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.mlba.utils.MLBAUtils;

public class HomePage
{
	WebDriver	driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	MLBAUtils	customUtils;
	Logger	log	= Logger.getLogger(HomePage.class);
	
	@FindBy(xpath = ".//*[@id='signIn']")
	WebElement	signInButton;
	
	@FindBy(xpath = ".//*[@id='Email']")
	WebElement	userName;
	
	@FindBy(xpath = ".//*[@id='next']")
	WebElement	nextButton;
	
	@FindBy(xpath = ".//*[@id='Passwd']")
	WebElement	passwordBox;
	
	@FindBy(xpath = ".//*[@id='answer']")
	WebElement	cityBox;
	
	
	public GmailProfilePage validLogIn() throws Throwable 
	{
		customUtils = new MLBAUtils(driver);
		Thread.sleep(1000);
		customUtils.webElement(userName).sendKeys("MLBASeleniumAutomation@gmail.com");
		log.info("Entered the userid");
		
		customUtils.webElement(nextButton).click();
	
		log.info("Clicked on the next button");
		customUtils.waitForElement(3000);
		customUtils.webElement(passwordBox).sendKeys("mlbapassword");
		log.info("Entered the password");
		
		customUtils.webElement(signInButton).click();
		log.info("Clicked on the signin button");
		customUtils.waitForElement(2000);
		
		return new GmailProfilePage(driver);
	}

	public GmailProfilePage invalidUserName() throws InterruptedException
	{
		customUtils = new MLBAUtils(driver);
		customUtils.webElement(userName).sendKeys("SeleniumAutomation@gmaill.com");
		customUtils.webElement(nextButton).click();
		customUtils.waitForElement(2000);
		customUtils.webElement(passwordBox).sendKeys("mlbapassword");
		customUtils.webElement(signInButton).click();
		customUtils.waitForElement(3000);
		return new GmailProfilePage(driver);
	}

	public GmailProfilePage invalidPassword() throws InterruptedException
	{
		customUtils = new MLBAUtils(driver);
		customUtils.webElement(userName).sendKeys("MLBASeleniumAutomation@gmail.com");
		customUtils.webElement(nextButton).click();
		customUtils.waitForElement(2000);
		customUtils.webElement(passwordBox).sendKeys("mlbapassword123");
		customUtils.webElement(signInButton).click();
		customUtils.waitForElement(3000);
		return new GmailProfilePage(driver);
	}
}
