package org.charter.pageObjects.Android;


import java.time.Duration;
import java.util.List;

import org.charter.utils.AndroidActions;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class TextMessagePage extends AndroidActions{
	
	AndroidDriver driver;
	
	public TextMessagePage(AndroidDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(2000)), this);
		
	}
	
	
	
	@AndroidFindBy(xpath="//android.support.v7.widget.RecyclerView[@content-desc=\"Conversation list\"]/android.view.ViewGroup")
	private List<WebElement> listMsg;	
	
	
	@AndroidFindBy(xpath="//android.support.v7.widget.RecyclerView[@content-desc=\"Conversation list\"]/android.view.ViewGroup[1]/android.widget.RelativeLayout/android.widget.TextView[1]")
	private WebElement firstMesg;	
	

	@AndroidFindBy(xpath="//android.widget.Button[@content-desc=\"Delete\"]")
	private WebElement deleteLbl;	
	
	@AndroidFindBy(id="android:id/button1")
	private WebElement deleteBttn;	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text = 'Priscilla']")
	private WebElement conversationName;	
	
	public void deleteMsg() throws InterruptedException {
		
		
		int MesgSize =  listMsg.size();
		
		System.out.println(MesgSize);
	
		longPress(listMsg.get(0));
		
		for(int i=1;i<2;i++) {
			
				//longPress(listMsg.get(i));
				listMsg.get(i).click();
				
				Thread.sleep(2000);			
		}
		String conveName = firstMesg.getText();
		System.out.println(conveName);
		deleteLbl.click();
		deleteBttn.click();
		Thread.sleep(2000);		
		String newMsg = firstMesg.getText();
		System.out.println(newMsg);
		if(!conveName.equalsIgnoreCase(newMsg)) {
				System.out.println("selected message already deleted");

			}else
			{
				System.out.println(" message is not deleted");
			}
	}
}
	
	
	

	
	


