import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class fluentWait {
	
	public static void main(String []args) {
		
		System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.findElement(By.cssSelector("a[href='/dynamic_loading']")).click();
		driver.findElement(By.cssSelector("a[href='/dynamic_loading/1']")).click();
		driver.findElement(By.xpath("//button[text()='Start']")).click();
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(4))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);
		
		WebElement helloWorldMessage = wait.until(new Function<WebDriver, WebElement>() {
			
			public WebElement apply(WebDriver driver) {
				if(driver.findElement(By.cssSelector("div[id='finish'] h4")).isDisplayed())
						{
						return driver.findElement(By.cssSelector("div[id='finish'] h4"));
						} 
						else 
						{
							return null;
						}
				}
			});
		System.out.println(driver.findElement(By.cssSelector("div[id='finish'] h4")).getText());
		}
		
	}
 
