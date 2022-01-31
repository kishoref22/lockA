package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPageElements {

	public WebDriver driver;

	public ProductsPageElements(WebDriver driver) throws IOException {
		this.driver = driver;
	}
	
	By minPriceSelect = By.cssSelector("div[class='_1YAKP4'] select[class='_2YxCDZ']"); 
	By maxPriceSelect = By.xpath("(//select[@class='_2YxCDZ'])[2]");
	
	By fAssuredCheckBox = By.xpath("//label[@class='_2iDkf8 shbqsL']//*[@class='_24_Dny _3tCU7L']");
	By internalStorageDropdown = By.xpath("//div[contains(text(),'Internal Storage')]");
	
	By internalStorageCheckBox = By.xpath("//*[@title='256 GB & Above']//*[@class='_24_Dny']");

	public WebElement getMinPriceSelect() {
		return driver.findElement(minPriceSelect);
	}

	public WebElement getMaxPriceSelect() {
		return driver.findElement(maxPriceSelect);
	}

	public WebElement getfAssuredCheckBox() {
		return driver.findElement(fAssuredCheckBox);
	}

	public WebElement getInternalStorageDropdown() {
		return driver.findElement(internalStorageDropdown);
	}

	public WebElement getInternalStorageCheckBox() {
		return driver.findElement(internalStorageCheckBox);
	}

	
	
}

