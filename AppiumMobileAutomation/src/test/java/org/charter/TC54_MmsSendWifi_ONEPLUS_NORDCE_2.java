package org.charter;

import org.charter.pageObjects.Android.MMSSendWifiPage;

import org.testng.annotations.Test;

public class TC54_MmsSendWifi_ONEPLUS_NORDCE_2 extends BaseTest {
	@Test
	public void SendMMS() throws InterruptedException {

		MMSSendWifiPage msg = new MMSSendWifiPage(driver);

		// launch settings
		msg.launchAppDirect("com.android.settings", "com.android.settings.Settings");

		// turning ofF mobile data and wifi
		msg.settings_wifi();
		msg.settingsBack();
		msg.settings_mobiledata();

		// launch message app
		msg.launchAppDirect("com.google.android.apps.messaging", "com.google.android.apps.messaging.main.MainActivity");

		// send MMS
		msg.sendMMS();
		msg.scrollWithCoordinates(null);

	}

}
