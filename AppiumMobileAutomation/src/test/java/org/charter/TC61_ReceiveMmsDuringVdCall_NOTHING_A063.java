package org.charter;

import java.net.MalformedURLException;

import org.charter.pageObjects.Android.rcvMmsPage;
import org.charter.pageObjects.Android.videoCallPage;
import org.testng.annotations.Test;

public class TC61_ReceiveMmsDuringVdCall_NOTHING_A063 extends BaseTest {

	@Test

	public void sendMessage() throws MalformedURLException {

		try {

			// Make a Video Call
			videoCallPage call = new videoCallPage(driver);
			call.launchAppDirect("com.google.android.dialer",
					"com.google.android.dialer.extensions.GoogleDialtactsActivity");
			call.makeVidcall();

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
