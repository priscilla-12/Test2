package org.charter;

import org.charter.pageObjects.Android.SMSSendNotificationPage2;
//import org.charter.pageObjects.Android.TC47_SMS_SEND_NOTIFICATIONPAGE2_ONEPLUS_NORDCE_2;
import org.testng.annotations.Test;

public class TC47_SmsSendNotification_ONEPLUS_NORDCE_2 extends BaseTest {

	@Test

	public void sendMessage() throws InterruptedException {

		SMSSendNotificationPage2 msg = new SMSSendNotificationPage2(driver);
		msg.launchAppDirect("com.google.android.apps.messaging", "com.google.android.apps.messaging.main.MainActivity");

		msg.sendMessage();

	}

}
