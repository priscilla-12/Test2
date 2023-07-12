package org.charter.pageObjects.Android;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.charter.utils.AndroidActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ReceiveMmsWifiCallPage extends AndroidActions {

	AndroidDriver driver;

	public ReceiveMmsWifiCallPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(2000)), this);
	}

	@AndroidFindBy(id = "com.sec.android.app.launcher:id/workspace")
	private WebElement swipeLabel;

	@AndroidFindBy(accessibility = "Phone")
	private WebElement phoneIcon;

	@AndroidFindBy(accessibility = "Search")
	private WebElement clicksearchIcon;

	@AndroidFindBy(id = "com.samsung.android.dialer:id/search_src_text")
	private WebElement clicksearchText;

	@AndroidFindBy(id = "com.samsung.android.dialer:id/contact_list_item_main")
	private WebElement clickcontactList;

	@AndroidFindBy(accessibility = "Call, Button")
	private WebElement clickCallButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='SIM 1']")
	private WebElement selectSIM;

	@AndroidFindBy(id = "com.samsung.android.incallui:id/call_type_icon")
	private WebElement WifiCallingIcon;

	@AndroidFindBy(accessibility = "More options")
	private WebElement screenMenuButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Send message']")
	private WebElement sendButton;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Received : Abc, Attached image SIM 1 \"]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView")
	private WebElement checkReceivedTime;

	@AndroidFindBy(id = "com.samsung.android.messaging:id/attach_root_view")
	private WebElement swipeLabel1;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc='Received : Abc, Attached image SIM 1']")
	private WebElement longPress;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='View details']")
	private WebElement clickViewDetails;

	@AndroidFindBy(id = "android:id/parentPanel")
	private WebElement msgDetails;

	@AndroidFindBy(id = "android:id/button1")
	private WebElement clickOk;

	@AndroidFindBy(id = "com.samsung.android.messaging:id/base_list_item_info_date")
	private WebElement infoDate;

	@AndroidFindBy(xpath = "com.android.systemui:id/header_clock")
	private WebElement checkSystemTime;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
	private WebElement backBtn;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
	private WebElement backBtn1;

	@AndroidFindBy(accessibility = "End call")
	private WebElement callEndButton;

	@AndroidFindBy(id = "android:id/button2")
	private WebElement cancelButton;

	public void swipeScreen() throws InterruptedException {
		swipeUp(swipeLabel, "up");
		Thread.sleep(5000);

	}

	public void swipeScreen1() throws InterruptedException {
		swipeDown(swipeLabel1, "down");
		Thread.sleep(5000);

	}

	public void clickPhoneIcon() throws InterruptedException {
		phoneIcon.click();
		Thread.sleep(5000);

	}

	public void searchIcon() throws InterruptedException {
		clicksearchIcon.click();
		Thread.sleep(8000);

	}

	public void searchText() throws InterruptedException {
		clicksearchText.click();
		clicksearchText.sendKeys("Abc");
		Thread.sleep(8000);

	}

	public void contactList() throws InterruptedException {
		clickcontactList.click();
		Thread.sleep(8000);

	}

	public void callButton() throws InterruptedException {
		clickCallButton.click();
		Thread.sleep(8000);

	}

	public void sim() throws InterruptedException {
		selectSIM.click();
		Thread.sleep(8000);

	}

	public void wifiCalling() throws InterruptedException {
		WifiCallingIcon.click();
		Thread.sleep(8000);
		boolean wifiCallingSymbol = WifiCallingIcon.isDisplayed();
		if (wifiCallingSymbol) {
			System.out.println("Wifi Calling is Displayed on Screen Sucesssfully");
		} else {
			System.out.println("Wifi Calling  Displayed is failed");
		}

		Thread.sleep(8000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));

	}

	public void menuButton() throws InterruptedException {
		screenMenuButton.click();
		Thread.sleep(8000);

	}

	public void sendMessage() throws InterruptedException {
		sendButton.click();
		Thread.sleep(8000);

	}

	public void viewDetails() throws InterruptedException {
		clickViewDetails.click();
		Thread.sleep(8000);

	}

	public void messageDetails() throws InterruptedException {
		clickViewDetails.click();
		Thread.sleep(8000);

	}

	public void OkButton() throws InterruptedException {
		clickOk.click();
		Thread.sleep(8000);

	}

	public void receivedStatus() throws InterruptedException {

		boolean ReceivedMessageStatus1 = checkReceivedTime.isDisplayed();
		System.out.println(checkReceivedTime.getText());
		System.out.println(driver.getDeviceTime());

		if (checkReceivedTime.isDisplayed()) {

			System.out.println("MMS received time is, " + checkReceivedTime.getText());

		} else {
			System.out.println("MMS receiving time  is failed");
		}
		Thread.sleep(5000);
		backBtn.click();
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}

	public void callEnd() throws InterruptedException {
		callEndButton.click();
		Thread.sleep(5000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));

	}

	public void cancel() throws InterruptedException {
		cancelButton.click();
		Thread.sleep(5000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(5000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(5000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
}
