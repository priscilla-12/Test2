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

public class InstantMsgContactBookPage extends AndroidActions {

	AndroidDriver driver;

	public InstantMsgContactBookPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(2000)), this);
	}

	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Contacts\"]")
	private WebElement clickOnContacts;

	@AndroidFindBy(id = "android:id/input")
	private WebElement clickSearchButton;

	@AndroidFindBy(id = "com.android.contacts:id/name")
	private WebElement selectContact;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Text message\"]")
	private WebElement clickMsgIcon;

	@AndroidFindBy(id = "com.android.mms:id/embedded_text_editor")
	private WebElement clickTextMsg;

	@AndroidFindBy(id = "com.android.mms:id/send_button")
	private WebElement clickSendIcon;

	@AndroidFindBy(id = "com.android.mms:id/message_date")
	private WebElement verifySmsDetails;

	public void clickContacts() throws InterruptedException {
		clickOnContacts.click();
		Thread.sleep(1000);
	}

	public void clickOnSearch() throws InterruptedException {
		clickSearchButton.click();
		clickSearchButton.sendKeys("haritha");
		Thread.sleep(1000);

	}

	public void selectingUser() throws InterruptedException {
		selectContact.click();
		Thread.sleep(1000);

	}

	public void clickMsgButton() throws InterruptedException {
		clickMsgIcon.click();
		Thread.sleep(1000);

	}

	public void sendingSms() throws InterruptedException {
		clickTextMsg.click();
		clickTextMsg.sendKeys("Hi");
		Thread.sleep(1000);

	}

	public void clickSend() throws InterruptedException {
		clickSendIcon.click();
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