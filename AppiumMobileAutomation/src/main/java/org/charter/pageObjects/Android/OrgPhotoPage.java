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

public class OrgPhotoPage extends AndroidActions {

	AndroidDriver driver;

	public OrgPhotoPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(2000)), this);
	}

	@AndroidFindBy(id = "com.sec.android.app.launcher:id/workspace")
	private WebElement swipeLabel;

	@AndroidFindBy(id = "com.sec.android.app.launcher:id/app_search_edit_text")
	private WebElement clickSearch;

	@AndroidFindBy(id = "com.samsung.android.app.galaxyfinder:id/edit_search")
	private WebElement clickEditSearch;

	@AndroidFindBy(accessibility = "Photos")
	private WebElement clickPhotos;

	@AndroidFindBy(id = "com.google.android.apps.photos:id/tab_library")
	private WebElement clickLibrary;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Download']")
	private WebElement clickDownload;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Photo taken on 31-Mar-2023 10:03:40 am\"]")
	private WebElement selectPhoto;

	@AndroidFindBy(accessibility = "Create or add to album")
	private WebElement clickaddButton;

	@AndroidFindBy(id = "com.google.android.apps.photos:id/actionbar_overflow")
	private WebElement clickactionBar;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Copy to folder']")
	private WebElement clickCopyFolder;

	@AndroidFindBy(id = "android:id/button1")
	private WebElement clickAllow;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='New folder']")
	private WebElement clickNewFolder;

	@AndroidFindBy(id = "com.google.android.apps.photos:id/folder_name")
	private WebElement enterFolderName;

	@AndroidFindBy(id = "android:id/button1")
	private WebElement clickCreate;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
	private WebElement backbtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Aancy']")
	private WebElement clickagainFolder;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Photo taken on 31-Mar-2023 10:03:40 am\"]")
	private WebElement verifyPhoto;

	@AndroidFindBy(accessibility = "Navigate up")
	private WebElement backbtn1;

	public void swipeScreen() throws InterruptedException {
		swipeUp(swipeLabel, "up");
		Thread.sleep(5000);
	}

	public void search() throws InterruptedException {
		clickSearch.click();
		Thread.sleep(5000);

	}

	public void searchEdit() throws InterruptedException {
		clickEditSearch.click();
		clickEditSearch.sendKeys("Photos");
		Thread.sleep(5000);

	}

	public void photos() throws InterruptedException {
		clickPhotos.click();
		Thread.sleep(5000);

	}

	public void library() throws InterruptedException {
		clickLibrary.click();
		Thread.sleep(5000);

	}

	public void download() throws InterruptedException {
		clickDownload.click();
		Thread.sleep(5000);

	}

	public void longPressPhotos() throws InterruptedException {
		longPress(selectPhoto);
		Thread.sleep(5000);
	}

	public void actionBar() throws InterruptedException {
		clickactionBar.click();
		Thread.sleep(5000);

	}

	public void copyFolder() throws InterruptedException {
		clickCopyFolder.click();
		Thread.sleep(5000);

	}

	public void allow() throws InterruptedException {
		clickAllow.click();
		Thread.sleep(5000);

	}

	public void newFolder() throws InterruptedException {
		clickNewFolder.click();
		Thread.sleep(5000);

	}

	public void folderName() throws InterruptedException {
		enterFolderName.click();
		enterFolderName.sendKeys("Aancy");
		Thread.sleep(5000);

	}

	public void create() throws InterruptedException {
		clickCreate.click();
		backbtn.click();
		Thread.sleep(5000);

	}

	public void againFolder() throws InterruptedException {
		clickagainFolder.click();
		Thread.sleep(5000);

	}

	public void verify() throws InterruptedException {

		boolean photoStatus = verifyPhoto.isDisplayed();

		if (photoStatus) {
			System.out.println("Photos Copied to another Folder successfully");

		} else {
			System.out.println("Photos Copied to another Folder is failed");
		}
		Thread.sleep(8000);
		backbtn1.click();
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}

}
