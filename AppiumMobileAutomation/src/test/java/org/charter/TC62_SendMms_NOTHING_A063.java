package org.charter;

import java.net.MalformedURLException;

import org.charter.pageObjects.Android.sendMmsPage;
import org.charter.pageObjects.Android.audioCallPage;
import org.testng.annotations.Test;

public class TC62_SendMms_NOTHING_A063 extends BaseTest {

	@Test

	public void sendMessage() throws MalformedURLException {

		try {

			// Send MMS
			sendMmsPage mms = new sendMmsPage(driver);
			mms.launchAppDirect("com.google.android.apps.messaging",
					"com.google.android.apps.messaging.main.MainActivity");
			mms.sendMms();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
