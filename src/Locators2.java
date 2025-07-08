import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

//		Login with proper credentials and verify the messages and headings after sign in
		String name = "Goutham";
		
		String tempPassword = getPassword(driver);
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(tempPassword);
		driver.findElement(By.className("signInBtn")).click(); 
		
		Thread.sleep(Duration.ofSeconds(1));
		
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello "+name+",");
		//driver.findElement(By.className("logout-btn")).click();
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//form[@class='form']/h1")).getText(), "Sign in");
		driver.close();
		
	}
	
	
	public static String getPassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(Duration.ofSeconds(1));
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		String passwordText = driver.findElement(By.cssSelector("form p")).getText();
		String[] passwordArray = passwordText.split("'");
		return passwordArray[1].split("'")[0]; 
	}

}
