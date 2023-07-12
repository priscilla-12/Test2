package org.charter.utils;

import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.SupportsRotation;

public class IOSActions extends AppiumUtils {

	AndroidDriver driver;

	public IOSActions(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * This method will perform long press operation on the web element
	 * 
	 * @param ele - WebElement
	 */
	public void longPress(WebElement ele) {
		try {
			((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
					ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration", 2000));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will perform Scroll operation on the page based on the
	 * coordinates provided. No parameter required
	 */
	public void scrollWithCoordinates(String direction) {

		try {
			// Java
			boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
					ImmutableMap.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will perform Scroll operation till the end of page No parameter
	 * required
	 */
	public void scrollTillEnd() {

		try {
			boolean canScrollMore;
			do {
				canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
						ImmutableMap.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down"));
			} while (canScrollMore);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will use Google's UI Automator engine to scroll to the
	 * options/Menu provided
	 * 
	 * @param optionName eg. Menu name like 'Views'
	 */
	public void uiautomatorScroll(String optionName) {
		try {
			driver.findElement(AppiumBy.androidUIAutomator(
					"new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + optionName + "\"));"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will swipe the web element in the specified direction.
	 * 
	 * @param ele       - Element to be swiped
	 * @param direction - Direction to be swiped
	 */
	public void swipe(WebElement ele, String direction) {
		try {
			((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
					((RemoteWebElement) ele).getId(), "direction", "left", "percent", 0.75));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method will drag and drop the web element to the specified coordinates
	 * 
	 * @param sourceElement - Source element to be dragged
	 * @param endX          - X coordinates
	 * @param endY          - Y coordinates
	 */
	public void dragAndDrop(WebElement sourceElement, int endX, int endY) {
		try {
			((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of("elementId",
					((RemoteWebElement) sourceElement).getId(), "endX", endX, "endY", endY));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void rotateDevice(int x, int y, int z) {
		try {
			DeviceRotation landscape = new DeviceRotation(0, 0, z);

			((SupportsRotation) driver).rotate(landscape);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
