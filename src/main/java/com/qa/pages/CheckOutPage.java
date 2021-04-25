package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BasePage;

public class CheckOutPage extends BasePage{
	
	//PageFactory
	@FindBy(xpath="//td[@class='a-text-right aok-nowrap a-nowrap']")
	WebElement checkoutPagePrice;
	
		
	//Initializing the page object
	public CheckOutPage()
	{
		PageFactory.initElements(driver, this);
			
	}
	
	//Actions:
	//price of the item displayed in checkout page
	public String getPrice()
	{
		return checkoutPagePrice.getText();
	}

}
