package org.charter.pageObjects.Android;


import java.time.Duration;

import org.charter.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class cameraRearPage extends AndroidActions{
	
	AndroidDriver driver;
	
	public cameraRearPage(AndroidDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(2000)), this);
		
	}
	
	@AndroidFindBy(id ="com.motorola.launcher3:id/workspace")
	private WebElement swipEle;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@content-desc=\"Camera\"]")
	private WebElement cameraLbl;
	
	@AndroidFindBy(id ="com.ontim.camera2:id/hint_root")
	private WebElement frontcameraLbl;
	

	@AndroidFindBy(id ="com.ontim.camera2:id/camera_switcher")
	private WebElement switchCameraBttn;
	
	@AndroidFindBy(xpath ="//android.widget.LinearLayout[@content-desc=\"back\"]")
	private WebElement backlen;
	
	@AndroidFindBy(xpath ="//android.widget.LinearLayout[@content-desc=\"front\"]/android.widget.ImageView")
	private WebElement front;
	
	
	@AndroidFindBy(id ="com.ontim.camera2:id/mode_shutter_button")
	private WebElement clickCameraBttn;
	
	@AndroidFindBy(id ="com.ontim.camera2:id/thumbnail")
	private WebElement displayImg;
	
	
	@AndroidFindBy(id ="com.ontim.camera2:id/entry_lens")
	private WebElement len;
	
	@AndroidFindBy(id ="com.ontim.camera2:id/multi_focus_indicator")
	private WebElement focusRingBack;
	
	@AndroidFindBy(id ="com.ontim.camera2:id/focus_view")
	private WebElement focusRingfront;
	
	public void swipToUp() {
		swipeUp(swipEle,"up");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		e.printStackTrace();
		}

	}
	
public void clickToRearCam() throws InterruptedException {
	
	uiautomatorScroll("Camera");
	cameraLbl.click();
	//frontcameraLbl.click();
	Thread.sleep(2000);
//	String frontSwitch = front.getAttribute("enabled");
//	System.out.println(frontSwitch);
	
	if(focusRingBack.isDisplayed()) {
		System.out.println("raer camera is On");
		
		clickCameraBttn.click(); 
	}
	else {

		System.out.println("Front carmera is on. swich to rear camera");
		switchCameraBttn.click();
		clickCameraBttn.click();

	}
	
	Thread.sleep(2000);
	displayImg.click();
	Thread.sleep(2000);
	System.out.println("Pointed image is displayed");
	
}

}

	


