package com.crm.comcast.genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.comcast.pom_repoxitory.Homepage;
import com.crm.comcast.pom_repoxitory.Loginpage;

import io.github.bonigarcia.wdm.WebDriverManager;
//base
public class BaseClass {
	public WebDriver driver;
public	JavaUtility jLip=new JavaUtility();
public	FileUtility fLip=new FileUtility();
public	WebDriverUtility wLip=new WebDriverUtility();
public	Excelutility eLip=new Excelutility();
 public   jdbcUtility dLip=new jdbcUtility();
 public static WebDriver sdriver=null;
 
@BeforeSuite(groups= {"smoke","regression"})
 public void bsConfig() throws Throwable {
	 dLip.connectTodatabase();
	 System.out.println("-----connet to db---");
 }
//@Parameters("BROWSER")
 @BeforeClass(groups= {"smoke","regression"})
 public void bcCong() throws Throwable {
	String URL = fLip.getPropertyKeyValue("url");
	String BROWSER = fLip.getPropertyKeyValue("browser");
	
	 if(BROWSER.equals("chrome"))
	 {
		 
		  driver=new ChromeDriver();
	  }
	  else if(BROWSER.equals("firefox")) {
		 
		  driver=new FirefoxDriver();
	  }
	  else {
		  driver=new ChromeDriver();
	  }
	 wLip.waituntilpageload(driver);
	 sdriver=driver;
	 
	 driver.get(URL);
 }
@BeforeMethod(groups= {"smoke","regression"})
	public void bmConfig() throws Throwable {
		String USERNAME = fLip.getPropertyKeyValue("username");
		String PASSWORD = fLip.getPropertyKeyValue("password");
		
		
		Loginpage l=new Loginpage(driver);
		l.loginToApp(USERNAME, PASSWORD);
		System.out.println("----its login succesful----");
		
	}
	@AfterMethod(groups= {"smoke","regression"})
	public void amConfig() {
		Homepage h=new Homepage(driver);
		h.logout();
	}
	
	@AfterClass(groups= {"smoke","regression"})
	public void acConfig() {
		driver.quit();
		System.out.println("---close the browser");
		
	}
	@AfterSuite
	public void asConfig() throws Throwable {
		dLip.closedatabase();
		System.out.println("----db close succesfully---");
	}
			

}
