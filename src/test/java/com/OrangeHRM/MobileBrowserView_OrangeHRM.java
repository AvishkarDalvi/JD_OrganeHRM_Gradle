package com.OrangeHRM;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MobileBrowserView_OrangeHRM {	ChromeDriver driver;
@Test
public void SignOn() {
	  
    	driver.navigate().to("https://www.borrowlenses.com/");
		/*driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();*/

}
@BeforeTest
public void LaunchBrowser() {
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		
      ChromeOptions iPhoneOption = new ChromeOptions();

      driver = new ChromeDriver(iPhoneOption);
      Dimension d = new Dimension(640, 960);
      driver.manage().window().maximize();
      driver.manage().window().setSize(d);

}

@AfterTest
public void CloseBrowser() {
	//	driver.quit();
}}
