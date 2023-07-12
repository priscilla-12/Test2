package org.charter;

import org.charter.pageObjects.Android.WiFiRadioPage;
import org.charter.pageObjects.Android.microphonePage;
import org.testng.annotations.Test;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class TC98_MicroPhoneTest_Motoe40_A11 extends BaseTest {

	@Test
	public void microphoneTest() throws InterruptedException {

		microphonePage mico = new microphonePage(driver);
		// mico.swipToUp();

		Thread.sleep(5000);

		mico.clickToPlayStore();

		Thread.sleep(5000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));

		driver.pressKey(new KeyEvent(AndroidKey.HOME));

		Thread.sleep(10000);

		mico.startRecording();
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
	}

}
