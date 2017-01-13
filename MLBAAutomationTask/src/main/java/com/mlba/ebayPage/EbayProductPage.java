package com.mlba.ebayPage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.mlba.utils.MLBAUtils;

public class EbayProductPage
{
	WebDriver driver;
	
	public EbayProductPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	MLBAUtils	customUtils;
	Logger	log	= Logger.getLogger(EbayProductPage.class);
	
	@FindBy(xpath = ".//*[@id='item5430ad03cd']/ul[1]/li[1]/span")
	WebElement	productPrice;
	
	public void firstProductOnSearch()
	{
		customUtils = new MLBAUtils(driver);
		String productvalue = customUtils.webElement(productPrice).getText();
		String num=productvalue.replace("$", "");
		log.info(num);
		double price=Double.parseDouble(num);
		log.info("The price of the guitar is $"+price);
		
	}
}
