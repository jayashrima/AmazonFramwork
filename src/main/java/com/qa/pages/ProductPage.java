package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BasePage;

public class ProductPage extends BasePage{
	
	       //PageFactory 

			//@FindBy(id="newBuyBoxPrice")
			@FindBy(xpath="//*[@id=\"newBuyBoxPrice\"]")
			WebElement productPagePrice;
			
			@FindBy(id="add-to-cart-button")
			WebElement addToCartBtn;
				
			//Initializing the page object
			public ProductPage()
			{
				PageFactory.initElements(driver, this);
					
			}
			
			//Actions:
			//price displayed in the product page
			public String getPrice()
			{
				return productPagePrice.getText();
			}
			
			
			//click Add to cart button and returns the object of the the page that follows the button click
			public ProceedToCheckoutPage addToCartBtnClick()
			{
				addToCartBtn.click();
				return new ProceedToCheckoutPage();
			}
			
		


}
