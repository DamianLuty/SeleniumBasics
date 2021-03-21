package PracticalProblemsAndMethods;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Scrolling {

	public static void main (String []args ) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		//creating java script executor to handle scripts in Selenium
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//scrolling down the whole page to specific position
		js.executeScript("window.scrollBy(0,500)");
		
		Thread.sleep(2000);
		//scrolling the table to the bottom of the table
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=300");
		
		List<WebElement> amounts = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum = 0;
		
		for(int i = 0; i < amounts.size(); i++) {
			
			sum += Integer.parseInt(amounts.get(i).getText());;
		}
		System.out.println(sum);
		driver.findElement(By.cssSelector(".totalAmount")).getText();
		int webValue = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		
		Assert.assertEquals(sum, webValue);
	}

}
