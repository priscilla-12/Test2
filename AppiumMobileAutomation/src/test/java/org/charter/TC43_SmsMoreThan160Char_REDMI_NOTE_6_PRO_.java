package org.charter;

import org.charter.pageObjects.Android.SmsMoreThan160CharPage;
import org.charter.pageObjects.Android.messagePage;
import org.charter.pageObjects.Android.SmsFromCallHisPage;
import org.charter.pageObjects.Android.InstantMsgContactBookPage;
import org.charter.pageObjects.Android.ReceiveSmsWhileBrowsingPage;
import org.charter.pageObjects.Android.ReceiveSmsDuringVoCallPage;
import org.charter.pageObjects.Android.MessageDeliverSpclCharPage;
import org.charter.pageObjects.Android.wifiPage;
import org.testng.annotations.Test;

public class TC43_SmsMoreThan160Char_REDMI_NOTE_6_PRO_ extends BaseTest {

	@Test

	public void longText() throws InterruptedException {

		SmsMoreThan160CharPage lng = new SmsMoreThan160CharPage(driver);
		lng.launchAppDirect("com.android.mms", "com.android.mms.ui.MmsTabActivity");
		lng.clickOnAdd();
		lng.clickOnReci();
		lng.recipientName();
		lng.selectUser();
		lng.clickTypMsg();
		lng.clickSend();
		lng.verifyTime();

	}

}
