package org.charter.pageObjects.Android;


import java.time.Duration;
import java.util.List;

import org.charter.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BrowsingPage extends AndroidActions{
	
	AndroidDriver driver;
	
	public BrowsingPage(AndroidDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(2000)), this);
		
	}
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Folder: Google, 4 or more items\"]")
	private WebElement browseApp;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Google\"]")
	private WebElement GoogleApp;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Search…\"]/android.widget.TextView")
	private WebElement SearchText;
	
	@AndroidFindBy(id = "com.google.android.googlequicksearchbox:id/googleapp_search_box")
	private WebElement SearchBox;
	
	@AndroidFindBy(accessibility = "Start chat")
	private WebElement startChat;
	
	@AndroidFindBy(xpath = "//android.widget.MultiAutoCompleteTextView[@text = 'Type a name, phone number, or email']")
	private WebElement textEdit;
	
	@AndroidFindBy(id = "com.google.android.apps.messaging:id/compose_message_text")
	private WebElement composeMsg;
	

	@AndroidFindBy(id = "com.google.android.apps.messaging:id/send_message_button_icon")
	private WebElement sendMsg;
	
	@AndroidFindBy(accessibility = "Switch between entering text and numbers")
	private WebElement keypad;
	
	
	
	@AndroidFindBy(id = "com.google.android.apps.messaging:id/message_text")
	private WebElement logPressEle;
	
	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"More conversation options\"]")
	private WebElement convrsOption;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'View details']")
	private WebElement viewDetails;
	
	@AndroidFindBy(id = "com.google.android.apps.messaging:id/message")
	private WebElement msgDetail;
	

	@AndroidFindBy(id = "com.google.android.apps.messaging:id/message_status")
	private WebElement msgStatus;
	
	
	public void browsingTest() throws InterruptedException {
		
		browseApp.click();
		GoogleApp.click();
		SearchText.click();
		SearchBox.sendKeys("Mobile Testing");
		driver.hideKeyboard();
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
	
	
}
	public void sendMessge() {
		startChat.click();
		textEdit.click();
		keypad.click();
		textEdit.sendKeys("7358307962");
		driver.hideKeyboard();
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		composeMsg.click();
		composeMsg.sendKeys("Hi");
		sendMsg.click();
		driver.hideKeyboard();

		if(msgStatus.isDisplayed()) {
			longPress(logPressEle);
			convrsOption.click();
			viewDetails.click();
			if(msgDetail.isDisplayed()) {
				String msgViewDetail = msgDetail.getText();
				System.out.println("Message Detail is displayed"+msgViewDetail);
			}
			else
			{
				System.out.println("Message Detail not be displayed");
			}
			System.out.println("sms recived by user");
		}
		else
		{
			System.out.println("sms not recived by user");
		}
		
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
	}
	}
	
	



