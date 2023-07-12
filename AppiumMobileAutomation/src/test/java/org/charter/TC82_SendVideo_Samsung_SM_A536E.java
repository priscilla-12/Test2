package org.charter;

import java.io.File;
import java.net.URL;
import java.time.Duration;

import org.charter.pageObjects.Android.msgPage;

import org.charter.pageObjects.Android.MmsSendPage;
import org.charter.pageObjects.Android1.TC81_PHOTOSENDPAGE_SAMSUNG_SM_A536E;
import org.charter.pageObjects.Android1.TC82_VIDEOSENDPAGE_SAMSUNG_SM_A536E;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class TC82_SendVideo_Samsung_SM_A536E extends BaseTest {

	@Test

	public void sendMessage() throws InterruptedException {

		TC82_VIDEOSENDPAGE_SAMSUNG_SM_A536E video = new TC82_VIDEOSENDPAGE_SAMSUNG_SM_A536E(driver);

		video.launchAppDirect("com.sec.android.app.launcher",
				"com.sec.android.app.launcher.activities.LauncherActivity");
		video.swipeScreen();
		video.messagesIcon();
		video.searchIcon();
		video.searchText();
		video.contact();
		video.otherOptions();
		video.videoOption();
		video.gallery();
		video.videoFolder();
		video.video();
		video.videoSize();
		video.okButton();
		video.sentButton();

	}
}
