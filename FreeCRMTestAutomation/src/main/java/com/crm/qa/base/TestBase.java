package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public static FileInputStream ip;
	public static EventFiringWebDriver E_driver;
	static WebEventListener Event_Driver;

	
	public TestBase(){
		try{
		 prop= new Properties();
		
		 ip = new FileInputStream("C:\\Users\\kirri\\workspace\\FreeCRMTestAutomation\\src\\main\\java\\com\\crm"
		 +"\\qa\\config\\config.properties");
			
			prop.load(ip);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		
	}}


	public static void Intialization(){
	
		
	String BrowserName= prop.getProperty("browser");	
		if(BrowserName.equals("chrome")){
			
	System.setProperty("webdriver.chrome.driver", "C:\\eclipse-SDK-4.2.1-win32-x86_64\\browser drivers\\chromedriver.exe");
			
	 driver = new ChromeDriver();
	
			
		}
		
		else if(BrowserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "C:\\eclipse-SDK-4.2.1-win32-x86_64\\browser drivers\\geckodriver.exe");
			driver = new FirefoxDriver();	
		}
		
		
		E_driver=  new EventFiringWebDriver(driver);
		Event_Driver = new WebEventListener();
		E_driver.register(Event_Driver);
		driver= E_driver;
		
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_WAIT_TIME, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		
		
	}
}
	
	
	
	
	

