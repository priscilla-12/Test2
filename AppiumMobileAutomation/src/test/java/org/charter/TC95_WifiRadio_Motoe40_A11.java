package org.charter;

import org.charter.pageObjects.Android.WiFiRadioPage;
import org.testng.annotations.Test;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class TC95_WifiRadio_Motoe40_A11 extends BaseTest {

	@Test
	public void WifiRadioEnable() throws InterruptedException {
		WiFiRadioPage wifi = new WiFiRadioPage(driver);
		wifi.swipScrren1();
		wifi.swipScrren2();
		wifi.clickOnSetting();
		wifi.wifienable();

		driver.pressKey(new KeyEvent(AndroidKey.HOME));

		Thread.sleep(5000);

		WiFiRadioPage spt = new WiFiRadioPage(driver);

		spt.swipToUp();

		Thread.sleep(5000);

		spt.oklaTest();
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
	}

}
