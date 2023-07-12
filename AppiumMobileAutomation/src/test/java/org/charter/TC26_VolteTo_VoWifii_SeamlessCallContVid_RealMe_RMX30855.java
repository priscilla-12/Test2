package org.charter;

import org.charter.pageObjects.Android.VerifyVideoCallRejectPage;
import org.charter.pageObjects.Android.VoLTEtoVoWiFiCallContinuity_VideoCallPage;
import org.charter.pageObjects.Android.messagePage;
import org.charter.pageObjects.Android.wifiPage;
import org.testng.annotations.Test;

public class TC26_VolteTo_VoWifii_SeamlessCallContVid_RealMe_RMX30855 extends BaseTest {
	
	@Test
	
	public void Vowifi() {
		
		
		try {	
			//Send SMS
			 VoLTEtoVoWiFiCallContinuity_VideoCallPage v = new VoLTEtoVoWiFiCallContinuity_VideoCallPage(driver);
			v.launchAppDirect("com.google.android.dialer","com.google.android.dialer.extensions.GoogleDialtactsActivity");
		    v.videocall();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
