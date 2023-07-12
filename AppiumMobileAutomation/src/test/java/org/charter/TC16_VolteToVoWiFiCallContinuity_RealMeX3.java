package org.charter;

import org.charter.pageObjects.Android.WifiPage_RealmeX3;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class TC16_VolteToVoWiFiCallContinuity_RealMeX3 extends BaseTest {

	@Test
	public void callConnection() throws InterruptedException {

		WifiPage_RealmeX3 call3 = new WifiPage_RealmeX3(driver);
		// To directly open the settings activity
		call3.launchAppDirect("com.android.settings", "com.android.settings.Settings");

		// To click searchbox in settings
		call3.settingsSearchbox();

		// To enter data in searchbox
		call3.enterSettingName("wifi");

		// To click on Search
		call3.clickSearchIcon();

		// To scroll to the desired activity
		call3.uiautomatorScroll("Wi-Fi");
		Thread.sleep(2000);

		// To open Wifi Settings in the device
		call3.openWifiSettings();

		// To turn off Wifi so that we can go for normal call
		call3.CheckWifi("Off");

		// To navigate back to home screen
		call3.navigateHome();

		// To open the dialer for making a call
		call3.openDialer();

		// To click on searchbar in dialer
		call3.clickSearchbar();
		Thread.sleep(2000);

		// To search for a saved contact by passing contact name as an argument
		call3.searchContact("Divya Collabera");

		// To click on search icon on keyboard
		call3.clickSearchIcon();
		Thread.sleep(1000);

		// To click on calling icon beside the contact
		call3.clickCallingIcon();

		// To select a Sim to call via
		call3.selectSimToCall();

		Thread.sleep(5000);

		// To check if calling via sim1, sim2 or Wifi
		call3.checkCallingStatus();

		// To open the notification bar
		call3.notificationBar();
		Thread.sleep(2000);

		// To turn wifi on or off
		call3.OnOffWifi();
		Thread.sleep(1000);

		// To get back to the call
		call3.tapWithCoordinates(500, 1000);
		Thread.sleep(1000);

		// To check if calling via sim1, sim2 or Wifi
		call3.checkCallingStatus();

		// To end the call
		call3.clickEndCall();
	}

}
