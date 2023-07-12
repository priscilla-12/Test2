package Sample.Appium;
import java.io.File;
//import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
//import io.appium.java_client.service.local.AppiumDriverLocalService;
//import io.appium.java_client.service.local.AppiumServiceBuilder;
//import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.service.local.flags.ServerArgument;

public class BaseTest {
	
	  public AndroidDriver driver;
	  	
	  public AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException
	{
		//service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\priscilla.d\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
		//.withIPAddress("127.0.0.1").usingPort(4723).build();
         //service.start();
		
         service = new AppiumServiceBuilder()        
			//.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))        
			.withAppiumJS(new File("C:\\Users\\priscilla.d\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))        
			.withIPAddress("127.0.0.1")        
			.withArgument(GeneralServerFlag.SESSION_OVERRIDE)        
			//.withArgument(GeneralServerFlag.BASEPATH,"/wd/hub/")     
			.usingPort(4723).withLogFile(new 
			File("C:\\Users\\priscilla.d\\Desktop\\AppiumServerLogs.txt")).withTimeout(Duration.ofSeconds(300)).build();
			service.start();
		//AndroidDriver,IOS Driver
		
		//Actual automation
		//Xpath,id,accessibility id,class name,android UIAutomator
		
		
		UiAutomator2Options options = new UiAutomator2Options();
		//options.setDeviceName("Priscilla");  //Emulator
		options.setDeviceName("Android Device");  //real device
		options.setChromedriverExecutable("C:\\Users\\priscilla.d\\Documents\\chromedriver.exe");
		
	     options.setApp("C://Users//priscilla.d//eclipse-workspace//Appium//src//test//java//resources//ApiDemos-debug.apk");
		
	  //  options.setApp("C://Users//priscilla.d//eclipse-workspace//Appium//src//test//java//resources//General-Store.apk");
	   // driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
	    driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		}
	
	     public void longPressAction(WebElement ele)
	     {
	    	 ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
					    "elementId",((RemoteWebElement)ele).getId(),"duration",2000));
	     //Thread.sleep(2000);
	
	     }
	     
	     
	   
	   //If dont know the Target use this Script
	   //ScrollGesture=Event  //left,top,height..=Keyvalues
	   //This command is for appium  //Scroll until End
//	   		public void scrollToEndAction()
//	   		{
//	   		boolean canScrollMore;
//	   		do {
//	   		        canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
//	   			    "left", 100, "top", 100, "width", 200, "height", 200,
//	   			    "direction", "down",
//	   			    "percent", 3.0
//	   			));
//	   		}while(canScrollMore);
//	   		}
	   		
	     //left->String Direction  //ele,direction->parameter
	     public void swipeAction(WebElement ele,String direction)
	     {
	    	 ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
	  			   "elementId",((RemoteWebElement)ele).getId(),
	  			    "direction", "left",
	  			    "percent", 0.75
	  			));
	     }
	   		
	   	 public Double getFormattedAmount(String amount)
	   	 {
	   		Double price = Double.parseDouble(amount.substring(1));
	   		return price;
	   	 }
	  
	   	 
	   	 
	   	@AfterClass
	    public void tearDown() {
	    driver.quit();
	    service.close();
	    }
}
