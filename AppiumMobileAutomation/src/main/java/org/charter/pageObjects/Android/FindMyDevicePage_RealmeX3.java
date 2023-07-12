package org.charter.pageObjects.Android;

import java.time.Duration;

import org.charter.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FindMyDevicePage_RealmeX3 extends AndroidActions {

	AndroidDriver driver;

	public FindMyDevicePage_RealmeX3(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(2000)), this);
	}

	@AndroidFindBy(id = "com.android.chrome:id/url_bar")
	private WebElement urlfound;

	@AndroidFindBy(id = "com.google.android.apps.adm:id/device_name")
	private WebElement deviceName;

	@AndroidFindBy(id = "android:id/title")
	private WebElement findMyDevice;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Find My Device app']")
	private WebElement openApp;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Find My Device web']")
	private WebElement openWebPortal;

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

	public void clickFindMyDevice() {
		findMyDevice.click();
	}

	public void clickOpenApp() {
		openApp.click();

	}

	public void clickOpenWebPortal() {
		openWebPortal.click();
	}

	public void checkFindMyDevice(String expected_data) {

		String actual_data = findMyDevice.getText();

		dataComparision(actual_data, expected_data);
	}

	public void checkDevice(String expected_data) {

		String actual_data = deviceName.getText();

		dataComparision(actual_data, expected_data);
	}

	public void verifyForURL(String expected_data) {

		String actual_data = urlfound.getText();

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
