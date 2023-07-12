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

public class MessageDeliverSpclCharPage extends AndroidActions {

	AndroidDriver driver;

	public MessageDeliverSpclCharPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(2000)), this);
	}

	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Compose\"]")
	private WebElement clickAdd;

	@AndroidFindBy(id = "com.android.mms:id/recipients_viewer")
	private WebElement clickReci;

	@AndroidFindBy(id = "com.android.mms:id/recipients_editor")
	private WebElement typeReciName;

	@AndroidFindBy(id = "com.android.mms:id/name")
	private WebElement selectName;

	@AndroidFindBy(id = "com.android.mms:id/embedded_text_editor")
	private WebElement clickText;

	@AndroidFindBy(id = "com.android.mms:id/send_button")
	private WebElement clickSendIcon;

	@AndroidFindBy(id = "com.android.mms:id/message_date")
	private WebElement verifySmsDetails;

	public void clickAddIcon() throws InterruptedException {
		clickAdd.click();
		Thread.sleep(1000);
	}

	public void clickOnReci() throws InterruptedException {
		clickReci.click();
		Thread.sleep(1000);
	}

	public void recipientName() throws InterruptedException {
		typeReciName.click();
		typeReciName.sendKeys("haritha");
		Thread.sleep(1000);

	}

	public void selectUser() throws InterruptedException {
		selectName.click();
		Thread.sleep(1000);

	}

	public void clickingText() throws InterruptedException {
		clickText.click();
		clickText.sendKeys("!@#$%^^&*");
		Thread.sleep(1000);

	}

	public void clickSend() throws InterruptedException {
		clickSendIcon.click();
		Thread.sleep(1000);

	}

	public void verifyTime() throws InterruptedException {
		verifySmsDetails.click();
		boolean msgSentStatus = verifySmsDetails.isDisplayed();
		System.out.println(verifySmsDetails.getText());
		System.out.println(driver.getDeviceTime());

		if (verifySmsDetails.isDisplayed()) {
			System.out.println("SMS Sent time is," + verifySmsDetails.getText());

		} else {
			System.out.println("SMS failed to send");
		}
		Thread.sleep(8000);

	}

}