package org.charter;

import org.charter.pageObjects.Android.SMSReceivePage;

import org.testng.annotations.Test;

public class TC51_SmsReceive_ONEPLUS_NORDCE_2 extends BaseTest {
	@Test

	public void ReceiveMessage() {

		SMSReceivePage msg = new SMSReceivePage(driver);
		msg.launchAppDirect("com.google.android.apps.messaging", "com.google.android.apps.messaging.main.MainActivity");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		try {
			msg.ReceiveMessage();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		msg.SMSReceiveMessage();
	}
}
