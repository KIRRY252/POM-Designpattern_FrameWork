package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	HomePage homepage;
	LoginPage loginpage;
	TestUtil testutil;
	ContactsPage contactspage;
	String sheetName = "ContactsData";
	
	
	
	public ContactsPageTest(){
		super();
		
	}

	
	@BeforeMethod
	public void setup() {
		
		Intialization();
		testutil = new TestUtil();
		 loginpage= new LoginPage();
		 homepage=  loginpage.ValidateLogin(prop.getProperty("username"), prop.getProperty("password"));
		 testutil.SwitchToFrames();
		 contactspage = homepage.ClickonContactsLinkPage();
		 
	}
	@Test(priority=2)
	
	public void validateContactLinklabelTest() {
		testutil.SwitchToFrames();
		Assert.assertTrue(contactspage.verifycontatsLabelLink(),"Contacts link is missing");
		
	}
	
	@Test(priority=1)
	public void validateusercheckboxTest() {
		contactspage.SelectUserCheckBox("raj ganesh");
		
		
	}
	
	@SuppressWarnings("static-access")
	@DataProvider
	public Object[][] getTestDataCRM() {
		Object[][] data = testutil.getTestData(sheetName);
		return data;
		
		
	}
	
	
	@Test(priority= 4,dataProvider = "getTestDataCRM")
	public void ValidateCreatenewcontact(String title,String Fname,String SurName,String Comp) {
		homepage.HoveroncontactsLink();
		//contactspage.Createnewcontact("Mr.", "sand", "GUN", "Micro");
		contactspage.Createnewcontact(title, Fname, SurName, Comp);
		
		
	}
	@AfterMethod
	public void TearDown() {
		driver.quit();
		
	}
}

			
	
