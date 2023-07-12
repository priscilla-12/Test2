package org.charter;

import org.charter.pageObjects.Android.VerifyVideoCallRejectPage;
import org.charter.pageObjects.Android.VoWIFIToVoLTECallContinuity_VideoCallPage;
import org.charter.pageObjects.Android.VoLTEtoVoWiFiCallContinuity_VideoCallPage;
import org.charter.pageObjects.Android.messagePage;
import org.charter.pageObjects.Android.wifiPage;
import org.testng.annotations.Test;

public class TC25_VoWifiToVolteSeamlessCallContVidCall_RealMe_RMX3085 extends BaseTest {
	
	@Test
	
	public void Vowifi() {
		
		
		try {	
			//Send SMS
			 VoWIFIToVoLTECallContinuity_VideoCallPage vc= new VoWIFIToVoLTECallContinuity_VideoCallPage(driver);
			vc.launchAppDirect("com.google.android.dialer","com.google.android.dialer.extensions.GoogleDialtactsActivity");
		    vc.videocall();
		 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
