package com.crm.comcast.genericUtility;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * this class contain generic method
 * @author DELL
 *
 */
public class WebDriverUtility {
	/**
	 *this method wait 20 for page loading 
	 * @param driver
	 */
	public void waituntilpageload(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Iconstant.IMPLICITLY_TIMEOUT, TimeUnit.SECONDS);
	}
	
	public void waitForElementVisiblity(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Iconstant.EXPLICITLY_TIMEOUT);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForpage(WebDriver driver,String partialPageUrl) {
		WebDriverWait wait=new WebDriverWait(driver, Iconstant.EXPLICITLY_TIMEOUT);
		wait.until(ExpectedConditions.urlContains(partialPageUrl));
	}
	
	
	/**
	 * this method perform handle dropdown index
	 * @param 
	 * @param index
	 */
	
	public void select(WebElement element,int index) {
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	
	/**
	 * this method perform mouse hover
	 * @param driver
	 * @param element
	 */
	public void mouseover(WebDriver driver,WebElement element) {
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
	}
	/**
	 * this method contains haldle alert accept
	 * @param driver
	 */
	
	public void alertaccept(WebDriver driver) {
		 driver.switchTo().alert().accept();
	}
	/**
	 * this method contain handle alert dissmiss
	 * @param driver
	 */
	
	public void alertDismiss(WebDriver driver) {
		 driver.switchTo().alert().dismiss();;
	}
	/**
	 * this method contains alert gettext
	 * @param driver
	 */
	
	public void alertgatGetText(WebDriver driver) {
		 driver.switchTo().alert().getText();
	}
	
	
	/**
	 * this method used handlewindow to another
	 * @param driver
	 * @param partialwinTittle
	 */
	
	public void switchToWindow(WebDriver driver,String partialwinTittle) {
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		
		while(it.hasNext()) {
			String wind=it.next();
			String title = driver.switchTo().window(wind).getTitle();
			if(title.contains(partialwinTittle)) {
				break;
			}
		}
	}
	

}
