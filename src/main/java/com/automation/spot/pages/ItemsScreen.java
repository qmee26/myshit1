package com.automation.spot.pages;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.automation.spot.OR.DashboardScreen_OR;
import com.automation.spot.OR.ItemsScreen_OR;
import com.automation.spot.OR.LaunchScreen_OR;


public class ItemsScreen extends BasePage{
	//	public WebElement getLoginButton(){
	//		return functionLibrary.getElement("Id,"+LaunchScreen_OR.loginButton);
	//	}

	public void tapOnDetailsLink() throws Exception {
		WebElement details = functionLibrary.getElement("Id,"+ItemsScreen_OR.detailsLinkOnBottom);
		functionLibrary.clickOnGivenElement(details);
	}


	//	public boolean verifyLaunchScreen(){
	//		return functionLibrary.isElementPresent(getLoginButton())
	//				&& functionLibrary.isElementPresent(getSignUpButton());
	//	}
}