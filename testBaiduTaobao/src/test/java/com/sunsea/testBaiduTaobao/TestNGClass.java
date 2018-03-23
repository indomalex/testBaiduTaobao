package com.sunsea.testBaiduTaobao;

import org.testng.Assert;

import org.testng.annotations.Test;


public class TestNGClass {

	String msg = "Hello TestNG!";
	NGClass msgUtil = new NGClass(msg);
	
	@Test
	public void testPrintMessage() {
		Assert.assertEquals(msg, msgUtil.printMessage());
	}
	
}
