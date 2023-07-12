package org.charter;

import org.charter.pageObjects.Android.messagePage;
import org.charter.pageObjects.Android.ReceiveSmsWhileBrowsingPage;
import org.charter.pageObjects.Android.ReceiveSmsDuringVoCallPage;
import org.charter.pageObjects.Android.ReceiveSmsDuringVidCallPage;
import org.charter.pageObjects.Android.wifiPage;
import org.testng.annotations.Test;

public class TC40_ReceiveSmsDuringVdCall_Redmi_Note_6_Pro extends BaseTest {

	@Test

	public void receiveMessage() throws InterruptedException {

		ReceiveSmsDuringVidCallPage call = new ReceiveSmsDuringVidCallPage(driver);
		call.launchAppDirect("com.android.contacts", "com.android.contacts.activities.TwelveKeyDialer");
		call.contact();
		call.search();
		call.name();
		call.call();
		call.launchAppDirect("com.android.mms", "com.android.mms.ui.MmsTabActivity");
		call.clickOnName();
		call.verifyTime();

	}

}
