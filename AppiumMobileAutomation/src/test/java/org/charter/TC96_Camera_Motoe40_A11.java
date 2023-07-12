package org.charter;

import org.charter.pageObjects.Android.cameraPage;
import org.testng.annotations.Test;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class TC96_Camera_Motoe40_A11 extends BaseTest {

	@Test
	public void CameraClick() throws InterruptedException {
		cameraPage c1 = new cameraPage(driver);
		c1.swipToUp();
		c1.clickToCamera();
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
	}

}
