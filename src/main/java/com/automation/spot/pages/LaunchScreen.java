package com.automation.spot.pages;
import org.openqa.selenium.WebElement;

import com.automation.spot.OR.LaunchScreen_OR;


public class LaunchScreen extends BasePage{
	
	public void tapOnLoginButton() throws Exception{
		WebElement element=functionLibrary.getElement("Id:"+LaunchScreen_OR.loginButton);
		functionLibrary.clickOnGivenElement(element);
	}
	
	public void verifyLaunchScreen(){
		
	}
}