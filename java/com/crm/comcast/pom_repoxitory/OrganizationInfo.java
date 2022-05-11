package com.crm.comcast.pom_repoxitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfo {
	public OrganizationInfo(WebDriver driver) {
		PageFactory.initElements(driver, this); 
		
	}
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement succesfulMsg;
	
	
	public WebElement getSuccesfulMsg() {
		return succesfulMsg;
	} 
	

}
