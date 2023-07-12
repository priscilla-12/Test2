package org.charter;

import org.charter.pageObjects.Android.WifiPage_RealmeX3;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class TC17_VoWifi_To_VolteCallConference_RealMeX3 extends BaseTest {

	@Test
	public void callConnection() throws InterruptedException {

		WifiPage_RealmeX3 call4 = new WifiPage_RealmeX3(driver);
		// To directly open the settings activity
		call4.launchAppDirect("com.android.settings", "com.android.settings.Settings");

		// To click searchbox in settings
		call4.settingsSearchbox();

		// To enter data in searchbox
		call4.enterSettingName("wifi");

		// To click on Search
		call4.clickSearchIcon();

		// To scroll to the desired activity
		call4.uiautomatorScroll("Wi-Fi");
		Thread.sleep(2000);

		// To open Wifi Settings in the device
		call4.openWifiSettings();

		// To turn off Wifi so that we can go for normal call
		call4.CheckWifi("On");

		// To navigate back to home screen
		call4.navigateHome();

		// To open the dialer for making a call
		call4.openDialer();

		// To click on searchbar in dialer
		call4.clickSearchbar();
		Thread.sleep(2000);

		// To search for 1st saved contact by passing contact name as an argument
		call4.searchContact("Divya Collabera");

		// To click on search icon on keyboard
		call4.clickSearchIcon();
		Thread.sleep(1000);

		// To click on calling icon beside the contact
		call4.clickCallingIcon();

		// To select a Sim to call via
		call4.selectSimToCall();

		Thread.sleep(5000);

		// To check if calling via sim1, sim2 or Wifi
		call4.checkCallingStatus();

		// To add a new call
		call4.clickAddCall();
		Thread.sleep(2000);

		// To navigate back so that we can search for a new contact
		call4.navigateBack();

		// To click on searchbar in dialer
		call4.clickSearchbar();
		Thread.sleep(2000);

		// To search for 2nd saved contact by passing contact name as an argument
		call4.searchContact("Narendra Mama Ji");

		// To click on search icon on keyboard
		call4.clickSearchIcon();
		Thread.sleep(1000);

		// To click on calling icon beside the contact
		call4.clickCallingIcon();

		// To select a Sim to call via
		call4.selectSimToCall();
		Thread.sleep(5000);

		// To merge both the calls
		call4.clickMergeCalls();
		Thread.sleep(3000);

		// To check if calling via sim1, sim2 or Wifi
		call4.checkCallingStatus();

		// To add a new call
		call4.clickAddCall();
		Thread.sleep(2000);

		// To navigate back so that we can search for a new contact
		call4.navigateBack();

		// To click on searchbar in dialer
		call4.clickSearchbar();
		Thread.sleep(2000);

		// To search for 3rd saved contact by passing contact name as an argument
		call4.searchContact("Selva Ascendion");

		// To click on search icon on keyboard
		call4.clickSearchIcon();
		Thread.sleep(1000);

		// To click on calling icon beside the contact
		call4.clickCallingIcon();

		// To select a Sim to call via
		call4.selectSimToCall();
		Thread.sleep(5000);

		// To merge both the calls
		call4.clickMergeCalls();
		Thread.sleep(3000);

		// To check if calling via sim1, sim2 or Wifi
		call4.checkCallingStatus();

		// To open the notification bar
		call4.notificationBar();
		Thread.sleep(2000);

		// To turn wifi on or off
		call4.OnOffWifi();
		Thread.sleep(1000);

		// To get back to the call
		call4.tapWithCoordinates(500, 1000);
		Thread.sleep(1000);

		// To check if calling via sim1, sim2 or Wifi
		call4.checkCallingStatus();
		Thread.sleep(2000);

		// To end the call
		call4.clickEndCall();
	}

}
