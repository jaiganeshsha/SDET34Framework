package com.crm.comcast.genericUtility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener{
	public void onTestFailure(ITestResult result) {
	JavaUtility jLip=new JavaUtility();
	 String testName = result.getMethod().getMethodName();
	EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
	   File src = edriver.getScreenshotAs(OutputType.FILE);
File dest = new File("./screenshot/"+testName+"_"+jLip.getSystemdate()+".png");
try {
	FileUtils.copyFile(src, dest);
	
}
catch(Exception e){
	
}

}
}