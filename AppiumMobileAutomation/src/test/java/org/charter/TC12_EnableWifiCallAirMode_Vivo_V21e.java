package org.charter;

import org.charter.pageObjects.Android.wifiPage;
import org.charter.pageObjects.Android.wifiPage2;
import org.testng.annotations.Test;

public class TC12_EnableWifiCallAirMode_Vivo_V21e extends BaseTest {
	
	
	@Test
	public void AirplaneModeTest() throws InterruptedException {
		
		// To create an Object of Class wifiPage
		wifiPage2 am = new  wifiPage2(driver);
		
		// Launching Settings in android device
		am.launchAppDirect("com.android.settings", "com.android.settings.Settings");
		
		// To open Network settings
		am.openNetworkAndInternet();
		
		//To Open Airplane Mode
		am.openAirplaneMode();
		
		// To open Wifi
		am.openWiFi();
		
		// To open Sim card settings
		am.openSIMCard();
		
		// Open Sim card
		am.gotSim1();
		
		// To Scroll down
		am.uiautomatorScroll("Wi-Fi Calling");
		
		//To open WifiCalling 
		am.openWiFiCalling();
		
		//To Turn On WifiCalling
		am.turnWifiCalling("On");
		Thread.sleep(5000);
		
		//To move 2nd sim option
		am.gotSim2();
		
		//To open WifiCalling 
		am.turnWifiCalling("On");
	}

}
