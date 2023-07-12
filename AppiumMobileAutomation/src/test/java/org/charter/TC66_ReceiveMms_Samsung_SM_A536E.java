package org.charter;

import java.io.File;
import java.net.URL;
import java.time.Duration;

import org.charter.pageObjects.Android.msgPage;

import org.charter.pageObjects.Android.MmsReceivePage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class TC66_ReceiveMms_Samsung_SM_A536E extends BaseTest {

	@Test

	public void receivedMessage() throws InterruptedException {

		MmsReceivePage msg = new MmsReceivePage(driver);
		msg.launchAppDirect("com.sec.android.app.launcher", "com.sec.android.app.launcher.activities.LauncherActivity");
		msg.swipeScreen();
		msg.messagesIcon();
		msg.searchIcon();
		msg.searchText();
		msg.contact();
		msg.receivedStatus();

	}
}
