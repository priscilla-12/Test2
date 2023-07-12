package org.charter1;

import java.io.File;
import java.net.URL;
import java.time.Duration;

import org.charter.pageObjects.Android.msgPage;

import org.charter.pageObjects.Android.MmsSendPage;
import org.charter.pageObjects.Android1.TC79_ORGPHOTOPAGE_SAMSUNG_SM_A536E;
import org.charter.pageObjects.Android1.TC80_ORGVIDEOPAGE_SAMSUNG_SM_A536E;
import org.charter.pageObjects.Android1.TC81_PHOTOSENDPAGE_SAMSUNG_SM_A536E;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class TC80_ORGVIDEO_SAMSUNG_SM_A536E extends BaseTest{
	 
		
		
    @Test
	
	public void browseVideos() throws InterruptedException {
		
	//	try {	
			
			// Turning off Wifi and Mobile Data
//		      wifiPage wifi = new wifiPage(driver);
//		      wifi.launchAppDirect("com.android.settings","com.android.settings.Settings");
//		      wifi.turnOffWifi();
//			  wifi.turnOffMobileDataNetwork();			
	
			//Send SMS
			TC80_ORGVIDEOPAGE_SAMSUNG_SM_A536E video = new TC80_ORGVIDEOPAGE_SAMSUNG_SM_A536E(driver);
			//msg.launchAppDirect("com.google.android.apps.messaging","com.google.android.apps.messaging.main.MainActivity");
			video.launchAppDirect("com.sec.android.app.launcher","com.sec.android.app.launcher.activities.LauncherActivity");
			video.swipeScreen();
			video.search();
			video.searchEdit();
			video.photos();
			video.library();
			video.download();
			//photo.demoFolder();
			video.longPressVideos();
			video.actionBar();
			video.copyFolder();
			video.allow();
			video.newFolder();
			video.folderName();
			video.create();
			video.againFolder();
			video.verify();
		
			
            
       
		
}}






