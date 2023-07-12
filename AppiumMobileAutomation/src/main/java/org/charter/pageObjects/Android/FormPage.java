package org.charter.pageObjects.Android;

import org.charter.utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.time.Duration;

public class FormPage extends AndroidActions {

	AndroidDriver driver;

	public FormPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(2000)), this);

	}

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

	public void selectGender(String female) {
		if (female.equalsIgnoreCase("female")) {
			femaleOption.click();
		}

	}

}
