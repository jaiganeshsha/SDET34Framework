
package com.crm.comcast.compaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.genericUtility.BaseClass;
import com.crm.comcast.genericUtility.Excelutility;
import com.crm.comcast.genericUtility.FileUtility;
import com.crm.comcast.genericUtility.WebDriverUtility;
import com.crm.comcast.pom_repoxitory.Compaign;
import com.crm.comcast.pom_repoxitory.ContactInfo;
import com.crm.comcast.pom_repoxitory.CreateCompaign;
import com.crm.comcast.pom_repoxitory.Homepage;

import io.github.bonigarcia.wdm.WebDriverManager;
//push to git
//pull to local
public class CompaignVitiger extends BaseClass{
	
	@Test(groups= {"regression"})
	public void compaign() throws Throwable {
		Homepage h=new Homepage(driver);
		h.mousehover();
		
		Compaign c=new Compaign(driver);
		c.getCompaignlnk().click();
		
		String data = eLip.getDtaFromExcel("mer", 1, 2);

		CreateCompaign cc=new CreateCompaign(driver);
		cc.getCreatecompaigntextlnk().sendKeys(data);
	cc.getSavebtn().click();
	
	ContactInfo ci=new ContactInfo(driver);
	String actual = ci.getContactvfy().getText();
	String expected="textyentra";
	 boolean flag = actual.contains("textyentra");
	Assert.assertTrue(flag,"it is not verify");
	// String actdata = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	//if(actdata.contains(data)) {
		System.out.println("it is verifyed");
	//}
	//else {
		//System.out.println("it not verifyed");
//	}
	 
	
	h.logout();
	
}
}
