package org.charter;

import java.io.File;
import java.net.URL;
import java.time.Duration;

import org.charter.pageObjects.Android.msgPage;

import org.charter.pageObjects.Android.MsgNotificationPage;
import org.charter.pageObjects.Android.SecondNoPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class TC69_MsgNotification_Samsung_SM_A536E extends BaseTest {

	@Test

	public void msgDelivered() throws InterruptedException {

		MsgNotificationPage msg = new MsgNotificationPage(driver);
		msg.launchAppDirect("com.sec.android.app.launcher", "com.sec.android.app.launcher.activities.LauncherActivity");
		msg.swipeScreen();
		msg.messagesIcon();
		msg.searchIcon();
		msg.searchText();
		msg.contact();
		msg.msgEditor();
		msg.sentButton();
		msg.cancel();
		msg.swipeScreen1();
		msg.deliveryReport();
		msg.swipeScreen2();

	}
}
