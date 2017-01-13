package com.mlba.test;



import org.testng.annotations.Test;

import com.mlba.ebayPage.EbayHomePage;
import com.mlba.ebayPage.EbayProductPage;
import com.mlba.gmailPage.HomePage;
import com.mlba.gmailPage.GmailProfilePage;

public class SmokeTest extends BaseTest
{
	@Test
	public void gmailLoginTest() throws Throwable
	{
		
		HomePage homePage = new HomePage(driver);
		GmailProfilePage gmailProfilePage = homePage.validLogIn();
		Thread.sleep(5000);
		gmailProfilePage.verifyProfileLogo();
	}

	@Test
	public void gmailInvalidUserLoginTest()throws Exception
	{
		
		HomePage homePage = new HomePage(driver);
		GmailProfilePage gmailProfilePage = homePage.invalidUserName();
		Thread.sleep(5000);
		gmailProfilePage.verifyProfileLogo();
	}

	@Test
	public void gmailInvalidPassLoginTest()throws Exception
	{
		
		HomePage homePage = new HomePage(driver);
		GmailProfilePage gmailProfilePage = homePage.invalidPassword();
		Thread.sleep(5000);
		gmailProfilePage.verifyProfileLogo();
	}
	
	@Test
	public void ebayProduct() throws InterruptedException
	{
		
		EbayHomePage ebayHomePage= new EbayHomePage(driver);
		EbayProductPage ebayProductPage= ebayHomePage.searchElecticGuiter();
		
		ebayProductPage.firstProductOnSearch();
		
		
	}
}
