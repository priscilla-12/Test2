package org.charter.pageObjects.Android;

import java.time.Duration;

import org.charter.utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class touchScreenPage extends AndroidActions {

	AndroidDriver driver;

	public touchScreenPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(2000)), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Airplane mode']")
	private WebElement airplanModeIcon;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Video']")
	private WebElement videoAppIcon;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Clock']")
	private WebElement clockAppIcon;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Accounts & sync']")
	private WebElement accountsAndSync;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Wi-Fi']")
	private WebElement wifiLabel;

	public void swipeLeft() throws InterruptedException {
		try {
			driver.pressKey(new KeyEvent(AndroidKey.HOME));
			Thread.sleep(2000);

			// LEFT Swipe
			swipeScreen("LEFT");
			Thread.sleep(1000);

			boolean vidIconExist = videoAppIcon.isDisplayed();
			if (vidIconExist) {
				System.out.println("Performed LEFT swipe");
			} else {
				System.out.println("LEFT swipe didn't worked");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void swipeRight() {
		try {
			// Right Swipe
			swipeScreen("RIGHT");
			Thread.sleep(1000);

			boolean clockAppIconExist = clockAppIcon.isDisplayed();
			if (clockAppIconExist) {
				System.out.println("Performed RIGHT swipe");
			} else {
				System.out.println("RIGHT swipe didn't worked");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void swipeUp() {
		try {
			launchAppDirect("com.android.settings", "com.android.settings.Settings");
			Thread.sleep(2000);
			swipeScreen("UP");
			Thread.sleep(1000);

			boolean accAndSyncExist = accountsAndSync.isDisplayed();
			if (accAndSyncExist) {
				System.out.println("Performed UP swipe");
			} else {
				System.out.println("UP swipe didn't worked");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void swipeDown() {
		try {
			Thread.sleep(2000);
			swipeScreen("DOWN");
			Thread.sleep(1000);

			boolean wifiLabelExist = wifiLabel.isDisplayed();
			if (wifiLabelExist) {
				System.out.println("Performed Down swipe");
			} else {
				System.out.println("Down swipe didn't worked");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
