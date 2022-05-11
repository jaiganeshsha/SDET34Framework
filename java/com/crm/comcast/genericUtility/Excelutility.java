package com.crm.comcast.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * it developed using appachi poi,which is used to handle micro soft excel
 * @author DELL
 *
 */
public class Excelutility {
	/**
	 * read the data from excel file
	 * @return data
	 * @throws Throwable
	 */
	public String getDtaFromExcel(String sheetname,int rownum,int cellnum) throws Throwable {
		FileInputStream fis=new FileInputStream(Iconstant.EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		Row row = sh.getRow(rownum);
		String data = row.getCell(cellnum).getStringCellValue();
		return data;
	}
	
	public void setDataExcel(String sheetname,int rownum,int cellnum,String data) throws Throwable {
		FileInputStream fis=new FileInputStream(Iconstant.EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("sheetname");
		Row row = sh.getRow(rownum);
		   Cell cel = row.getCell(cellnum);
		  cel.setCellValue(data);
		  FileOutputStream fos=new FileOutputStream(Iconstant.EXCELPATH);
		  wb.write(fos);
		  wb.close();
		  
		  
	
	}	
     public Object[][] getDataForDataProvider(String sheet) throws EncryptedDocumentException, IOException{
    	 FileInputStream fis=new FileInputStream(Iconstant.EXCELPATH);
    	Workbook wb = WorkbookFactory.create(fis);
    	Sheet sh = wb.getSheet(sheet);
    	int lastrow = sh.getLastRowNum();
    	short lastcell = sh.getRow(0).getLastCellNum();
    	Object[][] data=new Object[lastrow][lastcell];
    	for(int i=0;i<lastrow;i++) {
    		for(int j=0;j<lastcell;j++) {
    			data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
    		}
    	}
    	return data;
     }
}
