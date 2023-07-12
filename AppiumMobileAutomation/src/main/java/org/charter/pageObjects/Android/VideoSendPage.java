package org.charter.pageObjects.Android;

import java.time.Duration;

import org.charter.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class VideoSendPage extends AndroidActions {

	AndroidDriver driver;

	public VideoSendPage(AndroidDriver driver) {
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

	@AndroidFindBy(accessibility = "Other options")
	private WebElement selectOtherOptions;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Video']")
	private WebElement clickVideoIcon;

	@AndroidFindBy(accessibility = "Gallery")
	private WebElement clickGallery;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Videos']")
	private WebElement clickVideoFolder;

	@AndroidFindBy(xpath = "(//android.widget.FrameLayout[@content-desc=\"Button\"])[2]/android.widget.FrameLayout[2]")
	private WebElement selectVideo;

	@AndroidFindBy(id = "com.samsung.android.messaging:id/video_send_full_size")
	private WebElement selectVideoSize;

	@AndroidFindBy(id = "android:id/button1")
	private WebElement clickOK;

	@AndroidFindBy(id = "com.samsung.android.messaging:id/end_buttons_container")
	private WebElement clickSent;

	@AndroidFindBy(id = "com.samsung.android.messaging:id/base_list_item_info_status_text")
	private WebElement MessageStatus;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
	private WebElement backBtn;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
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

	public void otherOptions() throws InterruptedException {
		selectOtherOptions.click();
		Thread.sleep(8000);
	}

	public void videoOption() throws InterruptedException {
		clickVideoIcon.click();
		Thread.sleep(8000);
	}

	public void gallery() throws InterruptedException {
		clickGallery.click();
		Thread.sleep(8000);
	}

	public void videoFolder() throws InterruptedException {
		clickVideoFolder.click();
		Thread.sleep(8000);
	}

	public void video() throws InterruptedException {
		selectVideo.click();
		Thread.sleep(8000);
	}

	public void videoSize() throws InterruptedException {
		selectVideoSize.click();
		Thread.sleep(8000);
	}

	public void okButton() throws InterruptedException {

		clickOK.click();
		Thread.sleep(8000);
	}

	public void sentButton() throws InterruptedException {
		clickSent.click();
		Thread.sleep(8000);

		boolean msgSentStatus = MessageStatus.isDisplayed();

		if (msgSentStatus) {
			String msgStatus = MessageStatus.getText();
			String str = "Delivered";
			if (msgStatus.equalsIgnoreCase(str)) {
				System.out.println("Videos Shared to another User successfully");
			} else {
				System.out.println("Videos Sharing Failed");
			}
			// System.out.println("Photos Shared to another User successfully");

		} else {
			System.out.println("Msg sent Status element is not Displayed");
		}
		Thread.sleep(5000);
		backBtn.click();
		backBtn1.click();
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}

}
