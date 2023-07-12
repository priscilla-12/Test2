package org.charter;

import org.charter.pageObjects.Android.LTERadioPage;
import org.testng.annotations.Test;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class TC100_LTERadioTest_Motoe40_A11 extends BaseTest {
	@Test
	public void findLTENework() throws InterruptedException {

		LTERadioPage lte = new LTERadioPage(driver);
		lte.launchAppDirect("com.motorola.launcher3", "com.android.launcher3.CustomizationPanelLauncher");
		lte.findLTENework();
		lte.findLTENework2();

		lte.clickOnSetting();
		lte.scrollForLTE();
		lte.clickLTEbttn();

		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		lte.swipToUp();
		lte.downloadSpeedTest();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));

		lte.checkSpeed();

		driver.pressKey(new KeyEvent(AndroidKey.HOME));
	}

}
