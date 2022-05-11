package com.crm.practise;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.genericUtility.BaseClass;
@Listeners(com.crm.comcast.genericUtility.Listeners.class)
public class CheakScreenShot extends BaseClass {
	@Test
	public void cheak() {
		System.out.println("=====tesy start====");
		Assert.assertEquals(false, true);
		System.out.println("=====test end====");
	}
	

}
