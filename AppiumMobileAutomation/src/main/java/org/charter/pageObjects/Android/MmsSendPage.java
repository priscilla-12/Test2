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

public class MmsSendPage extends AndroidActions {

	AndroidDriver driver;

	public MmsSendPage(AndroidDriver driver) {
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

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='My Files']")
	private WebElement clickMyFiles;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Images']")
	private WebElement clickImages;

	@AndroidFindBy(accessibility = "Search")
	private WebElement selectSearchIcon;

	@AndroidFindBy(id = "com.sec.android.app.myfiles:id/search_src_text")
	private WebElement searchText;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='image.jpg']")
	private WebElement selectImage;

	@AndroidFindBy(id = "com.sec.android.app.myfiles:id/ripple")
	private WebElement clickCheckBox;

	@AndroidFindBy(id = "com.sec.android.app.myfiles:id/navigation_bar_item_small_label_view")
	private WebElement clickDone;

	@AndroidFindBy(id = "android:id/title")
	private WebElement selectImageTitle;

	@AndroidFindBy(id = "com.google.android.documentsui:id/thumbnail")
	private WebElement selectIconThumb;

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

	public void myFiles() throws InterruptedException {
		clickMyFiles.click();
		Thread.sleep(8000);
	}

	public void images() throws InterruptedException {
		clickImages.click();
		Thread.sleep(8000);
	}

	public void searchIcon1() throws InterruptedException {
		selectSearchIcon.click();
		Thread.sleep(8000);
	}

	public void Text() throws InterruptedException {
		searchText.click();
		searchText.sendKeys("image.jpg");
		Thread.sleep(8000);
	}

	public void image() throws InterruptedException {
		selectImage.click();
		Thread.sleep(8000);
	}

	public void checkBox() throws InterruptedException {
		clickCheckBox.click();
		clickDone.click();
		Thread.sleep(8000);
	}

	public void imageTitle() throws InterruptedException {
		selectImageTitle.click();
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
			System.out.println("MMS is delivered to secondary device successfully");

		} else {
			System.out.println("MMS sending failed");
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
