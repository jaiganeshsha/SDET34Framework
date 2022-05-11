package com.crm.practise;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.comcast.genericUtility.BaseClass;
import com.crm.comcast.genericUtility.Excelutility;
import com.crm.comcast.pom_repoxitory.CreateOrganization;
import com.crm.comcast.pom_repoxitory.Homepage;
import com.crm.comcast.pom_repoxitory.Organization;

public class DataprividerTestScriptExcendBaseClass    extends BaseClass {
	
	@Test(dataProvider="data")
	public void createOrg(String orgname) {
	int random = jLip.getRandomNumber();
	
	Homepage h=new Homepage(driver);
	h.getOrganization().click();
	
	Organization o=new Organization(driver);
	o.getCreateOrgLink().click();
	
	CreateOrganization co=new CreateOrganization(driver);
	co.createOrg(orgname+random);
	

		
	}
	Object[][] orgname ;
	@DataProvider(name="data")
	public Object[][] getdata() throws EncryptedDocumentException, IOException{
		
		return eLip.getDataForDataProvider("org");
		
	}
	

}
