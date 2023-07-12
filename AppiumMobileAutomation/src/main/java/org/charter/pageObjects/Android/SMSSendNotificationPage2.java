package org.charter.pageObjects.Android;

import java.time.Duration;

import org.charter.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

public class SMSSendNotificationPage2 extends AndroidActions {

	AndroidDriver driver;
	String a = "helo";

	public SMSSendNotificationPage2(AndroidDriver driver) {
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

	@AndroidFindBy(accessibility = "More conversation options")
	private WebElement longpressdetails;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='View details']")
	private WebElement viewdetails;

	@AndroidFindBy(id = "com.google.android.apps.messaging:id/message")
	private WebElement messagedetails;

	@AndroidFindBy(id = "com.google.android.apps.messaging:id/message_text_and_info")
	private WebElement message;

	public void sendMessage() throws InterruptedException {
		Start_chat.click();
		Thread.sleep(1000);

		toTxtBox1.sendKeys("7529977551");

		Thread.sleep(1000);
		driver.pressKey(new KeyEvent(AndroidKey.TAB));

		Thread.sleep(3000);
		enterMsgTxtBox.click();
		Thread.sleep(1000);
		enterMsgTxtBox.sendKeys(a);
		sendMsgBtn.click();
		Thread.sleep(1000);
		longPress(message);
		Thread.sleep(5000);
		tapWithCoordinates(1007, 198);

		viewdetails.click();

		System.out.println("msg is +" + messagedetails.getText());

		System.out.println(messagedetails.getText().split("Sent")[1]);

	}
}
