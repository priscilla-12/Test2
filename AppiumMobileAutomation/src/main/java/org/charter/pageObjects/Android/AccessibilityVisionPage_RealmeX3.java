package org.charter.pageObjects.Android;

import java.time.Duration;

import org.charter.utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AccessibilityVisionPage_RealmeX3 extends AndroidActions {

	AndroidDriver driver;

	public AccessibilityVisionPage_RealmeX3(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(2000)), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Weather']")
	private WebElement results;

	@AndroidFindBy(id = "com.google.android.dialer:id/incall_contact_grid")
	private WebElement receiverIcon;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Answer & end other call']")
	private WebElement answerAndReject;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Hold call\"]/android.widget.ImageView")
	private WebElement holdCall;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Merge calls\"]/android.widget.ImageView")
	private WebElement mergeCalls;

	@AndroidFindBy(id = "com.google.android.googlequicksearchbox:id/search_widget_dynamic_left_icon")
	private WebElement mikeIcon;

	@AndroidFindBy(id = "com.google.android.googlequicksearchbox:id/googleapp_search_box")
	private WebElement askData;

	@AndroidFindBy(id = "com.google.android.googlequicksearchbox:id/search_edit_frame")
	private WebElement googleSearchBox;

	@AndroidFindBy(id = "android:id/title")
	private WebElement FindMyDevice;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Fingerprint']")
	private WebElement fingerprint;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Accessibility']")
	private WebElement accessibility;

	@AndroidFindBy(id = "com.android.settings:id/search_src_text")
	private WebElement searchSetting;

	@AndroidFindBy(id = "com.android.settings:id/animated_hint")
	private WebElement settingsSearchBox;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Security']")
	private WebElement securityLbl;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='More security settings']")
	private WebElement moreSecSettLbl;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Device manager']")
	private WebElement deviceManageLbl;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Find My Device']")
	private WebElement findMyDeviceLbl;

	public void verifyFindMyDevice() {
		try {

			uiautomatorScroll("Security");
			Thread.sleep(2000);

			securityLbl.click();
			moreSecSettLbl.click();
			deviceManageLbl.click();

			boolean findMyDeviceExist = findMyDeviceLbl.isDisplayed();

			if (findMyDeviceExist) {
				System.out.println("Find my Device is present");
			} else {
				System.out.println("Find my Device is not present");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void settingsSearchbox() {
		settingsSearchBox.click();

	}

	public void enterSettingName(String string) {
		searchSetting.sendKeys(string);
	}

	public void clickaccessibility() {
		accessibility.click();

	}

	public void clickGoogleSearchBox() {
		googleSearchBox.click();
	}

	public void askGoogle(String question) {
		askData.sendKeys(question);

	}

	public void clickMikeIcon() {
		mikeIcon.click();

	}

	public void acceptCall() {
		swipe(receiverIcon, "up");
	}

	public void answer2ndReject1stCall() {
		answerAndReject.click();
	}

	public void clickMergeCalls() {
		mergeCalls.click();
	}

	public void putOnHold() {
		holdCall.click();
	}

	public void openFingerprint() {
		fingerprint.click();
	}

	public void verifyResults(String expected_data) {
		String actual_data = results.getText();

		dataComparision(actual_data, expected_data);
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
