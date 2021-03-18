import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class arrayWithProducts {
	
	public static void main(String []args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//implicitWait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		String[] itemsNeeded = {"Brocolli", "Cauliflower", "Beetroot", "Tomato" };
		
		addItem(driver, itemsNeeded);
		
		driver.findElement(By.cssSelector("a[class='cart-icon']")).click();
		driver.findElement(By.cssSelector("div[class='action-block']")).click();
		
		driver.findElement(By.cssSelector("input[class='promoCode']")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.cssSelector("button[class='promoBtn']")).click();
		
		//explicitWait creating a new object
		WebDriverWait w = new WebDriverWait(driver, 5);
		//using object to wait until the message appear after code is applied with success/no success
		w.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("span[class='promoInfo']"))));
		driver.findElement(By.xpath("//*[text()='Place Order']")).click();;
			
		}
	
	public static void addItem(WebDriver driver, String[] itemsNeeded) {
	
	List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
	List<WebElement> buttons = driver.findElements(By.xpath("//button[text()='ADD TO CART']"));
	
	
	for (int i=0; i<products.size(); i++) 
	{
		String[] name = products.get(i).getText().split("-");
		String formattedName = name[0].trim();
		System.out.println(formattedName);
		
		List itemNeededList = Arrays.asList(itemsNeeded);
		int itemsNeededSize = itemsNeeded.length;
		int j = 0;
		if(itemNeededList.contains(formattedName)) {
			driver.findElements(By.cssSelector("div[class='product-action']")).get(i).click();
										
			j++;
			
			if(j==itemsNeededSize) {
				break;
			}
		}
	}

}

}