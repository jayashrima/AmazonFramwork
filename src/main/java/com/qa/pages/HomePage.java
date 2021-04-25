package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BasePage;

public class HomePage  extends BasePage {
	
	//PageFactory
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	 WebElement searchBox;
	
	@FindBy(xpath="//input[@id='nav-search-submit-button']")
	 WebElement searchBtn;
	
	@FindBy(xpath="//span[@id='newBuyBoxPrice']")
	 WebElement priceBeforeAddToCart;
	
	
	//body/div[@id='a-page']/div[4]//form[1]/div/span[1] second price
	
	//Initializing the object
	public HomePage() {
		PageFactory.initElements(driver,this);
	}
	
	//Actions:
	public ResultsPage searchBox(String searchItem)
	{
		searchBox.sendKeys(searchItem);
		searchBtn.click();
		return new ResultsPage();
		
	}

	
	
	


	
	
	}


	

