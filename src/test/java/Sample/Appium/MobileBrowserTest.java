package Sample.Appium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileBrowserTest extends MobileBrowserBaseTest {
	
	@Test
	public void browserTest() throws InterruptedException
	{	 
	     driver.get("https://rahulshettyacademy.com/angularAppdemo/");
	     driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
	     driver.findElement(By.cssSelector("a[routerlink*='products']")).click();
	     //scroll in mobile browser
	     ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)", "");
	     String text = driver.findElement(By.cssSelector("a[href*='products/3']")).getText();
	     Assert.assertEquals(text, "Devops");
	}

}
