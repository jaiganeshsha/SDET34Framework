package com.crm.comcast.pom_repoxitory;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Compaign {
	
	public Compaign(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
   @FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']") 
   private WebElement compaignlnk;
//git
public WebElement getCompaignlnk() {
	return compaignlnk;
}
   
   
   
}
