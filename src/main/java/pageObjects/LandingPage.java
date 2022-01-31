package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import lockheed.Base;

public class LandingPage extends Base {

	public WebDriver driver;

	public LandingPage(WebDriver driver) throws IOException {
		this.driver = driver;
	}
	
	
	
	

	By login = By.cssSelector("a[href*='login']");
	By productsBar = By.cssSelector("_37M3Pb");
	By searchBar = By.xpath("//input[@class='_3704LK']");
	By submitSearch = By.cssSelector("button[type='submit']");
	By closePopUp = By.cssSelector("._2KpZ6l._2doB4z");
	By dealsOfTheDay = By.cssSelector("div[class='_1AtVbE'] "
			+ "div[class='_3E8aIl KdL3Vb'] div[class='_2N81D7'] div h2[class='_2cAig-']");
	
	
	// div[class='_3E8aIl KdL3Vb'] div[class='_2N81D7'] h2[class='_2cAig-']
	// div[class='_1AtVbE'] div[class='_3E8aIl KdL3Vb'] div[class='_2N81D7'] div h2[class='_2cAig-']

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getLogin() {
		return driver.findElement(login);
	}

	public WebElement getProductsBar() {
		return driver.findElement(productsBar);
	}

	public WebElement getSearchBar() {
		return driver.findElement(searchBar);
	}

	public WebElement getSubmitSearch() {
		return driver.findElement(submitSearch);
	}

	public WebElement getClosePopUp() {
		return driver.findElement(closePopUp);
	}

	public WebElement dealsOfTheDayText() {
		return driver.findElement(dealsOfTheDay);
	}
	
	
	

}
