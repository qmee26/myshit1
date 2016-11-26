package com.automation.spot.pages;
import org.openqa.selenium.WebElement;

import com.automation.spot.OR.LaunchScreen_OR;


public class DashboardScreen extends BasePage{
//	public WebElement getLoginButton(){
//		return functionLibrary.getElement("Id,"+LaunchScreen_OR.loginButton);
//	}

	
	public void tapOnMiddleLocation() throws Exception{
		functionLibrary.tapOnMiddleOfTheScreen();
	}
	
//	public boolean verifyLaunchScreen(){
//		return functionLibrary.isElementPresent(getLoginButton())
//				&& functionLibrary.isElementPresent(getSignUpButton());
//	}
}