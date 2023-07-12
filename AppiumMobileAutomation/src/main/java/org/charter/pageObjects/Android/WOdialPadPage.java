package org.charter.pageObjects.Android;

import java.time.Duration;

import org.charter.utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import dev.failsafe.internal.util.Assert;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import static org.testng.Assert.assertEquals;

public class WOdialPadPage extends AndroidActions {

	AndroidDriver driver;

	public WOdialPadPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(300)), this);
	}

	@AndroidFindBy(accessibility = "key pad")
	private WebElement dialPad;

	@AndroidFindBy(accessibility = "Phone")
	private WebElement phoneIcon;

	@AndroidFindBy(accessibility = "dial")
	private WebElement dialbtn;

	@AndroidFindBy(id = "com.google.android.dialer:id/contactgrid_status_text")
	private WebElement wificall;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Hold call\"]/android.widget.ImageView")
	private WebElement holdCall;

	public void dialPad() {
		dialPad.click();

	}

	public void phoneIcon() {
		phoneIcon.click();

	}

	public void dialbtn() {
		dialbtn.click();

	}

	public void dialNo(String string) {
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + string + "']")).click();
	}

	public void wificall() {
		assertEquals(holdCall.isDisplayed(), true);

		if (holdCall.isDisplayed()) {
			System.out.println("Call is Connected");
		} else {
			System.out.println("Call is not Connected");
		}

	}

	public void moVoiceCall() throws InterruptedException {
		dialPad();
		dialNo("7");
		dialNo("8");
		dialNo("7");
		dialNo("1");
		dialNo("7");
		dialNo("5");
		dialNo("1");
		dialNo("8");
		dialNo("7");
		dialNo("8");
		dialbtn();
		Thread.sleep(3000);
		wificall();
	}

	public void launchAppDirect(String appPackage, String appActivity) {
		try {
			Activity activityMsg = new Activity(appPackage, appActivity);
			driver.startActivity(activityMsg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
