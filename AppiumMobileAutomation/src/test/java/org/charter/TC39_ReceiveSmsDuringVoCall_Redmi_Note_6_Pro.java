package org.charter;

import org.charter.pageObjects.Android.messagePage;
import org.charter.pageObjects.Android.ReceiveSmsWhileBrowsingPage;
import org.charter.pageObjects.Android.ReceiveSmsDuringVoCallPage;
import org.charter.pageObjects.Android.wifiPage;
import org.testng.annotations.Test;

public class TC39_ReceiveSmsDuringVoCall_Redmi_Note_6_Pro extends BaseTest {

	@Test

	public void receiveMessage() throws InterruptedException {

		ReceiveSmsDuringVoCallPage call = new ReceiveSmsDuringVoCallPage(driver);
		call.launchAppDirect("com.android.contacts", "com.android.contacts.activities.TwelveKeyDialer");

		call.contact();
		call.search();
		call.name();
		call.call();
		call.swipe();
		call.sms();
        call.verify();

	}

}
