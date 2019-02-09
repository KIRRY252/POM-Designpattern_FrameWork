package com.crm.qa.testcases;


import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginpageTest extends TestBase {

	LoginPage loginpage;
	HomePage homePage;
	
	public LoginpageTest(){
		super();
		
	}
	
	@BeforeMethod
	public void setup(){
		Intialization();
		
	 loginpage = new LoginPage();
		}
@Test(priority=1)
public void ValidatepageTitleTest(){

	String title= loginpage.ValidatetheLoginPageTitle();
	AssertJUnit.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
	}
@Test(priority=2)
public void validatecrmlogoTest(){
	boolean flag = loginpage.ValidatetheCRMLOGO();
	AssertJUnit.assertTrue(flag);
	
}
	@Test(priority=3)
	public void validateLoginTest(){
		homePage= loginpage.ValidateLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
		
	}
}
