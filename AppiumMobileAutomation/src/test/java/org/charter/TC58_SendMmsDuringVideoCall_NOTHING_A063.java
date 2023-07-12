package org.charter;

import java.net.MalformedURLException;

import org.charter.pageObjects.Android.sendMmsPage;
import org.charter.pageObjects.Android.videoCallPage;
import org.testng.annotations.Test;

public class TC58_SendMmsDuringVideoCall_NOTHING_A063 extends BaseTest {

	@Test

	public void sendMessage() throws MalformedURLException {

		try {

			// Make a Video Call
			videoCallPage call = new videoCallPage(driver);
			call.launchAppDirect("com.google.android.dialer",
					"com.google.android.dialer.extensions.GoogleDialtactsActivity");
			call.makeVidcall();

			Thread.sleep(5000);
			call.touchWithCoordinates(897, 1677);
			call.touchWithCoordinates(971, 1458);

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
