package com.automation.spot.testcase;

import junit.framework.Assert;

import org.testng.annotations.Test;

public class LoginTestCase extends BaseTestCase
{

	private String emailId="prom1@dakota.com";
	private String password="abcde12345";

	@Test
	public void loginIntoApp(){
		try {
			Assert.assertTrue(launchScreen.verifyLaunchScreen());
			
			launchScreen.tapOnLoginButton();
			Assert.assertTrue(loginScreen.verifyLoginScreen());
			
			loginScreen.enterTextIntoEmailField(emailId);
			loginScreen.enterTextIntoPasswordField(password);
			loginScreen.tapOnLogin();
			Assert.assertTrue(loginScreen.getDashboardScreenSource());
			
		} catch (Exception e) {
			System.out.println("In Exception");
		}
	}

}
