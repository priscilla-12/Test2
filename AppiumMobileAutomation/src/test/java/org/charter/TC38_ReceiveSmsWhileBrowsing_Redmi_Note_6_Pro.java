package org.charter;

import org.charter.pageObjects.Android.messagePage;
import org.charter.pageObjects.Android.ReceiveSmsWhileBrowsingPage;
import org.charter.pageObjects.Android.wifiPage;
import org.testng.annotations.Test;

public class TC38_ReceiveSmsWhileBrowsing_Redmi_Note_6_Pro extends BaseTest {

	@Test

	public void receiveMessage() throws InterruptedException {

		ReceiveSmsWhileBrowsingPage msg = new ReceiveSmsWhileBrowsingPage(driver);
		msg.launchAppDirect("com.android.chrome", "com.google.android.apps.chrome.Main");

		msg.searchBox();
		msg.urlBar();
		msg.search();
		msg.swipe();
		msg.msgReceived();
		msg.verify();

	}

}
