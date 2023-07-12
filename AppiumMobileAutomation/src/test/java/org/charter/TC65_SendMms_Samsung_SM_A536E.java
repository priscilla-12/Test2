package org.charter;

import java.io.File;
import java.net.URL;
import java.time.Duration;

import org.charter.pageObjects.Android.msgPage;

import org.charter.pageObjects.Android.MmsSendPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class TC65_SendMms_Samsung_SM_A536E extends BaseTest {

	@Test

	public void sendMessage() throws InterruptedException {

		MmsSendPage msg = new MmsSendPage(driver);
		msg.launchAppDirect("com.sec.android.app.launcher", "com.sec.android.app.launcher.activities.LauncherActivity");
		msg.swipeScreen();
		msg.messagesIcon();
		msg.searchIcon();
		msg.searchText();
		msg.contact();
		msg.otherOptions();
		msg.myFiles();
		msg.images();
		msg.searchIcon1();
		msg.Text();
		msg.checkBox();
		msg.okButton();
		msg.sentButton();

	}
}
