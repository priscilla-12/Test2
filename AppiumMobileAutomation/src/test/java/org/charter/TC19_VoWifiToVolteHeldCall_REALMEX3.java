package org.charter;

import org.charter.pageObjects.Android.WifiPage_RealmeX3;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class TC19_VoWifiToVolteHeldCall_REALMEX3 extends BaseTest {

	@Test
	public void callConnection() throws InterruptedException {

		WifiPage_RealmeX3 call6 = new WifiPage_RealmeX3(driver);

		// To directly launch settings activity
		call6.launchAppDirect("com.android.settings", "com.android.settings.Settings");

		// To click searchbox in settings
		call6.settingsSearchbox();

		// To enter data in searchbox
		call6.enterSettingName("wifi");

		// To click on Search
		call6.clickSearchIcon();

		// To scroll to the desired activity
		call6.uiautomatorScroll("Wi-Fi");
		Thread.sleep(2000);

		// To open Wifi Settings in the device
		call6.openWifiSettings();

		// To turn off Wifi so that we can go for normal call
		call6.CheckWifi("On");

		// To navigate back to home screen
		call6.navigateHome();

		Thread.sleep(5000);
		call6.tapWithCoordinates(500, 300);
		Thread.sleep(1000);

		// To Accept a call
		call6.acceptCall();
		Thread.sleep(5000);

		// To Accept another call
		call6.acceptCall();

		// To check if calling via sim1, sim2 or Wifi
		call6.checkCallingStatus();

		// To check the status of 1st call
		call6.check1stCallStatus();
		Thread.sleep(1000);

		// To open the notification bar
		call6.notificationBar();
		Thread.sleep(2000);

		// To turn wifi on or off
		call6.OnOffWifi();
		Thread.sleep(1000);

		// To get back to the call
		call6.tapWithCoordinates(500, 1000);
		Thread.sleep(1000);

		// To check if calling via sim1, sim2 or Wifi
		call6.checkCallingStatus();
		Thread.sleep(2000);

		// To end 2nd Call
		call6.clickEndCall();

		// To verify if 1st call resumes or not
		call6.verify1stCallStatus();
	}

}
