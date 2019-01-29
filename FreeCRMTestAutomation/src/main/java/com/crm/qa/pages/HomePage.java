package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	
	@FindBy(xpath = "//td[contains(text(),'User: Rav Kir')]")
	WebElement usernameLabel;
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")	
	WebElement ContactsLink;
	
	
	@FindBy(xpath = "//a[contains(text(),'Deals')]")	
	WebElement DealsLink;
	
	@FindBy(xpath = "//a[contains(text(),'Tasks')]")	
	WebElement TasksLink;
	
	@FindBy(xpath = "//a[@title='New Contact']")	
	WebElement NewContactLink;
	
	
	

public HomePage() {

	PageFactory.initElements(driver, this);
}


public String VerifyHomePageTitle() {
	return driver.getTitle();
}

public boolean VerifyusernameLabelname() {
	return usernameLabel.isDisplayed();
}


public ContactsPage ClickonContactsLinkPage() {
	
	 ContactsLink.click();
	 
	 return new ContactsPage();
}

public DealsPage ClickonDealsLinkPage() {
	DealsLink.click();
	return new DealsPage();
	
}
public TasksPage ClickonTasksLinkPage() {
	TasksLink.click();
	return new TasksPage();
}

public void HoveroncontactsLink() {
	
	Actions Act= new Actions(driver);
	Act.moveToElement(ContactsLink).build().perform();	
	 NewContactLink.click();
}


}