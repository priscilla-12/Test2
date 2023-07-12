package org.charter;

import org.charter.pageObjects.Android.systemAppSettingsPage;
import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.Test;

public class TC102_VendorDefaultApps_Vivo1919 extends BaseTest {

	@Test

	public void checkUpdates() {

		try {

			// Turning off Wifi and Mobile Data
			systemAppSettingsPage sa = new systemAppSettingsPage(driver);
			sa.launchAppDirect("com.android.settings", "com.android.settings.Settings");
			sa.navigateToSysAppSettings();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
