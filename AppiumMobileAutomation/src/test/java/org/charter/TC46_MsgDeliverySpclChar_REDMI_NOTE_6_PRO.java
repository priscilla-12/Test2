package org.charter;

import org.charter.pageObjects.Android.messagePage;
import org.charter.pageObjects.Android.SmsFromCallHisPage;
import org.charter.pageObjects.Android.InstantMsgContactBookPage;
import org.charter.pageObjects.Android.ReceiveSmsWhileBrowsingPage;
import org.charter.pageObjects.Android.ReceiveSmsDuringVoCallPage;
import org.charter.pageObjects.Android.MessageDeliverSpclCharPage;
import org.charter.pageObjects.Android.wifiPage;
import org.testng.annotations.Test;

public class TC46_MsgDeliverySpclChar_REDMI_NOTE_6_PRO extends BaseTest {

	@Test

	public void specialCharacters() throws InterruptedException {

		MessageDeliverSpclCharPage spl = new MessageDeliverSpclCharPage(driver);
		spl.launchAppDirect("com.android.mms", "com.android.mms.ui.MmsTabActivity");
		spl.clickAddIcon();
		spl.clickOnReci();
		spl.recipientName();
		spl.selectUser();
		spl.clickingText();
		spl.clickSend();
		spl.verifyTime();
	}

}
