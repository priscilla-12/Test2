package org.charter;

import org.charter.pageObjects.Android.touchScreenPage;
import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.Test;

public class TC87_TouchScreen_Vivo1919 extends BaseTest {

	@Test

	public void TouchScreen() {

		try {

			touchScreenPage touch = new touchScreenPage(driver);

			touch.swipeLeft();
			touch.swipeRight();
			touch.swipeUp();
			touch.swipeDown();

			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
