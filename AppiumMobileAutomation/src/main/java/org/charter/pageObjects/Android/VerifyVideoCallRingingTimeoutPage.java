package org.charter.pageObjects.Android;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.charter.utils.AndroidActions;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class VerifyVideoCallRingingTimeoutPage extends AndroidActions {
	private static final String accessibility = null;

	AndroidDriver driver;
	public VerifyVideoCallRingingTimeoutPage(AndroidDriver driver) {
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
	
	@AndroidFindBy( xpath= "//android.widget.ImageButton[@content-desc=\'End call\']")
	 private WebElement endcall;
	
	public void videocall() throws InterruptedException {
		Contact.click();
		 Search.click();
		 Search.sendKeys("healer");
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent (AndroidKey.ENTER));
		User2.click();
		Thread.sleep(3000);
		 Videocall.click();
		  Thread.sleep(40000);
		 endcall.click();
		 
	 }
}
