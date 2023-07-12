package org.charter;

import java.net.MalformedURLException;

import org.charter.pageObjects.Android.ChromePage;
import org.charter.pageObjects.Android.rcvMmsPage;
import org.charter.pageObjects.Android.sendMmsPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TC59_ReceiveMmsWhileBrowse_NOTHING_A063 extends BaseTest {

	@Test

	public void handleMms() throws InterruptedException, MalformedURLException {

		// Browse Ascendion
		ChromePage asc = new ChromePage(driver);
		asc.launchAppDirect("com.android.chrome", "com.google.android.apps.chrome.Main");
		Thread.sleep(2000);
		asc.browseOnChrome();

		// Check rcvd MMS
		rcvMmsPage mms = new rcvMmsPage(driver);
		mms.launchAppDirect("com.google.android.apps.messaging", "com.google.android.apps.messaging.main.MainActivity");
		mms.checkRcvMms();
	}

}
