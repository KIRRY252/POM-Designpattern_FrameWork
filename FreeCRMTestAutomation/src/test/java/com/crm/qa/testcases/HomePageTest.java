package com.crm.qa.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	HomePage homepage;
	LoginPage loginpage;
	TestUtil testutil;
	ContactsPage contactspage;
	
	
	
	public HomePageTest(){
		super();
		
	}
	
	@BeforeMethod
	public void setup() {
		
		Intialization();
		testutil = new TestUtil();
		 loginpage= new LoginPage();
		 homepage=  loginpage.ValidateLogin(prop.getProperty("username"), prop.getProperty("password"));
		 
		
	}
	
	@Test(priority =1)
	public void VerifyHomePageTitleTest() {
		String HomepageTitle = homepage.VerifyHomePageTitle();
		AssertJUnit.assertEquals(HomepageTitle, "CRMPRO", "Homepage Title not matched");
		
	}
	
	@Test(priority =2)
	public void VerifyUserlabelLink() {
		testutil.SwitchToFrames();
		AssertJUnit.assertTrue(homepage.VerifyusernameLabelname());
		
	}
	@Test(priority =3)
	public void VerifyContactsLinkTest() {
		testutil.SwitchToFrames();
		contactspage = homepage.ClickonContactsLinkPage();
	
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
		
	}
	
}
