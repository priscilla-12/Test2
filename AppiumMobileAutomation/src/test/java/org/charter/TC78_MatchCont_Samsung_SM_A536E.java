package org.charter;

import java.io.File;
import java.net.URL;
import java.time.Duration;

import org.charter.pageObjects.Android.msgPage;

import org.charter.pageObjects.Android.SecondNoPage;
import org.charter.pageObjects.Android1.TC74_ADDPICTUREPAGE_SAMSUNG_SM_A536E;
import org.charter.pageObjects.Android1.TC76_DELETECONTPAGE_SAMSUNG_SM_A536E;
import org.charter.pageObjects.Android1.TC78_MATCHCONTPAGE_SAMSUNG_SM_A536E;
import org.charter.pageObjects.Android1.TC75_SEARCHCONTPAGE_SAMSUNG_SM_A536E;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class TC78_MatchCont_Samsung_SM_A536E extends BaseTest {

	@Test

	public void matchcontact() throws InterruptedException {

		TC78_MATCHCONTPAGE_SAMSUNG_SM_A536E contact = new TC78_MATCHCONTPAGE_SAMSUNG_SM_A536E(driver);
		contact.launchAppDirect("com.sec.android.app.launcher",
				"com.sec.android.app.launcher.activities.LauncherActivity");
		contact.swipeScreen();
		contact.clickPhoneIcon();
		contact.keypad();
		contact.dialer();
		contact.content();
		contact.dialButton();
		contact.sim();
		contact.verify();

	}
}
