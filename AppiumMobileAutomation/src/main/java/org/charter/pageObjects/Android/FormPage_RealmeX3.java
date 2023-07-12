package org.charter.pageObjects.Android;

import org.charter.utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.time.Duration;

public class FormPage_RealmeX3 extends AndroidActions {

	AndroidDriver driver;

	public FormPage_RealmeX3(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(2000)), this);

	}

	@AndroidFindBy(xpath = "//android.view.View[1]/android.view.View[2]/android.widget.Button")
	private WebElement openAppOnDevice;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Search for apps & games']")
	private WebElement playStoreSearchBox;

	@AndroidFindBy(className = "android.widget.EditText")
	private WebElement searchApp;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	private WebElement nameField;

	@AndroidFindBy(id = "android:id/text1")
	private WebElement country;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
	private WebElement femaleOption;

	public void country(String countryName) throws InterruptedException {
		Thread.sleep(5000);
		country.click();
		uiautomatorScroll(countryName);
		String test = "//android.widget.TextView[text()='" + countryName + "']";
		System.out.println("************" + test);
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + countryName + "']")).click();
	}

	public void enterName(String name) {
		nameField.sendKeys(name);
	}

	public void enterAppName(String appname) {
		searchApp.sendKeys(appname);
	}

	public void pStoreSearchBox() {
		playStoreSearchBox.click();
	}

	public void selectGender(String female) {
		if (female.equalsIgnoreCase("female")) {
			femaleOption.click();
		}
	}

	public void openOrInstallRealApp() {
		openAppOnDevice.click();
	}

	public void clickSearchIcon() {
		driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "search"));
	}

}
