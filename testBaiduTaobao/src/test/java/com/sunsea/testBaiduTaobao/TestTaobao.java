package com.sunsea.testBaiduTaobao;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import webtest.myFirefoxDriver;

public class TestTaobao {
	
	private String driverPath = System.getProperty("user.dir") + "\\geckodriver.exe";
	private String fireFoxPath = "C:\\Program Files\\Firefox Developer Edition\\firefox.exe";
	private FirefoxDriver driver = null;
	
	private String driverServer = "";
	private String caseSession = "";
	
	@BeforeClass
	public void init() {
		System.setProperty("webdriver.gecko.driver", driverPath);
		System.setProperty("webdriver.firefox.bin", fireFoxPath);
	}
	
	//自动登录淘宝
	@Test
	public void login() throws Exception {
		//处理代理设置不正确的问题
		Proxy pxy = new Proxy();
		pxy.setProxyType(ProxyType.AUTODETECT);
		FirefoxOptions options = new FirefoxOptions().setProxy(pxy);
		driver =new FirefoxDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://www.taobao.com");
		
		driver.findElement(By.xpath("//div/a[@class='h' and @target='_top']")).click();
		
		
		WebDriverWait wait = new WebDriverWait(driver, 6);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("J_Quick2Static")));
		
		driver.findElement(By.id("J_Quick2Static")).click();
		
		driver.findElement(By.xpath("//input[@id='TPL_username_1']")).sendKeys("indomalex");
		driver.findElement(By.xpath("//input[@id='TPL_password_1']")).sendKeys("Process2Fast!");
		
		WebElement from = null;
		WebElement errDiv = null;
		Actions builder = new Actions(driver);
		Action dragAndDrop = null;
		WebElement div = null;
		do {
			from = driver.findElement(By.xpath("//span[@id='nc_1_n1z' and @class='nc_iconfont btn_slide']"));
			div = driver.findElement(By.xpath("//div[@id='nocaptcha' and @class='nc-container tb-login']"));
			
			System.out.println(div.getCssValue("display"));
			if(div.getCssValue("display").equals("none"))
				break;
			
			dragAndDrop = builder.clickAndHold(from)
					.moveToElement(from, 258, 0)
					.release()
					.build();
			dragAndDrop.perform();
			
			Thread.sleep(1000);
			
			try {
				errDiv = driver.findElement(By.xpath("//div[@class='errloading']"));
			}
			catch(NoSuchElementException e) {
				break;
			}
			
			errDiv.findElement(By.xpath(".//a[1]")).click();
			
			Thread.sleep(1000);
			
		}
		while(true);
		
		driver.findElement(By.xpath("//button[@id='J_SubmitStatic']")).click();	
		
	}
	
	//手动方法绕过淘宝登录。一种是硬等待30秒自己操作，第二种是用第三方包将此浏览器转交给aboutMySelf继续执行
	//第二种可以扩展为将相应信息存到文件，能够做到用另外的程序接手该浏览器继续操作
	@Test(enabled=false)
	public void openByManual() throws Exception {
		Proxy pxy = new Proxy();
		pxy.setProxyType(ProxyType.AUTODETECT);
		FirefoxOptions options = new FirefoxOptions().setProxy(pxy);
		driver =new FirefoxDriver(options);
		
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://www.taobao.com");
		
		//浏览器转交关键代码（在aboutMySelf里重新获取）
//		HttpCommandExecutor executor = (HttpCommandExecutor)driver.getCommandExecutor();
//		driverServer = executor.getAddressOfRemoteServer().toString();
//		caseSession = driver.getSessionId().toString();
		
//		//30秒时间手动登录
		Thread.sleep(30000);
		
		//手动登录后可以继续由程序接手
	
	}
	
	//打印登录后的用户昵称
	@Test(enabled=false,dependsOnMethods={"openByManual"})
	public void aboutMySelf() throws Exception {
		//注意这里没有用全局的driver,而是生成了全新的newDriver
		WebDriver newDriver = new myFirefoxDriver(driverServer,caseSession);
		newDriver.findElement(By.xpath("//a[@class='site-nav-login-info-nick ']")).click();
		
		WebElement em = newDriver.findElement(By.xpath("//div[@class='s-name']//em[1]"));
		System.out.println("用户昵称为：" + em.getText());
		
		Thread.sleep(2000);
		newDriver.quit();
		
	}
	
	@Test(enabled=false,dependsOnMethods={"openByManual"})
	public void searchSth() {

	}
	
	@Test(enabled=false,dependsOnMethods={"openByManual"})
	public void cartUsing() {
		
	}
	
	@Test(enabled=false,dependsOnMethods={"openByManual"})
	public void logout() {
		
	}
	
	@AfterClass
	public void tearDown() {
		
	}
	
}
