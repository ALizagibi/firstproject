package myTest1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test1 {
//this is myfristproject in githup 
	WebDriver driver = new EdgeDriver();

	String THEWEBSITE = "https://www.saucedemo.com/";

	@BeforeTest
	public void mysetup() {

		driver.get(THEWEBSITE);
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void login() throws InterruptedException {

		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");

		Thread.sleep(2000);
		driver.findElement(By.id("login-button")).click();

	}

	@Test(priority = 2)
	public void addOneRandomItem() throws InterruptedException {

		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		Thread.sleep(1000);

	}

	@Test(priority = 3)
	public void removeOneRandomItem() {
		driver.findElement(By.id("remove-sauce-labs-backpack")).click();

	}

	@AfterTest
	public void myAfterTest() {
//	 driver.quit();

	}

}
