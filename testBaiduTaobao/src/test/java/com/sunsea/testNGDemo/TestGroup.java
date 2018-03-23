package com.sunsea.testNGDemo;

import org.testng.annotations.*;

public class TestGroup {
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("beforeClass()");
	}
	
	@AfterClass
	public void AfterClass() {
		System.out.println("AfterClass()");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforeMethod()");
	}
	
	@AfterMethod
	public void AfterMethod() {
		System.out.println("AfterMethod()");
	}

	@BeforeGroups("database")
    public void setupDB() {
        System.out.println("setupDB()");
    }

    @AfterGroups("database")
    public void cleanDB() {
        System.out.println("cleanDB()");
    }

    @Test(groups = "selenium-test")
    public void runSelenium() {
        System.out.println("runSelenium()");
    }

    @Test(groups = "selenium-test")
    public void runSelenium1() {
        System.out.println("runSelenium()1");
    }

    @Test(groups = "database")
    public void testConnectOracle() {
        System.out.println("testConnectOracle()");
    }

    @Test(groups = "database")
    public void testConnectMsSQL() {
        System.out.println("testConnectMsSQL()");
    }

    @Test(dependsOnGroups = { "database", "selenium-test" })
    public void runFinal() {
        System.out.println("runFinal()");
    }
}
