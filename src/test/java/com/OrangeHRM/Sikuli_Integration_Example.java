package com.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sikuli_Integration_Example {WebDriver driver;
@Test
public void FileUpload_UsingSikuli() throws Exception {
	WebDriverManager.chromedriver().setup();
	String filepath = "C:\\Selenium_Training\\workspace\\JD_OrganeHRM_Gradle\\Sikuli_Objects\\";
	//String inputFilePath = "D:\\F Drive\\Selenium Training Data\\workspace\\Maven_Selenium_WebDriver_4\\Sikuli_Scripts\\";
	Screen s = new Screen();
	Pattern fileInputTextBox = new Pattern(filepath+"textBoxFile.PNG");
	Pattern openButton = new Pattern(filepath+"openButton.png");

	// Open Chrome browser	
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://gofile.io/uploadFiles");
	Thread.sleep(15000);
	// Click on Browse button and handle windows pop up using Sikuli
	driver.findElement(By.xpath("//button[@id='dropZoneBtnSelect']")).click();
	Thread.sleep(15000);
	s.wait(fileInputTextBox, 20);
	s.type(fileInputTextBox,filepath+"imp_links.txt");
	s.click(openButton);

	// Close the browser
	//driver.close();

}}
