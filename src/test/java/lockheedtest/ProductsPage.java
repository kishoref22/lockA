package lockheedtest;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import lockheed.Base;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.ProductsPageElements;

public class ProductsPage {
	public static Logger log = LogManager.getLogger(Base.class.getName());
	static WebDriver driver;
	LandingPage lan;
	ProductsPageElements pro;
	LoginPage login;
	Base base;
	
	
	
	

	@BeforeTest
	public void openBrowser() throws IOException {
		base = new Base();
		driver = base.initializeDriver();
		log.info("driver instance was created");
		driver.get(base.getURL());
		
      
	}

	@Test(priority = 1)
	public void Login() throws IOException, InterruptedException {
        
		base.getExtent().createTest("Login");
		login = new LoginPage(driver);
		Actions action = new Actions(driver);
		action.moveToElement(login.getEmail()).click().sendKeys(login.getEmailKey());
		action.build().perform();
		action.moveToElement(login.getPassword()).click().sendKeys(login.getPasswordKey());
		action.build().perform();
		action.moveToElement(login.submitCredentials()).click();
		action.build().perform();
		log.info("entered username and password");

	}

	@Test(priority = 3)
	public void searchForProduct() throws IOException, InterruptedException {
		base.getExtent().createTest("searchProduct");
		lan = new LandingPage(driver);
		// Stale element exception occured, put it in try block to solve it
		try {
			lan.getSearchBar().sendKeys("iphone 13 pro max");
			Thread.sleep(1000);
			lan.getSubmitSearch().click();

		} catch (StaleElementReferenceException e) {
			lan.getSearchBar().sendKeys("iphone 13 pro max");
			lan.getSubmitSearch().click();
		}

		log.info("searched for the product iphone");
		Thread.sleep(2000);

	}

	@Test(priority = 4)
	public void applyFilters() throws IOException {
		base.getExtent().createTest("applyFilters");
		pro = new ProductsPageElements(driver);
		Select select = new Select(pro.getMinPriceSelect());
		select.selectByValue("30000");
		Select select1 = new Select(pro.getMaxPriceSelect());
		select1.selectByValue("Max");
		pro.getInternalStorageDropdown().click();
		pro.getInternalStorageCheckBox().click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(pro.getfAssuredCheckBox()));
		element.click();
		log.info("applied the filters");
		// modified again

	}

	@Test(priority = 2)
	public void verifyDealsText() throws IOException {
		base.getExtent().createTest("verifyDetailsText");
		lan = new LandingPage(driver);
		String dealsText = lan.dealsOfTheDayText().getText();
		Assert.assertEquals(dealsText, "Deals of the Day");
		log.info("deals text verified");
		base.getExtent().flush();
	}

	public void getPricesOfIphones() {

	}

	@AfterTest
	public void closeBrowser() throws InterruptedException {

		Thread.sleep(2000);
		log.info("closing the browser and quit the webdriver session");
		driver.close();
		driver.quit();
		

	}
}
