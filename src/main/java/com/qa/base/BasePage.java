package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Utils.Utilities;



public class BasePage {

	public	static WebDriver driver;
	public	static Properties prop;
	
		public BasePage() {
			
			try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\jayas\\Documents\\eclips-workspace\\AmazonPOMProject\\src\\main\\java\\com\\qa\\config\\config.properties");
			prop.load(ip);
	    	} catch(FileNotFoundException e) {
			e.printStackTrace();
	      	}catch (IOException e) {
			e.printStackTrace();
		}
	}

		public static void initialization() {
			
			String browserName = prop.getProperty("browser");
			
			if(browserName.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver","C:\\Users\\jayas\\Documents\\eclips-workspace\\AmazonPOMProject\\Resources\\chromedriver.exe");
				driver = new ChromeDriver();
				
			}else if(browserName.equals("FF")) {
				System.setProperty("webdriver.gecko.driver","C:\\Users\\jayas\\Documents\\eclips-workspace\\AmazonPOMProject\\Resources\\gecodriver.exe");
				driver = new FirefoxDriver();
		}
				
	
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Utilities.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Utilities.IMPLICIT_WAIT,TimeUnit.SECONDS);
			
			driver.get(prop.getProperty("url"));			
		}		


}
