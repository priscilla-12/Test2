package org.charter.pageObjects.Android;

import java.net.MalformedURLException;
import java.time.Duration;

import org.charter.utils.AndroidActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ChromePage extends AndroidActions {

	AndroidDriver driver;

	public ChromePage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(2000)), this);
	}

	@AndroidFindBy(id = "com.android.chrome:id/search_box_text")
	private WebElement chromSrchBox;

	@AndroidFindBy(id = "com.android.chrome:id/url_bar")
	private WebElement chromUrlBar;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Logo\"]")
	private WebElement ascLogo;

	@AndroidFindBy(className = "android.widget.Button")
	private WebElement ascMenuBar;

	@AndroidFindBy(xpath = "//a[text()='About us']")
	private WebElement ascAboutUs;

	public void browseOnChrome() throws InterruptedException, MalformedURLException {
		try {

			chromSrchBox.click();
			chromUrlBar.sendKeys("https://ascendion.com/");
			driver.pressKey(new KeyEvent(AndroidKey.ENTER));
			Thread.sleep(10000);

			if (ascLogo.isDisplayed()) {
				System.out.println("Ascendion Page got opened");
			} else {
				System.out.println("Ascendion Page didn't opened");
			}

			Thread.sleep(10000);
			driver.pressKey(new KeyEvent(AndroidKey.HOME));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
