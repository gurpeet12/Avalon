package com.avlon.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestBase {

	public static Properties prop;
	public static AppiumDriver<MobileElement> driver;
	
public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/avlon/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
}

	
public static void initialization() {
	try
	{
	 DesiredCapabilities dCap = new DesiredCapabilities();
	 		
	    dCap.setCapability("deviceName", "emulator-5554");
		dCap.setCapability("platformName", "ANDROID");
		dCap.setCapability("app","C:/Users/sumee/OneDrive/Desktop/app-release-15.apk");
		dCap.setCapability("appPackage", "com.avalonlabs.avalonvoices");
		dCap.setCapability("appActivity", ".MainActivity");
		dCap.setCapability("fullContextList", true);
		dCap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		
		
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		
		driver = new AppiumDriver<MobileElement>(url, dCap);
		
		

	}
	catch(Exception exp)
	{
		System.out.println("Cause of exception is :"+ exp.getCause());
		System.out.println("Message is :"+ exp.getMessage());			
	}
	
}
}
