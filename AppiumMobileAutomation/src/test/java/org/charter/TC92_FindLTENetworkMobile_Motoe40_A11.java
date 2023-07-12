package org.charter;

import org.charter.pageObjects.Android.LTENeworkPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class TC92_FindLTENetworkMobile_Motoe40_A11 extends BaseTest {
	@Test
	public void findLTENework() {

		LTENeworkPage lte = new LTENeworkPage(driver);
		lte.launchAppDirect("com.motorola.launcher3", "com.android.launcher3.CustomizationPanelLauncher");
		lte.findLTENework();
		lte.findLTENework2();

		lte.clickOnSetting();
		lte.scrollForLTE();
		lte.clickLTEbttn();

		driver.pressKey(new KeyEvent(AndroidKey.HOME));

		lte.findLTENework();

		lte.displayMessage();
		driver.pressKey(new KeyEvent(AndroidKey.HOME));

	}

}
