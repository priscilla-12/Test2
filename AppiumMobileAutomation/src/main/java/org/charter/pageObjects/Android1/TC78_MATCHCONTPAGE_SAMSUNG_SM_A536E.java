package org.charter.pageObjects.Android1;

import java.time.Duration;

import org.charter.utils.AndroidActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TC78_MATCHCONTPAGE_SAMSUNG_SM_A536E extends AndroidActions {

	AndroidDriver driver;
	

	 public TC78_MATCHCONTPAGE_SAMSUNG_SM_A536E(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(2000)), this);		
	}
	 
	 
	 
	 
	 @AndroidFindBy(id = "com.sec.android.app.launcher:id/workspace")
	 private WebElement  swipeLabel;
	 
	 @AndroidFindBy(accessibility = "Phone")
	 private WebElement  phoneIcon;
	 
     @AndroidFindBy(xpath = "//android.widget.TextView[@text='Keypad']")
	 private WebElement  clickKeypad;
	 
	 @AndroidFindBy(id = "com.samsung.android.dialer:id/digits")
	 private WebElement  clickDialer;
	 
	 @AndroidFindBy(id = "com.samsung.android.dialer:id/dialpad_search_result_content_layout")
	 private WebElement  viewContent;
	 
	 @AndroidFindBy(id = "com.samsung.android.dialer:id/dialButtonImage")
	 private WebElement  clickDialButton;
	 
	 @AndroidFindBy(xpath = "//android.widget.TextView[@text='SIM 1']")
	 private WebElement  selectSIM;
	 
	 @AndroidFindBy(id = "com.samsung.android.incallui:id/call_time")
	 private WebElement  verifyCall;
	 
	 @AndroidFindBy(accessibility = "End call")
	 private WebElement  clickEndCall;
	 
	 @AndroidFindBy(id = "android:id/button2")
	 private WebElement  cancelButton;
	 
	 @AndroidFindBy(id = "com.samsung.android.incallui:id/call_card_state_container")
	 private WebElement  callContainer;
	 
	 
	
	 
	 
	 
	 
	 public void swipeScreen() throws InterruptedException
	 {
		 swipeUp(swipeLabel, "up");
		 Thread.sleep(5000);

}

	

	    public void clickPhoneIcon() throws InterruptedException {
		phoneIcon.click();
		Thread.sleep(8000);
		
	}
	    

	   public void keypad() throws InterruptedException {
		   clickKeypad.click();
	       Thread.sleep(8000);
			
		}
	   public void dialer() throws InterruptedException  {
		   clickDialer.click();
		   clickDialer.sendKeys("574");
			Thread.sleep(8000);
			
		}
	   public void content() throws InterruptedException  {
		   viewContent.click();
		   Thread.sleep(8000);
			
		}
	   
	   public void dialButton() throws InterruptedException   {
		   clickDialButton.click();
		   Thread.sleep(8000);
			
		}
	   
	   public void sim() throws InterruptedException {
		   selectSIM.click();
		 Thread.sleep(5000);
		 }


	   
	   public void verify() throws InterruptedException {
//			verifyContacts.click();
			Thread.sleep(5000);
			
			boolean results = verifyCall.isDisplayed();
			Thread.sleep(8000);
			
			System.out.println(verifyCall.getText());
			//System.out.println(driver.getDeviceTime());
			if(results) {
				System.out.println("User directly select the phonebook entry and make the call successfully");
			} else {
				System.out.println("User directly select the phonebook entry and make the call is failed");
			}
	    Thread.sleep(8000);
	    clickEndCall.click();
	    cancelButton.click();
	    Thread.sleep(2000);
	    driver.pressKey(new KeyEvent (AndroidKey.BACK));
	    Thread.sleep(2000);
	    driver.pressKey(new KeyEvent (AndroidKey.BACK));
	    
	   }
	   

	   }

