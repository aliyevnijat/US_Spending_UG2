package com.us_spending.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class TestBaseClass {
	protected WebDriver driver;

	@Parameters("browser")
	@BeforeClass(alwaysRun=true)
	public void setUp(@Optional String browser) {
		driver = Driver.getDriver(browser);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Configuration.getProperty("url"));
	}
	
	@AfterClass(alwaysRun=true)
	public void tearDown() {
		Driver.quit();
	}
	
	

}
