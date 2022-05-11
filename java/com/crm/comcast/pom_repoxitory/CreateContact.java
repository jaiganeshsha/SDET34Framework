package com.crm.comcast.pom_repoxitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericUtility.WebDriverUtility;

public class CreateContact extends WebDriverUtility {
	WebDriver driver;
	public CreateContact(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="lastname")
	private WebElement lastNamebx;
	
	
	@FindBy(name="button")
	private WebElement savebtn;
	
	@FindBy(name="assigntype")
	private WebElement group_link;
	
	@FindBy(name = "assigned_group_id")
	private WebElement selectbox;


	public WebElement getLastNamebx() {
		return lastNamebx;
	}


	public WebElement getSavebtn() {
		return savebtn;
	}


	public WebElement getGroup_link() {
		return group_link;
	}


	public WebElement getSelectbox() {
		return selectbox;
	}
	public void dropdown() throws InterruptedException {
		WebDriverUtility wLip=new WebDriverUtility();
		group_link.click();
		Thread.sleep(3000);
		wLip.select(selectbox, 2);
		
	}

}
