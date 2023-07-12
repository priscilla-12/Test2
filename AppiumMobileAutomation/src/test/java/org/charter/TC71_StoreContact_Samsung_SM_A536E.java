package org.charter;

import java.io.File;
import java.net.URL;
import java.time.Duration;

import org.charter.pageObjects.Android.msgPage;
import org.charter.pageObjects.Android.StoreContactPage;
import org.charter.pageObjects.Android.AddEmailPage;

import org.charter.pageObjects.Android.SecondNoPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class TC71_StoreContact_Samsung_SM_A536E extends BaseTest {

	@Test

	public void newContact() throws InterruptedException {

		StoreContactPage contact = new StoreContactPage(driver);
		contact.launchAppDirect("com.sec.android.app.launcher",
				"com.sec.android.app.launcher.activities.LauncherActivity");
		contact.swipeScreen();
		contact.clickPhoneIcon();
		contact.createContact();
		contact.nameEdit();
		contact.phoneTextView();
		contact.phoneEditText();
		contact.saveButton();

	}
}
