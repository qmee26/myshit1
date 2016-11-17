package com.automation.spot.utils;

import io.appium.java_client.MobileBy;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FunctionLibrary extends DriverInit{

	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean isElementPresent(WebElement e) {
		for(int abc=0;abc<10;abc++){
			try {
				if(e.isDisplayed())
					return true;
				else 
					waitTime(1000);
			} catch (Exception e1) {
				waitTime(1000);
			}
		}
		return false;
	}

	public List<? extends WebElement> getElementList(String locatorName) {

		//		String locatorKeyVal = env.getProperty(locatorName);
		String locatorStrategy = locatorName.split(":")[0];
		String locatorValue = locatorName.split(":")[1];
		List<? extends WebElement> elementList = null;

		switch (locatorStrategy) {
		case "AccessibilityID":
			elementList = driver.findElements(MobileBy.AccessibilityId(locatorValue));
			break;
		case "Class":
			elementList = driver.findElements(MobileBy.className(locatorValue));
			break;
		case "Xpath":
			elementList = driver.findElements(MobileBy.xpath(locatorValue));
			break;
		case "AndroidUIAutomator":
			elementList = driver.findElements(MobileBy.AndroidUIAutomator(locatorValue));
			break;
		case "Css":
			elementList = driver.findElements(MobileBy.cssSelector(locatorValue));
			break;
		case "Id":
			elementList = driver.findElements(MobileBy.id(locatorValue));
			break;
		case "Tag":
			elementList = driver.findElements(MobileBy.tagName(locatorValue));
			break;
		case "LinkText":
			elementList = driver.findElements(MobileBy.linkText(locatorValue));
			break;
		case "PartialLinkText":
			elementList = driver.findElements(MobileBy.partialLinkText(locatorValue));
			break;
		}
		return elementList;
	}

	public WebElement getElement(String locatorName) {

		//		String locatorKeyVal = env.getProperty(locatorName);
		String locatorStrategy = locatorName.split(":")[0];
		String locatorValue = locatorName.split(":")[1];
		WebElement element = null;

		switch (locatorStrategy) {
		case "AccessibilityID":
			element = FindElement(MobileBy.AccessibilityId(locatorValue));
			break;
		case "Class":
			element = FindElement(MobileBy.className(locatorValue));
			break;
		case "Xpath":
			element = FindElement(MobileBy.xpath(locatorValue));
			break;
		case "AndroidUIAutomator":
			element = FindElement(MobileBy.AndroidUIAutomator(locatorValue));
			break;
		case "Css":
			element = FindElement(MobileBy.cssSelector(locatorValue));
			break;
		case "Id":
			element = FindElement(MobileBy.id(locatorValue));
			break;
		case "Tag":
			element = FindElement(MobileBy.tagName(locatorValue));
			break;
		case "LinkText":
			element = FindElement(MobileBy.linkText(locatorValue));
			break;
		case "PartialLinkText":
			element = FindElement(MobileBy.partialLinkText(locatorValue));
			break;
		}
		return element;
	}

	private WebElement FindElement(By locator){
		WebElement element = null;
		for(int i=0;i<10;i++){
			try{
				element = driver.findElement(locator);
				break;
			}
			catch(NoSuchElementException e){
				continue;
			}
		}
		return element;
	}

	public void takeScreenShot(String fileName) {
		// TODO Auto-generated method stub
		File file = new File(fileName + ".png");
		File tmpFile = driver
				.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(tmpFile, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getTextFromGivenElement(WebElement ele){
		System.out.println(ele.getText());
		return ele.getText();
	}


	public void clickOnGivenElement(WebElement ele) throws Exception {
		ele.click();
		waitTime(3000);
	}

	public void selectTheValueFromDropdown(WebElement ele, String value) throws Exception {
		Select select=new Select(ele);
		select.selectByVisibleText(value);
	}

	public void enterTextIntoGivenTextBox(WebElement ele, String text) throws Exception{
		ele.sendKeys(text);
	}

	public void selectOptionFromDropdown(WebElement ele, String option) throws Exception {
		for(int i=0;i<10;i++){
			try{
				Select select=new Select(ele);
				select.selectByVisibleText(option);
				waitTime(1000);
				break;
			}
			catch(Exception e){
				continue;
			}
		}

	}

}
