package deep_dive;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		List<WebElement> products =  driver.findElements(By.xpath("//div[@class='product']"));
		for(WebElement product:products) {
			if(product.findElement(By.xpath(".//h4[@class='product-name']")).getText().contains("Cucumber")) {
				product.findElement(By.xpath(".//div[@class='product-action']/button[text()='ADD TO CART']")).click();
				break;
			}
		}

	}

}
