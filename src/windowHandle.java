import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowHandle {
	
	public static void main(String []args) {
		
		System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.findElement(By.cssSelector("a[href='https://rahulshettyacademy.com/#/documents-request']")).click();
		Set<String> windows = driver.getWindowHandles(); //taking parent and child ID
		
		//Creating iterator - access to set of windows activated by Selenium (at the beginning its out of the box)
		Iterator<String>id = windows.iterator();
		
		//activating/assigning parentID
		String parentID = id.next(); 
		
		//activating/assigning childID
		String childID = id.next();
		driver.switchTo().window(childID);
				
		String email = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		
		driver.switchTo().window(parentID);
		
		driver.findElement(By.id("username")).sendKeys(email);;
		
		
	}    

}
