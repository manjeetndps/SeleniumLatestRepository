package com.training.waitcommands;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.training.webdriverhelper.DriverUtility;

public class WaitCommands extends DriverUtility {

	private static WebDriverWait driverWait;
	
	public static void fluentWait() {
		driverWait = (WebDriverWait) new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(Exception.class);
	}

	public static void explicitWait(WebElement element) {

		driverWait = new WebDriverWait(driver, 30);
		driverWait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public static void webDriverWaitFor(long timeUnit) {
		
		if (timeUnit > 30 ) {
			setDriverWait(new WebDriverWait(driver, timeUnit));
		} else {
			setDriverWait(new WebDriverWait(driver, 30));
		}
	}

	public WebDriverWait getDriverWait() {
		return driverWait;
	}

	public static void setDriverWait(WebDriverWait driverWaitFor) {
		driverWait = driverWaitFor;
	}
}

