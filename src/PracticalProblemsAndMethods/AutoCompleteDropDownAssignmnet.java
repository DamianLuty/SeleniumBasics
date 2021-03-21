package PracticalProblemsAndMethods;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class AutoCompleteDropDownAssignmnet {
	
	public static void main(String []args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.cssSelector("input[id='autocomplete']")).sendKeys("pol");
		Thread.sleep(2000L);
		
		List<WebElement> autoSuggestion = driver.findElements(By.cssSelector(".ui-menu-item"));
		
		for(WebElement selection : autoSuggestion) {
			if(selection.getText().equalsIgnoreCase("Poland")) {
				selection.click();
				break;
			}
		}	
		System.out.println(driver.findElement(By.cssSelector("input[id='autocomplete']")).getAttribute("value"));
	}
}
