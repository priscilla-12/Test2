package org.charter;

import java.net.MalformedURLException;

import org.charter.pageObjects.Android.sendMmsPage;
import org.charter.pageObjects.Android.audioCallPage;
import org.charter.pageObjects.Android.rcvMmsPage;
import org.testng.annotations.Test;

public class TC63_ReceiveMms_NOTHING_A063 extends BaseTest {

	@Test

	public void sendMessage() throws MalformedURLException {

		try {

			// Check rcvd MMS
			rcvMmsPage mms = new rcvMmsPage(driver);
			mms.launchAppDirect("com.google.android.apps.messaging",
					"com.google.android.apps.messaging.main.MainActivity");
			mms.checkRcvMms();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
