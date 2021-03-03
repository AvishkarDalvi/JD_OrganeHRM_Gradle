package com.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class OrangeHRM_Login_TestNG {
	ChromeDriver driver;

	@Test(priority = 1)
	public void HDFCLogin() throws InterruptedException {
//		driver.findElement(By.xpath("//td[normalize-space()='User ID / Customer ID']"));
		//Thread.sleep(2000);
//		explicit wait
		WebDriverWait wait=new WebDriverWait(driver, 60);
		WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[normalize-space()='User ID / Customer ID']")));
		driver.findElement(By.xpath("//input[@name='fldLoginUserId']")).sendKeys("1000");
		driver.findElementByXPath("//tbody/tr/td/a/img[1]").click();
	}

//	@SuppressWarnings("deprecation")
//	@Test(priority = 2)
//	public void HDFCLogout() throws InterruptedException {
////		Thread.sleep(5000);
//		driver.findElement(By.id("welcome")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.linkText("Logout")).click();
//		//to get text and verify
//		String ActText=driver.findElement(By.id("logInPanelHeading")).getText();
//		String ExpText="LOGIN Panel";
//		Assert.assertEquals(ExpText, ActText);
//		//to get the currentURL
//		String ActURL=driver.getCurrentUrl();
//		String ExpectedURL="https://opensource-demo.orangehrmlive.com/index.php/auth/login";
//		Assert.assertEquals(ExpectedURL, ActURL);
//		//to verify the title
//		String ActTitle=driver.getTitle();
//		String ExpectedTitle="OrangeHRM";
//		Assert.assertEquals(ExpectedTitle, ActTitle);
//	}

	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://netbanking.hdfcbank.com/netbanking/");

	}

	@AfterTest
	public void afterTest() {
		driver.quit();// Close all the browser opened by Selenium
	}

}
