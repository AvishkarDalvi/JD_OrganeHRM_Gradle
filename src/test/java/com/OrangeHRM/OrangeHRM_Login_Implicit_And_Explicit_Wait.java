package com.OrangeHRM;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class OrangeHRM_Login_Implicit_And_Explicit_Wait {
	ChromeDriver driver;

	@Test(priority = 1)
	public void Login() throws InterruptedException {
//		Thread.sleep(5000);
		//Implicit wait example
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.linkText("Dashboard")).isDisplayed();
	}

	@Test(priority = 2)
	public void Logout() throws InterruptedException {
//		Thread.sleep(5000);
		driver.findElement(By.id("welcome")).click();
		//Thread.sleep(2000);
		//explicit wait
		WebDriverWait wait=new WebDriverWait(driver, 60);
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_admin_viewAdminModule")));
		WebElement admin = driver.findElementById("menu_admin_viewAdminModule");

        Actions action = new Actions(driver);
        
        action.moveToElement(admin).build().perform();
        WebElement usermanagement = driver.findElementByLinkText("User Management");
        action.moveToElement(usermanagement).build().perform();
        Thread.sleep(5000);
        driver.findElementByLinkText("Users").click();
//		String ActText=element.getText();
//		System.out.println(ActText);
//		element.click();
//		driver.findElement(By.linkText("Logout")).click();
	}

	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");

	}

	@AfterTest
	public void afterTest() {
		driver.quit();// Close all the browser opened by Selenium
	}

}
