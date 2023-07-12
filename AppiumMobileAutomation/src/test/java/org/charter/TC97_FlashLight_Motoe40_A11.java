package org.charter;

import org.charter.pageObjects.Android.LEDflashLightPage;
import org.testng.annotations.Test;

public class TC97_FlashLight_Motoe40_A11 extends BaseTest {

	@Test
	public void flashLightEnable() throws InterruptedException {
		LEDflashLightPage fl = new LEDflashLightPage(driver);
		fl.swipScrren1();
		fl.swipScrren2();
		fl.clickOnFashLight();

	}

}
