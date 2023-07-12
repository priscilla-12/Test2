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

public class SmsMoreThan160CharPage extends AndroidActions {

	AndroidDriver driver;

	public SmsMoreThan160CharPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(2000)), this);
	}

	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Compose\"]")
	private WebElement clickAddButton;

	@AndroidFindBy(id = "com.android.mms:id/recipients_viewer")
	private WebElement clickRecipient;

	@AndroidFindBy(id = "com.android.mms:id/recipients_editor")
	private WebElement typeUserName;

	@AndroidFindBy(id = "com.android.mms:id/name")
	private WebElement selectUser;

	@AndroidFindBy(id = "com.android.mms:id/embedded_text_editor")
	private WebElement clickTextMsg;

	@AndroidFindBy(id = "com.android.mms:id/send_button")
	private WebElement clickSendButton;

	@AndroidFindBy(id = "com.android.mms:id/message_date")
	private WebElement verifySmsDetails;

	public void clickOnAdd() throws InterruptedException {
		clickAddButton.click();
		Thread.sleep(1000);
	}

	public void clickOnReci() throws InterruptedException {
		clickRecipient.click();
		Thread.sleep(1000);
	}

	public void recipientName() throws InterruptedException {
		typeUserName.click();
		typeUserName.sendKeys("haritha");
		Thread.sleep(1000);

	}

	public void selectUser() throws InterruptedException {
		selectUser.click();
		Thread.sleep(1000);

	}

	public void clickTypMsg() throws InterruptedException {
		clickTextMsg.click();
		clickTextMsg.sendKeys(
				"Appium is a mobile automation testing tool which is used to automate mobile applications on different mobile operating systems such as Android and iOS. It is an open source tool which can be used to automate the testing of different mobile device applications such as native, WAP and hybrid application. Appium is a mobile automation testing tool which is used to automate mobile applications on different mobile operating systems");
		Thread.sleep(8000);

	}

	public void clickSend() throws InterruptedException {
		clickSendButton.click();
		driver.hideKeyboard();
		Thread.sleep(1000);

	}

	public void verifyTime() throws InterruptedException {
		verifySmsDetails.click();
		boolean msgSentStatus = verifySmsDetails.isDisplayed();
		System.out.println(verifySmsDetails.getText());
		System.out.println(driver.getDeviceTime());

		if (verifySmsDetails.isDisplayed()) {
			System.out.println("SMS Sent time is," + verifySmsDetails.getText());

		} else {
			System.out.println("SMS failed to send");
		}
		Thread.sleep(8000);

	}

}