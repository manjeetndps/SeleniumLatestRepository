/**
 * Author:- Manjeet Kumar
 */

package com.training.reusableservice;

import com.training.actionparser.MouseAndKeyBoardActions;
import com.training.constants.ConfigConstant;
import com.training.pagefactory.PageFactory;
import com.training.pageobjects.LoginAndCreateFolderPage;
import com.training.webdriverhelper.BaseTestSetup;
import com.training.webdriverwait.WebdriverWait;

public class LoginService extends BaseTestSetup {

	private static LoginAndCreateFolderPage loginAndCreateFolderPage;
	
	public void loginToRegOnline() {
		
		loginAndCreateFolderPage = PageFactory.getLoginAndCreateFolderPage();
		
		WebdriverWait.waitForElementPresent(loginAndCreateFolderPage.getTxtUserName());
		MouseAndKeyBoardActions.enterText(loginAndCreateFolderPage.getTxtUserName(), BaseTestSetup.configDataList.get(ConfigConstant.USERNAME).toString(), "Username text field");
		
		WebdriverWait.waitForElementPresent(loginAndCreateFolderPage.getTxtUserName());
		MouseAndKeyBoardActions.enterText(loginAndCreateFolderPage.gettxtPassword(), BaseTestSetup.configDataList.get(ConfigConstant.PASSWORD).toString(), "Password text field");
		
		WebdriverWait.waitForElementPresent(loginAndCreateFolderPage.getbtnSignIn());
		MouseAndKeyBoardActions.clickElement(loginAndCreateFolderPage.getbtnSignIn(), "Sign In");
		
		WebdriverWait.waitForElementPresent(loginAndCreateFolderPage.getEventsFolderLink());
	}
	
	public void logOut(){
		
		WebdriverWait.waitForElementPresent(loginAndCreateFolderPage.getlnkUserName());
		MouseAndKeyBoardActions.clickElement(loginAndCreateFolderPage.getlnkUserName(), "User Name Link");
		
		WebdriverWait.waitForElementPresent(loginAndCreateFolderPage.getlnkLogout());
		MouseAndKeyBoardActions.clickElement(loginAndCreateFolderPage.getlnkLogout(), "Logout Link");
	}
}
