package org.charter.pageObjects.Android;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.testng.Assert;

import org.charter.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class rcvMmsPage extends AndroidActions {

	AndroidDriver driver;

	public rcvMmsPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(2000)), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Anusha CollB']")
	private WebElement AnushaSms;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.google.android.apps.messaging:id/message_status']")
	private WebElement rcvMsgTime;

	@AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"Image\"])")
	private List<WebElement> picList;

	public void checkRcvMms() throws InterruptedException {

		try {

			// To Get System/Device Date
			Thread.sleep(5000);
			SimpleDateFormat formatter = new SimpleDateFormat("hh:mm aa");

			String startDate = formatter.format(Calendar.getInstance().getTime());

			AnushaSms.click();
			String endDate = rcvMsgTime.getText();
			// Parsing the given String to Date object

			Date date1 = formatter.parse(startDate);

			Date date2 = formatter.parse(endDate);

			Assert.assertEquals(date2.after(date1), true);

		} catch (Exception e) {
			e.printStackTrace();
			;
		}

	}

}
