package org.charter;

import org.charter.pageObjects.Android.FormPage_RealmeX3;
import org.testng.annotations.Test;

public class TC02_ThirdPartyApps_RealMeX3 extends BaseTest {

	@Test
	public void playStoreApp() {

		// Creating an Object
		FormPage_RealmeX3 form = new FormPage_RealmeX3(driver);

		// Directly launching playstore
		form.launchAppDirect("com.android.vending", "com.android.vending.AssetBrowserActivity");

		// Click on playstore searchbox
		form.pStoreSearchBox();

		// Enter to app name in searchbox
		form.enterAppName("netflix");

		// To open Find My Device app
		form.clickSearchIcon();

		// To install or open the app
		form.openOrInstallRealApp();

	}

}
