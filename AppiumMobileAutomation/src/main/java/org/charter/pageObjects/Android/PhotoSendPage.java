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

public class PhotoSendPage extends AndroidActions {

	AndroidDriver driver;

	public PhotoSendPage(AndroidDriver driver) {
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

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Image']")
	private WebElement clickImage;

	@AndroidFindBy(accessibility = "Gallery")
	private WebElement clickGallery;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Ascendion Friends']")
	private WebElement clickFolder;

	@AndroidFindBy(xpath = "(//android.widget.FrameLayout[@content-desc=\"Button\"])[4]/android.widget.FrameLayout[2]")
	private WebElement selectPhoto;

	@AndroidFindBy(id = "com.sec.android.gallery3d:id/action_done")
	private WebElement clickDone;

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
		Thread.sleep(5000);
	}

	public void messagesIcon() throws InterruptedException {
		openMessages.click();
		Thread.sleep(5000);

	}

	public void searchIcon() throws InterruptedException {
		clickSearch.click();
		Thread.sleep(5000);
	}

	public void searchText() throws InterruptedException {
		clickSearchText.click();
		clickSearchText.sendKeys("Abc");
		Thread.sleep(5000);
	}

	public void contact() throws InterruptedException {
		selectContact.click();
		Thread.sleep(5000);
	}

	public void otherOptions() throws InterruptedException {
		selectOtherOptions.click();
		Thread.sleep(5000);
	}

	public void image() throws InterruptedException {
		clickImage.click();
		Thread.sleep(5000);
	}

	public void gallery() throws InterruptedException {
		clickGallery.click();
		Thread.sleep(5000);
	}

	public void folder() throws InterruptedException {
		clickFolder.click();
		Thread.sleep(5000);
	}

	public void photo() throws InterruptedException {
		selectPhoto.click();
		Thread.sleep(5000);
	}

	public void doneButton() throws InterruptedException {
		clickDone.click();
		Thread.sleep(5000);
	}

	public void okButton() throws InterruptedException {

		clickOK.click();
		Thread.sleep(8000);
	}

	public void sentButton() throws InterruptedException {
		clickSent.click();
		Thread.sleep(10000);

		boolean msgSentStatus = MessageStatus.isDisplayed();

		if (msgSentStatus) {
			String msgStatus = MessageStatus.getText();
			String str = "Delivered";
			if (msgStatus.equalsIgnoreCase(str)) {
				System.out.println("Photos Shared to another User successfully");
			} else {
				System.out.println("Photos Sharing Failed");
			}
			// System.out.println("Photos Shared to another User successfully");

		} else {
			System.out.println("Msg sent Status element is not Displayed");
		}
		Thread.sleep(8000);
		backBtn.click();
		backBtn1.click();

		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}

}
