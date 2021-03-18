import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalendarInTravelWebsites {
	
	public static void main(String []args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companions");
		
		driver.findElement(By.cssSelector("button[id='ez-accept-all']")).click();
		driver.findElement(By.cssSelector("input[id='travel_date']")).click();
		
		//checking size/number of days available on the web page in calendar
		List<WebElement> dates = driver.findElements(By.className("day"));
		int numberOfDays = driver.findElements(By.className("day")).size();
		
		//checking size/number of months available on the web page in calendar
		List<WebElement> months = driver.findElements(By.className("month"));
		int numberOfMonths = driver.findElements(By.className("month")).size();

		
		//selecting month from the list of buttons similar to calendar ones
//		driver.findElement(By.className("datepicker-switch")).click();
//		for(int i = 0; i < numberOfMonths; i++) {
//			String month = driver.findElements(By.className("month")).get(i).getText();
//			if(month.equalsIgnoreCase("Sep")) 
//			{	
//				driver.findElements(By.className("month")).get(i).click();
//				break;
//			}
//		}
		
		// selecting month by using the >> button
		while(!driver.findElement(By.cssSelector("div[class='datepicker-days'] th[class='datepicker-switch']")).getText().contains("September")) {
			driver.findElement(By.cssSelector("div[class='datepicker-days'] th[class='next']")).click();
		}
		
		//selecting specifc day from calendar
		for(int i = 0; i < numberOfDays; i++) {
			String number = driver.findElements(By.className("day")).get(i).getText();
			if(number.equals("3")) 
			{
				driver.findElements(By.className("day")).get(i).click();
				break;
			}
		}
	}

}
