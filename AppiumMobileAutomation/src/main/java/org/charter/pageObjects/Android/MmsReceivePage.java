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

public class MmsReceivePage extends AndroidActions {

	AndroidDriver driver;

	public MmsReceivePage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(2000)), this);
	}

	@AndroidFindBy(id = "com.sec.android.app.launcher:id/workspace")
	private WebElement swipeLabel;

	@AndroidFindBy(accessibility = "Messages")
	private WebElement openMessages;

	@AndroidFindBy(accessibility = "Search")
	private WebElement clickSearch;

	@AndroidFindBy(id = "com.samsung.android.messaging:id/search_src_text")
	private WebElement clickSearchText;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Abc']")
	private WebElement selectContact;

	@AndroidFindBy(id = "com.samsung.android.messaging:id/base_list_item_info_date")
	private WebElement checkReceivedTime;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
	private WebElement backBtn;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
	private WebElement backBtn1;

	public void swipeScreen() throws InterruptedException {
		swipeUp(swipeLabel, "up");
		Thread.sleep(8000);

	}

	public void messagesIcon() throws InterruptedException {
		openMessages.click();
		Thread.sleep(8000);

	}

	public void searchIcon() throws InterruptedException {
		clickSearch.click();
		Thread.sleep(8000);
	}

	public void searchText() throws InterruptedException {
		clickSearchText.click();
		clickSearchText.sendKeys("Abc");
		Thread.sleep(8000);
	}

	public void contact() throws InterruptedException {
		selectContact.click();
		Thread.sleep(8000);
	}

	public void receivedStatus() throws InterruptedException {

		boolean ReceivedMessageStatus1 = checkReceivedTime.isDisplayed();
		System.out.println(checkReceivedTime.getText());
		System.out.println(driver.getDeviceTime());

		if (checkReceivedTime.isDisplayed()) {

			System.out.println("MMS received time is, " + checkReceivedTime.getText());

		} else {
			System.out.println("MMS receiving time  is failed");
		}
		Thread.sleep(5000);
		backBtn.click();

		Thread.sleep(5000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
}
