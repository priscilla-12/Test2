package org.charter.pageObjects.Android;

import static org.testng.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.charter.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class mmsRotationPage extends AndroidActions {

	AndroidDriver driver;

	public mmsRotationPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(2000)), this);
	}

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Start chat']")
	private WebElement startChat;

	@AndroidFindBy(className = "android.widget.MultiAutoCompleteTextView")
	private WebElement typeBox;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Anusha CollB']")
	private WebElement AnushaSms;

	@AndroidFindBy(id = "com.google.android.apps.messaging:id/compose_message_text")
	private WebElement composeMsg;

	@AndroidFindBy(id = "com.google.android.apps.messaging:id/plus_button")
	private WebElement addFiles;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Add files, location and more\"]")
	private WebElement plusButton;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Files\"]")
	private WebElement Files;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Lord Krishna.jpg']")
	private WebElement selectLK;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Lord Ganesha.jpg']")
	private WebElement selectLG;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='cat.mp4']")
	private WebElement selectCat;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='abstract.mp4']")
	private WebElement selectAbs;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.google.android.apps.messaging:id/message_status']")
	private WebElement rcvMsgTime;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Send end-to-end encrypted message\"]")
	private WebElement sendMMS;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.google.android.apps.messaging:id/status_icon']")
	private WebElement deliveredSign;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.google.android.apps.messaging:id/message_status']")
	private WebElement deliveredTime;

	public void checkRcvMms() throws InterruptedException {

		try {

			SimpleDateFormat formatter = new SimpleDateFormat("hh:mm aa");

			String startDate = formatter.format(Calendar.getInstance().getTime());
			Thread.sleep(10000);

			AnushaSms.click();
			String midDate = rcvMsgTime.getText();

			Date date1 = formatter.parse(startDate);

			Date date2 = formatter.parse(midDate);

			assertEquals(date2.after(date1), true);

			// Send Attachment
			addFiles.click();
			Files.click();
			selectLG.click(); // picture
			Files.click();
			selectCat.click(); // video

			Thread.sleep(5000);
			sendMMS.click();

			Thread.sleep(50000);
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			String endDate = rcvMsgTime.getText();
			Date date3 = formatter.parse(endDate);

			if (date3.after(date2)) {
				// Send Multiple Attachments
				plusButton.click();
				Files.click();
				selectLG.click(); // Pic
				Files.click();
				selectCat.click(); // Video
				Files.click();
				selectLK.click(); // Pic
				Files.click();
				selectAbs.click(); // Video

				Thread.sleep(20000);

				sendMMS.click();
			}

			else {
				System.out.println("Something Went Wrong:" + " " + "Please Check Your Code");
			}

		} catch (Exception e) {
			e.printStackTrace();
			;
		}

	}

}
