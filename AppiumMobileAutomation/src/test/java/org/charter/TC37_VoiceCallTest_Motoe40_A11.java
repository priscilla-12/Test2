package org.charter;

import org.charter.pageObjects.Android.VoiceCallMsgPage;
import org.charter.pageObjects.Android.cameraPage;
import org.testng.annotations.Test;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class TC37_VoiceCallTest_Motoe40_A11 extends BaseTest {

	@Test
	public void voiceCallTest() throws InterruptedException {
		VoiceCallMsgPage v1 = new VoiceCallMsgPage(driver);
		v1.launchAppDirect("com.google.android.dialer", "com.google.android.dialer.extensions.GoogleDialtactsActivity");
		v1.StartCall();

		v1.launchAppDirect("com.google.android.apps.messaging", "com.google.android.apps.messaging.main.MainActivity");
		v1.startMsg();
		v1.swipeScreen();
		driver.pressKey(new KeyEvent(AndroidKey.HOME));

	}

}
