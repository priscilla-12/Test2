package org.charter;

import java.io.File;
import java.net.URL;
import java.time.Duration;

import org.charter.pageObjects.Android.msgPage;

//import org.charter.pageObjects.Android.mmsSendPage;
import org.charter.pageObjects.Android.SecondNoPage;
import org.charter.pageObjects.Android.AddEmailPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class TC73_AddEmail_Samsung_SM_A536E extends BaseTest {

	@Test

	public void emailAccount() throws InterruptedException {

		AddEmailPage email = new AddEmailPage(driver);
		email.launchAppDirect("com.sec.android.app.launcher",
				"com.sec.android.app.launcher.activities.LauncherActivity");
		email.swipeScreen();
		email.clickPhoneIcon();
		email.searchIcon();
		email.searchText();
		email.contactList();
		email.detailsButton();
		email.editButton1();
		email.emailText();
		email.emailEditText();
		email.editButton2();

	}
}
