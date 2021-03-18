import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsDemo {
	
	public static void main(String []args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://amazon.com");
		
		WebElement accountNaviPan= driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
		
		WebDriverWait w = new WebDriverWait(driver, 5);
		w.until(ExpectedConditions.visibilityOf(driver.findElement
				(By.cssSelector("div[class='a-section glow-toaster glow-toaster-theme-default glow-toaster-slot-default nav-coreFlyout nav-flyout']"))));
		driver.findElement(By.cssSelector("input[data-action-type='DISMISS']")).click();
		
		Actions a = new Actions(driver);
		a.moveToElement(accountNaviPan).build().perform();
		
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox")))
			.click()
			.keyDown(Keys.SHIFT)
			.sendKeys("hello")
			.build()
			.perform();
	}

}
