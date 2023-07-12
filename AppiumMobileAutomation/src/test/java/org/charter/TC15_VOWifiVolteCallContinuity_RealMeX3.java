package org.charter;

import org.charter.pageObjects.Android.WifiPage_RealmeX3;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class TC15_VOWifiVolteCallContinuity_RealMeX3 extends BaseTest {

	@Test
	public void callConnection() throws InterruptedException {

		WifiPage_RealmeX3 call2 = new WifiPage_RealmeX3(driver);
		// To directly open the settings activity
		call2.launchAppDirect("com.android.settings", "com.android.settings.Settings");

		// To click searchbox in settings
		call2.settingsSearchbox();

		// To enter data in searchbox
		call2.enterSettingName("wifi");

		// To click on Search
		call2.clickSearchIcon();

		// To scroll to the desired activity
		call2.uiautomatorScroll("Wi-Fi");
		Thread.sleep(2000);

		// To open Wifi Settings in the device
		call2.openWifiSettings();

		// To turn off Wifi so that we can go for normal call
		call2.CheckWifi("On");

		// To navigate back to home screen
		call2.navigateHome();

		// To open the dialer for making a call
		call2.openDialer();

		// To click on searchbar in dialer
		call2.clickSearchbar();
		Thread.sleep(2000);

		// To search for a saved contact by passing contact name as an argument
		call2.searchContact("Divya Collabera");

		// To click on search icon on keyboard
		call2.clickSearchIcon();
		Thread.sleep(1000);

		// To click on calling icon beside the contact
		call2.clickCallingIcon();

		// To select a Sim to call via
		call2.selectSimToCall();

		Thread.sleep(5000);

		// To check if calling via sim1, sim2 or Wifi
		call2.checkCallingStatus();

		// To open the notification bar
		call2.notificationBar();
		Thread.sleep(2000);

		// To turn wifi on or off
		call2.OnOffWifi();
		Thread.sleep(1000);

		// To get back to the call
		call2.tapWithCoordinates(500, 1000);
		Thread.sleep(1000);

		// To check if calling via sim1, sim2 or Wifi
		call2.checkCallingStatus();

		// To end the call
		call2.clickEndCall();
	}

}
