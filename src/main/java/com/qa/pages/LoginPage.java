package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BasePage;

public class LoginPage extends BasePage {
	

	//PageFactory
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement loginBtn;
	

	//Initializing the page object
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	
	public HomePage login(String un,String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}

	/*
	 * public LoginPage clickOnContinue(String property) { // TODO Auto-generated
	 * method stub return null; }
	 */

}
