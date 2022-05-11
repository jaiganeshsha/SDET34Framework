package com.crm.comcast.pom_repoxitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProduct {
	
	public CreateProduct(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
@FindBy(name ="productname")
private WebElement createproductlnk;


@FindBy(name ="button")
private WebElement savebtn;


public WebElement getCreateproductlnk() {
	return createproductlnk;
}


public WebElement getSavebtn() {
	return savebtn;
}

public void createnewproduct(String data1) {
	createproductlnk.sendKeys(data1);
	savebtn.click();
}
}
