package org.charter;

import java.io.File;
import java.net.URL;
import java.time.Duration;

import org.charter.pageObjects.Android.msgPage;

import org.charter.pageObjects.Android.SecondNoPage;
import org.charter.pageObjects.Android1.TC74_ADDPICTUREPAGE_SAMSUNG_SM_A536E;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class TC74_AddPicture_Samsung_SM_A536E extends BaseTest {

	@Test

	public void picture() throws InterruptedException {

		TC74_ADDPICTUREPAGE_SAMSUNG_SM_A536E picture = new TC74_ADDPICTUREPAGE_SAMSUNG_SM_A536E(driver);
		picture.launchAppDirect("com.sec.android.app.launcher",
				"com.sec.android.app.launcher.activities.LauncherActivity");
		picture.swipeScreen();
		picture.clickPhoneIcon();
		picture.searchIcon();
		picture.searchText();
		picture.contactList();
		picture.detailsButton();
		picture.profilePicture();
		picture.gallery();
		picture.downloads();
		picture.image();
		picture.done();
		picture.callButton();
		picture.sim();
		picture.imageVerify();

	}
}
