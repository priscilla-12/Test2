package org.charter;

import static org.testng.Assert.assertEquals;

import org.charter.utils.AndroidActions;
import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.Test;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class TC88_DisplayOrientation_vivo1919 extends BaseTest {

	@Test

	public void TouchScreen() {

		try {

			AndroidActions actions = new AndroidActions(driver);

			// Potrait Mode
			actions.launchAppDirect("com.whatsapp", "com.whatsapp.HomeActivity");

			driver.rotate(ScreenOrientation.PORTRAIT);

			ScreenOrientation orientation = driver.getOrientation();
			System.out.println("Orientation is " + orientation);

			assertEquals(orientation.toString(), "PORTRAIT");

			// Landscape
			driver.pressKey(new KeyEvent(AndroidKey.HOME));
			actions.launchAppDirect("com.whatsapp", "com.whatsapp.HomeActivity");

			driver.rotate(ScreenOrientation.LANDSCAPE);
			orientation = driver.getOrientation();
			System.out.println("Orientation is " + orientation);

			assertEquals(orientation.toString(), "LANDSCAPE");

			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
