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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class OrangeHRM_AddUser {
	ChromeDriver driver;

	@Test(priority = 1)
	public void Login() {

		// driver.findElementById("txtUsername").sendKeys("Admin");
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.linkText("Dashboard")).isDisplayed();
	}

	@Test(priority = 3)
	public void Logout() throws InterruptedException {

		driver.findElement(By.id("welcome")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();
	}

	@Test(priority = 2)
// This is for Add User Functionality
	public void AddUser() throws InterruptedException

	{

		WebElement admin = driver.findElementById("menu_admin_viewAdminModule");
		Actions action = new Actions(driver);
		action.moveToElement(admin).build().perform();
		WebElement usermanagement = driver.findElementByLinkText("User Management");
		action.moveToElement(usermanagement).build().perform();
		Thread.sleep(5000);
		driver.findElementByLinkText("Users").click();
		driver.findElementById("btnAdd").click();
		Select userrole = new Select(driver.findElementById("systemUser_userType"));
		// userrole.selectByVisibleText("Admin");
		// userrole.selectByValue("1");
		userrole.selectByIndex(0);
		driver.findElementById("systemUser_employeeName_empName").sendKeys("Fiona Grace");
		driver.findElementById("systemUser_userName").sendKeys("Dixit2");
		driver.findElementById("systemUser_password").sendKeys("selenium");
		driver.findElementById("systemUser_confirmPassword").sendKeys("selenium");
		driver.findElementById("btnSave").click();
		Thread.sleep(2000);
		driver.findElementByName("btnDelete").isDisplayed();

	}

	@BeforeTest
	public void beforeTest() {
		// Launch the Chrome Browser
		// WebDriverManager.firefoxdriver().setup();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}

	@AfterTest
	public void afterTest() {
		// driver.close();//Close the Current Browser
		driver.quit();// Close All the browser opened by Selenium
	}
}
