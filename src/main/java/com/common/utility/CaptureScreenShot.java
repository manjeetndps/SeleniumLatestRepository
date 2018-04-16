/**
 * Author:- Manjeet Kumar
 */

package com.common.utility;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.training.constants.ConfigConstant;
import com.training.fileparser.FileSystemUtils;
import com.training.webdriverhelper.BaseTestSetup;

public class CaptureScreenShot extends BaseTestSetup {

	private static Logger logger = LoggerFactory.getLogger(CaptureScreenShot.class);

	public static RandomDataGeneration randomDataGeneration;
	public static String strScreenshotName;

	public static String getScreenShotFilePath(String appName, String testName) {

		configDataList = readConfigData();
		randomDataGeneration = new RandomDataGeneration();
		String today = randomDataGeneration.getToDayDate();
		String scrShotFolder = randomDataGeneration.getDateAndTime();
		String name= ".\\ScreenShots";
		FileSystemUtils.createDir(name);
		
		if (testName.equalsIgnoreCase(configDataList.get(ConfigConstant.TESTTYPE).toString())) {
			name = name + "\\" + testName;
		} else {
			name = name + "\\" + appName;
		}
		
		FileSystemUtils.createDir(name);

		name = name + "\\" + today;
		FileSystemUtils.createDir(name);

		name = name + "\\" + scrShotFolder;
		FileSystemUtils.createDir(name);

		return strScreenshotName = name + "\\" + appName + "_" + testName + "_" + scrShotFolder + ".png";
	}

	public static String takeScreenShot(String appName, String testName) {

		try {
			strScreenshotName = getScreenShotFilePath(appName, testName);

			File screenShotFileType = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			File screenshotFile = new File(strScreenshotName);

			FileUtils.copyFile(screenShotFileType, screenshotFile);

			strScreenshotName = screenshotFile.getCanonicalPath();
			logger.info("Screenshot Path ::" + strScreenshotName);
		} catch (Exception e) {
			logger.info("Error Occured while taking the Screenshot... " + e.getMessage());
			Assert.fail("Error Occured while taking the Screenshot... " + e.getMessage());
		}

		return strScreenshotName;
	}

	public static void capturePrtScn_Screenshot() throws Exception {
		Robot robot = new Robot();
		configDataList = readConfigData();

		strScreenshotName = getScreenShotFilePath(configDataList.get(ConfigConstant.APPNAME).toString(),
				configDataList.get(ConfigConstant.TESTTYPE).toString());

		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
		ImageIO.write(screenFullImage, "png", new File(strScreenshotName));

		System.out.println("A full screenshot saved! at " + strScreenshotName);
	}

	public static void capturePrtScn_Screenshot_KeyPress() throws Exception {

		Robot robot = new Robot();
		configDataList = readConfigData();
		robot.keyPress(KeyEvent.VK_PRINTSCREEN);
		robot.keyRelease(KeyEvent.VK_PRINTSCREEN);

		Thread.sleep(15000);

		strScreenshotName = getScreenShotFilePath(configDataList.get(ConfigConstant.APPNAME).toString(),
				configDataList.get(ConfigConstant.TESTTYPE).toString());

		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

		BufferedImage image = (BufferedImage) clipboard.getData(DataFlavor.imageFlavor);

		ImageIO.write(image, "png", new File(strScreenshotName));

		System.out.println("A full screenshot saved! at " + strScreenshotName);
	}
}
