import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scope {
	
	public static void main (String []args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		//1. Give me the number of links available on the website
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//limitating the webdriver only to part of the website - footer
		WebElement footdriver = driver.findElement(By.cssSelector("div[id='gf-BIG']"));
		//printing number of links included in footer
		System.out.println(footdriver.findElements(By.tagName("a")).size());
		
		//limitating the webdriver to 1st column from footer website
		WebElement footdriverColumn1 = driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		
		int NumberOfLinks = footdriverColumn1.findElements(By.tagName("a")).size();
		
		Actions a = new Actions(driver);
		
		WebDriverWait w = new WebDriverWait(driver, 5);
		
		for(int i=1; i < NumberOfLinks; i++) {
			//opening webpages in new tab
			a.keyDown(Keys.CONTROL).click(footdriverColumn1.findElements(By.tagName("a")).get(i)).build().perform();
		}
		
		Thread.sleep(5000L);
		
		//switching to each tab and printing the webpage title
			Set<String> websites = driver.getWindowHandles();
			Iterator<String> iteration = websites.iterator();
		
			while(iteration.hasNext()) {
				
				driver.switchTo().window(iteration.next());
				System.out.println(driver.getTitle());
			}
			
			
		}

}

