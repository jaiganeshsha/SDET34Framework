package com.crm.comcast.pom_repoxitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCompaign {
	
	public CreateCompaign(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(name = "campaignname")
	private WebElement createcompaigntextlnk;
	
	@FindBy(xpath = "//img[@title='Select']")
	private WebElement compaignwindowlnk;
	
	@FindBy(name = "button")
	private WebElement savebtn;

	public WebElement getCreatecompaigntextlnk() {
		return createcompaigntextlnk;
	}

	public WebElement getCompaignwindowlnk() {
		return compaignwindowlnk;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

}
