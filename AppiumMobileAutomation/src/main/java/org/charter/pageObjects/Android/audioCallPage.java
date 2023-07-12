package org.charter.pageObjects.Android;

import java.net.MalformedURLException;
import java.time.Duration;

import org.charter.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class audioCallPage extends AndroidActions {

	AndroidDriver driver;

	public audioCallPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(2000)), this);
	}

	@AndroidFindBy(id = "com.google.android.dialer:id/tab_contacts")
	private WebElement contactsList;

	@AndroidFindBy(className = "android.widget.EditText")
	private WebElement searchCont;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.google.android.dialer:id/contact_header']")
	private WebElement contName;

	@AndroidFindBy(id = "com.google.android.contacts:id/verb_call")
	private WebElement audCall;

	@AndroidFindBy(id = "com.google.android.contacts:id/verb_text")
	private WebElement textMsg;

	@AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"Phone account icon\"])[1]")
	private WebElement selectJioSim;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='airtel']")
	private WebElement simAirtel;

	public void makeAcall() throws InterruptedException, MalformedURLException {
		try {

			contactsList.click();
			Thread.sleep(2000);
			searchCont.click();
			searchCont.sendKeys("9113028422");
			Thread.sleep(4000);
			contName.click();

			// Make Audio Call
			audCall.click();
			selectJioSim.click();

			Thread.sleep(50000);
			driver.pressKey(new KeyEvent(AndroidKey.HOME));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
