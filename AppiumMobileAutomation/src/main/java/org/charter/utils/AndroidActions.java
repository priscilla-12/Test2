package org.charter.utils;

import java.time.Duration;

import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.SupportsRotation;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class AndroidActions extends AppiumUtils {

	AndroidDriver driver;

	public AndroidActions(AndroidDriver driver) {
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

	public void tapWithCoordinates(int x, int y) {

		try {
			TouchAction touchAction = new TouchAction(driver);
			touchAction.tap(PointOption.point(x, y)).perform();
			Thread.sleep(3000);

		} catch (InterruptedException e) {
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

	public void swipeUp(WebElement ele, String direction) {
		try {
			((JavascriptExecutor) driver).executeScript("mobile: swipeGesture",
					ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "direction", "up", "percent", 1.0));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void swipeRight(WebElement ele, String direction) {
		try {
			((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
					((RemoteWebElement) ele).getId(), "direction", "right", "percent", 1.0));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void swipeDown(WebElement ele, String direction) {
		try {
			((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
					((RemoteWebElement) ele).getId(), "direction", "down", "percent", 1.0));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void swipeByCoordinates(int startX, int startY, int endX, int endY) {
		TouchAction ts = new TouchAction(driver);
		ts.press(PointOption.point(startX, startY)).moveTo(PointOption.point(endX, endY)).release().perform();
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
			driver.rotate(landscape);
			((SupportsRotation) driver).rotate(landscape);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *      * This method will check if a string is contained in other or not     
	 * * @param string1 actual data      * @param string2 expected data, which we
	 * are expecting to be present in string1     
	 */
	public void dataComparision(String actual_data, String expected_data) {

		actual_data = actual_data.toLowerCase();
		expected_data = expected_data.toLowerCase();

		if (actual_data.contains(expected_data)) {
			System.out.println(expected_data + " is present");
		} else {
			System.out.println(expected_data + " is not present");
		}
	}

	public boolean dataComparision1(String actual_data, String expected_data) {
		actual_data = actual_data.toLowerCase();
		expected_data = expected_data.toLowerCase();
		if (actual_data.contains(expected_data)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method will tap using coordinates with given x and y vale
	 * 
	 * @param x-coordinates & y-coordinates
	 */
	public void touchWithCoordinates(int x, int y) {

		try {
			TouchAction touchAction = new TouchAction(driver);
			touchAction.tap(PointOption.point(x, y)).perform();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will launch the application directly with given app package and
	 * activity
	 * 
	 * @param appPackage
	 * @param appActivity
	 */
	public void launchAppDirect(String appPackage, String appActivity) {
		try {
			Activity activityMsg = new Activity(appPackage, appActivity);
			driver.startActivity(activityMsg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void swipeScreen(String dir) {

		System.out.println("swipeScreen(): dir: '" + dir + "'");

		final int ANIMATION_TIME = 200; // ms

		final int PRESS_TIME = 200; // ms

		int edgeBorder = 10; // better avoid edges

		PointOption pointOptionStart, pointOptionEnd;

		org.openqa.selenium.Dimension dims = driver.manage().window().getSize();

		pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

		switch (dir) {

		case "DOWN": // center of footer

			pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);

			break;

		case "UP": // center of header

			pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);

			break;

		case "LEFT": // center of left side

			pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);

			break;

		case "RIGHT": // center of right side

			pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);

			break;

		default:

			throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");

		}

		try {

			new TouchAction(driver)

					.press(pointOptionStart)

					.waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))

					.moveTo(pointOptionEnd)

					.release().perform();

		}

		catch (Exception e) {

			System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());

			return;
		}
	}
}