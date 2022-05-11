package com.crm.practise;

import java.sql.ResultSet;

import com.crm.comcast.genericUtility.jdbcUtility;

public class jdbcExecuteQuerryProgram {
	public static void main(String[] args) throws Throwable {
		jdbcUtility jLip=new jdbcUtility();
		jLip.connectTodatabase();
		   ResultSet exe = jLip.executeQuary("select * from students_info");
		
		while(exe.next()) {
			System.out.println(exe.getInt(1)+"\t"+exe.getString(2)+"\t"+exe.getString(3)+"\t"+exe.getString(4));
		}
	}

}