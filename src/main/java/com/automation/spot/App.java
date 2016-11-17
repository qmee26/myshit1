package com.automation.spot;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class App 
{
	public static AppiumDriver<? extends WebElement> driver;
	private static AppiumDriverLocalService serviceClient;

	public static void main( String[] args ) throws MalformedURLException
	{
		startAppium();
		System.out.println( "Starting suite" );
		String deviceName="Android Emulator";
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4725/wd/hub"), setCapabilities(deviceName));
		System.out.println( "Driver is started successfully.." );
		waitTime(10000);
		//-----Perform some action on App

		driver.findElement(By.id("com.verizon.npd.spot:id/button_account_login")).click();
		

		//-----End Actions on App
		System.out.println( "Closing the app" );
		closeApp();
		System.out.println( "App is closed now" );
		
		serviceClient.stop();
	}
	public static DesiredCapabilities setCapabilities(String deviceName){
		String apkName="Spot.apk";
		String appPackage="com.verizon.npd.spot";
		String appActivity="com.verizon.npd.spot.views.ItemsActivity";
		DesiredCapabilities capabilities = null;
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "\\testdata\\apk");
		File app = new File(appDir, apkName);
		switch(deviceName){
		case "Android Emulator":
			capabilities = new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android"); 
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0.0");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
			capabilities.setCapability("locale", "US");
			capabilities.setCapability("deviceReadyTimeout", "450");  //Timeout in seconds while waiting for device to become ready
			capabilities.setCapability("newCommandTimeout", "600000");		
			capabilities.setCapability("app", app.getAbsolutePath());
			capabilities.setCapability("appPackage", appPackage);
			capabilities.setCapability("appActivity", appActivity);
			break;
		}
		return capabilities;
	}

	public static void closeApp(){
		driver.closeApp();
	}
	public void resetApp(){
		driver.resetApp();
		waitTime(5000);
	}
	public static void waitTime(long time){
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void startAppium() {
		String osName = System.getProperty("os.name").toLowerCase();

		String nodePath = null;
		String appiumPath = null;

		if (osName.contains("mac")) {
			//            mac path
			nodePath = "/usr/local/bin/node";
			appiumPath = "/usr/local/lib/node_modules/appium/build/lib/main.js";
		} else if (osName.contains("linux")) {
			//      linux path
			nodePath = System.getenv("HOME") + "/.linuxbrew/bin/node";
			appiumPath = System.getenv("HOME") + "/.linuxbrew/lib/node_modules/appium/build/lib/main.js";
		}
		else if(osName.contains("windows")){
			//          windows path
			nodePath = "C:\\Program Files (x86)\\Appium\\node.exe";
			appiumPath = "C:\\Program Files (x86)\\Appium\\node_modules\\appium\\lib\\server\\main.js";
		}
		serviceClient = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
		.usingDriverExecutable(new File(nodePath))
		.usingPort(4725)
		.withAppiumJS(new File(appiumPath)));

		serviceClient.start();
	}
}
