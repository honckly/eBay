package com.grab.ebay;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.TimeOutDuration;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import com.grab.ebay.PageElement;
public class BaseDefinition {
    private static AppiumDriverLocalService service;
    public static PageElement pageElement;  
    public static AndroidDriver<MobileElement> driver;
    private String deviceName = "Android 8.0";
    
    @Before
    public void setUp() throws Exception{
    		startServer();
    		androidCaps();
    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        if (service != null) {
            service.stop();
        }
    }
	public void startServer() {
	    service = AppiumDriverLocalService.buildService(
	    		new AppiumServiceBuilder()
	    		.withArgument(GeneralServerFlag.LOG_LEVEL, "info").
	    		withIPAddress("127.0.0.1")
	    		.usingPort(4723)
	    		);
	    service.start();
	
	    if (service == null || !service.isRunning()) {
	        throw new AppiumServerHasNotBeenStartedLocallyException(
	                "An appium server node is not started!");
	    }
	}
	public void androidCaps() throws Exception {

		File classpathRoot = new File(System.getProperty("user.dir"));
	  	File appDir = new File(classpathRoot, "app/");
	  	File app = new File(appDir.getCanonicalPath(), "eBay.apk");
	  	DesiredCapabilities capabilities = new DesiredCapabilities();
	  
	  	capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
	  	capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
//	    capabilities.setCapability("fullReset", true);
	    capabilities.setCapability("appWaitPackage", "com.ebay.mobile");
	    capabilities.setCapability("appWaitActivity", "com.ebay.mobile.activities.MainActivity");
	  	
	    pageElement = new PageElement();
	    driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		PageFactory.initElements(new AppiumFieldDecorator(driver, new TimeOutDuration(60, TimeUnit.SECONDS)), pageElement);
	}
	
	public ArrayList<String> firstNItemPrice(int num,List<AndroidElement> items,List<AndroidElement> prices){
		ArrayList<String> items_price = new ArrayList<String>();
		ArrayList<String> price = new ArrayList<String>();
		ArrayList<String> item = new ArrayList<String>();
		
		for(int i=0;i<num;i++){
			item.add(items.get(i).getText());
			price.add(prices.get(i).getText());
		}
		items_price.addAll(item);
		items_price.addAll(price);
	
		return items_price;
	}
 
}
