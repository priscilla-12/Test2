package org.charter;

import org.charter.pageObjects.Android.VerifyVideoCallRejectPage;
import org.charter.pageObjects.Android.messagePage;
import org.charter.pageObjects.Android.wifiPage;
import org.testng.annotations.Test;

public class TC23_VerifyVideoCallReject_RealMe_RMX3085 extends BaseTest {
	
	@Test
	
	public void sendMessage() {
		
		
		try {	
			//Send SMS
			 VerifyVideoCallRejectPage c = new VerifyVideoCallRejectPage(driver);
			c.launchAppDirect("com.google.android.dialer","com.google.android.dialer.extensions.GoogleDialtactsActivity");
		    c.videocall();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
