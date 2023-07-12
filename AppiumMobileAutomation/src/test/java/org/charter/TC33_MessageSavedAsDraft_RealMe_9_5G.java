package org.charter;

import org.charter.pageObjects.Android.messagePage;
import org.charter.pageObjects.Android.wifiPage;
import org.testng.annotations.Test;
import org.charter.utils.*;

public class TC33_MessageSavedAsDraft_RealMe_9_5G extends BaseTest {

	@Test

	public void draftMessage() {

		try {

			messagePage msg = new messagePage(driver);
			msg.launchAppDirect("com.google.android.apps.messaging",
					"com.google.android.apps.messaging.main.MainActivity");
			msg.draftMessage();
			Thread.sleep(2000);
			msg.launchAppDirect("com.google.android.apps.messaging",
					"com.google.android.apps.messaging.main.MainActivity");
			msg.draftmsgIcon();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
