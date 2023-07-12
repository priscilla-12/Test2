package org.charter;

import java.net.MalformedURLException;

import org.charter.pageObjects.Android.audioCallPage;
import org.charter.pageObjects.Android.rcvMmsPage;
import org.testng.annotations.Test;

public class TC60_ReceiveMmsDuringVoCall__NOTHING_A063 extends BaseTest {

	@Test

	public void receivedMms() throws MalformedURLException {

		try {
			// Make a Audio Call
			audioCallPage call = new audioCallPage(driver);
			call.launchAppDirect("com.google.android.dialer",
					"com.google.android.dialer.extensions.GoogleDialtactsActivity");
			call.makeAcall();

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
