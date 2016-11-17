package com.automation.spot.testcase;

import org.testng.annotations.Test;

public class LoginTestCase extends BaseTestCase
{

	@Test
	public void loginIntoApp(){
		try {
			launchScreen.tapOnLoginButton();
			//verify login screen
			
			
		} catch (Exception e) {
			System.out.println("In Exception");
		}
	}

}
