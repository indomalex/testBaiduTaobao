package com.sunsea.testBaiduTaobao;

import org.testng.annotations.Test;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//用浏览器打开本地页面，作一些测试
public class TestMyPages {
	
	@Test
	public void testTestPage() {

		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		String currentDir = "file:///d:/eclipse-workspace/testBaiduTaobao";
		driver.get(currentDir + "/testPage.html");
		
		
		
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".red_box")));
		
        WebElement element = driver.findElement(By.cssSelector(".red_box"));    
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border = \"5px solid yellow\"",element);
        
        
        System.out.println("运行完毕");
	}
	
	
	public static void main(String[] args) {
		TestMyPages test = new TestMyPages();
		test.testTestPage();
	}
}



