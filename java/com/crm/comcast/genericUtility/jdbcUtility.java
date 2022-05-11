package com.crm.comcast.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.Resultset;

/**
 * this class contain jdbc connection
 * @author DELL
 *
 */
public class jdbcUtility {
static	Connection conn;
static	ResultSet result;
static	Driver driver;
	/**
	 * this method used to connect the database
	 * @param dbname
	 * @throws Throwable
	 */
	public void  connectTodatabase() throws Throwable{
		
		try {
    driver=new Driver();
    DriverManager.registerDriver(driver);
    
    conn=DriverManager.getConnection(Iconstant.JDBC_URL_STRING,Iconstant.JDBC_USERNAME,Iconstant.JDBC_PASSWORD);
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
	}
	
	/**
	 * this method used to ececte the quary
	 * @param quary
	 * @param index
	 * @return
	 * @throws Throwable
	 */
	public ResultSet executeQuary(String quary) throws Throwable {
		
		Statement stat = conn.createStatement();
		
		
		 result = stat.executeQuery(quary);
		
		return result;
	}
		
	/**
	 * this method used to close the connection
	 * @throws SQLException
	 */
	
	public void closedatabase() throws Throwable {
		try {
			conn.close();
		
		}
		catch(Exception e) {
			
		}
	
		
		
	}
	public int executeUpdate(String quary) throws Throwable {
		
		Statement stat = conn.createStatement();
	int	result=stat.executeUpdate(quary);
		
		return result;
	}

	public boolean executeQuaryAndVerify(String querry,int columindex,String expectedData ) throws Throwable {
		boolean flag=false;
		result=conn.createStatement().executeQuery(querry);
		
		while(result.next()) {
			if(result.getString(columindex).equals(expectedData)) {
				flag=true;
				break;
				
			}
		}
		if(flag) {
			System.out.println(expectedData+"==data is verify in data base");
			return flag;
		}
		else {
			System.out.println(expectedData+"==data is not verify in data base");
			return flag;
		}
	}
	
	

}
