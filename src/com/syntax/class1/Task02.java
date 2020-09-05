package com.syntax.class1;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//TC 1: HRMS Application Login: 
//Open chrome browser
//Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
//Enter valid username and password
//Click on login button
//Then verify Syntax Logo is displayed
//Close the browser
//
//TC 2: HRMS Application Negative Login: 
//Open chrome browser
//Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
//Enter valid username
//Leave password field empty
//Verify error message with text “Password cannot be empty” is displayed.



public class Task02 {
	public static WebDriver driver;
	@BeforeMethod
	public void openBrowser() {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");

		driver = new ChromeDriver();
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
		driver.manage().window().maximize();

	}

	@Test(priority = 1)
	public void validLogin() {

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.cssSelector("input#btnLogin")).click();
		String welcomeText  = driver.findElement(By.id("welcome")).getText();

		if(welcomeText.contains("Admin")) {
			System.out.println("Admin is logged in.test pass");
		} else {
			System.out.println("Admin is NOT logged in.test fail");
		}
	}

	@Test(priority = 2)
	public void invalidLogin() {

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
//		driver.findElement(By.id("txtPassword")).sendKeys("");
		driver.findElement(By.cssSelector("input#btnLogin")).click();


		String spanMessage = driver.findElement(By.id("spanMessage")).getText();
		String expectedErrorMessage = "Password cannot be empty";

		if(spanMessage.contentEquals(expectedErrorMessage)) {
			System.out.println("empty Password message displayed. test pass");
		} else {
			System.out.println("empty Password message Not displayed. test fail");
		}

	}


	@Test(priority = 3)
	public void LogoValidation() {

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.cssSelector("input#btnLogin")).click();

		WebElement logo = driver.findElement(By.xpath("//img[@src= '/humanresources/symfony/web/webres_5acde3dbd3adc6.90334155/themes/default/images/syntax.png']"));


		if(logo.isDisplayed()) {
			System.out.println("Logo Displayed. test pass");
		} else {
			System.out.println("Logo NOT Displayed. test fail");
		}
	}

	@Test(priority = 4, enabled = false )
	public void titleValidation() {
		String expectedTitle="Human Management System";
		String actualTitle=driver.getTitle();

		if(actualTitle.contentEquals(expectedTitle)) {
			System.out.println("Title are matched. test pass");
		} else {
			System.out.println("Title are Not matched. test fail");
		}
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}



}