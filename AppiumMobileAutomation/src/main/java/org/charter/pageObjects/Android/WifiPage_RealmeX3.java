package org.charter.pageObjects.Android;

import java.time.Duration;

import org.charter.utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WifiPage_RealmeX3 extends AndroidActions {

	AndroidDriver driver;

	public WifiPage_RealmeX3(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(2000)), this);
	}

	@AndroidFindBy(id = "com.google.android.dialer:id/contactgrid_bottom_timer")
	private WebElement firstcallverification;

	@AndroidFindBy(id = "com.google.android.dialer:id/hold_contact_name")
	private WebElement firstCallStatus;

	@AndroidFindBy(xpath = "(//android.widget.ImageButton[@content-desc=\"Disconnect call in conference\"])[2]")
	private WebElement end2ndCall;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Manage callers\"]/android.widget.ImageView")
	private WebElement manageCalls;

	@AndroidFindBy(id = "com.google.android.dialer:id/incall_contact_grid")
	private WebElement receiverIcon;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Merge calls\"]/android.widget.ImageView")
	private WebElement mergeCalls;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Add call\"]/android.widget.ImageView")
	private WebElement addCall;

	@AndroidFindBy(id = "com.google.android.dialer:id/incall_end_call")
	private WebElement endCall;

	@AndroidFindBy(id = "com.google.android.dialer:id/contactgrid_status_text")
	private WebElement callingStatus;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='SIM1']")
	private WebElement simToCall;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.google.android.dialer:id/call_button']")
	private WebElement callingIcon;

	@AndroidFindBy(id = "com.google.android.dialer:id/open_search_bar_text_view")
	private WebElement searchBar;

	@AndroidFindBy(id = "com.google.android.dialer:id/open_search_view_edit_text")
	private WebElement searchContact;

	@AndroidFindBy(id = "android:id/switch_widget")
	private WebElement wifiOnOrOff;

	@AndroidFindBy(id = "com.android.settings:id/search_src_text")
	private WebElement searchSetting;

	@AndroidFindBy(id = "com.android.settings:id/animated_hint")
	private WebElement settingsSearchBox;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@content-desc,'Phone')]")
	private WebElement Dialer;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Wi-Fi']")
	private WebElement wifiLabel;

	@AndroidFindBy(id = "android:id/checkbox")
	private WebElement wifiToggle;

	@AndroidFindBy(accessibility = "Navigate up")
	private WebElement backBtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Mobile network']")
	private WebElement mobileDataLbl;

	@AndroidFindBy(id = "android:id/checkbox")
	private WebElement dataNetworkToggle;

	public void turnOffWifi() throws InterruptedException {
		wifiLabel.click();
		wifiToggle.click();
		backBtn.click();
		Thread.sleep(2000);
	}

	public void turnOffMobileDataNetwork() {
		mobileDataLbl.click();
		dataNetworkToggle.click();
		backBtn.click();
	}

	public void callAndroidAction() {

		WebElement ele = driver.findElement(By.id("com.google.android.apps.messaging:id/message_text"));

		longPress(ele);

	}

	public void openDialer() {
		Dialer.click();

	}

	public void settingsSearchbox() {
		settingsSearchBox.click();

	}

	public void enterSettingName(String string) {
		searchSetting.sendKeys(string);
	}

	public void openWifiSettings() {
		wifiLabel.click();
	}

	public void CheckWifi(String expected_data) {

		String actual_data = wifiOnOrOff.getText();

		System.out.println("wifi is " + actual_data);
		if (!actual_data.equalsIgnoreCase(expected_data)) {
			wifiOnOrOff.click();
			System.out.println("Turned Wifi " + expected_data);
		}

	}

	public void searchContact(String string) {

		searchContact.sendKeys(string);
	}

	public void clickSearchbar() {
		searchBar.click();
	}

	public void clickCallingIcon() {
		callingIcon.click();
	}

	public void selectSimToCall() {
		simToCall.click();
	}

	public void notificationBar() {
		swipeByCoordinates(550, 70, 550, 1200);

	}

	public void checkCallingStatus() {
		String callvia = callingStatus.getText();
		System.out.println("calling via " + callvia);
	}

	public void OnOffWifi() {
		tapWithCoordinates(145, 500);

	}

	public void clickEndCall() {
		endCall.click();
	}

	public void clickAddCall() {
		addCall.click();
	}

	public void clickMergeCalls() {
		mergeCalls.click();
	}

	public void acceptCall() {
		swipe(receiverIcon, "up");
	}

	public void clickManageCalls() {
		manageCalls.click();
	}

	public void clickEnd2ndCall() {
		end2ndCall.click();

	}

	public void check1stCallStatus() {
		String status = firstCallStatus.getText();

		System.out.println("Status of 1st Call : " + status);
	}

	public void verify1stCallStatus() {
		String verification = firstcallverification.getText();

		System.out.println("\n\nTimer Present as : " + verification + " means call resumed\n\n");
	}

	public void clickSearchIcon() {
		driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "search"));
	}

	public void navigateBack() {
		driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
	}

	public void navigateHome() {
		driver.pressKey(new KeyEvent().withKey(AndroidKey.HOME));
	}

}
