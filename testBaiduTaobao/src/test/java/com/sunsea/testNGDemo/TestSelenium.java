package com.sunsea.testNGDemo;

import org.testng.annotations.Test;

@Test(groups = "selenium-test")
public class TestSelenium {
	
	public void runSelenium() {
		System.out.println("runSelenium()");
	}
	@Test(dependsOnMethods = "runSelenium")
	public void runSelenium1() {
		System.out.println("runSelenium1()");
	}
}
