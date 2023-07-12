package org.charter.pageObjects.Android;

import java.time.Duration;

import org.charter.utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class wifiPage extends AndroidActions {

	AndroidDriver driver;

	public wifiPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(300)), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[(@text='Wi-Fi')]")
	private WebElement wifiLabel;

	@AndroidFindBy(id = "android:id/switch_widget")
	private WebElement wifiToggle;

	@AndroidFindBy(accessibility = "Navigate up")
	private WebElement backBtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[(@text='Mobile network')]")
	private WebElement mobileNetworkLbl;

	@AndroidFindBy(xpath = "//android.widget.TextView[(@text='Mobile data')]")
	private WebElement mobileDataLbl;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[8]/android.widget.LinearLayout/android.widget.Switch[@resource-id='android:id/switch_widget']")
	private WebElement mobileDatatoggle;

	public void wifiLabel() {
		wifiLabel.click();

	}

	public void wifiToggle() {
		String wifiStatus = wifiToggle.getText();
		if (wifiStatus.equalsIgnoreCase("On")) {
			wifiLabel.click();
		}

	}

	public void backBtn() {
		backBtn.click();

	}

	public void mobileNetworkLbl() {
		mobileNetworkLbl.click();

	}

	public void mobileDatatoggle() {
		String dataStaus = mobileDatatoggle.getText();
		System.out.println(dataStaus);
		if (dataStaus.equalsIgnoreCase("On")) {
			mobileDataLbl.click();
		}
	}

	public void turnOffWifi() throws InterruptedException {
		wifiLabel();
		wifiToggle();
		backBtn();

	}

	public void turnOffMobileDataNetwork() throws InterruptedException {

		mobileNetworkLbl();
		mobileDatatoggle();
		backBtn();
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		Thread.sleep(2000);
	}

	public void launchAppDirect(String appPackage, String appActivity) {
		try {
			Activity activityMsg = new Activity(appPackage, appActivity);
			driver.startActivity(activityMsg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
