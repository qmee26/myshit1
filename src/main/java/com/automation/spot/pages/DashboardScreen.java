package com.automation.spot.pages;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.automation.spot.OR.DashboardScreen_OR;
import com.automation.spot.OR.LaunchScreen_OR;


public class DashboardScreen extends BasePage{
	//	public WebElement getLoginButton(){
	//		return functionLibrary.getElement("Id,"+LaunchScreen_OR.loginButton);
	//	}


	public void tapOnMiddleLocation() throws Exception{
		functionLibrary.tapOnMiddleOfTheScreen();
	}
	public void tapOnItemLink(String itemText) throws Exception{
		List<? extends WebElement>  listOfItems =functionLibrary.getElementList("Id,"+DashboardScreen_OR.itemsLinkOnDashboard);
		Iterator<? extends WebElement> it = listOfItems.iterator();
		while(it.hasNext()){
			WebElement item = (WebElement) it.next();
			if(item.getText().equals(itemText)){
				functionLibrary.clickOnGivenElement(item);
				break;
			}
		}
	}
	public void tapOnSpecificItemLink() throws Exception {
		WebElement specificItem=functionLibrary.getElement("Id,"+DashboardScreen_OR.itemsLinkOnDashboard);
		functionLibrary.clickOnGivenElement(specificItem);
	}


	//	public boolean verifyLaunchScreen(){
	//		return functionLibrary.isElementPresent(getLoginButton())
	//				&& functionLibrary.isElementPresent(getSignUpButton());
	//	}
}