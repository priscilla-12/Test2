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

public class MobileBrowserBaseTest {
	
	  public AndroidDriver driver;
	  
	  public AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException
	{
		
		
         service = new AppiumServiceBuilder()        
			//.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))        
			.withAppiumJS(new File("C:\\Users\\priscilla.d\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))        
			.withIPAddress("127.0.0.1")        
			.withArgument(GeneralServerFlag.SESSION_OVERRIDE)   
			//.withArgument(GeneralServerFlag.BASEPATH,"/wd/hub/")     
			.usingPort(4723).withLogFile(new 
			File("C:\\Users\\priscilla.d\\Desktop\\AppiumServerLogs.txt")).withTimeout(Duration.ofSeconds(300)).build();
			service.start();
		
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Priscilla");
		options.setChromedriverExecutable("C:\\Users\\priscilla.d\\Documents\\chromedriver.exe");
		options.setCapability("browserName", "Chrome");
		//driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
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
