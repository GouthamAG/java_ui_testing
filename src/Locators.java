import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		
		// implicit wait - 5 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

//		Attempt login with wrong credentials
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		driver.findElement(By.name("inputPassword")).sendKeys("randomPassword");
		driver.findElement(By.className("signInBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		Thread.sleep(1000);
		
//		reset password after  clicking forgot password
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Goutham");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("goutham@gmail.com");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();
		driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("john@gmail.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9834567890");
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		//		Above line generates error shown below without Thread.sleep(1000);
		//		Exception in thread "main" org.openqa.selenium.ElementClickInterceptedException: element click intercepted: 
		//		Element <button class="reset-pwd-btn">...</button> is not clickable at point (506, 437). 
		//		Other element would receive the click: <div class="overlay-panel overlay-left">...</div>
		//		  (Session info: chrome=138.0.7204.93)
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		
		Thread.sleep(1000);
		
//		Login with proper credentials
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Goutham");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.xpath("//button[contains(@class, 'submit')]")).click();
		
	}

}
