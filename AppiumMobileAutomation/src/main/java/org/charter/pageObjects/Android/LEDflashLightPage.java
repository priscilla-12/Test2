package org.charter.pageObjects.Android;

import java.awt.event.KeyEvent;
import java.time.Duration;

import org.charter.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LEDflashLightPage extends AndroidActions{
	
	AndroidDriver driver;
	
	public LEDflashLightPage(AndroidDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(2000)), this);
		
	}
	
	@AndroidFindBy(id = "com.motorola.launcher3:id/workspace")
	private WebElement swipLb;
	
	@AndroidFindBy(id = "com.android.systemui:id/notification_stack_scroller")
	private WebElement swipLb2;
	
	@AndroidFindBy(xpath = "//android.widget.Switch[@content-desc=\"Flashlight\"]")
	private WebElement flashLightIcon;
	
	
public void swipScrren1() {
		
		swipeDown(swipLb, "down");
		
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
public void swipScrren2() {
		
		swipeDown(swipLb2, "down");
		
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
public void clickOnFashLight() throws InterruptedException {
	
	flashLightIcon.click();
	
	Thread.sleep(2000);
	
boolean flashBttn= flashLightIcon.isEnabled();
					
	if(flashBttn) {
		
		System.out.println("flashlight on successfully");
		flashLightIcon.click();
		System.out.println("flashlightis turn off");
		
	}
	else {
		System.out.println("flashlight trunoff");
		
	}
//System.out.println(WiFiConn.isDisplayed() +"Wifi is Connected");
	
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
}
	
}
	
	


