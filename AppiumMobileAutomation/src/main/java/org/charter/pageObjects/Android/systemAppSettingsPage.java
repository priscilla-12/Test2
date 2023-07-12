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

public class systemAppSettingsPage extends AndroidActions {

	AndroidDriver driver;

	public systemAppSettingsPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(2000)), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Apps & permissions']")
	private WebElement appsAndPermissions;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='System app settings']")
	private WebElement systemAppSett;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Weather']")
	private WebElement weather;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Check for update']")
	private WebElement chkForUpdate;

	@AndroidFindBy(xpath = "//hierarchy/android.widget.Toast")
	private WebElement toastMsg;

	public void navigateToSysAppSettings() throws InterruptedException {
		try {
			uiautomatorScroll("Apps & permissions");
			appsAndPermissions.click();
			systemAppSett.click();
			weather.click();
			chkForUpdate.click();

			waitForElementToAppear(toastMsg, "text", "Already the latest version.", 5);

			WebDriverWait waitForToast = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitForToast
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));

			try {
				int size = driver.findElements(By.xpath("/hierarchy/android.widget.Toast")).size();
				System.out.println(size);

				if (size > 0) {
					System.out.println("Toast message is displayed in the device as " + toastMsg.getText());
				} else {
					System.out.println("Toast message is not displayed ");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
