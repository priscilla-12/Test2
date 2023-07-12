package org.charter;

import org.charter.pageObjects.Android.FindMyDevicePage_RealmeX3;
import org.testng.annotations.Test;

public class TC04_AbilityToFindMyMobile_RealMeX3 extends BaseTest {

	@Test
	public void findMyDevice() throws InterruptedException {

		FindMyDevicePage_RealmeX3 fmv = new FindMyDevicePage_RealmeX3(driver);
		// To directly open the settings activity
		fmv.launchAppDirect("com.android.settings", "com.android.settings.Settings");

		// To click searchbox in settings
		fmv.settingsSearchbox();

		// To enter data in searchbox
		fmv.enterSettingName("find my device");

		// To click on search icon on Android keyboard
		fmv.clickSearchIcon();

		// To check if Find My Device is present or not
		fmv.checkFindMyDevice("Find My Device");

		// To open Find My Device
		fmv.clickFindMyDevice();

		// To open Find My Device app
		fmv.clickOpenApp();
		Thread.sleep(3000);

		// To Check if device name Available or not
		fmv.checkDevice("Realme X3");

		// To navigate back
		fmv.navigateBack();
		Thread.sleep(3000);

		// To open Web Portal
		fmv.clickOpenWebPortal();
		Thread.sleep(6000);

		// To Check if Last seen Available or not
		fmv.verifyForURL("android/find");

	}
}
