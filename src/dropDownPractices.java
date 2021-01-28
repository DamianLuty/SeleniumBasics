import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dropDownPractices {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//opening practice website
		driver.get("https://spicejet.com");
		
		//dropdown with static element
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(staticDropdown);
		//selecting the value from the dropdown list
		dropdown.selectByIndex(5);
		//System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByVisibleText("GBP");
		//driver.findElement(By.cssSelector("div[id='divpaxinfo']")).click();
		driver.findElement(By.id("divpaxinfo")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		//selecting number of passangers
		WebElement passengers = driver.findElement(By.id("ctl00_mainContent_ddl_Adult"));
		Select dropdown2 = new Select(passengers);
		//no. of passengers
		dropdown2.selectByValue("4");
		driver.findElement(By.id("divpaxinfo")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
				
	}

}
