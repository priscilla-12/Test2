package Sample.Appium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerce_tc_2 extends BaseTest{

	@Test
	public void FillForm() throws InterruptedException
	{
	  driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Priscilla");
	  driver.hideKeyboard();
	  //Using text attribute
	  driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
	  //Select the dropdown and scroll
	  driver.findElement(By.id("android:id/text1")).click();
	  driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));"));
	  driver.findElement(By.xpath("//android.widget.TextView[@text='India']")).click();
	  driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	 //Thread.sleep(2000);
	  //Handling Toast Message and store it
//	  String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
//	  //put Asserstion
//	  Assert.assertEquals(toastMessage,"Please enter your name");
	  driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
	  
	  //Get All the products names  //size take into one var
	int productCount =  driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
	//iterate every product..
	for(int i=0;i<productCount;i++)
	{
		String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
		if(productName.equalsIgnoreCase("Jordan 6 Rings"))
		{
			driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
		}
	}
	  driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	  //Thread.sleep(2000);
	  
	  //Using WebdriverWait Class This class is wait until the toolbar Cart
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	  wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text", "Cart"));
	  
	 String lastPageProduct =  driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
	 Assert.assertEquals(lastPageProduct, "Jordan 6 Rings");
	  
	  
	}
}
