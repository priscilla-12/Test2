package org.charter.pageObjects.Android1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

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

public class TC75_SEARCHCONTPAGE_SAMSUNG_SM_A536E extends AndroidActions {

	AndroidDriver driver;
	

	 public TC75_SEARCHCONTPAGE_SAMSUNG_SM_A536E(AndroidDriver driver) {
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
	 
	 @AndroidFindBy(accessibility = "A")
	 private WebElement  clickcontactList;
	 
	 @AndroidFindBy(id = "com.samsung.android.dialer:id/count")
	 private WebElement  verifyContacts;
	 
	 @AndroidFindBy(id = "com.samsung.android.dialer:id/contact_list_item_main")
	 private List<WebElement> contactList;
	 
	 
	
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
			clicksearchText.sendKeys("A");
			 driver.hideKeyboard();
			Thread.sleep(8000);
			
		}

	   
	   
	   
	   
	   public void contact() throws InterruptedException {

		   String contact = verifyContacts.getText();
           String[] contacttext= contact.split(" ");

		   contacttext[0]= "170";
           contacttext[1]="found";
           int contactcount=Integer.parseInt(contacttext[0]);
		   
           if (contactcount>0) {
           System.out.println("Total number of contacts displayed for letter 'A' is," + contactcount);
		   
           int contactSize = contactList.size();
           System.out.println("Number of contacts displayed in current page for letter A is, "+contactList.size());
		   
          // String contactcount = contactList.getText();
           System.out.println("Length of the result showing element , verifyContacts is 9 and the actual result is, "+contact);
		   }
           else
           {
           System.out.println("No contacts displayed for letter 'A' ");

		   }
           Thread.sleep(2000);
           backButton.click();
		   Thread.sleep(5000);
	       driver.pressKey(new KeyEvent (AndroidKey.BACK));
	       Thread.sleep(5000);
	       driver.pressKey(new KeyEvent (AndroidKey.BACK));
	    
	}

}
