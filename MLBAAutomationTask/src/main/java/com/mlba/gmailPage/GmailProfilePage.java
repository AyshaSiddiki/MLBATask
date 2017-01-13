package com.mlba.gmailPage;



import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.mlba.utils.MLBAUtils;

public class GmailProfilePage
{
	WebDriver driver;

	public GmailProfilePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		log.info("Elements has initialized");
	}

	MLBAUtils	customUtils	= new MLBAUtils(driver);
	Logger	log		= Logger.getLogger(GmailProfilePage.class);
	
	@FindBy(xpath = "//div[@class='gb_uc gb_hb gb_Cf gb_R']/a")
	WebElement	profileLogo;

	public void verifyProfileLogo() 
	{
		if (customUtils.webElement(profileLogo).isDisplayed())
		{
			log.info("Landed to the expected profile page");
		}
		else
			log.error("error");
	}
}
