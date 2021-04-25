package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BasePage;

public class ProceedToCheckoutPage extends BasePage {
	
	//PageFactory
	@FindBy(xpath="//span[@class='a-color-price hlb-price a-inline-block a-text-bold']")
	WebElement proceedToCheckoutPagePrice;
	
	@FindBy(id="hlb-ptc-btn-native")
	WebElement checkoutBtn;
		
	//Initializing the page object
	public ProceedToCheckoutPage()
	{
		PageFactory.initElements(driver, this);
			
	}
	
	public String getPrice()
	{
		return proceedToCheckoutPagePrice.getText();
	}
	
	
	public LoginPage clickOnProceedToCheckout()
	{
		 checkoutBtn.click();
		 return new LoginPage();
	}

}
