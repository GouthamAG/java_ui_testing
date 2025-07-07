import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeliniumIntro {

	public static void main(String[] args) {
		// Chrome -> ChromeDriver class-->  methods  --> close get
		// Firefox - FirefoxDriver class--> methods  --> close get
		// WebDriver --> Interface -->empty methods  --> close get
		//chromedriver.exe --> invokes Chrome browser
       //				   --> provided by third party (Chrome)	    	
		
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		
//		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();
		driver.quit();
	}

}
