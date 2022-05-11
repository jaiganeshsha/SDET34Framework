package com.crm.comcast.pom_repoxitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganization {
	public CreateOrganization(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name ="accountname")
	private WebElement orgNameText;
	
	@FindBy(name="button")
	private WebElement savebtn;
	
	
	public WebElement getOrgNameText() {
		return orgNameText;
	}


	public WebElement getSavebtn() {
		return savebtn;
	}
	public void createOrg(String orgname) {
		orgNameText.sendKeys(orgname);
		savebtn.click();
	}

}
