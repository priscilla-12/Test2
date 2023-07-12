package org.charter.pageObjects.Android;

import java.time.Duration;

import org.charter.utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

public class videoAppPage extends AndroidActions {

	AndroidDriver driver;

	public videoAppPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(2000)), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Automation Video']")
	private WebElement automationVideoFolder;

	@AndroidFindBy(id = "com.android.VideoPlayer:id/local_iv_thumbnail")
	private WebElement video;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Delete']")
	private WebElement deleteIcon;

	@AndroidFindBy(id = "com.android.VideoPlayer:id/confirm")
	private WebElement confirmDeleteBtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Video']")
	private WebElement videosAppIcon;

	@SuppressWarnings("deprecation")
	public void deleteVideo() throws InterruptedException {
		try {
			videosAppIcon.click();

			TouchAction touchAction = new TouchAction(driver);
			touchAction.tap(PointOption.point(386, 214)).perform();
			Thread.sleep(3000);

			automationVideoFolder.click();
			Thread.sleep(2000);

			longPress(video);

			deleteIcon.click();
			Thread.sleep(1000);

			confirmDeleteBtn.click();
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
