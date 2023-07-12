package org.charter;

import org.charter.pageObjects.Android.VerifyVideoCallRingingTimeoutPage;
import org.charter.pageObjects.Android.VerifyVideoCallRejectPage;
import org.charter.pageObjects.Android.messagePage;
import org.charter.pageObjects.Android.wifiPage;
import org.testng.annotations.Test;

public class TC24_VerifyVdCallRingingTimeout_RealMe_RMX3085 extends BaseTest {
	
	@Test
	
	public void call() {
		
		
		try {	
			//Making Videocall
			 VerifyVideoCallRingingTimeoutPage Vc = new VerifyVideoCallRingingTimeoutPage(driver);
			Vc.launchAppDirect("com.google.android.dialer","com.google.android.dialer.extensions.GoogleDialtactsActivity");
		    Vc.videocall();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
