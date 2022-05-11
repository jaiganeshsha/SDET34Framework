package com.crm.practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
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

import com.crm.comcast.genericUtility.Excelutility;
import com.crm.comcast.genericUtility.FileUtility;
import com.crm.comcast.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CompaignProductWindow {
	public static void main(String[] args) throws Throwable {
Excelutility eLip=new Excelutility();
FileUtility fLip=new FileUtility();
WebDriverUtility wLip=new WebDriverUtility();
		
		Random random=new Random();
		  int intrandom = random.nextInt(1000);
		  
		String data = eLip.getDtaFromExcel("mer", 1, 2)+intrandom;
	  
	String URL = fLip.getPropertyKeyValue("url");
	String USERNAME = fLip.getPropertyKeyValue("username");
	String PASSWORD = fLip.getPropertyKeyValue("password");
	String BROWSER = fLip.getPropertyKeyValue("browser");
	  
	  
	WebDriverManager.chromiumdriver().setup();
	  WebDriver driver=null;
	  if(BROWSER.equals("chrome")) {
		  driver=new ChromeDriver();
	  }
	  else if(BROWSER.equals("firefox")) {
		  driver=new FirefoxDriver();
	  }
	  else {
		  driver=new ChromeDriver();
	  }
	  
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 
		
		//Launch the browser
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		WebElement exe = driver.findElement(By.xpath("(//td[@align='center'])[13]"));
		
		Actions act = new Actions(driver);
		
		act.moveToElement(exe).perform();
		driver.findElement(By.name("Campaigns")).click();
		driver.findElement(By.xpath("(//img[@title='Create Campaign...'])")).click();
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(data);
		driver.findElement(By.name("button")).click();
		Set<String> set1=driver.getWindowHandles();
	Iterator<String> it1 = set1.iterator();
	
	
	while(it1.hasNext()) {
		String Cid = it1.next();
		driver.switchTo().window(Cid);
		String ja = driver.getTitle();
		if(ja.contains("Products&action")) {
			break;
		}
	}
	driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(data);
	driver.findElement(By.xpath("//input[@name='search']")).click();
	driver.findElement(By.xpath("//a[.='"+data+"']")).click();
	wLip.switchToWindow(driver,"campaigns&action");
	
	
	driver.findElement( By.name("button")).click();
	
	
	
	WebElement j = driver.findElement(By.xpath("(//td[@valign='bottom'])[2]"));
	wLip.mouseover(driver, j);
	driver.findElement(By.linkText("Sign Out")).click();
	
	}

}
