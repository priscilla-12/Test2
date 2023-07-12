package org.charter;

import org.charter.pageObjects.Android.AccessibilityVisionPage_RealmeX3;
import org.testng.annotations.Test;

public class TC05_VisionVoiceAssistant_RealMeX3 extends BaseTest {

	@Test
	public void AccessibilityVision() throws InterruptedException {

		AccessibilityVisionPage_RealmeX3 vision1 = new AccessibilityVisionPage_RealmeX3(driver);

		// To directly open the settings activity
		vision1.launchAppDirect("com.android.settings", "com.android.settings.Settings");

		// To click searchbox in settings
		vision1.settingsSearchbox();

		// To enter data in searchbox
		vision1.enterSettingName("google assistant");

		// To click on search icon on Android keyboard
		vision1.clickSearchIcon();

		// Scrolling to accessibility
		vision1.uiautomatorScroll("Accessibility");
		Thread.sleep(5000);

		// Open accessibility
		vision1.clickaccessibility();
		Thread.sleep(2000);

		for (int i = 0; i < 2; i++) {
			vision1.navigateHome();
		}

		// clicks google search icon
		vision1.clickGoogleSearchBox();

		// Sends the string to google searchbox
		vision1.askGoogle("What is the temperature today");

		// clicks google search icon
		vision1.clickSearchIcon();
		Thread.sleep(5000);

		// This is to verify if the results displayed on web portal or not
		vision1.verifyResults("Weather");

		// navigates to home screen, need of loop is because it navigates to recent home
		// tab
		// that doesn't have google assistant
		for (int i = 0; i < 2; i++) {
			vision1.navigateHome();
		}

		// wakes up google by clicking on mike
		vision1.clickMikeIcon();

	}

}
