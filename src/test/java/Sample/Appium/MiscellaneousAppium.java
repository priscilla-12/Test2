package Sample.Appium;

//import java.io.File;
import java.net.MalformedURLException;
//import java.net.URL;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.options.UiAutomator2Options;


public class MiscellaneousAppium extends BaseTest {

	@Test
	public void Miscellaneous() throws MalformedURLException
	{
		//App Package & App Activity
		//Activity->class
		Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
		driver.startActivity(activity);//open the app and bring the particular screen
        
//		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
//		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		
		//1.Device Rotation
		DeviceRotation landscape = new DeviceRotation(0, 0, 90);
		driver.rotate(landscape);
		
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		
		//grab the wifisettings text & place it String Var
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "WiFi settings");
		
		//2.Copy paste
		//In android we use Copy to clipboard
		driver.setClipboardText("Prisy"); //copy the text  //setClipboard->Method
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText()); //paste the text
		
		//driver.findElement(By.id("android:id/edit")).sendKeys("Prisy");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElement(By.id("android:id/button1")).click();
		
		//3.Android KeyEvents(back button,enter,home button)
		driver.pressKey(new KeyEvent(AndroidKey.BACK)); //press BackButton
		driver.pressKey(new KeyEvent(AndroidKey.HOME)); //Press HomeButton
		
		
	}
}
