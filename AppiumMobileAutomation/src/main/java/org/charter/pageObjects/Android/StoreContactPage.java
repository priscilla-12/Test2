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

public class StoreContactPage extends AndroidActions {

	AndroidDriver driver;

	public StoreContactPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(2000)), this);
	}

	@AndroidFindBy(id = "com.sec.android.app.launcher:id/workspace")
	private WebElement swipeLabel;

	@AndroidFindBy(accessibility = "Phone")
	private WebElement phoneIcon;

	@AndroidFindBy(accessibility = "Create contact")
	private WebElement selectCreateContact;

	@AndroidFindBy(id = "com.samsung.android.app.contacts:id/nameEdit")
	private WebElement clickNameEdit;

	@AndroidFindBy(id = "com.samsung.android.app.contacts:id/titleText")
	private WebElement clickPhoneTextView;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Phone']")
	private WebElement clickPhoneEditText;

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Save\"]/android.view.ViewGroup/android.widget.TextView")
	private WebElement clickSave;

	@AndroidFindBy(accessibility = "Navigate up")
	private WebElement backButton;

	public void swipeScreen() throws InterruptedException {
		swipeUp(swipeLabel, "up");
		Thread.sleep(5000);

	}

	public void clickPhoneIcon() throws InterruptedException {
		phoneIcon.click();
		Thread.sleep(8000);

	}

	public void createContact() throws InterruptedException {
		selectCreateContact.click();
		Thread.sleep(8000);

	}

	public void nameEdit() throws InterruptedException {
		clickNameEdit.click();
		clickNameEdit.sendKeys("prisy");
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(8000);

	}

	public void phoneTextView() throws InterruptedException {
		clickPhoneTextView.click();

		Thread.sleep(8000);

	}

	public void phoneEditText() throws InterruptedException {
		clickPhoneEditText.click();
		clickPhoneEditText.sendKeys("9876543210");
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(5000);
	}

	public void saveButton() throws InterruptedException {

		clickSave.click();
		Thread.sleep(5000);
		backButton.click();
		Thread.sleep(5000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}

}
