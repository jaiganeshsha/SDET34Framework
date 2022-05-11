package com.crm.comcast.pom_repoxitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contact {
	
	
	public Contact(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
     @FindBy(xpath ="//img[@src='themes/softed/images/btnL3Add.gif']")
     private WebElement contact_link;

	public WebElement getContact_link() {
		return contact_link;
	}
}
