package com.mlba.ebayPage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mlba.utils.MLBAUtils;

public class EbayHomePage 
{
	WebDriver	driver;
	

	public EbayHomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	MLBAUtils	customUtils;
	Logger	log	= Logger.getLogger(EbayHomePage.class);
	
	@FindBy(xpath = "//div[@id='gh-ac-box2']/input")
	WebElement	searchBox;
	
	@FindBy(xpath = "//td[@class='gh-td']/input")
	WebElement	searchButton;

	public EbayProductPage searchElecticGuiter() throws InterruptedException
	{
		customUtils = new MLBAUtils(driver);
		
		customUtils.webElement(searchBox).sendKeys("Electric Guitar");
		log.info("Electric guitar is entered on the text box");
		
		customUtils.webElement(searchButton).click();
		log.info("Clicked on the search button");
		customUtils.waitForElement(3000);
	
		return new EbayProductPage(driver);
	}
}
