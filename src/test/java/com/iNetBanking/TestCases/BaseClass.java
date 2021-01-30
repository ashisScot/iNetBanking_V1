package com.iNetBanking.TestCases;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
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

import com.iNetBanking.PageObjects.LoginPage;
import com.iNetBanking.Utils.ReadConfig;


public class BaseClass {
	ReadConfig readConfig = new ReadConfig();
	public String baseURL = readConfig.getApplicationURL();
	public String userName= readConfig.getUserName();
	public String password =readConfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String browser) {
		logger = Logger.getLogger("eBanking");
		PropertyConfigurator.configure("log4j.properties");
		
		if (browser.equals("CHROME")) {
			System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readConfig.getFireFoxPath());
			driver = new FirefoxDriver();
		} else if (browser.equals("ie")) {
			System.setProperty("webdriver.ie.driver", readConfig.getIEPath());
			driver = new InternetExplorerDriver();
		}
		
		driver.get(baseURL);
		driver.manage().window().maximize();	
		loginToApplication();

	}
	
	public void loginToApplication() {
		LoginPage  loginPage = new LoginPage(driver);
		loginPage.enterUserName(userName);
		loginPage.enterPassWord(password);
		loginPage.clickLoginBtn();
		logger.info("Logged into application");
	}
	
	public void captureScreenShot(WebDriver driver, String testName) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File("./Screenshot/"+testName+".png");
		try {
			FileUtils.copyFile(source, target);
			logger.info("Taken the ScreenShot");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("ScreenShot take functionality failed");
		}
		
		
	}
	
	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(8);
		return generatedString;
	}
	
	public String randomNumeric() {
		String generatedString = RandomStringUtils.randomNumeric(4);
		return generatedString;
	}
	
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
