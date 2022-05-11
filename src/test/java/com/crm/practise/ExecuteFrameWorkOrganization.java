package com.crm.practise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.genericUtility.BaseClass;
import com.crm.comcast.genericUtility.Excelutility;
import com.crm.comcast.genericUtility.FileUtility;
import com.crm.comcast.genericUtility.JavaUtility;
import com.crm.comcast.genericUtility.WebDriverUtility;
import com.crm.comcast.pom_repoxitory.CreateOrganization;
import com.crm.comcast.pom_repoxitory.Homepage;
import com.crm.comcast.pom_repoxitory.Loginpage;
import com.crm.comcast.pom_repoxitory.Organization;
import com.crm.comcast.pom_repoxitory.OrganizationInfo;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExecuteFrameWorkOrganization extends BaseClass {
	@Test(groups= {"smoke"})
	public void frameWorkOraganization() throws Throwable {
	
		
		int randomnum = jLip.getRandomNumber();
		String data = eLip.getDtaFromExcel("mer", 1, 2)+randomnum;
		
		Loginpage lp=new Loginpage(driver);
		

		//click to organization
	Homepage h=new Homepage(driver);
		h.getOrganization().click();
		
		
		//navigate to organization
		Organization o=new Organization(driver);
		o.getCreateOrgLink().click();
		
		
		//navigate to create Organization
		
		CreateOrganization c=new CreateOrganization(driver);
		c.getOrgNameText().sendKeys(data);
		c.getSavebtn().click();
		
		//verify
		OrganizationInfo oi=new OrganizationInfo(driver);
		wLip.waitForElementVisiblity(driver,oi.getSuccesfulMsg() );
		
		//verify using assert
		String actual = oi.getSuccesfulMsg().getText();
		boolean flag = actual.contains("textyentra");
		Assert.assertTrue(flag,"its not verify");
		
			System.out.println("its verify succesfy");
		
		
		
		//navigate to signout
		h.logout();
	
	}

}

