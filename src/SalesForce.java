import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SalesForce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https:\\login.salesforce.com");
		
		//fulfilling login/password fields
		driver.findElement(By.cssSelector("input[id='username']")).sendKeys("test1");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("test2");
		driver.findElement(By.cssSelector("input[id='Login']")).click();
		
		//capturing error message that appears when incorrect data is entered
		String error = driver.findElement(By.cssSelector("div[id='error']")).getText();
		System.out.println(error);
		
	}

}
