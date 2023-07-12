package org.charter;

import org.charter.pageObjects.Android.messagePage;
import org.charter.pageObjects.Android.wifiPage;
import org.testng.annotations.Test;
import org.charter.utils.*;

public class TC31_SmsSendDataWifiOff_RealMe_9_5G extends BaseTest {

	@Test

	public void sendMessage() {

		try {

			wifiPage wifi = new wifiPage(driver);
			wifi.launchAppDirect("com.android.settings", "com.android.settings.Settings");
			wifi.turnOffWifi();
			wifi.turnOffMobileDataNetwork();

			messagePage msg = new messagePage(driver);
			msg.launchAppDirect("com.google.android.apps.messaging",
					"com.google.android.apps.messaging.main.MainActivity");
			msg.sendMessage();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
