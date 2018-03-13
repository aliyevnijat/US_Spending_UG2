package com.us_spending.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {
	
	private static WebDriver driver;

	public static WebDriver getDriver(String browser) {

		String driverType = browser == null ? Configuration.getProperty("browser") : browser;
		if (driver == null) {
			switch (driverType.toLowerCase()) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver", Configuration.getProperty("chromedriver"));
				driver = new ChromeDriver();
				break;
			case "firefox":
				System.setProperty("webdriver.gecko.driver", Configuration.getProperty("geckodriver"));
				driver = new FirefoxDriver();
				break;
			case "ie":
				break;
			case "safari":
				driver = new SafariDriver();
				break;
			case "edge":

				break;
			}
		}
		return driver;
	}

	public static void quit() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

}
