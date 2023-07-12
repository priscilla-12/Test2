package org.charter1;

import java.io.File;
import java.net.URL;
import java.time.Duration;

import org.charter.pageObjects.Android.msgPage;

import org.charter.pageObjects.Android.SecondNoPage;
import org.charter.pageObjects.Android1.TC74_ADDPICTUREPAGE_SAMSUNG_SM_A536E;
import org.charter.pageObjects.Android1.TC76_DELETECONTPAGE_SAMSUNG_SM_A536E;
import org.charter.pageObjects.Android1.TC75_SEARCHCONTPAGE_SAMSUNG_SM_A536E;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class TC76_DELETECONT_SAMSUNG_SM_A536E extends BaseTest{
	 
		
		
    @Test
	
	public void deletecontact() throws InterruptedException {
		
		
	//	try {	
			
			// Turning off Wifi and Mobile Data
//		      wifiPage wifi = new wifiPage(driver);
//		      wifi.launchAppDirect("com.android.settings","com.android.settings.Settings");
//		      wifi.turnOffWifi();
//			  wifi.turnOffMobileDataNetwork();			
	
			//Send SMS
			TC76_DELETECONTPAGE_SAMSUNG_SM_A536E contact = new TC76_DELETECONTPAGE_SAMSUNG_SM_A536E(driver);
			contact.launchAppDirect("com.sec.android.app.launcher","com.sec.android.app.launcher.activities.LauncherActivity");
			contact.swipeScreen();
			contact.clickPhoneIcon();
			contact.searchIcon();
			contact.searchText();
			contact.contactList();
			contact.detailsButton();
			contact.more();
			contact.deleteOption();
			contact.deleteBtn();
			contact.verify();
			
			
			
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		
}}






