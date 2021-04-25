package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.base.BasePage;
import com.qa.pages.CheckOutPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.ProceedToCheckoutPage;
import com.qa.pages.ProductPage;
import com.qa.pages.ResultsPage;


public class CheckOutPageTest extends BasePage {
	   
		
	HomePage homepage;
	ResultsPage resultspage;
	ProductPage productpage;
	ProceedToCheckoutPage proceedtocheckoutpage;
	LoginPage loginPage ;
	CheckOutPage checkoutpage;
	
	//Initializes browser and url properties
	public CheckOutPageTest()
	{
		super();
	}
	
	
	@BeforeTest
	public void setup()
	{
		initialization();
		homepage = new HomePage();
		searchAndClick();
		
	}
	//Actions:
	public void searchAndClick()
	{
		resultspage = homepage.searchBox(prop.getProperty("searchItem"));
		productpage = resultspage.firstSearchResultClick();
	}
	
	//function to Initialize proceedToCheckoutPage object
	public void proceedToCheckOut()
	{
		proceedtocheckoutpage = productpage.addToCartBtnClick();
	}
	
	private void navigateToCheckoutPage() {
		loginPage = proceedtocheckoutpage.clickOnProceedToCheckout();
		
		
	}

	//This method asserts the price in product page with that of results page
	@Test(priority=1)
	public void validateProductPagePrice()
	{
		Assert.assertEquals(productpage.getPrice(), ResultsPage.price);
		proceedToCheckOut();
		
	}
	
	
	//This method asserts the price in ProceedTocheckout page with that of results page
	@Test(priority =2)
	public void validateProceedToCheckoutPagePrice()
	{
		Assert.assertEquals(proceedtocheckoutpage.getPrice(), ResultsPage.price);
		navigateToCheckoutPage();
	}



	//This method asserts the price in Checkout page with that of results page
	@Test(priority=3)
	public void validateCheckoutPagePrice()
	{
		Assert.assertEquals(ResultsPage.price, checkoutpage.getPrice() );
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
	
}
