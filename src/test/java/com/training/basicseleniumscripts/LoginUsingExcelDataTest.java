package com.training.basicseleniumscripts;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.training.constants.ConfigConstant;
import com.training.fileparser.ExcelFileReader;
import com.training.webdriverhelper.BaseTestSetup;

@Listeners(com.training.reportutility.DemoListener.class)
public class LoginUsingExcelDataTest extends BaseTestSetup {

	public static Map<String, String> columnData = new HashMap<String,String>();;
	public static Map<String, Map<String,String>> excelDataSet = new HashMap<String, Map<String,String>>();

	@BeforeClass
	public void setup() {

		excelDataSet = ExcelFileReader.readTestData(configDataList.get(ConfigConstant.TESTDATAPATH).toString(),
				configDataList.get(ConfigConstant.TESTDATASHEETNAME).toString());
		
	}

	@Test
	public void loginUsingExcelData() throws InterruptedException {

		for (int i = 0; i <= excelDataSet.size(); i++) {
			if (excelDataSet.get("Row" + i) != null) {
				columnData = excelDataSet.get("Row" + i);

				login(columnData.get("UserName"), columnData.get("Password"));
			}
		}
	}

	/**
	 * Login Method
	 * 
	 * @throws InterruptedException
	 */
	private void login(String UserName, String password) throws InterruptedException {

		driver.findElement(By.xpath("//a[contains(text(),\"Signin\")]")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[text()=\"Signup\"]/../../../../fieldset/input[@name='username']"))
				.sendKeys(UserName);
		driver.findElement(By.cssSelector("#login>form>fieldset:nth-of-type(2)>input[type$=\"password\"]"))
				.sendKeys(password);

		driver.findElement(By.xpath("//a[text()=\"Signup\"]/../../../../div/div/input[@value=\"Submit\"]")).click();
		Thread.sleep(3000);
	}
}
