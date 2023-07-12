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

public class ReceiveSmsDuringVidCallPage extends AndroidActions {

	AndroidDriver driver;

	public ReceiveSmsDuringVidCallPage(AndroidDriver driver) {
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

	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Video call\"]")
	private WebElement callIcon;

	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Haritha\"]")
	private WebElement clickName;

	@AndroidFindBy(id = "com.android.mms:id/message_date")
	private WebElement timeVerify;

	public void contact() throws InterruptedException {
		clickContact.click();
		Thread.sleep(2000);
	}

	public void search() throws InterruptedException {
		searchButton.click();
		searchButton.sendKeys("harish");
		Thread.sleep(4000);

	}

	public void name() throws InterruptedException {
		clickBar.click();
		Thread.sleep(3000);

	}

	public void call() throws InterruptedException {
		callIcon.click();
		Thread.sleep(1000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(2000);

	}

	public void clickOnName() throws InterruptedException {
		clickName.click();
		Thread.sleep(1000);

	}

	public void verify() throws InterruptedException {
		timeVerify.click();
		Thread.sleep(5000);

	}

	public void verifyTime() throws InterruptedException {
		timeVerify.click();
		boolean msgSentStatus = timeVerify.isDisplayed();
		System.out.println(timeVerify.getText());
		System.out.println(driver.getDeviceTime());

		if (timeVerify.isDisplayed()) {
			System.out.println("SMS Received time is," + timeVerify.getText());

		} else {
			System.out.println("SMS failed to send");
		}
		Thread.sleep(8000);

	}

}