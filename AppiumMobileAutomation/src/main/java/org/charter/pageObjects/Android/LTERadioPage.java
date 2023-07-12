package org.charter.pageObjects.Android;

import java.time.Duration;

import org.charter.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LTERadioPage extends AndroidActions {

	AndroidDriver driver;

	public LTERadioPage(AndroidDriver driver) {

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

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Network & internet']")
	private WebElement NewtIntr;

	@AndroidFindBy(id = "com.android.settings:id/switchWidget")
	private WebElement enableWifibtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Connected']")
	private WebElement WiFiConn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='JIO 4G']")
	private WebElement Jio4G;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Advanced']")
	private WebElement Advanced;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Preferred network type']")
	private WebElement prefrNwtLb;

	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[1]")
	private WebElement LTEBttn;

	@AndroidFindBy(id = "org.zwanoo.android.speedtest:id/results_assembly_layout")
	private WebElement display;

	@AndroidFindBy(id = "com.motorola.launcher3:id/workspace")
	private WebElement swipEle;

	@AndroidFindBy(accessibility = "Play Store")
	private WebElement playStoreLbl;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Search for apps & games']")
	private WebElement tapToSearch;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index = 1]")
	private WebElement editText;

	@AndroidFindBy(accessibility = "Search for \"speed test\" ")
	private WebElement speedTestlbl;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Image of app or game icon for Speedtest by Ookla\"]")
	private WebElement speedTestOkl;

	@AndroidFindBy(xpath = "//android.widget.Button[@index = 2]")
	private WebElement installBttn;

	@AndroidFindBy(accessibility = "Speedtest")
	private WebElement SpeedtestApp;

	@AndroidFindBy(id = "org.zwanoo.android.speedtest:id/go_button")
	private WebElement goBttn;

	@AndroidFindBy(id = "org.zwanoo.android.speedtest:id/results_assembly_layout")
	private WebElement resultTest;

	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"DOWNLOAD\"]/android.view.ViewGroup/android.widget.TextView[3]")
	private WebElement download;

	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"UPLOAD\"]/android.view.ViewGroup/android.widget.TextView[3]")
	private WebElement upload;

	@AndroidFindBy(id = "org.zwanoo.android.speedtest:id/closeIcon")
	private WebElement closeIcon;

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

		String checkvalue = enableWifibtn.getAttribute("checked");
		System.out.println(checkvalue);

		if (checkvalue.equals("true")) {

			enableWifibtn.click();

			System.out.println("Wifi is diconnected");

		} else {

			System.out.println("Wifi is already diconnected");
		}

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

	public void swipToUp() {

		swipeUp(swipEle, "up");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void downloadSpeedTest() throws InterruptedException {

		swipeScreen("UP");
		playStoreLbl.click();

		System.out.println("Play store is opened");

		tapToSearch.click();

		editText.sendKeys("speed test");

		speedTestlbl.click();

		speedTestOkl.click();

		installBttn.click();

		Thread.sleep(5000);

		System.out.println("SpeedTest installed Successfully");

	}

	public void checkSpeed() throws InterruptedException {

		SpeedtestApp.click();
		goBttn.click();
		Thread.sleep(1000);

		if (download.isDisplayed() && upload.isDisplayed()) {

			System.out.println("download speed is " + download.getText());
			Thread.sleep(10000);
			System.out.println("upload speed is " + upload.getText());
			System.out.println("speedTest run sucessfully");

			closeIcon.click();

		}

	}

}
