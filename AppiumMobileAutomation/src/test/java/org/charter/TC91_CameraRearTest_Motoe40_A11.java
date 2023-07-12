package org.charter;

import org.charter.pageObjects.Android.cameraPage;
import org.charter.pageObjects.Android.cameraRearPage;
import org.testng.annotations.Test;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class TC91_CameraRearTest_Motoe40_A11 extends BaseTest {

	@Test
	public void CameraClick() throws InterruptedException {
		cameraRearPage c1 = new cameraRearPage(driver);
		c1.swipToUp();
		c1.clickToRearCam();
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
	}

}
