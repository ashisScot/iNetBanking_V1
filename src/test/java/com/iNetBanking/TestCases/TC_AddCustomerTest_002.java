package com.iNetBanking.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.reader.ReaderException;

import com.iNetBanking.PageObjects.AddCustomerPage;
import com.iNetBanking.PageObjects.HomePage;
import com.iNetBanking.Utils.ReadExcelData;

public class TC_AddCustomerTest_002 extends BaseClass {

	@Test(dataProvider = "AddCustomerData")
	public void addCustomerTest(String customerName, String gender, String dob, String address, String city,
			String state, String pin, String mobileNum, String passWord) {
		logger.info("Open the application url");

		try {
			HomePage home = new HomePage(driver);
			AddCustomerPage addCustomer = new AddCustomerPage(driver);
			home.clickNewCustomer();
			logger.info("Navigating to the Add Customer Page");
			addCustomer.enterCustomerName(customerName);
			addCustomer.selectGender(gender);
			addCustomer.enterDateOfBirth(dob);
			addCustomer.enterAddress(address);
			addCustomer.enterCity(city);
			Thread.sleep(3000);
			addCustomer.enterState(state);
			Thread.sleep(3000);
			addCustomer.enterPIN(pin);
			Thread.sleep(3000);
			addCustomer.enterMobile(mobileNum);
			Thread.sleep(3000);
			String email = randomString()+randomNumeric()+"@gmail.com";
			addCustomer.enterEmail(email);
			Thread.sleep(3000);
			addCustomer.enterPassWord(password);
			addCustomer.clickOnSubmit();
			Thread.sleep(3000);
			
			if(addCustomer.verifyCustomerSuccesMsgDisplayed()) {
				logger.info("Customer Add Successful");
				captureScreenShot(driver, "addCustomerTest");
				Assert.assertTrue(true);
			}
			 else {
				captureScreenShot(driver, "addCustomerTest");
				logger.error("Add Customer test Failed");
				Assert.assertTrue(false);
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			captureScreenShot(driver, "addCustomerTest");
			Assert.fail("Add Customer Test Failed");

		}

	}
	
	@DataProvider(name = "AddCustomerData")
	 String[][] getDataFromExcel() throws IOException {
		String data[][] = ReadExcelData.getTestData("AddCustomer");
		return data;
	}

}
