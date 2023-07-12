package org.charter;

import org.charter.pageObjects.Android.SMSSendSTDCodePage;
//import org.charter.pageObjects.Android.TC48_SMS_SEND_STD_CODEPAGE_ONEPLUS_NORDCE_2;
import org.testng.annotations.Test;

public class TC48_SmsSendSTDCode_ONEPLUS_NORDCE_2 extends BaseTest {

	@Test

	public void sendMessage() throws InterruptedException {

		SMSSendSTDCodePage msg = new SMSSendSTDCodePage(driver);
		msg.launchAppDirect("com.google.android.apps.messaging", "com.google.android.apps.messaging.main.MainActivity");

		msg.sendMessage();

	}

}
