package org.charter;

import org.charter.pageObjects.Android.SMSSendPage;

import org.testng.annotations.Test;

public class TC50_SmsSend_ONEPLUS_NORDCE_2 extends BaseTest {

	@Test

	public void sendMessage() {
		// Send SMS
		SMSSendPage msg = new SMSSendPage(driver);
		msg.launchAppDirect("com.google.android.apps.messaging", "com.google.android.apps.messaging.main.MainActivity");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		try {
			msg.sendMessage();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		msg.SMSdisplayNotification();

	}

}
