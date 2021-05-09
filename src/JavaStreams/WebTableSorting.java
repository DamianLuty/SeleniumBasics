package JavaStreams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.google.common.collect.Streams;


public class WebTableSorting {
	
	public static void main(String []args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		
		//click on column
		driver.findElement(By.xpath("//tr/td[1]")).click();
		
		//capture all webelements into list
		//List<WebElement> names = driver.findElements(By.xpath("//tr/td[1]"));
		List<WebElement> names = driver.findElements(By.cssSelector("div[class='tableWrapper'] tr td:nth-child(1)"));
		
		//capture text of all webelements into new (original) list
		List<String> stringValues = names.stream().map(s->s.getText()).collect(Collectors.toList());
		stringValues.stream().forEach(n->System.out.println(n));
		
		//sort on the original list of step 3 -> sorted list
		List<String> sortedValues = stringValues.stream().sorted().collect(Collectors.toList());
		sortedValues.stream().forEach(n->System.out.println(n));
		
		//checking does original list is in the same order as sorted list
		//Assert.assertTrue(stringValues.equals(sortedValues));
		List<String> price;
		//scan name column and get the text - once you encounter rice then print the price of that vegetable
		
		do {
			names = driver.findElements(By.cssSelector("div[class='tableWrapper'] tr td:nth-child(1)"));
			
			price = names.stream().filter(s->s.getText().contains("Almond"))
					.map(s->getVegePrice(s)).collect(Collectors.toList());
					price.forEach(a->System.out.println(a));
		
		if(price.size() < 1) {
			driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
			Thread.sleep(2000L);
			}
		} while (price.size() < 1);
	}
	
	private static String getVegePrice(WebElement n) {
	String price = n.findElement(By.xpath("following-sibling::td[1]")).getText();
	return price;
	}
}


