package org.charter;

import java.io.File;
import java.net.URL;
import java.time.Duration;

import org.charter.pageObjects.Android.msgPage;
import org.charter.pageObjects.Android.StoreContactPage;
import org.charter.pageObjects.Android.AddEmailPage;

import org.charter.pageObjects.Android.MobileWebPage;
import org.charter.pageObjects.Android.SecondNoPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class TC70_MobileWeb_Samsung_SM_A536E extends BaseTest {

	@Test

	public void mobileInternet() throws InterruptedException {

		MobileWebPage web = new MobileWebPage(driver);
		web.launchAppDirect("com.sec.android.app.launcher", "com.sec.android.app.launcher.activities.LauncherActivity");
		web.swipeScreen1();
		web.swipeScreen2();
		web.mobileData();
		web.launchAppDirect("com.android.chrome", "com.google.android.apps.chrome.Main");
		web.search();
		web.urlBar();
		web.Text();
		web.close();

	}
}
