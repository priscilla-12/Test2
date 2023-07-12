package org.charter;

import org.charter.pageObjects.Android.AccessibilityVisionPage_RealmeX3;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class TC07_CallWaiting_RealMeX3 extends BaseTest {

	@Test
	public void callConnection() throws InterruptedException {

		AccessibilityVisionPage_RealmeX3 call = new AccessibilityVisionPage_RealmeX3(driver);

		// To open Call Accepting Page
		call.tapWithCoordinates(500, 300);
		Thread.sleep(1000);

		// To Accept a call
		call.acceptCall();
		Thread.sleep(1000);

		// To put 1st call on hold
		call.putOnHold();
		Thread.sleep(5000);

		// To accept 2nd call
		call.acceptCall();

		// To merge both the calls
		call.clickMergeCalls();

	}

}
