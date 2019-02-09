package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	
	//pagefactory -OR first write all the objects present on the login page like username password, loginbttn.
	
	
	
	
@FindBy(name = "username")
@CacheLookup
WebElement username;
	
@FindBy(name="password")
@CacheLookup
WebElement password;

@FindBy(xpath ="//input[@type='submit']")
@CacheLookup
WebElement LoginButton;
	

@FindBy(xpath = "//a[@href='https://www.freecrm.com/register/']")
@CacheLookup
WebElement SignupButton;

@FindBy(xpath ="//img[@class = 'img-responsive'][@alt='free crm logo']")
@CacheLookup
WebElement CRMlogo_img;
//Initialising the page objects
public LoginPage(){
	
	PageFactory.initElements(driver, this);
}

	//Actions

public String ValidatetheLoginPageTitle(){
	return driver.getTitle();
		
}
public boolean ValidatetheCRMLOGO(){
	return CRMlogo_img.isDisplayed();
}

public HomePage ValidateLogin(String un,String pwd){
		
	username.sendKeys(un);
	password.sendKeys(pwd);
	LoginButton.click();
	
	return new HomePage();
		
		
		
	}

	
	
	
	
	
}

