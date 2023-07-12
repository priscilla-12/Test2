package Sample.Appium;

//import java.io.File;
import java.net.MalformedURLException;
//import java.net.URL;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.options.UiAutomator2Options;


public class AppiumBasics extends BaseTest {

	@Test
	public void WifiSettingsName() throws MalformedURLException
	{
		
        
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		
		//grab the wifisettings text & place it String Var
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "WiFi settings");
		
		driver.findElement(By.id("android:id/edit")).sendKeys("Prisy");
		driver.findElement(By.id("android:id/button1")).click();
		//set wifi name	
		
	}
}
