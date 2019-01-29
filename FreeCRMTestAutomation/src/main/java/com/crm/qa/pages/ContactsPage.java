package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage  extends TestBase{

	
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	
	WebElement contactsLabel;
	
	
	@FindBy(xpath = "//a[contains(text(),'raj ganesh')]//parent::td//preceding-sibling::td[@class='datalistrow']// input[@name='contact_id']")
	WebElement usercheckbox;
	
	/*@FindBy(xpath ="//select[@name='title']")
	WebElement Title;
	*/
	@FindBy(id="first_name")
	WebElement Firstname;
	

	@FindBy(id="surname")
	WebElement Surname;
	
	
	@FindBy(xpath ="//input[@name=\"client_lookup\"]")
	WebElement Company;
	

	@FindBy(xpath ="//input[@type='submit' and @value='Save']")
	WebElement SaveButton;
	
	
	public ContactsPage() {
		
		PageFactory.initElements(driver, this);
		}
	
	public boolean verifycontatsLabelLink() {
		return contactsLabel.isDisplayed();
	}
	
	public void SelectUserCheckBox(String name) {
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]//parent::td"+
	"//preceding-sibling::td[@class='datalistrow']// input[@name='contact_id']")).click();
		
		
		
	}
	
	public void Createnewcontact(String title,String Fname,String SurName,String Comp) {
		Select select = new Select(driver.findElement(By.name("title")));
		
		select.selectByVisibleText(title);
		Firstname.sendKeys(Fname);
		Surname.sendKeys(SurName);
		Company.sendKeys(Comp);
		SaveButton.click();
		
		
	}
	
	
	
	
	
	

}
