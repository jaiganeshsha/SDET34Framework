package com.crm.comcast.pom_repoxitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericUtility.WebDriverUtility;

public class Homepage extends WebDriverUtility {
	
	
	WebDriver driver;
	public Homepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(linkText = "Organizations")
private WebElement organization;


  @FindBy(linkText = "Contacts")
  private WebElement contact;
  
  
  @FindBy(linkText = "Products")
  private WebElement product;
  
  
  @FindBy(xpath = "//img[@src='themes/softed/images/menuDnArrow.gif']")
  private WebElement morelink;
  
  @FindBy(name ="Campaigns")
  private WebElement campaignslink;
  
  
  @FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
  private WebElement moveto;



@FindBy(xpath = "//a[.='Sign Out']")
  private WebElement signout;


public WebDriver getDriver() {
	return driver;
}


public WebElement getOrganization() {
	return organization;
}


public WebElement getContact() {
	return contact;
}


public WebElement getProduct() {
	return product;
}


public WebElement getMorelink() {
	return morelink;
}


public WebElement getCampaignslink() {
	return campaignslink;
}


public WebElement getSignout() {
	return signout;
}
public WebElement getMoveto() {
	return moveto;
}


public void logout() {
	
		Actions a=new Actions(driver);
		a.moveToElement(moveto).perform();
		getSignout().click();
}
		
public void mousehover() {
	mouseover(driver, morelink);
	waitForElementVisiblity(driver,campaignslink);
	campaignslink.click();
}
		
		
		
		
		
		
		
		
	
		
		
		
		
	
		
	}




  

