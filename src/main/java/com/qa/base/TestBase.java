package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.utils.TestUtil;

public class TestBase {

	protected static Properties prop;
	protected static  WebDriver driver;

	public TestBase() {

		prop = new Properties();
		FileInputStream inStream;
		try {
			inStream = new FileInputStream("C:\\Users\\Manu Chauhan\\eclipse-workspace\\UIAutomation"
					+ "\\src\\main\\java\\com\\qa\\config\\config.properties");

			prop.load(inStream);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Manu Chauhan\\eclipse-workspace\\UIAutomation\\src\\main\\resources\\chromedriver.exe");
			 driver = new ChromeDriver();
		}
		else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\Manu Chauhan\\eclipse-workspace\\UIAutomation\\src\\main\\resources\\geckodriver.exe");
			 driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);	
		//driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICT_WAIT, TimeUnit.SECONDS);
	//	driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		
	}

}
