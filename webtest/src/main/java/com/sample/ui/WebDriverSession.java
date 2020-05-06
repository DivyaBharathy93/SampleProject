package com.sample.ui;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class WebDriverSession {

	static Properties prop;
	static WebDriver driver;
	
	/**
	 * Purpose: Loading the Property file using constructor
	 * author: d.b.bakthavachalam
	 */
	
	public WebDriverSession(){
		try {
			
			FileInputStream fis=new FileInputStream("C:\\Users\\Lenovo\\git repo\\webtest\\src\\main\\java\\com\\sample\\resources\\environment.properties");
			prop=new Properties();
			prop.load(fis);
			fis.close();
		}catch(Exception e) {
			System.out.println("Property File doesn't exists");
		}
		
	}
	
	
	/**
	 * Purpose: Providing the instance of WebDriver method, based on browsers.
	 * author: d.b.bakthavachalam
	 */
	
	public static void getDriverInstance()
	{
		if (prop.getProperty("Browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C://Users//Lenovo//git repo//Driver//chromedriver_win32//chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("window-size=1400,1800");
			options.addArguments("headless");
			//options.setHeadless(true);
//			options.setPageLoadStrategy(PageLoadStrategy.NONE);
			driver = new ChromeDriver(options);
//			driver = new ChromeDriver();
		} else if (prop.getProperty("Browser").equalsIgnoreCase("FireFox")) {
			System.setProperty("webdriver.gecko.driver", "C://Users//Lenovo//git repo//Driver//geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(prop.getProperty("Browser").equalsIgnoreCase("htmlunitdriver")) {
			System.setProperty("webdriver.chrome.driver",
					"C://Users//Lenovo//git repo//Driver//chromedriver_win32//chromedriver.exe");
			driver=new HtmlUnitDriver();
		}
		else {
			System.err.print("Please specify correct Browser to be Tested");
		}
	}
	
	public static WebDriver getDriver() {
		if (driver == null) {
			getDriverInstance();
			return driver;
		}else {
			return driver;
		}
	}
	
	public void navigateBrowser() {
		driver.manage().deleteAllCookies();
		if (!prop.getProperty("URL").isEmpty()) {
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(prop.getProperty("URL"));
		} else {
			System.out.println("Please enter a URL");
		}

	}
	
	public void closeBrowser() {
		driver.quit();
	}
	
	
}
