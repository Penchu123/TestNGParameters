package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class DataProviderTest {

	WebDriver driver;
	@DataProvider(name="Authentication")
	public Object[][] credentials(){
		return new Object[][] {{"testuser_1", "Test@123"}, {"testuser_1", "Test@123"}};		
	}

	@Test(dataProvider="Authentication")
	public void test(String uname, String pass){

		System.setProperty("webdriver.chrome.driver","C:/Softwares/chromedriver.exe");					
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String baseUrl = "http://demo.guru99.com/test/login.html";					
		driver.get(baseUrl);
		driver.manage().window().maximize();

		driver.findElement(By.id("email")).sendKeys(uname);							
		driver.findElement(By.name("passwd")).sendKeys(pass);								
		driver.findElement(By.id("SubmitLogin")).click();;
		
		String aTitle = driver.getTitle();
		System.out.println(aTitle);
		String eTitle = "";
		Assert.assertEquals(eTitle, aTitle);
		
		System.out.println("Test Passed");
		
		driver.close();
	}

}
