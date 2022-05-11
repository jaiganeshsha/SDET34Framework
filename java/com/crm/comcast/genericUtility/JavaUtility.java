package com.crm.comcast.genericUtility;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	/**
	 * this method used toget integer randomnumber with boundary of 0 to 1000
	 * @return intdata
	 */
	public int getRandomNumber(){
		Random ran=new Random();
		int randomnum=ran.nextInt(1000);
		return randomnum;
		
	}
	/**
	 * this method getthe current systemdate
	 */
	public String getSystemdate() {
		Date date=new Date();
		String systemdateandtime = date.toString();
		return systemdateandtime;
	}
	
	public String getSystemDate_yyyy_mm_dd() {
		Date date=new Date();
		String systemdateandtime = date.toString();
		String [] arr=systemdateandtime.split(" ");
		
		 String dd=arr[2];
		 String yyyy=arr[5];
		 int mm=date.getMonth()+1;
		String finalformat=yyyy+"-"+mm+"-"+dd;
		 return finalformat;
	}

}
