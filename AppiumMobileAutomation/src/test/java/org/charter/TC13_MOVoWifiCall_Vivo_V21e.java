package org.charter;

import org.charter.pageObjects.Android.wifiPage;
import org.charter.pageObjects.Android.wifiPage2;
import org.testng.annotations.Test;

public class TC13_MOVoWifiCall_Vivo_V21e extends BaseTest {
	
	
	@Test
	public void CallViaWifiTest() throws InterruptedException {
		
		// To create an Object of Class wifiPage
		wifiPage2 c1 = new wifiPage2(driver);
		
		// Launching Settings in android device
		c1.launchAppDirect("com.android.settings", "com.android.settings.Settings");
		
		// To open Network settings
		c1.openNetworkAndInternet();
		
		// To open Wifi
		c1.openWiFi();
		
		// To open Sim card settings
		c1.openSIMCard();
		
		// Open Sim card
		c1.gotSim1();
		
		// To Scroll down
		c1.uiautomatorScroll("Wi-Fi calling");
		
		//To open WifiCalling 
		c1.openWiFiCalling();
		
		//To Turn On WifiCalling
		c1.turnWifiCalling("On");
		Thread.sleep(2000);
		
		//To move 2nd sim option
		c1.gotSim2();
		
		//To open WifiCalling 
		c1.turnWifiCalling("On");
		Thread.sleep(2000);
		
		//To Go HomePage
		c1.HomePage();
		Thread.sleep(2000);
		
		//To Open Dialer
		c1.openDialer();
		Thread.sleep(5000);
		
		// To Click Number
		c1.clickNumber("9");
		c1.clickNumber("1");
		c1.clickNumber("7");
		c1.clickNumber("2");
		c1.clickNumber("8");
		c1.clickNumber("1");
		c1.clickNumber("2");
		c1.clickNumber("1");
		c1.clickNumber("1");
		c1.clickNumber("6");
		c1.clickDialNumber();
	}

}
