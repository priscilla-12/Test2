package org.charter;

import org.charter.pageObjects.Android.BrowsingPage;
import org.charter.pageObjects.Android.cameraPage;
import org.testng.annotations.Test;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class TC35_BrowsingTest_Motoe40_A11 extends BaseTest {

	@Test
	public void BrowserSearch() throws InterruptedException {
		BrowsingPage s = new BrowsingPage(driver);
		s.browsingTest();
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		s.launchAppDirect("com.google.android.apps.messaging", "com.google.android.apps.messaging.main.MainActivity");
		s.sendMessge();
	}
}