package com.automation.spot.testcase;

import org.testng.annotations.Test;

public class MapDetailsTestCase extends BaseTestCase
{

	@Test
	public void verifyMapDetailsScreen(){
		try {
			loginIntoApp(emailId, password);
			//tap on center of screen, will change the logic later on
			dashboardScreen.tapOnMiddleLocation();
			//swipe up on details link
			
			//verify elements
			
		} catch (Exception e) {
			System.out.println("In Exception");
		}
	}

}
