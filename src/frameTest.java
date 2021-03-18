import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class frameTest {
	
	public static void main(String []args) {
		
		System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://jqueryui.com/droppable/");
		//searching for number of frames available on the website
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		//switching to frame available in the website
		driver.switchTo().frame(0);
		//	driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
		driver.findElement(By.id("draggable")).click();
		
		//creating webelements for drag and drop purposes
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.cssSelector("div[id='droppable']"));
		
		Actions a = new Actions(driver);
		a.dragAndDrop(drag, drop).build().perform();
		
		//moving back to original content of the site
		driver.switchTo().defaultContent();
		
		driver.findElement(By.cssSelector("a[href='https://jqueryui.com/autocomplete/']")).click();
	}

}
