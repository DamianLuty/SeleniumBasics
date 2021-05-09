package JavaStreams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FilteringWebTable {
	
	public static void main(String []args ) {
		
		System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		String searchedVege = "Rice";
		driver.findElement(By.cssSelector("input[id='search-field']")).sendKeys(searchedVege);
		String searchResult = driver.findElement
				(By.cssSelector("table[class='table table-bordered'] tr td:nth-child(1)")).getText();
		
		Assert.assertTrue(searchedVege.equals(searchResult));
		
		System.out.println(driver.findElement(By.cssSelector
				("table[class='table table-bordered'] tr td:nth-child(2)")).getText());
		
		List<WebElement> veggies = driver.findElements
				(By.cssSelector("table[class='table table-bordered'] tr td:nth-child(1)"));
		
		List<WebElement> filteredList = veggies.stream().filter(s->s.getText().contains(searchedVege)).
				collect(Collectors.toList());
		
		Assert.assertEquals(veggies.size(), filteredList.size());
	}

}
