package com.crm.comcast.pom_repoxitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericUtility.FileUtility;

public class Loginpage {
	
	
	
	
	@FindBy(name="user_name")
	private WebElement untbx;
	
	@FindBy(name="user_password")
	private WebElement pwdbx;
	
	@FindBy(id="submitbutton")
	private WebElement lgbtn;
	
	WebDriver driver;
	public  Loginpage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getUntbx() {
		return untbx;
	}

	public WebElement getPwdbx() {
		return pwdbx;
	}

	public WebElement getLgbtn() {
		
		return lgbtn;
	}
	
	
	public void loginToApp(String username, String password) {
		untbx.sendKeys(username);
		pwdbx.sendKeys(password);
		lgbtn.click();
	}
	

	
		
	


}
