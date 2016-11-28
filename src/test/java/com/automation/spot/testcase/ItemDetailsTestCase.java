package com.automation.spot.testcase;

import org.testng.annotations.Test;

public class ItemDetailsTestCase extends BaseTestCase
{

	@Test
	public void verifyItemDetailsScreen(){
		try {
			loginIntoApp(emailId, password);
			//tap on center of screen, will change the logic later on
			dashboardScreen.tapOnMiddleLocation();
			//tap up on Item link
			dashboardScreen.tapOnItemLink("AUTOMATION");
			
			dashboardScreen.tapOnSpecificItemLink();

			itemsScreen.tapOnDetailsLink();
			
			//verification part for details
			
		} catch (Exception e) {
			System.out.println("In Exception");
		}
	}

}
