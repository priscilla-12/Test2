package org.charter.utils;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;

public class AppiumUtils {

	AppiumDriver driver;

	public AppiumUtils(AppiumDriver driver) {
		this.driver = driver;
	}

	/**
	 * This method will wait for the particular web element to appear in screen with
	 * the given attribute values.
	 * 
	 * @param ele
	 * @param attributeName
	 * @param attributeValue
	 */
	public void waitForElementToAppear(WebElement ele, String attributeName, String attributeValue, int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
		wait.until(ExpectedConditions.attributeContains(ele, attributeName, attributeValue));
	}

}
