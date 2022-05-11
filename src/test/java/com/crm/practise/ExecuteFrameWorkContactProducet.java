package com.crm.practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.comcast.genericUtility.BaseClass;
import com.crm.comcast.genericUtility.Excelutility;
import com.crm.comcast.genericUtility.FileUtility;
import com.crm.comcast.genericUtility.JavaUtility;
import com.crm.comcast.genericUtility.WebDriverUtility;
import com.crm.comcast.pom_repoxitory.Compaign;
import com.crm.comcast.pom_repoxitory.CreateCompaign;
import com.crm.comcast.pom_repoxitory.CreateProduct;
import com.crm.comcast.pom_repoxitory.Homepage;
import com.crm.comcast.pom_repoxitory.Loginpage;
import com.crm.comcast.pom_repoxitory.Products;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExecuteFrameWorkContactProducet  extends BaseClass{
	@Test
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
	

}
