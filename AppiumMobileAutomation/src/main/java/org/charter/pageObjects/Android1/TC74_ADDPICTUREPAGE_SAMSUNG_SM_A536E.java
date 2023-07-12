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

public class TC74_ADDPICTUREPAGE_SAMSUNG_SM_A536E extends AndroidActions {

	AndroidDriver driver;
	

	 public TC74_ADDPICTUREPAGE_SAMSUNG_SM_A536E(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(2000)), this);		
	}
	 
	 
	 
	 
	 @AndroidFindBy(id = "com.sec.android.app.launcher:id/workspace")
	 private WebElement  swipeLabel;
	 
	 @AndroidFindBy(accessibility = "Phone")
	 private WebElement  phoneIcon;
	 
     @AndroidFindBy(accessibility = "Search")
	 private WebElement  clicksearchIcon;
	 
	 @AndroidFindBy(id = "com.samsung.android.dialer:id/search_src_text")
	 private WebElement  clicksearchText;
	 
	 @AndroidFindBy(accessibility = "Demo")
	 private WebElement  clickcontactList;
	 
	 @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Details, Button\"]")
	 private WebElement  clickDetailsButton;
	 
	 @AndroidFindBy(accessibility = "Edit contact")
	 private WebElement  editProfilePicture;
	 
     @AndroidFindBy(accessibility = "Gallery")
	 private WebElement  clickGallery;
	 
	 @AndroidFindBy(xpath = "//android.widget.TextView[@text='Downloads']")
	 private WebElement  clickDownloads;
	 
	 @AndroidFindBy(xpath = "(//android.widget.FrameLayout[@content-desc=\"Button\"])[2]/android.widget.FrameLayout[2]")
	 private WebElement  clickImage;
	 
	 @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Done\"]/android.view.ViewGroup/android.widget.TextView")
	 private WebElement  clickDone;
	 
	 @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Save\"]/android.view.ViewGroup/android.widget.TextView")
	 private WebElement  clickSave;
	 
	 @AndroidFindBy(id = "com.samsung.android.app.contacts:id/communication_card_primary_icon")
	 private WebElement  clickCallButton;
	 
	 @AndroidFindBy(xpath = "//android.widget.TextView[@text='SIM 1']")
	 private WebElement  selectSIM;
	 
	 @AndroidFindBy(id = "com.samsung.android.incallui:id/photo")
	 private WebElement  verifyImage;
	 
	 @AndroidFindBy(accessibility = "End call")
	 private WebElement  clickEndButton;
	 
	 @AndroidFindBy(id = "android:id/button2")
	 private WebElement  clickCancel;
	 
	 @AndroidFindBy(accessibility = "Navigate up")
	 private WebElement  backButton;
	 
	 @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Navigate up\"]")
	 private WebElement  backButton1;
	 
	 
	
	 public void swipeScreen() throws InterruptedException
	 {
		 swipeUp(swipeLabel, "up");
		 Thread.sleep(5000);

}

	    public void clickPhoneIcon() throws InterruptedException {
		phoneIcon.click();
		Thread.sleep(8000);
		
	}
	    

	   public void searchIcon() throws InterruptedException {
		   clicksearchIcon.click();
	       Thread.sleep(8000);
			
		}
	   public void searchText() throws InterruptedException {
			clicksearchText.click();
			clicksearchText.sendKeys("Demo");
			Thread.sleep(8000);
			
		}
	   public void contactList() throws InterruptedException  {
		   clickcontactList.click();
			Thread.sleep(8000);
			
		}
	   
	   public void detailsButton() throws InterruptedException {
		   clickDetailsButton.click();
			Thread.sleep(8000);
			
		}
	   

	   public void profilePicture() throws InterruptedException {
		   editProfilePicture.click();
           Thread.sleep(8000);
	   }
	   
	   public void gallery() throws InterruptedException {
		   clickGallery.click();
		   Thread.sleep(8000);
			
		}
	   
	   public void downloads() throws InterruptedException {
		   clickDownloads.click();
		   Thread.sleep(8000);
			
		}
	   
	   public void image() throws InterruptedException {
		   clickImage.click();
		   Thread.sleep(8000);
			
		}
	   
	   public void done() throws InterruptedException {
		   clickDone.click();
		   clickSave.click();
		   Thread.sleep(20000);
			
		}
	   
	   public void callButton() throws InterruptedException {
		   clickCallButton.click();
		   
		   Thread.sleep(8000);
			
		}
	   
	   public void sim() throws InterruptedException {
		   selectSIM.click();
		   
		   Thread.sleep(8000);
			
		}
	   

	   public void imageVerify() throws InterruptedException {
//		verifyImage.click();
//		 Thread.sleep(8000);
		
		 boolean picturetoContact = verifyImage.isDisplayed();
		if(picturetoContact) {
			System.out.println("Phone Displayed the Picture While on the Calling Screen successfully");
		} else {
			System.out.println("Phone Displayed the Picture is failed");
		}
		
		 Thread.sleep(5000);
		 clickEndButton.click();
		 clickCancel.click();
		 backButton.click();
		 backButton1.click();
	     driver.pressKey(new KeyEvent (AndroidKey.BACK));
	    
	}

	
	
}
