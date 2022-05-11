package com.crm.practise;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.comcast.genericUtility.Excelutility;
import com.crm.comcast.genericUtility.FileUtility;
import com.crm.comcast.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class cvtiger {

	@Test(groups= {"regression"})
	public void compaign() throws Throwable {
		Excelutility eLip=new Excelutility();
		FileUtility fLip=new FileUtility();
		WebDriverUtility wLip=new WebDriverUtility();
		
			String data = eLip.getDtaFromExcel("mer", 1, 2);

	     String URL = fLip.getPropertyKeyValue("url");
	    String USERNAME = fLip.getPropertyKeyValue("username");
	     String PASSWORD = fLip.getPropertyKeyValue("password");
	    String BROWSER = fLip.getPropertyKeyValue("browser");
	  
	  Random random=new Random();
	  int intrandom = random.nextInt(1000);
	  
	  WebDriverManager.chromedriver().setup();
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
	
    wLip.mouseover(driver, exe);
	driver.findElement(By.name("Campaigns")).click();
	driver.findElement(By.xpath("(//img[@title='Create Campaign...'])")).click();
	driver.findElement(By.name("campaignname")).sendKeys(data);
	driver.findElement(By.name("button")).click();
	 String actdata = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(actdata.contains(data)) {
		System.out.println("it is verifyed");
	}
	else {
		System.out.println("it not verifyed");
	}
	 
	
	WebElement j = driver.findElement(By.xpath("(//td[@valign='bottom'])[2]"));
	wLip.mouseover(driver, j);
	driver.findElement(By.linkText("Sign Out")).click();
	
	
}
}


