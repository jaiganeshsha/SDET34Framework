package com.crm.comcast.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * this class contain property file
 * @author DELL
 *
 */
public class FileUtility {
	/**
	 * this method used to read the data from commendat.properties
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getPropertyKeyValue(String key) throws Throwable {
		FileInputStream fis =new FileInputStream(Iconstant.PROPERTYFILEPATH);
		Properties p= new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}

}
