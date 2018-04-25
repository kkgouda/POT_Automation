package com.frameworkUtil;

import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverUtil {

	static org.openqa.selenium.WebDriver driver;

	public WebDriverUtil(String webDriver) {
		switch (webDriver) {

		case "chrome":

			System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
			
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("window-size=1400,800");
//			options.addArguments("headless");
			
			driver = new org.openqa.selenium.chrome.ChromeDriver();   //need to write in chrome driver "options"

		}

	}

	public WebDriverUtil() {
		// TODO Auto-generated constructor stub
	}

	public org.openqa.selenium.WebDriver getWebDriver(String url) {
		driver.get(url);
		return driver;
	}
	
	public org.openqa.selenium.WebDriver getWebDriver() {
		return driver;
	}

}
