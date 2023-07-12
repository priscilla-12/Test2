package org.charter.pageObjects.Android;

import java.time.Duration;

import org.charter.utils.AndroidActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MobileWebPage extends AndroidActions {

	AndroidDriver driver;

	public MobileWebPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(2000)), this);
	}

	@AndroidFindBy(id = "com.sec.android.app.launcher:id/workspace")
	private WebElement swipeLabel1;

	@AndroidFindBy(id = "com.android.systemui:id/notification_stack_scroller")
	private WebElement swipeLabel2;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Mobile,data,Off,Button\"]/android.widget.ImageView")
	private WebElement enableMobileData;

	@AndroidFindBy(accessibility = "Chrome")
	private WebElement clickChrome;

	@AndroidFindBy(id = "com.android.chrome:id/search_box_text")
	private WebElement clickSearch;

	@AndroidFindBy(id = "com.android.chrome:id/url_bar")
	private WebElement url;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Automation']")
	private WebElement clickSearchText;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View[1]/android.view.View[3]/android.view.View/android.view.View/android.view.View[1]/android.widget.EditText")
	private WebElement verifyText;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='All']")
	private WebElement verifySearchTools;

	@AndroidFindBy(id = "com.android.chrome:id/feed_stream_recycler_view")
	private WebElement clickEnter;

	@AndroidFindBy(accessibility = "Home")
	private WebElement homeButton;

	public void swipeScreen1() throws InterruptedException {
		swipeDown(swipeLabel1, "down");
		Thread.sleep(8000);

	}

	public void swipeScreen2() throws InterruptedException {
		swipeDown(swipeLabel2, "down");
		Thread.sleep(8000);

	}

	public void mobileData() throws InterruptedException {
		enableMobileData.click();
		Thread.sleep(8000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(8000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));

	}

	public void chrome() throws InterruptedException {
		clickChrome.click();
		driver.get("https://ascendion.com");
		Thread.sleep(8000);

	}

	public void search() throws InterruptedException {
		clickSearch.click();
		Thread.sleep(8000);

	}

	public void urlBar() throws InterruptedException {
		url.click();
        url.sendKeys("Automation");
		Thread.sleep(5000);

	}

	public void searchText() throws InterruptedException {
		clickSearchText.click();
		Thread.sleep(5000);

	}

	public void Text() throws InterruptedException {
		clickEnter.click();

		boolean verifyStatus = verifyText.isDisplayed();
		System.out.println(verifyText.getText());
		if (verifyText.isDisplayed()) {
			System.out.println("Web Browser Searching is, " + verifyText.getText());

		} else {
			System.out.println("Web Browser Searching is failed");
			Thread.sleep(5000);

		}
	}

	public void close() throws InterruptedException {

		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(5000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));

	}

}
