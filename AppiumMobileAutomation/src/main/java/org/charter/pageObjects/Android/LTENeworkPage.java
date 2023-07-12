package org.charter.pageObjects.Android;

import java.time.Duration;

import org.charter.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LTENeworkPage extends AndroidActions{
	
	AndroidDriver driver;
	
	public LTENeworkPage(AndroidDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(2000)), this);
		
	}
	
	@AndroidFindBy(id = "com.motorola.launcher3:id/workspace")
	private WebElement swipLb;
	
	@AndroidFindBy(id = "com.android.systemui:id/notification_stack_scroller")
	private WebElement swipLb2;
	
	@AndroidFindBy(accessibility = "Open settings.")
	private WebElement settingIcon;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='Network & internet']")
	private WebElement NewtIntr;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='JIO 4G']")
	private WebElement Jio4G;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='Advanced']")
	private WebElement Advanced;
	
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='Preferred network type']")
	private WebElement prefrNwtLb;
	
	@AndroidFindBy(xpath ="//android.widget.CheckedTextView[1]")
	private WebElement LTEBttn;
	
	@AndroidFindBy(id ="com.android.systemui:id/carrier1")
	private WebElement LTEBar;
	
	
	
	@AndroidFindBy(xpath ="//android.widget.ImageView[@content-desc=\"ims\"]")
	private WebElement LTEtext;
	
	public void findLTENework() {
		
		swipeDown(swipLb, "down");
		
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
public void findLTENework2() {
		
		swipeDown(swipLb2, "down");
		
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

public void clickOnSetting() {
	
	settingIcon.click();
	NewtIntr.click();
	Jio4G.click();
	Advanced.click();
	
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
}

public void scrollForLTE() {
	
	String LTENet = prefrNwtLb.getText();
	uiautomatorScroll(LTENet);
	prefrNwtLb.click();
	
}

public void clickLTEbttn() {
	
	LTEBttn.click();
	 

}




public void displayMessage() {
	
	
		
		if(LTEtext.isDisplayed()) {
			System.out.println("voLTE bar is display");
			
		}
		else {
			System.out.println("voLTE bar is not display");
			
		}
	
}


}
