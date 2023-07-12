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

public class MsgNotificationPage extends AndroidActions {

	AndroidDriver driver;

	public MsgNotificationPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(2000)), this);
	}

	@AndroidFindBy(id = "com.sec.android.app.launcher:id/workspace")
	private WebElement swipeLabel;

	@AndroidFindBy(accessibility = "Messages")
	private WebElement openMessages;

	@AndroidFindBy(accessibility = "Search")
	private WebElement clickSearch;

	@AndroidFindBy(id = "com.samsung.android.messaging:id/search_src_text")
	private WebElement clickSearchText;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Aancy']")
	private WebElement selectContact;

	@AndroidFindBy(id = "com.samsung.android.messaging:id/message_edit_text")
	private WebElement messageEditor;

	@AndroidFindBy(id = "com.samsung.android.messaging:id/end_buttons_container")
	private WebElement clickSent;

	@AndroidFindBy(id = "android:id/button2")
	private WebElement clickCancel;

	@AndroidFindBy(id = "com.samsung.android.messaging:id/attach_root_view")
	private WebElement swipeLabel1;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='⁦Aancy‬ : Delivered.']")
	private WebElement delivered;

	@AndroidFindBy(id = "//android.widget.Button[@content-desc=\"Expand\"])")
	private WebElement reportExpand;

	@AndroidFindBy(id = "com.android.systemui:id/sec_panel_carrier_label_container")
	private WebElement swipeLabel2;

	@AndroidFindBy(accessibility = "Navigate up")
	private WebElement backBtn;

	@AndroidFindBy(accessibility = "Navigate up")
	private WebElement backBtn1;

	public void swipeScreen() throws InterruptedException {
		swipeUp(swipeLabel, "up");
		Thread.sleep(5000);

	}

	public void swipeScreen1() throws InterruptedException {
		swipeDown(swipeLabel1, "down");
		Thread.sleep(5000);

	}

	public void messagesIcon() throws InterruptedException {
		openMessages.click();
		Thread.sleep(8000);

	}

	public void searchIcon() throws InterruptedException {
		clickSearch.click();
		Thread.sleep(8000);
	}

	public void searchText() throws InterruptedException {
		clickSearchText.click();
		clickSearchText.sendKeys("Aancy");
		Thread.sleep(8000);
	}

	public void contact() throws InterruptedException {
		selectContact.click();
		Thread.sleep(5000);
	}

	public void msgEditor() throws InterruptedException {
		messageEditor.click();
		messageEditor.sendKeys("Hi");
        Thread.sleep(8000);
	}

	public void sentButton() throws InterruptedException {
		clickSent.click();

		Thread.sleep(8000);
	}

	public void cancel() throws InterruptedException {
		clickCancel.click();
        Thread.sleep(8000);
	}

	public void deliveryReport() throws InterruptedException {

		boolean msgSentStatus = delivered.isDisplayed();
		Thread.sleep(8000);
		if (msgSentStatus) {
			System.out.println("Message Delivered Notification is showing Successfully");
		} else {
			System.out.println("Message Delivered Notification is showing Failed");
		}

		Thread.sleep(5000);

	}

	public void swipeScreen2() throws InterruptedException {
		swipeUp(swipeLabel2, "up");
		Thread.sleep(5000);
		backBtn.click();

		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}

}
