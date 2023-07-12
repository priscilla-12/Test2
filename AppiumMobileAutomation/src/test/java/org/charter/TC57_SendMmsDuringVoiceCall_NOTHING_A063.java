package org.charter;

import java.net.MalformedURLException;

import org.charter.pageObjects.Android.sendMmsPage;
import org.charter.pageObjects.Android.audioCallPage;
import org.testng.annotations.Test;

public class TC57_SendMmsDuringVoiceCall_NOTHING_A063 extends BaseTest {

	@Test

	public void sendMessage() throws MalformedURLException {

		try {
			// Make a Audio Call
			audioCallPage call = new audioCallPage(driver);
			call.launchAppDirect("com.google.android.dialer",
					"com.google.android.dialer.extensions.GoogleDialtactsActivity");
			call.makeAcall();

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
