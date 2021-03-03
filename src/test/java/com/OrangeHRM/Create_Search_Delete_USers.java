package com.OrangeHRM;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.Random;
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

public class Create_Search_Delete_USers {
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

	
	@Test
	public void Search() throws InterruptedException {

		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		WebElement Admin = driver.findElement(By.xpath("//b[contains(text(),'Admin')]"));
		
		//Add User Section
		Actions action = new Actions(driver);
		action.moveToElement(Admin).build().perform();

		WebElement usermanagement = driver.findElement(By.linkText("User Management"));
		action.moveToElement(usermanagement).build().perform();

		driver.findElement(By.linkText("Users")).click();
		driver.findElement(By.xpath("//input[@id='btnAdd']")).click();
		Select SelectPass = new Select(driver.findElement(By.id("systemUser_userType")));
		SelectPass.selectByValue("1");
		driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys("Fiona Grace");
		
		//Using Randon class, we can generate Random number between given value
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(100);
		WebElement UserNameInputbox = driver.findElement(By.id("systemUser_userName"));
		UserNameInputbox.sendKeys("sivaharsha" + randomInt);
		String EnteredValue = UserNameInputbox.getAttribute("value");
		// driver.findElement(By.id("systemUser_userName")).sendKeys("sivaharsha");
		driver.findElement(By.id("systemUser_password")).sendKeys("harshaaa");
		driver.findElement(By.id("systemUser_confirmPassword")).sendKeys("harshaaa");
		Thread.sleep(2000);
		driver.findElement(By.id("btnSave")).click();
		Thread.sleep(3000);
		//Search Added User
		driver.findElement(By.name("searchSystemUser[userName]")).sendKeys(EnteredValue);
		driver.findElement(By.id("searchBtn")).click();
		//Delete Added User
		driver.findElement(By.name("chkSelectRow[]")).click();
		driver.findElement(By.id("btnDelete")).click();
		driver.findElement(By.id("dialogDeleteBtn")).click();

	}
	
/*	@Test
	public void AddUser() {

	}
	
	@Test
	public void SearchUser() {

	}
	@Test
	public void DeleteUser() {

	}*/



	
	@BeforeTest
	public void beforeTest() throws InterruptedException {
		// Launch the Chrome Browser
		// WebDriverManager.firefoxdriver().setup();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		Thread.sleep(3000);
	}

	@AfterTest
	public void afterTest() {
		// driver.close();//Close the Current Browser
		driver.quit();// Close All the browser opened by Selenium
	}
}
