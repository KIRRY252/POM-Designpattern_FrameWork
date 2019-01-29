package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	
	//pagefactory -OR first write all the objects present on the login page like username password, loginbttn.
	
	
	
	
@FindBy(name = "username")
WebElement username;
	
@FindBy(name="password")
WebElement password;

@FindBy(xpath ="//input[@type='submit']")
WebElement LoginButton;
	

@FindBy(xpath = "//a[@href='https://www.freecrm.com/register/']")
WebElement SignupButton;

@FindBy(xpath ="//img[contains(@class,'img-responsive']")
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

