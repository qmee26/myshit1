package com.automation.spot.pages;
import org.openqa.selenium.WebElement;

import com.automation.spot.OR.LaunchScreen_OR;


public class LaunchScreen extends BasePage{
	public WebElement getLoginButton(){
		return functionLibrary.getElement("Id,"+LaunchScreen_OR.loginButton);
	}
	
	public WebElement getSignUpButton(){
		return functionLibrary.getElement("Id,"+LaunchScreen_OR.signupButton);
	}
	
	public void tapOnLoginButton() throws Exception{
		functionLibrary.clickOnGivenElement(getLoginButton());
	}
	
	public boolean verifyLaunchScreen(){
		return functionLibrary.isElementPresent(getLoginButton())
				&& functionLibrary.isElementPresent(getSignUpButton());
	}
}