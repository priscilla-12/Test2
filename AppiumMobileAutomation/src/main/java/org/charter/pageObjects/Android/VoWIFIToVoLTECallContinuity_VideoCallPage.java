package org.charter.pageObjects.Android;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.charter.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class VoWIFIToVoLTECallContinuity_VideoCallPage extends AndroidActions {
	private static final String accessibility = null;
	public String timerText;
	AndroidDriver driver;
	public VoWIFIToVoLTECallContinuity_VideoCallPage(AndroidDriver driver) {
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
	
	@AndroidFindBy( id= "android:id/navigationBarBackground")
	 private WebElement Home;
	
	
	@AndroidFindBy( accessibility= "VoLTE")
	 private WebElement VoLTE;
	
	@AndroidFindBy( xpath= "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout")
	 private WebElement Notification ;
	
	@AndroidFindBy( id= "com.android.launcher:id/workspace")
	 private WebElement SwipeDown;
	
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
		Thread.sleep(2000);
        driver.pressKey(new KeyEvent (AndroidKey.HOME));
        Actions Act=new Actions(driver);
        Act.doubleClick(Notification).pause(2000);
        swipeDown(Notification,"down");
        boolean symbol = VoLTE.isDisplayed();
		 if(symbol==true) { 
			 
			 System.out.println("The call got established over VoLTE: " +timerText);
		 }
		 else {
			 System.out.println("This is not a VoLTE");
		 }
		// endcall.click();
	}
	
		
}
 