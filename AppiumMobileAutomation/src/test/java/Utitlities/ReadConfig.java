package Utitlities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	static Properties prop;
	
	public ReadConfig(){
		File file = new File("C:\\Appium\\MobileAutomationMyPractice\\src\\test\\java\\Configuration\\config.properties");
		try {
			FileInputStream fip = new FileInputStream(file);
			prop = new Properties();
			prop.load(fip);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will read the Property values form Properties file and return it.
	 * @param propName
	 * @return Property Value
	 */
	public String readPropertyFile(String propName ) {
		return prop.getProperty(propName);
		
	}
	
}
