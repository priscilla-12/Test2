package org.charter;

import org.charter.pageObjects.Android.WifiPage_RealmeX3;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class TC18_VolteToVoWifi_SeamlessConference_RealMeX3 extends BaseTest {

	@Test
	public void callConnection() throws InterruptedException {

		WifiPage_RealmeX3 call5 = new WifiPage_RealmeX3(driver);
		// To directly open the settings activity
		call5.launchAppDirect("com.android.settings", "com.android.settings.Settings");

		// To click searchbox in settings
		call5.settingsSearchbox();

		// To enter data in searchbox
		call5.enterSettingName("wifi");

		// To click on Search
		call5.clickSearchIcon();

		// To scroll to the desired activity
		call5.uiautomatorScroll("Wi-Fi");
		Thread.sleep(2000);

		// To open Wifi Settings in the device
		call5.openWifiSettings();

		// To turn off Wifi so that we can go for normal call
		call5.CheckWifi("Off");

		// To navigate back to home screen
		call5.navigateHome();

		// To open the dialer for making a call
		call5.openDialer();

		// To click on searchbar in dialer
		call5.clickSearchbar();
		Thread.sleep(2000);

		// To search for 1st saved contact by passing contact name as an argument
		call5.searchContact("Divya Collabera");

		// To click on search icon on keyboard
		call5.clickSearchIcon();
		Thread.sleep(1000);

		// To click on calling icon beside the contact
		call5.clickCallingIcon();

		// To select a Sim to call via
		call5.selectSimToCall();
		Thread.sleep(5000);

		// To add a new call
		call5.clickAddCall();
		Thread.sleep(2000);

		// To navigate back so that we can search for a new contact
		call5.navigateBack();

		// To click on searchbar in dialer
		call5.clickSearchbar();
		Thread.sleep(2000);

		// To search for 2nd saved contact by passing contact name as an argument
		call5.searchContact("Selva Ascendion");

		// To click on search icon on keyboard
		call5.clickSearchIcon();
		Thread.sleep(1000);

		// To click on calling icon beside the contact
		call5.clickCallingIcon();

		// To select a Sim to call via
		call5.selectSimToCall();
		Thread.sleep(5000);

		// To merge both the calls
		call5.clickMergeCalls();
		Thread.sleep(3000);

		// To check if calling via sim1, sim2 or Wifi
		call5.checkCallingStatus();

		// To open the notification bar
		call5.notificationBar();
		Thread.sleep(2000);

		// To turn wifi on or off
		call5.OnOffWifi();
		Thread.sleep(1000);

		// To get back to the call
		call5.tapWithCoordinates(500, 1000);
		Thread.sleep(2000);

		// To check if calling via sim1, sim2 or Wifi
		call5.checkCallingStatus();

		// To end the call
		call5.clickEndCall();
	}

}
