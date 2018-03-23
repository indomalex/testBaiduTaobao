package com.sunsea.testBaiduTaobao;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestBaidu {
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("beforeSuite干的事");
	}
	
	@BeforeTest
	public void beforeTest() {
		String driverPath = System.getProperty("user.dir") + "\\geckodriver.exe";
		String fireFoxPath = "C:\\Program Files\\Firefox Developer Edition\\firefox.exe";
		System.setProperty("webdriver.gecko.driver", driverPath);
		System.setProperty("webdriver.firefox.bin", fireFoxPath);
		System.out.println("beforeTest干的事");
	}
	
	@BeforeClass()
	public void setup() {
		System.out.println("beforeClass干的事。");
	}
	
	@BeforeGroups(groups = {"testBaidu"})
	public void beforeGroupsBaidu() {
		System.out.println("beforeGroups=testBaike干的事");
	}
	
	@BeforeGroups(groups = {"testBaike"})
	public void beforeGroupsBaike() {
		System.out.println("beforeGroups=testBaike干的事");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforeMethod干的事");
	}
	
	
	
	//在此可以列出"应该有的"异常。若没有出现所列异常，会测试报失败
	@Test(groups = {"testBaidu"}, expectedExceptions = {ExceptionInInitializerError.class, NullPointerException.class})
	public void testSearch() {

		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.baidu.com");
		
		WebElement kw = driver.findElement(By.id("kw"));
		kw.sendKeys("饺子");
		
		WebElement su = driver.findElement(By.id("su"));
		su.click();
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		driver.findElement(By.xpath("//h3[@class='t c-gap-bottom-small']/a")).click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.close();
		
		System.out.println("这里是testBaidu的具体内容");
		
		throw new NullPointerException();
		
		
	
	}
	
	
	
	@Test(groups = {"testBaike"})
	public void testBaike() {
		System.out.println("这里是testBaike的具体内容");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod干的事");
	}
	
	@AfterGroups(groups = {"testBaike"})
	public void afterGroupsBaike() {
		System.out.println("afterGroups=testBaike干的事");
	}
	
	@AfterGroups(groups = {"testBaidu"})
	public void afterGroupsBaidu() {
		System.out.println("afterGroups=testBaidu干的事");
	}
	
	@AfterClass
	public void teardown() {
		System.out.println("afterClass干的事");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("afterTest干的事");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("afterSuite干的事");
	}
	
	
	public static void main(String[] args) {
		String driverPath = System.getProperty("user.dir") + "\\geckodriver.exe";
		System.out.println(driverPath);
	}
	
}
