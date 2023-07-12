package org.charter.pageObjects.Android;

import java.time.Duration;

import org.charter.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MMSSendWifiPage extends AndroidActions {
	AndroidDriver driver;

	public MMSSendWifiPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(2000)), this);
	}

	@AndroidFindBy(id = "com.android.settings:id/coui_statusText1")
	private WebElement wifi_Homebutton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Wi-Fi']")
	private WebElement wifi_screen_button;

	@AndroidFindBy(id = "android:id/switch_widget")
	private WebElement wifi_button_for_enabling_and_disabling;

	@AndroidFindBy(accessibility = "Navigate up")
	private WebElement navigateback_to_settings;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Mobile network']")
	private WebElement MobilenetworkIcon;

	@AndroidFindBy(className = "android.widget.Switch")
	private WebElement mblDataStatus;

	@AndroidFindBy(accessibility = "Start chat")
	private WebElement Start_chat;

	@AndroidFindBy(id = "com.google.android.apps.messaging:id/recipient_text_view")
	private WebElement toTxtBox1;

	@AndroidFindBy(accessibility = "Add files, location and more")
	private WebElement PlusIcon;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Files\"]/android.widget.ImageView")
	private WebElement FilesIcon;

	@AndroidFindBy(accessibility = "Search")
	private WebElement SearchIcon;

	@AndroidFindBy(id = "com.google.android.documentsui:id/search_src_text")
	private WebElement Searchtextbox;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='yellow-cat.gif']")
	private WebElement imagegif;

	@AndroidFindBy(id = "com.google.android.apps.messaging:id/send_message_button_icon")
	private WebElement sendMsgBtn;

	public void settings_wifi() {
		wifi_screen_button.click();
		String wifi_status = wifi_button_for_enabling_and_disabling.getText();
		if (wifi_status.equals("On")) {
			System.out.println("wifi is already selected. now its getting turned off");
			wifi_button_for_enabling_and_disabling.click();
		} else {
			System.out.println("wifi  is not selected");
		}
	}

	public void settingsBack() {
		navigateback_to_settings.click();
	}

	public void settings_mobiledata() throws InterruptedException {
		MobilenetworkIcon.click();
		Thread.sleep(2000);
		String mobile_status = mblDataStatus.getText();
		System.out.println(mobile_status);
		if (mobile_status.equals("On")) {
			System.out.println("mobiledata is already selected. now its getting turned off");
			mblDataStatus.click();
		} else {
			System.out.println("mobiledata  is not selected");
		}
	}

	public void sendMMS() throws InterruptedException {
		Start_chat.click();
		Thread.sleep(1000);
		toTxtBox1.sendKeys("9150102654");
		Thread.sleep(1000);
		driver.pressKey(new KeyEvent(AndroidKey.TAB));
		Thread.sleep(3000);
		PlusIcon.click();
		Thread.sleep(1000);
		FilesIcon.click();
		SearchIcon.click();
		Searchtextbox.sendKeys("yellow-cat.gif");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		imagegif.click();
		sendMsgBtn.click();

	}

}
