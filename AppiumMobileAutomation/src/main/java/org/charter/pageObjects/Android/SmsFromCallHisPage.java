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

public class SmsFromCallHisPage extends AndroidActions {

	AndroidDriver driver;

	public SmsFromCallHisPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(2000)), this);
	}

	@AndroidFindBy(id = "com.android.contacts:id/secondary_action_iv")
	private WebElement selectUser;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Text message\"]")
	private WebElement clickMsg;

	@AndroidFindBy(id = "com.android.mms:id/embedded_text_editor")
	private WebElement clickText;

	@AndroidFindBy(id = "com.android.mms:id/send_button")
	private WebElement clickSend;

	@AndroidFindBy(id = "com.android.mms:id/message_date")
	private WebElement verifyDetails;

	public void selectUser2() throws InterruptedException {
		selectUser.click();
		Thread.sleep(1000);
	}

	public void clickMsgIcon() throws InterruptedException {
		clickMsg.click();
		Thread.sleep(1000);

	}

	public void sendMsg() throws InterruptedException {
		clickText.click();
		clickText.sendKeys("Hi");
		Thread.sleep(1000);

	}

	public void clickSendMsg() throws InterruptedException {
		clickSend.click();
		Thread.sleep(1000);

	}

	public void verifyTime() throws InterruptedException {
		verifyDetails.click();
		boolean msgSentStatus = verifyDetails.isDisplayed();
		System.out.println(verifyDetails.getText());
		System.out.println(driver.getDeviceTime());

		if (verifyDetails.isDisplayed()) {
			System.out.println("SMS Sent time is," + verifyDetails.getText());

		} else {
			System.out.println("SMS failed to send");
		}
		Thread.sleep(8000);

	}

}