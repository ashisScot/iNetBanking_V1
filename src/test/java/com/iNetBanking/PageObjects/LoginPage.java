package com.iNetBanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how= How.NAME, using="uid")
	private WebElement userNameTxt;

	@FindBy(how=How.NAME, using = "password")
	private WebElement passwordTxt;
	
	@FindBy(how=How.NAME, using = "btnLogin")
	private WebElement loginBtn;
	
	
	public void enterUserName(String userName) {
		userNameTxt.sendKeys(userName);
	}
	
	public void enterPassWord(String password) {
		passwordTxt.sendKeys(password);
	}
	
	public void clickLoginBtn() {
		loginBtn.click();
	}

}
