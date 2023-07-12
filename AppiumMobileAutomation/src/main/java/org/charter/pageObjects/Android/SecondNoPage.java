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

public class SecondNoPage extends AndroidActions {

	AndroidDriver driver;

	public SecondNoPage(AndroidDriver driver) {
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

	@AndroidFindBy(accessibility = "Abc")
	private WebElement clickcontactList;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Details, Button\"]")
	private WebElement clickDetailsButton;

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Edit\"]/android.view.ViewGroup/android.widget.TextView")
	private WebElement clickEditButton1;

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Edit\"]/android.view.ViewGroup/android.widget.TextView")
	private WebElement clickEditButton2;

	@AndroidFindBy(id = "com.samsung.android.app.contacts:id/add_another_text")
	private WebElement clickanotherText;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Phone']")
	private WebElement clickEditText;

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Save\"]/android.view.ViewGroup/android.widget.TextView")
	private WebElement Save;

	@AndroidFindBy(id = "com.samsung.android.app.contacts:id/contact_editor_fragment")
	private WebElement contact;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='9962670645']")
	private WebElement contactNumber;

	@AndroidFindBy(accessibility = "Navigate up")
	private WebElement backButton;

	@AndroidFindBy(accessibility = "Navigate up")
	private WebElement backButton1;

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
		clicksearchText.sendKeys("Abc");
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

	public void editButton() throws InterruptedException {
		clickEditButton1.click();
		Thread.sleep(8000);

	}

	public void addAnotherText() throws InterruptedException {
		clickanotherText.click();
		Thread.sleep(8000);
	}

	public void editText() throws InterruptedException {
		clickEditText.click();
		clickEditText.sendKeys("9962670645");
		Save.click();
		Thread.sleep(8000);

	}

	public void editButton1() throws InterruptedException {
		clickEditButton2.click();
		Thread.sleep(8000);

		boolean secondContactnumberStatus = contactNumber.isDisplayed();
		if (secondContactnumberStatus) {
			System.out.println("Second PhoneNumber 9962670645 is associated to the contact successfully");
		} else {
			System.out.println("Second PhoneNumber 9962670645 associated is failed");
		}

		Thread.sleep(5000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		backButton.click();
		backButton1.click();
		Thread.sleep(5000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}

}
