package com.crm.practise;

import com.crm.comcast.genericUtility.jdbcUtility;

public class JdbcExecuteUpdateQuerry {
	public static void main(String[] args) throws Throwable {
		jdbcUtility jLip=new jdbcUtility();
		jLip.connectTodatabase();
		int data = jLip.executeUpdate("insert into students_info values('8','balaji','raja','j');");
		System.out.println(data);
	}

}
