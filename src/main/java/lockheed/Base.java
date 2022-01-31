package lockheed;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		String path = "F:\\eclipse_workspace\\lockheed\\resources\\data.properties";
		FileInputStream fis = new FileInputStream(path);
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "F:\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browserName.equals("opera")) {
			System.setProperty("webdriver.opera.driver", "F:\\drivers\\operadriver.exe");
			driver = new OperaDriver();

		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		return driver;

	}

	public String getURL() {

		return prop.getProperty("url");
	}

	public void takeScreenShot(String testCaseName, WebDriver driver) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinAddress = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinAddress));

	}

	public ExtentReports getExtent() {

		// ExtentReports, ExtentSparkReporter
		String path = System.getProperty("user.dir") +"\\reports\\index.html";
		ExtentSparkReporter esp = new ExtentSparkReporter(path);
		esp.config().setReportName("Flipkart automation result");
		esp.config().setDocumentTitle("Test results");

		ExtentReports er = new ExtentReports();
		er.attachReporter(esp);
		er.setSystemInfo("Tester", "kishore");
		return er;

	}

}
