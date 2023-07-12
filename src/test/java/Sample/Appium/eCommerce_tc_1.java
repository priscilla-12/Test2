package Sample.Appium;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerce_tc_1 extends BaseTest{

	@Test
	public void FillForm() throws InterruptedException
	{
	  //driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Priscilla");
	  driver.hideKeyboard();
	  //Using text attribute
	  driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
	  //Select the dropdown and scroll
	  driver.findElement(By.id("android:id/text1")).click();
	  driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));"));
	  driver.findElement(By.xpath("//android.widget.TextView[@text='India']")).click();
	  driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	  Thread.sleep(2000);
	  //Handling Toast Message and store it
	  String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
	  //put Asserstion
	  Assert.assertEquals(toastMessage,"Please enter your name");
	}
}
