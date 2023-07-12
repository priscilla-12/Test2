package org.charter.pageObjects.Android;

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

public class SendMmsWifiCallPage extends AndroidActions {

	AndroidDriver driver;

	public SendMmsWifiCallPage(AndroidDriver driver) {
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

	@AndroidFindBy(accessibility = "Other options")
	private WebElement selectOtherOptions;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='My Files']")
	private WebElement clickMyFiles;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Images']")
	private WebElement clickImages;

	@AndroidFindBy(accessibility = "Search")
	private WebElement selectSearchIcon;

	@AndroidFindBy(id = "com.sec.android.app.myfiles:id/search_src_text")
	private WebElement searchText;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='image.jpg']")
	private WebElement selectImage;

	@AndroidFindBy(id = "com.sec.android.app.myfiles:id/checkbox")
	private WebElement clickCheckBox;

	@AndroidFindBy(id = "com.sec.android.app.myfiles:id/navigation_bar_item_small_label_view")
	private WebElement clickDone;

	@AndroidFindBy(id = "android:id/title")
	private WebElement selectImageTitle;

	@AndroidFindBy(id = "com.google.android.documentsui:id/thumbnail")
	private WebElement selectIconThumb;

	@AndroidFindBy(id = "android:id/button1")
	private WebElement clickOK;

	@AndroidFindBy(id = "com.samsung.android.messaging:id/end_buttons_container")
	private WebElement clickSent;

	@AndroidFindBy(id = "com.samsung.android.messaging:id/base_list_item_info_status_text")
	private WebElement MessageStatus;

	@AndroidFindBy(id = "com.sec.android.app.launcher:id/workspace")
	private WebElement swipeLabel1;

	@AndroidFindBy(accessibility = "Navigate up")
	private WebElement backBtn;

	@AndroidFindBy(accessibility = "Navigate up")
	private WebElement backBtn1;

	@AndroidFindBy(id = "com.google.android.apps.messaging:id/send_message_button_icon")
	private WebElement sendMessageIcon;

	@AndroidFindBy(accessibility = "End call")
	private WebElement callEndButton;

	@AndroidFindBy(id = "android:id/button2")
	private WebElement cancelButton;

	public void swipeScreen() throws InterruptedException {
		swipeUp(swipeLabel, "up");
		Thread.sleep(5000);

	}

	public void clickPhoneIcon() throws InterruptedException {
		phoneIcon.click();
		Thread.sleep(2000);

	}

	public void searchIcon() throws InterruptedException {
		clicksearchIcon.click();
		Thread.sleep(2000);

	}

	public void searchText() throws InterruptedException {
		clicksearchText.click();
		clicksearchText.sendKeys("Abc");
		Thread.sleep(2000);

	}

	public void contactList() throws InterruptedException {
		clickcontactList.click();
		Thread.sleep(2000);

	}

	public void callButton() throws InterruptedException {
		clickCallButton.click();
		Thread.sleep(2000);

	}

	public void sim() throws InterruptedException {
		selectSIM.click();
		Thread.sleep(5000);

	}

	public void wifiCalling() throws InterruptedException {
		WifiCallingIcon.click();
		Thread.sleep(2000);
		boolean wifiCallingSymbol = WifiCallingIcon.isDisplayed();
		if (wifiCallingSymbol) {
			System.out.println("Wifi Calling is Displayed on Screen Sucesssfully");
		} else {
			System.out.println("Wifi Calling  Displayed is failed");
		}

		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));

	}

	public void menuButton() throws InterruptedException {
		screenMenuButton.click();
		Thread.sleep(5000);

	}

	public void sendMessage() throws InterruptedException {
		sendButton.click();
		Thread.sleep(5000);

	}

	public void otherOptions() throws InterruptedException {
		selectOtherOptions.click();
		Thread.sleep(5000);
	}

	public void myFiles() throws InterruptedException {
		clickMyFiles.click();
		Thread.sleep(8000);
	}

	public void images() throws InterruptedException {
		clickImages.click();
		Thread.sleep(8000);
	}

	public void searchIcon1() throws InterruptedException {
		selectSearchIcon.click();
		Thread.sleep(8000);
	}

	public void Text() throws InterruptedException {
		searchText.click();
		searchText.sendKeys("image.jpg");
		Thread.sleep(8000);
	}

	public void image() throws InterruptedException {
		selectImage.click();
		Thread.sleep(8000);
	}

	public void checkBox() throws InterruptedException {
		clickCheckBox.click();
		clickDone.click();
		Thread.sleep(8000);
	}

	public void imageTitle() throws InterruptedException {
		selectImageTitle.click();
		Thread.sleep(5000);
	}

	public void okButton() throws InterruptedException {

		clickOK.click();
		Thread.sleep(8000);
	}

	public void sentButton() throws InterruptedException {
		clickSent.click();
		Thread.sleep(8000);

		boolean msgSentStatus = MessageStatus.isDisplayed();

		if (msgSentStatus) {
			System.out.println("MMS is delivered to secondary device successfully");

		} else {
			System.out.println("MMS sending failed");
		}
		Thread.sleep(5000);
		backBtn.click();
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));

	}

	public void swipeScreen1() throws InterruptedException {
		swipeDown(swipeLabel1, "down");
		Thread.sleep(5000);

	}

	public void callEnd() throws InterruptedException {
		callEndButton.click();
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));

	}

	public void cancel() throws InterruptedException {
		cancelButton.click();
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
}
