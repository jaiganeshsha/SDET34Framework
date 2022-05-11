package com.crm.comcast.pom_repoxitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfo {
	
	public ContactInfo(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
      @FindBy(xpath ="//span[@class='dvHeaderText']")
      private WebElement contactvfy;

	public WebElement getContactvfy() {
		return contactvfy;
	}
      
      
      
}
