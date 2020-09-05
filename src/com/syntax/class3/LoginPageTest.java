package com.syntax.class3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTest {

	public static WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
		// driver.manage().window().maximize();
	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}
	
	@Test(dataProvider="getData")
	public void multipleLogin(String username, String password, String name) throws InterruptedException {
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		Thread.sleep(4000);
		driver.findElement(By.cssSelector("input#btnLogin")).click();
		Thread.sleep(3000);
		String welcomeText = driver.findElement(By.id("welcome")).getText();
		Assert.assertEquals(welcomeText, "Welcome "+name);
	}
	
	@DataProvider
	public String[][] getData(){
		String[][] data= {
				{"Admin", "Hum@nhrm123", "Admin"},
				{"JohnTest", "Syntax123!", "John"},
				{"KokaL","Kokaytvyn$12345", "Koka"}
		};
		return data;
	}
}
