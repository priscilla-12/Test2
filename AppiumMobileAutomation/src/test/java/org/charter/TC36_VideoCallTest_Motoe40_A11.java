package org.charter;

import org.charter.pageObjects.Android.VideoCallMsgPage;
import org.charter.pageObjects.Android.VoiceCallMsgPage;
import org.charter.pageObjects.Android.cameraPage;
import org.testng.annotations.Test;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class TC36_VideoCallTest_Motoe40_A11 extends BaseTest {

	@Test
	public void voiceCallTest() throws InterruptedException {
		VideoCallMsgPage v1 = new VideoCallMsgPage(driver);
		v1.launchAppDirect("com.google.android.dialer", "com.google.android.dialer.extensions.GoogleDialtactsActivity");
		v1.StartCall();

		v1.launchAppDirect("com.google.android.apps.messaging", "com.google.android.apps.messaging.main.MainActivity");
		v1.startMsg();
		v1.swipeScreen();
		driver.pressKey(new KeyEvent(AndroidKey.HOME));

	}

}
