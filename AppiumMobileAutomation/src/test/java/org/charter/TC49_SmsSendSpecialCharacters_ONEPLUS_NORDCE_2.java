package org.charter;

import org.charter.pageObjects.Android.SMSSendSpecialCharacterPage;

import org.testng.annotations.Test;

public class TC49_SmsSendSpecialCharacters_ONEPLUS_NORDCE_2 extends BaseTest {

	@Test

	public void sendMessage() throws InterruptedException {
		// Send SMS
		SMSSendSpecialCharacterPage msg = new SMSSendSpecialCharacterPage(driver);
		msg.launchAppDirect("com.google.android.apps.messaging", "com.google.android.apps.messaging.main.MainActivity");

		msg.sendMessage();
		msg.launchAppDirect("com.google.android.apps.messaging", "com.google.android.apps.messaging.main.MainActivity");

		msg.ReceiveMessage();

	}

}
