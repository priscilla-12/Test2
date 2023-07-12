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

public class galleryPage extends AndroidActions {

	AndroidDriver driver;

	public galleryPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(2000)), this);
	}

	@AndroidFindBy(xpath = "(//android.widget.LinearLayout)[15]")
	private WebElement automationFolderInGallery;

	@AndroidFindBy(id = "com.vivo.gallery:id/gallery_root_bottom")
	private WebElement insideAutomationGallery;

	@AndroidFindBy(id = "com.vivo.gallery:id/delete")
	private WebElement deletePhotoIcon;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Delete']")
	private WebElement confirmDeleteBtn;

	@SuppressWarnings("deprecation")
	public void deletePhoto() throws InterruptedException {
		try {
			Thread.sleep(3000);
			automationFolderInGallery.click();
			int s = insideAutomationGallery.getLocation().getX();
			System.out.println(s);

			TouchAction touchAction = new TouchAction(driver);
			touchAction.tap(PointOption.point(121, 425)).perform();
			Thread.sleep(3000);

			deletePhotoIcon.click();
			confirmDeleteBtn.click();
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
