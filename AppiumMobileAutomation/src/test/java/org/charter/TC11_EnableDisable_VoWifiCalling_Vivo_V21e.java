package org.charter;

import org.charter.pageObjects.Android.wifiPage;
import org.charter.pageObjects.Android.wifiPage2;
import org.testng.annotations.Test;

public class TC11_EnableDisable_VoWifiCalling_Vivo_V21e extends BaseTest {
	
	
	@Test
	public void WifiCallingTest() throws InterruptedException {
		
		// To create an Object of Class wifiPage
		wifiPage2 wifi1 = new wifiPage2(driver);
		
		// Launching Settings in android device
		wifi1.launchAppDirect("com.android.settings", "com.android.settings.Settings");
		
		// To open Network settings
		wifi1.openNetworkAndInternet();
		
		// To open Sim card settings
		wifi1.openSIMCard();
		
		// Open Sim card
		wifi1.gotSim1();
		
		// To Scroll down
		wifi1.uiautomatorScroll("Wi-Fi calling");
		
		//To open WifiCalling 
		wifi1.openWiFiCalling();
		
		//To Turn On WifiCalling
		wifi1.turnWifiCalling("On");
		
		//To move 2nd sim option
		wifi1.gotSim2();
		
		//To Turn On WifiCalling
		wifi1.turnWifiCalling("On");
		Thread.sleep(3000);
		
	}

}
