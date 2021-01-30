package com.iNetBanking.TestCases;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.iNetBanking.PageObjects.LoginPage;


public class TC_LoginTest_001 extends BaseClass{
	
	@Test
	public void loginTest() {
		logger.info("Open the application url");
		
		try {
			if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
				logger.info("Login Test passed");
				Assert.assertTrue(true);				
			}
			else {
				captureScreenShot(driver, "loginTest");
				logger.info("LoginTest Failed");
				Assert.assertTrue(false);								
			}
				
		}
		catch(Exception e) {
			logger.error(e.getMessage());
			captureScreenShot(driver, "loginTest");
			Assert.fail("Login Test Failed");
			
			
		}	
			
	}

}
