package org.charter.pageObjects.Android;

import java.time.Duration;

import org.charter.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import dev.failsafe.internal.util.Assert;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class sendMmsPage extends AndroidActions {

	AndroidDriver driver;

	public sendMmsPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(2000)), this);
	}

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Start chat']")
	private WebElement startChat;

	@AndroidFindBy(className = "android.widget.MultiAutoCompleteTextView")
	private WebElement typeBox;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='airtel (SIM 2)']")
	private WebElement simAirtel;

	@AndroidFindBy(id = "android:id/button1")
	private WebElement simContinue;

	@AndroidFindBy(id = "com.google.android.apps.messaging:id/compose_message_text")
	private WebElement composeMsg;

	@AndroidFindBy(id = "com.google.android.apps.messaging:id/plus_button")
	private WebElement addFiles;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Files\"]")
	private WebElement Files;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Stickers\"]")
	private WebElement selectStickers;

	@AndroidFindBy(id = "com.google.android.apps.messaging:id/proxy_screen_search_bar")
	private WebElement stickerSearchBox;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='hello there']")
	private WebElement searchResult;

	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Hamster Bun Cute Sticker\"]")
	private WebElement helloThrSticker;

	@AndroidFindBy(id = "com.google.android.apps.messaging:id/camera_gallery_button")
	private WebElement GalleryBtn;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Explore more in Gallery\"]")
	private WebElement explrGallery;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='image March 22 2023 8 22 am']")
	private WebElement imgSelection;

	@AndroidFindBy(id = "com.google.android.apps.messaging:id/container_action_button")
	private WebElement addsSelectedImg;

//	 @AndroidFindBy(xpath="//android.widget.ImageView[@content-desc=\"Send MMS\"]")
	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Send end-to-end encrypted message\"]")
	private WebElement sendMMS;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.google.android.apps.messaging:id/status_icon']")
	private WebElement deliveredSign;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.google.android.apps.messaging:id/message_status']")
	private WebElement deliveredTime;

	public void sendMms() throws InterruptedException {

		try {
			Thread.sleep(5000);
			startChat.click();
			Thread.sleep(1000);

			typeBox.click();
			Thread.sleep(5000);

			typeBox.sendKeys("9113028422"); // Anusha

			Thread.sleep(5000);

			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			driver.pressKey(new KeyEvent(AndroidKey.ENTER));
			simAirtel.click();
			simContinue.click();

			// Send Sticker
			addFiles.click();
			selectStickers.click();
			stickerSearchBox.click();
			stickerSearchBox.sendKeys("hello there");
			Thread.sleep(2000);
			searchResult.click();
			Thread.sleep(2000);
			helloThrSticker.click();
			Thread.sleep(5000);

			composeMsg.sendKeys("This Side Abhinav");
			sendMMS.click();

			if (deliveredSign.isDisplayed()) {
				System.out.println("Message has been delivered");
				System.out.println(deliveredTime.getText());

			} else {
				System.out.println("Message hasn't been delivered");
			}

		} catch (Exception e) {
			e.printStackTrace();
			;
		}

	}

}
