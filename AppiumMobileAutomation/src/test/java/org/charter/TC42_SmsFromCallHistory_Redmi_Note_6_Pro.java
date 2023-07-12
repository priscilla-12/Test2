package org.charter;

import org.charter.pageObjects.Android.messagePage;
import org.charter.pageObjects.Android.SmsFromCallHisPage;
import org.charter.pageObjects.Android.ReceiveSmsWhileBrowsingPage;
import org.charter.pageObjects.Android.ReceiveSmsDuringVoCallPage;
import org.charter.pageObjects.Android.wifiPage;
import org.testng.annotations.Test;

public class TC42_SmsFromCallHistory_Redmi_Note_6_Pro extends BaseTest {

	@Test

	public void receiveMessage() throws InterruptedException {

		SmsFromCallHisPage sms = new SmsFromCallHisPage(driver);
		sms.launchAppDirect("com.android.contacts", "com.android.contacts.activities.TwelveKeyDialer");
		sms.selectUser2();
		sms.clickMsgIcon();
		sms.sendMsg();
		sms.clickSendMsg();
		sms.verifyTime();

	}

}
