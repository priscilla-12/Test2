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

public class SMSReceivePage extends AndroidActions {

	AndroidDriver driver;

	public SMSReceivePage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(2000)), this);
	}

	@AndroidFindBy(accessibility = "Start chat")
	private WebElement Start_chat;

	@AndroidFindBy(id = "com.google.android.apps.messaging:id/recipient_text_view")
	private WebElement toTxtBox1;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.google.android.apps.messaging:id/message_status']")
	private WebElement receivedmsg;

	public void ReceiveMessage() throws InterruptedException {
		Start_chat.click();
		Thread.sleep(1000);

		toTxtBox1.sendKeys("9885094321");
		driver.pressKey(new KeyEvent(AndroidKey.TAB));

	}

	public void SMSReceiveMessage() {
		boolean msg_status = receivedmsg.isDisplayed();
		if (msg_status) {
			System.out.println("SMS IS RECEIVED");
		} else {
			System.out.println("SMS IS NOTRECEIVED");
		}
	}
}
