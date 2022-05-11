package com.crm.comcast.testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.comcast.genericUtility.BaseClass;
import com.crm.comcast.pom_repoxitory.Compaign;
import com.crm.comcast.pom_repoxitory.CreateCompaign;
import com.crm.comcast.pom_repoxitory.CreateProduct;
import com.crm.comcast.pom_repoxitory.Homepage;
import com.crm.comcast.pom_repoxitory.Loginpage;
import com.crm.comcast.pom_repoxitory.Products;

public class Contactscript extends BaseClass {
	@Test(groups= {"smoke"})
	public void frameworkContactProduct() throws Throwable {

		
		int randomnum = jLip.getRandomNumber();
		String data = eLip.getDtaFromExcel("mer", 1, 2)+randomnum;
		String data1 = eLip.getDtaFromExcel("mer", 1, 1)+randomnum;
		
		Loginpage lp=new Loginpage(driver);
		
		Homepage h=new Homepage(driver);
		h.getProduct().click();
		
		Products p=new Products(driver);
		p.getProductestlnk().click();
		
		
		CreateProduct cp=new CreateProduct(driver);
		cp.createnewproduct(data1);
		
		
		wLip.waitForpage(driver,"DetailView&module=Products");
		//click on  compaign module
		
		h.mousehover();
		
		
		//click on compaign + symbols
		Compaign c=new Compaign(driver);
		c.getCompaignlnk().click();
		
		//navigate to create compaign page
		CreateCompaign cc=new CreateCompaign(driver);
		cc.getCreatecompaigntextlnk().sendKeys(data);
		cc.getCompaignwindowlnk().click();
		
		
		wLip.switchToWindow(driver, "Products&action");
		
		p.getProductwindowtextlnk().sendKeys(data1);
		p.getSearechbtn().click();
		driver.findElement(By.xpath("//a[text()='"+data1+"']")).click();
		
		
		wLip.switchToWindow(driver, "Campaigns&action");
		cc.getSavebtn().click();
		
		
		h.logout();
		h.getSignout().click();
	}
	
	
	@Test(groups= {"regression"})
	public void contactHandleDropDown() throws Throwable {
		//setting to launch chrome browser
	

	
		//click on contacts link
		
		WebElement contact=driver.findElement(By.xpath("//a[.='Contacts'] "));
		wLip.waitForElementVisiblity(driver, contact);
		
		
		contact.click();

		//click on add contact

		driver.findElement(By.xpath(" //img[@title='Create Contact...']")).click();

		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("jai");


		driver.findElement(By.xpath("//input[@value='T']")).click();

		WebElement seldd = driver.findElement(By.xpath("//select[@name='assigned_group_id']"));
		Select sel=new Select(seldd);
		sel.selectByValue("4");
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();

		//Logout
		Thread.sleep(2000);
		WebElement acc=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));

		Thread.sleep(2000);
		wLip.mouseover(driver, acc);
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();

		//close application
		driver.close();

	}

}


