package org.charter.pageObjects.Android;

import java.time.Duration;

import org.charter.utils.AndroidActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DeleteContactPage extends AndroidActions {

	AndroidDriver driver;

	public DeleteContactPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(2000)), this);
	}

	@AndroidFindBy(id = "com.sec.android.app.launcher:id/workspace")
	private WebElement swipeLabel;

	@AndroidFindBy(accessibility = "Phone")
	private WebElement phoneIcon;

	@AndroidFindBy(accessibility = "Search")
	private WebElement clicksearchIcon;

	@AndroidFindBy(id = "com.samsung.android.dialer:id/search_src_text")
	private WebElement clicksearchText;

	@AndroidFindBy(accessibility = "Example")
	private WebElement clickcontactList;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Details, Button\"]")
	private WebElement clickDetailsButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='More']")
	private WebElement clickMore;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Delete']")
	private WebElement clickDeleteOption;

	@AndroidFindBy(id = "android:id/button1")
	private WebElement clickDeleteBtn;

	@AndroidFindBy(accessibility = "Navigate up")
	private WebElement backButton;

	@AndroidFindBy(accessibility = "Search")
	private WebElement againSearch;

	@AndroidFindBy(id = "com.samsung.android.dialer:id/search_src_text")
	private WebElement clicksearchText1;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='No results found']")
	private WebElement verifyResults;

	@AndroidFindBy(id = "Navigate up")
	private WebElement backBtn;

	public void swipeScreen() throws InterruptedException {
		swipeUp(swipeLabel, "up");
		Thread.sleep(5000);

	}

	public void clickPhoneIcon() throws InterruptedException {
		phoneIcon.click();
		Thread.sleep(8000);

	}

	public void searchIcon() throws InterruptedException {
		clicksearchIcon.click();
		Thread.sleep(8000);

	}

	public void searchText() throws InterruptedException {
		clicksearchText.click();
		clicksearchText.sendKeys("Example");
		Thread.sleep(8000);

	}

	public void contactList() throws InterruptedException {
		clickcontactList.click();
		Thread.sleep(8000);

	}

	public void detailsButton() throws InterruptedException {
		clickDetailsButton.click();
		Thread.sleep(8000);

	}

	public void more() throws InterruptedException {
		clickMore.click();
		Thread.sleep(5000);
	}

	public void deleteOption() throws InterruptedException {
		clickDeleteOption.click();
		Thread.sleep(5000);
	}

	public void deleteBtn() throws InterruptedException {
		clickDeleteBtn.click();
		Thread.sleep(5000);
		backButton.click();
		againSearch.click();
		clicksearchText1.click();
		clicksearchText1.sendKeys("Example");
		driver.hideKeyboard();
	}

	public void verify() throws InterruptedException {

		Thread.sleep(8000);

		boolean results = verifyResults.isDisplayed();
		if (results) {
			System.out.println("Contacts is deleted from the Phonebook successfully");
		} else {
			System.out.println("Contacts is deleted from the Phonebook is failed");
		}
		Thread.sleep(8000);

		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
}
