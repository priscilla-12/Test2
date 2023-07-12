package org.charter1;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Utitlities.ReadConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest extends ReadConfig {
	
	public static AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public  void appiumConfiguration() throws MalformedURLException {
		 try {
			service = new AppiumServiceBuilder()
					.withAppiumJS(new File(readPropertyFile("appiumJsPath")))
					.usingDriverExecutable(new File(readPropertyFile("nodePath")))
					.withIPAddress("127.0.0.1")
					.usingPort(4723).withTimeout(Duration.ofSeconds(300)).build();
			
			
			service.start();
			
			boolean flg = service.isRunning();
			System.out.println(flg);
			
			UiAutomator2Options options = new UiAutomator2Options();
			options.setDeviceName(readPropertyFile("deviceName"));
			//options.setChromedriverExecutable("C:\\Users\\priscilla.d\\Documents\\chromedriver.exe");
	//		options.setApp(readPropertyFile("apkPath"));
//			options.setAppPackage("com.ebsco.dmp");
//			options.setAppActivity("com.ebsco.dmp.ui.DMPMainActivity");
			
			//options.setApp(readPropertyFile("apkPath"));
			//options.setAppPackage("com.android.vending");
  		   // options.setAppActivity("com.google.android.apps.messaging");
			
			 driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		} catch (AppiumServerHasNotBeenStartedLocallyException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	@AfterClass(enabled=true)
	public void tearDown() {
		try {
			driver.quit();
			service.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
