package org.charter.pageObjects.Android;

import java.time.Duration;

import org.charter.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WiFiRadioPage extends AndroidActions{
	
	AndroidDriver driver;
	
	public WiFiRadioPage(AndroidDriver driver) {
		
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
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text = 'Wi-Fi']")
	private WebElement WifiText;
	
	@AndroidFindBy(id ="com.android.settings:id/switchWidget")
	private WebElement enableWifibtn;
	//com.android.settings:id/switchWidget
	//com.android.settings:id/switch_widget
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text = 'Off']")
	private WebElement OffBttn;
	
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='Connected']")
	private WebElement WiFiConn;
	
	@AndroidFindBy(accessibility ="Back")
	private WebElement clickBack;
	
	@AndroidFindBy(className ="android.widget.RelativeLayout")
	private WebElement clickBack2;
	

	@AndroidFindBy(xpath ="//android.widget.RelativeLayout[@index = 1]")
	private WebElement mainScrrenbtn;
	
	@AndroidFindBy(id ="com.motorola.launcher3:id/workspace")
	private WebElement swipEle;
	
	@AndroidFindBy(accessibility = "Speedtest")
	private WebElement speedTestLbl;
	
	@AndroidFindBy(id ="org.zwanoo.android.speedtest:id/go_button")
	private WebElement speedGoBttn;
	

	@AndroidFindBy( xpath = "//android.widget.TextView[@index = 3]")
	private WebElement uplaodlbl;
	
	
	@AndroidFindBy(id ="org.zwanoo.android.speedtest:id/results_assembly_layout")
	private WebElement display;
	
	
	@AndroidFindBy(id ="//android.widget.TextView[@text = 'Off']")
	private WebElement wifiOffLbl;
	
	
	@AndroidFindBy(id ="org.zwanoo.android.speedtest:id/results_assembly_layout")
	private WebElement resultTest;
	
	

	@AndroidFindBy(xpath ="//android.widget.FrameLayout[@content-desc=\"DOWNLOAD\"]/android.view.ViewGroup/android.widget.TextView[3]")
	private WebElement download;
	

	@AndroidFindBy(xpath ="//android.widget.FrameLayout[@content-desc=\"UPLOAD\"]/android.view.ViewGroup/android.widget.TextView[3]")
	private WebElement upload;
	
	
	@AndroidFindBy(id ="org.zwanoo.android.speedtest:id/closeIcon")
	private WebElement closeIcon;
	
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
	
public void clickOnSetting() {
	
	settingIcon.click();
	NewtIntr.click();
	
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
}


public void wifienable() {
	
	String checkvalue = enableWifibtn.getAttribute("checked");

	
	if(checkvalue.equals("false")) {
		
		enableWifibtn.click();	
		
		System.out.println("Wifi is connected");
		
	}
	else {
	
		
		System.out.println("Wifi is already connected");
	}

}

public void swipToUp() {
	swipeUp(swipEle,"up");

	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
	e.printStackTrace();
	}

}

public void oklaTest() throws InterruptedException {
	Thread.sleep(5000);
	
	//uiautomatorScroll("Speedtest");
	
	swipeScreen("UP");
	speedTestLbl.click();
	

	speedGoBttn.click();
	
Thread.sleep(1000);
	
if(download.isDisplayed() && upload.isDisplayed()) {
	
	
	System.out.println("download speed is " +download.getText());
	Thread.sleep(10000);
	System.out.println("upload speed is " +upload.getText());
	System.out.println("speedTest run sucessfully");
	
	closeIcon.click();
}

	
}
}
	
	


