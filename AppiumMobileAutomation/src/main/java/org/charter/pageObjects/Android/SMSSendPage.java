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

public class SMSSendPage extends AndroidActions {

	AndroidDriver driver;

	public SMSSendPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(2000)), this);
	}

	@AndroidFindBy(accessibility = "Start chat")
	private WebElement Start_chat;

	@AndroidFindBy(id = "com.google.android.apps.messaging:id/recipient_text_view")
	private WebElement toTxtBox1;

	@AndroidFindBy(id = "com.google.android.apps.messaging:id/compose_message_text")
	private WebElement enterMsgTxtBox;

	@AndroidFindBy(id = "com.google.android.apps.messaging:id/send_message_button_icon")
	private WebElement sendMsgBtn;

	@AndroidFindBy(xpath = "//android.widget.TextView")
	private WebElement textlongpress;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.google.android.apps.messaging:id/status_icon']")
	private WebElement status_icon;

	public void sendMessage() throws InterruptedException {
		Start_chat.click();
		Thread.sleep(1000);

		toTxtBox1.sendKeys("9885094321");
		Thread.sleep(1000);
		driver.pressKey(new KeyEvent(AndroidKey.TAB));

		Thread.sleep(3000);
		enterMsgTxtBox.click();
		Thread.sleep(1000);
		enterMsgTxtBox.sendKeys("HI ");
		sendMsgBtn.click();
		Thread.sleep(20000);
	}

	public void SMSdisplayNotification() {
		boolean msg_status = status_icon.isDisplayed();
		System.out.println(msg_status);
		if (msg_status) {
			System.out.println("SMS IS DISPLAYED");
		} else {
			System.out.println("SMS IS NOTDISPLAYED");
		}
	}
}
