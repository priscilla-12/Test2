package org.charter;

import org.charter.pageObjects.Android.TextMessagePage;
import org.testng.annotations.Test;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class TC34_TextMsgTest_Motoe40_A11 extends BaseTest {

	@Test
	public void deleteTextMessage() throws InterruptedException {

		TextMessagePage textmsg = new TextMessagePage(driver);
		textmsg.launchAppDirect("com.google.android.apps.messaging",
				"com.google.android.apps.messaging.main.MainActivity");
		textmsg.deleteMsg();
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
	}

}
