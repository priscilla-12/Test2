package org.charter;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.charter.pageObjects.Android.*;
import org.charter.pageObjects.Android.wifiPage;
import org.testng.annotations.Test;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import org.charter.utils.*;

public class TC29_ToVerifyMoVoiceCall_RealMe_9_5G extends BaseTest {

	@Test
	public void receiveMessage() {

		try {

			WOdialPadPage movoice = new WOdialPadPage(driver);
			driver.pressKey(new KeyEvent(AndroidKey.HOME));
			movoice.phoneIcon();

			movoice.moVoiceCall();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
