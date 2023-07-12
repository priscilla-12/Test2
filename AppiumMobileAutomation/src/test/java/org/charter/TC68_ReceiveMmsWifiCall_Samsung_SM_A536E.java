package org.charter;

import java.io.File;
import java.net.URL;
import java.time.Duration;

import org.charter.pageObjects.Android.msgPage;
import org.charter.pageObjects.Android.StoreContactPage;
import org.charter.pageObjects.Android.AddEmailPage;

import org.charter.pageObjects.Android.SecondNoPage;
import org.charter.pageObjects.Android.ReceiveMmsWifiCallPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class TC68_ReceiveMmsWifiCall_Samsung_SM_A536E extends BaseTest {

	@Test

	public void wifiCall() throws InterruptedException {

		ReceiveMmsWifiCallPage mms = new ReceiveMmsWifiCallPage(driver);
		mms.launchAppDirect("com.sec.android.app.launcher", "com.sec.android.app.launcher.activities.LauncherActivity");
		mms.swipeScreen();
		mms.clickPhoneIcon();
		mms.searchIcon();
		mms.searchText();
		mms.contactList();
		mms.callButton();
		mms.sim();
		mms.wifiCalling();
		mms.menuButton();
		mms.sendMessage();
		mms.receivedStatus();
		mms.callEnd();
		mms.cancel();

	}
}
