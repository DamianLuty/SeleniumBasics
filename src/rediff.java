import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class rediff {
	
	public static void main(String []args) {
		
		System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.rediff.com/");
		driver.findElement(By.cssSelector("a[title*='Sign in']")).click();
		driver.findElement(By.cssSelector("input[id*='login']")).sendKeys("damian1");
		driver.findElement(By.cssSelector("input[id*='passwo']")).sendKeys("test2");
		driver.findElement(By.cssSelector("input[value='Sign in']")).click();
		
		System.out.println(driver.findElement(By.cssSelector("div[id='div_login_error']")).getText());
		
		
		
	}

}
