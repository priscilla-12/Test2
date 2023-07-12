package org.charter.pageObjects.Android;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.charter.utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class messagePage extends AndroidActions {

	AndroidDriver driver;
	SimpleDateFormat formatter;

	public messagePage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		formatter = new SimpleDateFormat("hh:mm aa");
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(2000)), this);
	}

	@AndroidFindBy(xpath = "//android.widget.Button[(@text='Start chat')]")
	private WebElement newMsgPlusIcon;

	@AndroidFindBy(id = "com.android.mms:id/compose_recipients_name")
	private WebElement toTxtBox1;

	@AndroidFindBy(id = "com.google.android.apps.messaging:id/recipient_text_view")
	private WebElement toTxtBox2;

	@AndroidFindBy(id = "com.google.android.apps.messaging:id/compose_message_text")
	private WebElement enterMsgTxtBox;

	@AndroidFindBy(id = "com.google.android.apps.messaging:id/send_message_button_icon")
	private WebElement sendMsgBtn;

	@AndroidFindBy(id = "com.android.mms:id/frame")
	private WebElement contactList;

	@AndroidFindBy(id = "com.google.android.apps.messaging:id/message_status")
	private WebElement revmsgTime;

	@AndroidFindBy(id = "com.google.android.apps.messaging:id/unread_badge")
	private WebElement msgUnreadbadge;

	@AndroidFindBy(xpath = "//android.widget.TextView[(@text='Draft')]")
	private WebElement draftMsgIcon;

	public void newMsgPlusIcon() {
		newMsgPlusIcon.click();

	}

	public void toTxtBox2() throws InterruptedException {

		driver.pressKey(new KeyEvent(AndroidKey.DIGIT_9));
		driver.pressKey(new KeyEvent(AndroidKey.DIGIT_9));
		driver.pressKey(new KeyEvent(AndroidKey.DIGIT_9));
		driver.pressKey(new KeyEvent(AndroidKey.DIGIT_7));
		driver.pressKey(new KeyEvent(AndroidKey.DIGIT_9));
		driver.pressKey(new KeyEvent(AndroidKey.DIGIT_9));
		driver.pressKey(new KeyEvent(AndroidKey.DIGIT_9));
		driver.pressKey(new KeyEvent(AndroidKey.DIGIT_6));
		driver.pressKey(new KeyEvent(AndroidKey.DIGIT_9));
		driver.pressKey(new KeyEvent(AndroidKey.DIGIT_3));

	}

	public void clickMsgTxtBox() {
		enterMsgTxtBox.click();

	}

	public void enterMsgTxtBox() {
		enterMsgTxtBox.sendKeys("Hello");

	}

	public void sendMsgBtn() {
		sendMsgBtn.click();

	}

	public void sendMessage() throws InterruptedException, AWTException {
		newMsgPlusIcon();
		Thread.sleep(2000);
		driver.findElement(By.id("com.google.android.apps.messaging:id/action_ime_dialpad_toggle")).click();

		toTxtBox2();

		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		Thread.sleep(2000);
		clickMsgTxtBox();
		enterMsgTxtBox();
		sendMsgBtn();

	}

	public void draftMessage() throws InterruptedException {
		newMsgPlusIcon();
		Thread.sleep(2000);
		driver.findElement(By.id("com.google.android.apps.messaging:id/action_ime_dialpad_toggle")).click();
		toTxtBox2();
		Thread.sleep(1000);
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		clickMsgTxtBox();
		enterMsgTxtBox();

		driver.pressKey(new KeyEvent(AndroidKey.HOME));

	}

	public void receivemsg(String startTime) throws InterruptedException, ParseException {

		if (msgUnreadbadge.isDisplayed()) {
			msgUnreadbadge.click();
			String msgrevTime = revmsgTime.getText();

			Date date1 = formatter.parse(startTime);

			Date date2 = formatter.parse(msgrevTime);

			assertEquals(date2.after(date1), true);

			System.out.println("Message Received");
		} else {
			System.out.println("Message not Received");
		}
	}

	public void draftmsgIcon() {
		if (draftMsgIcon.isDisplayed()) {
			System.out.println("Message Saved in Draft");
		} else {
			System.out.println("Message not Saved in Draft");
		}
	}

	public void launchAppDirect(String appPackage, String appActivity) {
		try {
			Activity activityMsg = new Activity(appPackage, appActivity);
			driver.startActivity(activityMsg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
