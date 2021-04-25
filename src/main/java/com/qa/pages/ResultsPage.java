package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BasePage;

public class ResultsPage extends BasePage{
	
public static String price;
	
	//PageFactory

	@FindBy(xpath="//*[@id=\"search\"]/div[1]/div/div[1]/div/span[3]/div[2]/div[2]")
	WebElement firstSearchResult;
	
	@FindBy(xpath="//span[@class='a-price-whole']")
	WebElement priceWhole;
	
	
	@FindBy(xpath="//span[@class='a-price-fraction']")
	WebElement priceFraction;
		
	//Initializing the page object
		
	public ResultsPage()
	{
		PageFactory.initElements(driver, this);
		price = getPrice();
			
	}
	
	//Actions:
	//extracts price of the first Product from the results page
	public String getPrice()
	{
		String wholePrice = priceWhole.getText();
		String fractionPrice = priceFraction.getText();
		String price = (new StringBuilder()).append("$").append(wholePrice).append(".").append(fractionPrice).toString();
		return price;
	}
	
	//clicks on first search result and returns the object of ProductPage
	public ProductPage firstSearchResultClick()
	{
		firstSearchResult.click();
		return new ProductPage();
	}



}
