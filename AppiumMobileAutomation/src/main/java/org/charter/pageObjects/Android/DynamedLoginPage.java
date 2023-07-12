package org.charter.pageObjects.Android;

import java.time.Duration;
import java.util.List;

import org.charter.utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DynamedLoginPage extends AndroidActions {
	AndroidDriver driver;

	public DynamedLoginPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(2000)), this);

	}

	@AndroidFindBy(id = "com.ebsco.dmp:id/btn_guest_access")
	private WebElement signInAsGuestBtn;

	@AndroidFindBy(id = "com.ebsco.dmp:id/button_0")
	private WebElement guestAccessGrantedOkBtn;

	@AndroidFindBy(id = "com.ebsco.dmp:id/layoutLiteInstall")
	private WebElement onlineOnly;

	@AndroidFindBy(id = "com.ebsco.dmp:id/buttonContinue")
	private WebElement continueBtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"  Search\"]")
	private WebElement searchBox;

	@AndroidFindBy(id = "com.ebsco.dmp:id/search_edittext")
	private WebElement searchBoxEdit;

	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Antibiotics for Streptococcal Pharyngitis\"]")
	private WebElement searchResultLnk;

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"OK\"]")
	private List<WebElement> warningOkBtnList;

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"OK\"]")
	private WebElement warningOkBtn;

	@AndroidFindBy(id = "com.ebsco.dmp:id/btn_install_complete_next")
	private WebElement installationNxtBtn;

	public void signInAsGuest() throws InterruptedException {
		int size;

		do {

			size = driver.findElements(By.xpath("//android.widget.Button[@content-desc=\"OK\"]")).size();

			if (size > 0) {
				warningOkBtn.click();
			}
		} while (size == 1);

		signInAsGuestBtn.click();
		Thread.sleep(3000);
	}

	public void guestAccessGranted() throws InterruptedException {

		int size;

		do {

			size = driver.findElements(By.xpath("//android.widget.Button[@content-desc=\"OK\"]")).size();
			Thread.sleep(2000);
			if (size > 0) {
				warningOkBtn.click();
			}
		} while (size == 1);

		Thread.sleep(3000);
	}

	public void signInMode() throws InterruptedException {
		onlineOnly.click();
		Thread.sleep(3000);
		continueBtn.click();
		Thread.sleep(3000);
	}

	public void installation() {
		waitForElementToAppear(installationNxtBtn, "text", "Next", 300);
		installationNxtBtn.click();
	}

	public void verifyAntibiotics() throws InterruptedException {
		searchBox.click();
		Thread.sleep(2000);
		searchBoxEdit.sendKeys("Antibiotics");
		Thread.sleep(2000);
		searchResultLnk.click();
		Thread.sleep(5000);
	}
}
