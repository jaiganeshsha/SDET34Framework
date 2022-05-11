package com.crm.comcast.practise;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.comcast.genericUtility.FileUtility;
import com.crm.comcast.genericUtility.WebDriverUtility;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithotFillingMandatoryFieldScript {
	public static void main(String[] args) throws Throwable {
		//setting to launch chrome browser
		WebDriverUtility wLip=new WebDriverUtility();
	 FileUtility fLip=new FileUtility();
		WebDriverManager.chromedriver().setup();
		//launching chrome browser
	WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		wLip.waituntilpageload(driver);
		//LAUNCHING THE VTIGER APPLICATION
		String URL = fLip.getPropertyKeyValue("url");
		String USERNAME = fLip.getPropertyKeyValue("username");
		String PASSWORD = fLip.getPropertyKeyValue("password");
		String BROWSER = fLip.getPropertyKeyValue("browser");
		driver.get(URL);
		
		//login to application
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		
	
		
		//click on contacts link		
		WebElement orgs=driver.findElement(By.xpath("//a[.='Contacts'] "));
		
		wLip.waitForElementVisiblity(driver,orgs );
		orgs.click();
		
		//click on add contact
		
		driver.findElement(By.xpath(" //img[@title='Create Contact...']")).click();
		
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("");
		driver.findElement(By.xpath("(//input[@value='  Save  '])[1]")).click();
		wLip.alertaccept(driver);
		
		
		
		//Logout
		Thread.sleep(2000);
		WebElement acc=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		wLip.mouseover(driver, acc);
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();


		//close application
		driver.close();
	}

}
