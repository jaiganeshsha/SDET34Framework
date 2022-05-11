package com.crm.comcast.practise;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.comcast.genericUtility.BaseClass;
import com.crm.comcast.genericUtility.FileUtility;
import com.crm.comcast.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactandhandledropdownScript extends BaseClass {
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
