package lockheedtest;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lockheed.Base;
import pageObjects.LandingPage;
import pageObjects.LoginPage;


@Test(groups = { "HomePage" })
public class HomePage extends Base {

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());

	public HomePage() throws IOException {
		super();

	}

	@BeforeTest
	public void openBrowser() throws IOException {
		Base base = new Base();
		driver = base.initializeDriver();
		log.info("driver instance was created");

		driver.get(base.getURL());

		// this is develop branch
	}

	
	
	
	@Test(dataProvider = "getData" , enabled = false)
	public void clickLogin(String username, String password) throws IOException, InterruptedException {
		LoginPage login = new LoginPage(driver);
		
		login.getEmail().sendKeys(username);
		login.getPassword().click();
		login.getPassword().sendKeys(password);
		
		login.submitCredentials().click();
		log.info("clicked on log in submit button");

		
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] obj = new Object[2][2];

		obj[0][0] = "restricted user mail";
		obj[0][1] = "restricted user password";

		obj[1][0] = "just4kishoref22@gmail.com";
		obj[1][1] = "Kishore@@987flip:;";

		return obj;

	}

	@Test(enabled = true)
	public void checkForProductsBar() throws IOException {

		LandingPage lan = new LandingPage(driver);
		Assert.assertTrue(lan.getProductsBar().isDisplayed());
		log.info("products bar is displayed");

	} // div[@class='_1kidPb'] //span[contains(text(),'Electronics')]

	@AfterTest
	public void closeBrowser() throws InterruptedException {

		Thread.sleep(2000);
		driver.close();
		driver.quit();
		log.info("closing the browser and quit the webdriver session");

	}

}
