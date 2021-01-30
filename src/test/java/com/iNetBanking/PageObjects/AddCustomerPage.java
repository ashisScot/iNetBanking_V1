package com.iNetBanking.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
 WebDriver driver;
 
 public AddCustomerPage(WebDriver driver) {
	 this.driver = driver;
	 PageFactory.initElements(driver, this);
 }
 
 @FindBy(how = How.NAME, using ="name")
 private WebElement customerName;
 
 private String genderXpath = "//input[@type = 'radio' and @value='*']" ;
 
 @FindBy(how = How.ID, using ="dob")
 private WebElement dateOfBirth;
 
 @FindBy(how = How.NAME, using ="addr")
 private WebElement address;
 
 @FindBy(how = How.NAME, using ="city")
 private WebElement city;
 
 @FindBy(how = How.NAME, using ="state")
 private WebElement state;
 
 @FindBy(how = How.NAME, using ="pinno")
 private WebElement pinNo;
 
 @FindBy(how = How.NAME, using ="telephoneno")
 private WebElement telePhoneNo;
 
 @FindBy(how = How.NAME, using ="emailid")
 private WebElement emailId;
 
 @FindBy(how = How.NAME, using ="password")
 private WebElement password;
 
 @FindBy(how = How.NAME, using ="sub")
 private WebElement submit;
 
 @FindBy(how = How.XPATH, using = "//*[text()='Customer Registered Successfully!!!']")
 private WebElement addCustomerSuccessMsg;
  
 
 private WebElement gender;
 
 public void enterCustomerName(String name) {
	 customerName.sendKeys(name);
 }
 
 public void selectGender(String value) {
	 if(value.equals("Male")) {
		 genderXpath =  genderXpath.replace("*", "m");
	 }
	 else if(value.equals("Female"))
		 genderXpath = genderXpath.replace("*", "f");
	 gender = driver.findElement(By.xpath(genderXpath));
	 gender.click();		 
 }
 
 public void enterDateOfBirth(String dob) {
	 dateOfBirth.sendKeys(dob);
	// dateOfBirth.sendKeys(date);
	 //dateOfBirth.sendKeys(year);
 }
 
 public void enterAddress(String addressValue) {
	 address.sendKeys(addressValue);
 }
 
 public void enterCity(String cityValue) {
	 city.sendKeys(cityValue);
 }
 
 public void enterState(String stateValue) {
	 state.sendKeys(stateValue);
 }
 
 public void enterPIN(String pin) {
	 pinNo.sendKeys(pin);
 }
 
 public void enterMobile(String mobileValue) {
	 telePhoneNo.sendKeys(mobileValue);
 }
 
 public void enterEmail(String emailID) {
	 emailId.sendKeys(emailID);
 }
 
 public void enterPassWord(String customPass) {
	 password.sendKeys(customPass);
 }
 
 public void clickOnSubmit() {
	 submit.click();
 }
 
 public boolean verifyCustomerSuccesMsgDisplayed() {
	 return addCustomerSuccessMsg.isDisplayed();
 }
 


 
 

}
