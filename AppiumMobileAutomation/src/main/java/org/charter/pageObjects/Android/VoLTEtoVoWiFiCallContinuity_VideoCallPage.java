package org.charter.pageObjects.Android;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.charter.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class VoLTEtoVoWiFiCallContinuity_VideoCallPage extends AndroidActions {
	private static final String accessibility = null;

	AndroidDriver driver;
	public String timerText;
	public VoLTEtoVoWiFiCallContinuity_VideoCallPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(2000)), this);		
	}

	@AndroidFindBy( xpath= "//android.widget.FrameLayout[@content-desc=\"Contacts\"]")
	private WebElement Contact ;
	
	@AndroidFindBy( className="android.widget.EditText")
	 private WebElement Search;
	
	@AndroidFindBy( className="android.widget.QuickContactBadge")
	private WebElement User2;
	
	@AndroidFindBy( xpath= "//android.widget.TextView[@content-desc=\"Make video call\"]")
	 private WebElement Videocall;
	
	@AndroidFindBy( id= "com.google.android.dialer:id/contactgrid_bottom_timer")
	 private WebElement timer;
	
	@AndroidFindBy( accessibility= "Wi-Fi calls")
	 private WebElement Vowifi;
	//@AndroidFindBy( xpath= "//android.widget.ViewAnimator[@resource-id='com.google.android.dialer:id/contactgrid_bottom_timer']")
	// private WebElement timer;
	
	@AndroidFindBy( xpath= "//android.widget.ImageButton[@content-desc=\'End call\']")
	 private WebElement endcall;
	public void videocall() throws InterruptedException {
		Contact.click();
		 Search.click();
		 Search.sendKeys("healer");
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent (AndroidKey.ENTER));
		User2.click();
		Thread.sleep(2000);
		 Videocall.click();
		 
		 Thread.sleep(30000);
		 boolean t = timer.isDisplayed();
		if(t==true) {
			String text = timer.getText();	
			timerText= text;
		}
		else {
			
		}
		 boolean symbol = Vowifi.isDisplayed();
		 if(symbol==true) {
			 System.out.println("The call got established over VoWIFI: " +timerText);
		 }
		 else {
			 System.out.println("VThis is VoWIFI");
		 }
		 endcall.click();
	}
}
