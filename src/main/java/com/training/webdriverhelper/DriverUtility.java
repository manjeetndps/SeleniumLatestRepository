/**
 * Author:- Manjeet Kumar
 */

package com.training.webdriverhelper;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.log4testng.Logger;

public class DriverUtility {

	private static org.slf4j.Logger logger = LoggerFactory.getLogger(DriverUtility.class);

	public static WebDriver driver;
	private static DesiredCapabilities dc;

	public static WebDriver browserLanch(String browserType, String appURL) {

		try {

			switch (browserType) {
			case "FF":
				driver = new FirefoxDriver();

				logger.info("Launching new instance of firefox web driver.");
				break;

			case "FirefoxLatest":
				File firefoxDriver = new File("./lib/geckodriver.exe");
				System.setProperty("webdriver.firefox.marionette", firefoxDriver.getAbsolutePath());
				System.setProperty("webdriver.gecko.driver", firefoxDriver.getAbsolutePath());
				dc = DesiredCapabilities.firefox();
				dc.setCapability("marionette", true);
				dc.setBrowserName("firefox");
				driver = new FirefoxDriver(dc);

				logger.info("Launching new instance of firefox(Gecko) web driver.");
				break;

			case "GC":

				File chromeDriver = new File("./lib/chromedriver.exe");
				System.setProperty("webdriver.chrome.driver", chromeDriver.getAbsolutePath());

				dc = DesiredCapabilities.chrome();
				ChromeOptions options = new ChromeOptions();
				options.addArguments(new String[] { "test-type" });
				options.addArguments(new String[] { "disable-extensions" });
				dc.setCapability(ChromeOptions.CAPABILITY, options);
				driver = new ChromeDriver(dc);

				logger.info("Launching new instance of google chrome web driver.");
				break;

			case "IE":

				File ieDriver = new File("./lib/IEDriverServer.exe");
				System.setProperty("webdriver.ie.driver", ieDriver.getAbsolutePath());
				dc = DesiredCapabilities.internetExplorer();
				dc.setCapability("requireWindowFocus", true);
				driver = new InternetExplorerDriver(dc);

				logger.info("Launching new instance of internet explorer web driver.");
				break;

			case "HTMLUnit":

				dc = new DesiredCapabilities();
				dc.setBrowserName("htmlunit");
				driver = new HtmlUnitDriver();

				logger.info("Launching new instance of HTML unit web driver.");
				break;

			}

			driver.manage().window().maximize();
			driver.get(appURL);
		} catch (Exception ex) {
			Assert.fail("Error occured while lanching the Browser ::" + browserType + " ::" + ex.getMessage());
		}

		return driver;

	}

	public static WebDriver getWebDriver() {
		return driver;
	}
}
