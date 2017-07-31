package com.training.testsuites;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.common.databuilder.ContextData;
import com.training.actionparser.MouseAndKeyBoardActions;
import com.training.pagefactory.PageFactory;
import com.training.pageobjects.WidgetPage;
import com.training.reusableservice.LoginService;
import com.training.waitcommands.WaitCommands;
import com.training.webdriverhelper.BaseTestSetup;
import com.training.webdriverwait.WebdriverWait;

@Listeners(com.training.reportutility.DemoListener.class)
public class MoveSliderTest extends BaseTestSetup {
	private WidgetPage widgetPage;
	private ContextData contextData;
	
	@BeforeClass()
	public void setUp(){
		
		widgetPage = PageFactory.getWidgetPage();	
	}
	
	@Test
	public void verifySliderMoved_Right(){
		
		LoginService.login();
		
		WebdriverWait.waitForElementPresent(widgetPage.getLnkWidget());
		
		MouseAndKeyBoardActions.clickElement(widgetPage.getLnkWidget(), "fieldName");
		
		WebdriverWait.waitForElementPresent(widgetPage.getLnkSlider());
		MouseAndKeyBoardActions.clickElement(widgetPage.getLnkSlider(), "fieldName");
		
		driver.switchTo().frame(0);
		
		WaitCommands.explicitWait(widgetPage.getBtnSlider());
		
		MouseAndKeyBoardActions.contextSelect(getContextData());
		
		WaitCommands.explicitWait(widgetPage.getBedrooms());
		Assert.assertEquals(widgetPage.getBedrooms().getText(), "Minimum number of bedrooms:");
			
		contextData = contextData.copyContextData();
		driver.switchTo().defaultContent();
	}
	
	private ContextData getContextData() {
		
		contextData = new ContextData();
		
		contextData.setSlider(true);
		contextData.setElement(widgetPage.getBtnSlider());
		contextData.setKey(Keys.ARROW_RIGHT);
		contextData.setnumberCount(5);
		contextData.setRelease(true);
		
		return contextData;
		
	}

}
