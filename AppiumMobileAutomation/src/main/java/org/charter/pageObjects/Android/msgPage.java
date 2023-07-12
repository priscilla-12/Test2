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

public class msgPage extends AndroidActions {

	AndroidDriver driver;

	public msgPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(2000)), this);
	}

	@AndroidFindBy(xpath = "//android.widget.Button[@index=1]")
	private WebElement newMsgPlusIcon;

	@AndroidFindBy(id = "com.android.mms:id/compose_recipients_name")
	private WebElement toTxtBox1;

	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"To\"]")
	private WebElement toTxtBox2;

	@AndroidFindBy(id = "com.android.mms:id/embedded_text_editor")
	private WebElement enterMsgTxtBox;

	@AndroidFindBy(id = "com.android.mms:id/send_button")
	private WebElement sendMsgBtn;

	@AndroidFindBy(id = "com.android.mms:id/frame")
	private WebElement contactList;

	public void sendMessage() throws InterruptedException {
		newMsgPlusIcon.click();
		Thread.sleep(2000);
		toTxtBox1.click();
		Thread.sleep(2000);
		toTxtBox2.sendKeys("9790174022");

		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		contactList.click();
		Thread.sleep(2000);
		enterMsgTxtBox.click();
		Thread.sleep(1000);
		enterMsgTxtBox.sendKeys("Hello");
		sendMsgBtn.click();
		Thread.sleep(5000);

	}

}
