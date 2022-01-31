package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	protected WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By login = By.xpath("//a[contains(text(),'Login')]");
	By email = By.xpath("//input[@type='text'][contains(@class,'_2IX_2- VJZDxU')]");
	By password = By.xpath("//input[@type='password']");
	By loginSubmit = By.xpath("//*[@autocomplete='on'] //*[@type='submit']");
	
	
	
	String emailKey = "just4kishoref22@gmail.com";
	String passwordKey = "Kishore@@987flip:;";
	
	
	public WebElement getLogin() {
		return driver.findElement(login);
	}


	public WebElement getEmail() {

		return driver.findElement(email);

	}

	public WebElement getPassword() {

		return driver.findElement(password);

	}

	public WebElement submitCredentials() {

		return driver.findElement(loginSubmit);

	}


	public String getEmailKey() {
		return emailKey;
	}


	public String getPasswordKey() {
		return passwordKey;
	}



	

}
