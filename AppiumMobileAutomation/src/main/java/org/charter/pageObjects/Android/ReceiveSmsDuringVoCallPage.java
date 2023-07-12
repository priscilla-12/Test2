package org.charter.pageObjects.Android;

import java.time.Duration;

import org.charter.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ReceiveSmsDuringVoCallPage extends AndroidActions {

	AndroidDriver driver;

	public ReceiveSmsDuringVoCallPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(2000)), this);
	}

	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Contacts\"]")
	private WebElement clickContact;

	@AndroidFindBy(id = "android:id/input")
	private WebElement searchButton;

	@AndroidFindBy(id = "com.android.contacts:id/name")
	private WebElement clickBar;

	@AndroidFindBy(id = "com.android.contacts:id/first_action_button")
	private WebElement callIcon;

	@AndroidFindBy(id = "miui:id/action_bar_overlay_layout")
	private WebElement swiping;

	@AndroidFindBy(id = "android:id/big_text")
	private WebElement receivedSms;

	@AndroidFindBy(id = "com.android.mms:id/message_date")
	private WebElement verifySms;

	public void contact() throws InterruptedException {
		clickContact.click();
		Thread.sleep(2000);
	}

	public void search() throws InterruptedException {
		searchButton.click();
		searchButton.sendKeys("haritha");
		Thread.sleep(4000);

	}

	public void name() throws InterruptedException {
		clickBar.click();
		Thread.sleep(3000);

	}

	public void call() throws InterruptedException {
		callIcon.click();
		Thread.sleep(3000);

	}

	public void swipe() throws InterruptedException {
		swipeDown(swiping, "down");
		Thread.sleep(8000);

	}

	public void sms() throws InterruptedException {
		receivedSms.click();
		Thread.sleep(8000);
	}

	public void verify() throws InterruptedException {
		verifySms.click();
		boolean msgReceievedStatus = verifySms.isDisplayed();
		System.out.println(verifySms.getText());
		System.out.println(driver.getDeviceTime());

		if (verifySms.isDisplayed()) {
			System.out.println("SMS received time is," + verifySms.getText());

		} else {
			System.out.println("SMS receiving failed");
		}
		Thread.sleep(8000);

	}

}