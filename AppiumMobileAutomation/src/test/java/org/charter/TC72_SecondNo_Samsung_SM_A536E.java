package org.charter;

import java.io.File;
import java.net.URL;
import java.time.Duration;

import org.charter.pageObjects.Android.msgPage;

import org.charter.pageObjects.Android.SecondNoPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class TC72_SecondNo_Samsung_SM_A536E extends BaseTest {

	@Test

	public void phonebook() throws InterruptedException {

		SecondNoPage phone = new SecondNoPage(driver);
		phone.launchAppDirect("com.sec.android.app.launcher",
				"com.sec.android.app.launcher.activities.LauncherActivity");
		phone.swipeScreen();
		phone.clickPhoneIcon();
		phone.searchIcon();
		phone.searchText();
		phone.contactList();
		phone.detailsButton();
		phone.editButton();
		phone.addAnotherText();
		phone.editText();
		phone.editButton1();

	}
}
