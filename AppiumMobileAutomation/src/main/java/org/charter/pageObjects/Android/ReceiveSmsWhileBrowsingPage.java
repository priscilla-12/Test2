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

public class ReceiveSmsWhileBrowsingPage extends AndroidActions {

	AndroidDriver driver;

	public ReceiveSmsWhileBrowsingPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(2000)), this);
	}

	@AndroidFindBy(id = "com.android.chrome:id/search_box_text")
	private WebElement searchText;

	@AndroidFindBy(id = "com.android.chrome:id/url_bar")
	private WebElement clickBar;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='appium automation']")
	private WebElement searchButton;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout")
	private WebElement swipe1;

	@AndroidFindBy(id = "android:id/big_text")
	private WebElement receivedMsg;

	@AndroidFindBy(id = "com.android.mms:id/message_date")
	private WebElement verifySms;

	public void searchBox() throws InterruptedException {
		searchText.click();
		Thread.sleep(2000);
	}

	public void urlBar() throws InterruptedException {
		clickBar.click();
		clickBar.sendKeys("appium automation");
		Thread.sleep(2000);

	}

	public void search() throws InterruptedException {
		searchButton.click();
		Thread.sleep(8000);

	}

	public void swipe() throws InterruptedException {
		swipeDown(swipe1, "down");
		Thread.sleep(8000);

	}

	public void msgReceived() throws InterruptedException {
		receivedMsg.click();
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