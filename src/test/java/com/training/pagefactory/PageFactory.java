/**
 * Author:- Manjeet Kumar
 */

package com.training.pagefactory;

import com.training.pageobjects.AttendeeProfilePage;
import com.training.pageobjects.CheckOutPage;
import com.training.pageobjects.CreateEventPage;
import com.training.pageobjects.CreateRegistrationPage;
import com.training.pageobjects.LoginAndCreateFolderPage;

public class PageFactory {
	
	public static LoginAndCreateFolderPage getLoginAndCreateFolderPage(){
		return new LoginAndCreateFolderPage();
	}
	
	public static CreateEventPage getCreateEventPage(){
		return new CreateEventPage();
	}
	
	public static CreateRegistrationPage getCreateRegistrationPage(){
		return new CreateRegistrationPage();
	}
	
	public static CheckOutPage getCheckOutPage(){
		return new CheckOutPage();
	}
	
	public static AttendeeProfilePage getAttendeeProfilePage(){
		return new AttendeeProfilePage();
	}
}
