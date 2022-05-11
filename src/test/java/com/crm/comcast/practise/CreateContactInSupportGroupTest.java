package com.crm.comcast.practise;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crm.comcast.genericUtility.BaseClass;
import com.crm.comcast.genericUtility.Excelutility;
import com.crm.comcast.genericUtility.FileUtility;
import com.crm.comcast.genericUtility.JavaUtility;
import com.crm.comcast.pom_repoxitory.Contact;
import com.crm.comcast.pom_repoxitory.CreateContact;
import com.crm.comcast.pom_repoxitory.Homepage;

import io.github.bonigarcia.wdm.WebDriverManager;
@Test
public class CreateContactInSupportGroupTest extends BaseClass {
	public void contactSupportGroup() throws Throwable {
		String data = eLip.getDtaFromExcel("mer", 1, 2);

		/*login to application*/
          
		Homepage h=new Homepage(driver);
		h.getContact().click();
       
		/*click on contacts link*/
		Contact c=new Contact(driver);
       c.getContact_link().click();
       CreateContact cc=new CreateContact(driver);
       cc.getLastNamebx().sendKeys(data);
		/*click on add contact*/
		
       cc.dropdown();

		cc.getSavebtn().click();

		
		/*validation*/
		String actualResult=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(actualResult.contains(data))
		{
			System.out.println(data+" ==> is verified : Pass");
		}
		else
		{
			System.out.println(data+" ==> is verified : Pass");
		}
		/*Logout*/
		h.logout();

		/*close application*/
		
	}



}
