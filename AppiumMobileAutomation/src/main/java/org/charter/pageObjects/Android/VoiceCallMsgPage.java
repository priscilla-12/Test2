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

public class VoiceCallMsgPage extends AndroidActions{
	
	AndroidDriver driver;
	
	public VoiceCallMsgPage(AndroidDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(2000)), this);
		
	}
	
	@AndroidFindBy(xpath ="//android.widget.EditText[@text = 'Search contacts & places']")
	private WebElement searchConBttn;
	
	@AndroidFindBy(xpath ="//android.widget.ImageView[@index = 2]")
	private WebElement callBttn;
	
	
	@AndroidFindBy(xpath ="(//android.widget.ImageView[@content-desc=\"Phone Account Icon\"])[1]")
	private WebElement simbttn;
	
	@AndroidFindBy(id ="com.google.android.dialer:id/contactgrid_bottom_timer")
	private WebElement callStartLb;
	
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
	

	@AndroidFindBy(id = "com.motorola.launcher3:id/workspace")
	private WebElement swipeScreen;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Hang up\"]")
	private WebElement hangUpBttn;
	
	public void StartCall() {
		searchConBttn.click();
		searchConBttn.sendKeys("9391421267");
		//driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		callBttn.click();
		simbttn.click();
		
		if(callStartLb.isDisplayed()) {
			driver.pressKey(new KeyEvent(AndroidKey.HOME));
		}
		else {
			System.out.println("Wait to Start Call");
		}
	}
	
	public void startMsg() {
		startChat.click();
		textEdit.click();
		keypad.click();
		textEdit.sendKeys("9391421267");
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
	
	public void swipeScreen() {
		swipeDown(swipeScreen,"down");
		hangUpBttn.click();
	}
	}


	
	


