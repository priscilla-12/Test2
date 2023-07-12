package org.charter.pageObjects.Android;

import java.awt.event.KeyEvent;
import java.time.Duration;

import org.charter.utils.AndroidActions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class microphonePage extends AndroidActions {

	AndroidDriver driver;

	public microphonePage(AndroidDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(2000)), this);

	}

	@AndroidFindBy(id = "com.motorola.launcher3:id/workspace")
	private WebElement swipEle;

	@AndroidFindBy(accessibility = "Play Store")
	private WebElement playStoreLbl;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Search for apps & games']")
	private WebElement tapToSearch;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index = 1]")
	private WebElement editText;

	@AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"Image of app or game icon for Voice Recorder\"])[1]")
	private WebElement voiceRecorderLbl;

	@AndroidFindBy(accessibility = "Search for \"voice recorder app\" ")
	private WebElement voiceRecorderApp;

	@AndroidFindBy(xpath = "//android.widget.Button[@index = 2]")
	private WebElement clickToInstall;

	@AndroidFindBy(accessibility = "Voice Recorder")
	private WebElement voiceRecorder;

	@AndroidFindBy(xpath = "//android.widget.Button[@text = 'WHILE USING THE APP']")
	private WebElement allowPerm;

	@AndroidFindBy(xpath = "//android.widget.Button[@text = 'ALLOW']")
	private WebElement allowPerm1;

	@AndroidFindBy(id = "com.media.bestrecorder.audiorecorder:id/btn_record_start")
	private WebElement startBttn;

	@AndroidFindBy(id = "com.media.bestrecorder.audiorecorder:id/btn_ok")
	private WebElement okbttn;

	@AndroidFindBy(id = "com.media.bestrecorder.audiorecorder:id/btn_play_current_record")
	private WebElement platbttn;

	@AndroidFindBy(className = "android.widget.FrameLayout")
	private WebElement popDisplay;

	@AndroidFindBy(id = "com.motorola.launcher3:id/apps_list_view")
	private WebElement scrollScrren;

	public void swipToUp() {
		swipeUp(swipEle, "up");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

	}

	public void clickToPlayStore() throws InterruptedException {
		swipeScreen("UP");

		Thread.sleep(5000);
		swipeScreen("UP");
		

		playStoreLbl.click();

		System.out.println("Play store is opened");

		tapToSearch.click();

		editText.sendKeys("voice Recorder app");

		voiceRecorderApp.click();

		voiceRecorderLbl.click();

		clickToInstall.click();

		Thread.sleep(5000);

		System.out.println("Voive Recorder installed Successfully");

	}

	public void startRecording() throws InterruptedException {

		voiceRecorder.click();
		allowPerm.click();
		allowPerm1.click();

		startBttn.click();
		System.out.println("Recording start");
		Thread.sleep(2000);
		startBttn.click();
		System.out.println("Recording stop");
		okbttn.click();

		platbttn.click();

		System.out.println("Recorded voice play sucessfully");

	}

}
