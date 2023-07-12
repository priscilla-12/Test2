package org.charter;

import org.charter.pageObjects.Android.messagePage;
import org.charter.pageObjects.Android.SmsFromCallHisPage;
import org.charter.pageObjects.Android.InstantMsgContactBookPage;
import org.charter.pageObjects.Android.ReceiveSmsWhileBrowsingPage;
import org.charter.pageObjects.Android.ReceiveSmsDuringVoCallPage;
import org.charter.pageObjects.Android.wifiPage;
import org.testng.annotations.Test;

public class TC45_InstantMsgContBook_REDMI_NOTE_6_PRO_ extends BaseTest {

	@Test

	public void receiveMessage() throws InterruptedException {

		InstantMsgContactBookPage msg = new InstantMsgContactBookPage(driver);
		msg.launchAppDirect("com.android.contacts", "com.android.contacts.activities.TwelveKeyDialer");
		msg.clickContacts();
		msg.clickOnSearch();
		msg.selectingUser();
		msg.clickMsgButton();
		msg.sendingSms();
		msg.clickSend();
		msg.verifyTime();

	}

}
