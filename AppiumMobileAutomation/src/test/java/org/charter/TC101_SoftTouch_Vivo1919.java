package org.charter;

import org.charter.utils.AndroidActions;
import org.testng.annotations.Test;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class TC101_SoftTouch_Vivo1919 extends BaseTest {

	@Test

	public void SoftTouchOnAllInstalledApps() {

		try {

			// Open Linkedln , Settings and Messaging apps one by one and close it
			AndroidActions actions = new AndroidActions(driver);
			actions.launchAppDirect("com.linkedin.android", "com.linkedin.android.authenticator.LaunchActivity");
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			Thread.sleep(2000);
			actions.launchAppDirect("com.android.settings", "com.android.settings.Settings");
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			Thread.sleep(2000);
			actions.launchAppDirect("com.android.mms", "com.android.mms.ui.ConversationList");
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
