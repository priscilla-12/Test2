package org.charter.pageObjects.Android;

import java.time.Duration;

import org.charter.utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class wifiPage2 extends AndroidActions {

	AndroidDriver driver;

	public wifiPage2(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(2000)), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='android:id/summary']")
	private WebElement wifiText;

	@AndroidFindBy(id = "com.android.contacts:id/search_view")
	private WebElement findcontact;

	@AndroidFindBy(id = "com.android.settings:id/switch_text")
	private WebElement wifiValidation;

	@AndroidFindBy(id = "com.android.dialer:id/lottieAnimationView")
	private WebElement searchContact;

	@AndroidFindBy(id = "com.android.incallui:id/dialpadFragment")
	private WebElement call;

	@AndroidFindBy(id = "com.android.incallui:id/dialpadFragment")
	private WebElement swipedown;

	@AndroidFindBy(id = "com.android.systemui:id/notification_stack_scroller")
	private WebElement swipeup;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='SIM 2']")
	private WebElement dialNumber;

	@AndroidFindBy(xpath = "//android.widget.Switch[@content-desc='Wi-Fi']")
	private WebElement openSim2;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@content-desc,'Phone')]")
	private WebElement openDialer;

	@AndroidFindBy(xpath = "//android.widget.Switch[@content-desc='Wi-Fi']")
	private WebElement openWiFi;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Airplane mode']")
	private WebElement openAirplaneMode;

	@AndroidFindBy(id = "android:id/switch_widget")
	private WebElement on_Off;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Wi-Fi calling']")
	private WebElement openWiFiCalling;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='SIM 1']")
	private WebElement Sim1;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='SIM 2']")
	private WebElement Sim2;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='SIM card & mobile network']")
	private WebElement openSimCard;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Network & internet']")
	private WebElement NetworkAndInternet;

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

	private WebDriver appiumDriver;

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

	public void openNetworkAndInternet() {
		NetworkAndInternet.click();
	}

	public void openSIMCard() {
		openSimCard.click();
	}

	public void openWiFiCalling() {
		// TODO Auto-generated method stub
		openWiFiCalling.click();
	}

	public void turnWifiCalling(String expected_data) {
		String actual_data = wifiValidation.getText();
		String temp = actual_data;
		if (!actual_data.equalsIgnoreCase(expected_data)) {
			on_Off.click();
			actual_data = expected_data;
		}

		boolean condition = dataComparision1(actual_data, expected_data);

		if (condition == true) {
			System.out.println("Wifi Calling is " + expected_data);

		} else {
			System.out.println("Wifi Calling is " + temp);
		}

	}

	public void scrollTillEnd() {

		try {
			boolean canScrollMore;
			do {
				canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
						ImmutableMap.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down"));
			} while (canScrollMore);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void uiautomatorScroll(String optionName) {
		try {
			driver.findElement(AppiumBy.androidUIAutomator(
					"new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + optionName + "\"));"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void openAirplaneMode() {
		// TODO Auto-generated method stub
		openAirplaneMode.click();
	}

	public void openWiFi() {
		// TODO Auto-generated method stub
		openWiFi.click();
		String WT = wifiText.getText();
		if (WT.equalsIgnoreCase("Off")) {
			System.out.println("Wifi Disconnected");
		} else
			System.out.println("Wifi Connected");
	}

	public void openDialer() {
		openDialer.click();
	}

	public void openSim2() {
		openSim2.click();
	}

	public void clickDialNumber() {
		dialNumber.click();
	}

	public void notificationBar() {

		swipe(swipedown, "down");

	}

	public void closenotificationBar() {
		swipe(swipeup, "up");
	}

	public void endCall() {
		call.click();
	}

	public void searchCon() {
		searchContact.sendKeys("Mummy");
	}

	public void gotSim1() {
		Sim1.click();
	}

	public void gotSim2() {
		Sim2.click();
	}

	public void searchContact() {
		findcontact.sendKeys("mummy");
	}

	public void searchContact1() {
		findcontact.sendKeys("Rohit collabera");
	}

	public void HomePage() {

		driver.pressKey(new KeyEvent().withKey(AndroidKey.HOME));

	}

	public void clickNumber(String string) {

		driver.findElement(By.xpath("//android.widget.TextView[@text='" + string + "']")).click();
	}
}
