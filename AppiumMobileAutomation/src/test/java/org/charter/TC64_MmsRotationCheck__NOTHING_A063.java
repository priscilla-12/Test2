package org.charter;

import java.net.MalformedURLException;
import java.util.List;

import org.charter.pageObjects.Android.mmsRotationPage;
import org.charter.pageObjects.Android.rcvMmsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC64_MmsRotationCheck__NOTHING_A063 extends BaseTest {

	@Test

	public void sendMessage() throws MalformedURLException {

		try {

			// Check rcvd MMS
			mmsRotationPage rcvMms = new mmsRotationPage(driver);
			rcvMms.launchAppDirect("com.google.android.apps.messaging",
					"com.google.android.apps.messaging.main.MainActivity");
			rcvMms.checkRcvMms();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
