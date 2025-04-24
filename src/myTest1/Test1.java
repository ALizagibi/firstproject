package myTest1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test1 {
//this is myfristproject in githup 
	WebDriver driver = new ChromeDriver();

	String THEWEBSITE = "https://www.saucedemo.com/";
	String UserName = "standard_user";
	String Password = "secret_sauce";

	@BeforeTest
	public void mysetup() {

		driver.get(THEWEBSITE);
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void login() throws InterruptedException {

		WebElement UserNameInput = driver.findElement(By.id("user-name"));
		WebElement PasswordInput = driver.findElement(By.id("password"));
		WebElement Login = driver.findElement(By.id("login-button"));

		UserNameInput.sendKeys(UserName);
		PasswordInput.sendKeys(Password);
		Login.click();
	}

	@Test(  priority = 2)
	public void AddAllItem() throws InterruptedException {
		
		List<WebElement>AddToCartButton=driver.findElements(By.className("btn"));
		
		for (int i =0 ;i<AddToCartButton.size();i++) {
			AddToCartButton.get(i).click();
			
			Thread.sleep(2000);
		}
		
		
		
	}

	@Test(priority = 3)
	public void RemoveAllItem() throws InterruptedException {

		List <WebElement>RemoveButtons= driver.findElements(By.className("btn_secondary"));
		
		for (int i =0 ;i<RemoveButtons.size();i++) {
			RemoveButtons.get(i).click();
			Thread.sleep(2000);
		}	
		}
		
	
	//lastindex =size-1
	@Test(priority=4)
	public void Task() {
		
		List <WebElement> ItemNames =driver.findElements(By.className("inventory_item_name"));
		
		for (int i=0 ; i<ItemNames.size() ;i++ ) {
			
			String ItemName =ItemNames.get(i).getText();
			
			if(ItemName.startsWith("s")) {
				
				continue;
				
			}else {
				
				System.out.println(ItemName);
			}
		
		
	}
	}
	
	@Test(priority = 5,enabled = false)
	public void logout() throws InterruptedException {

		WebElement BurgerMenu = driver.findElement(By.id("react-burger-menu-btn"));
		BurgerMenu.click();
		Thread.sleep(1000);

		WebElement LogoutButton = driver.findElement(By.id("logout_sidebar_link"));
		LogoutButton.click();
		
	}
	
//	@Test(priority =6)
//	
//	public void practice() {
//		
//		String MyTitle =driver.findElement(By.className("app_logo")).getText();
//		System.out.println(MyTitle);
//	}
	

	//@AfterTest
	//public void myAfterTest() {
//	 driver.quit();

	}


