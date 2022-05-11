package com.crm.comcast.pom_repoxitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Products {
	
	public Products(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement productestlnk;
	
	
	@FindBy(name = "search_text")
	private WebElement productwindowtextlnk;
	
	@FindBy(name = "search")
	private WebElement searechbtn;
	
	@FindBy(xpath = "//tr[@bgcolor='bgcolor']")
	private WebElement clicksearchtextlnk;
	
	public WebElement getProductestlnk() {
		return productestlnk;
	}

	public WebElement getProductwindowtextlnk() {
		return productwindowtextlnk;
	}

	public WebElement getSearechbtn() {
		return searechbtn;
	}

	public WebElement getClicksearchtextlnk() {
		return clicksearchtextlnk;
	}
	
	

}
