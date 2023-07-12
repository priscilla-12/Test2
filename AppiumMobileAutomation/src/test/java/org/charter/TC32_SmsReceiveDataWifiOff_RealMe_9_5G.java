package org.charter;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.charter.pageObjects.Android.messagePage;
import org.charter.pageObjects.Android.wifiPage;
import org.testng.annotations.Test;
import org.charter.utils.*;

public class TC32_SmsReceiveDataWifiOff_RealMe_9_5G extends BaseTest {

	@Test
	public void receiveMessage() {

		try {

			SimpleDateFormat formatter = new SimpleDateFormat("hh:mm aa");

			String startTime = formatter.format(Calendar.getInstance().getTime());

			wifiPage wifi = new wifiPage(driver);
			wifi.launchAppDirect("com.android.settings", "com.android.settings.Settings");
			wifi.turnOffWifi();
			Thread.sleep(20000);
			wifi.turnOffMobileDataNetwork();
			Thread.sleep(20000);

			messagePage msg = new messagePage(driver);
			msg.launchAppDirect("com.google.android.apps.messaging",
					"com.google.android.apps.messaging.main.MainActivity");
			Thread.sleep(20000);

			msg.receivemsg(startTime);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
