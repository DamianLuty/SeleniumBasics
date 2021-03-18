import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {
	
	public static void main(String []args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//inputing phrase to field
		driver.findElement(By.cssSelector("input[class='inputs']")).sendKeys("Damian");
		//clicking the "alarm" button to trigger an alert window
		driver.findElement(By.cssSelector("input[id='alertbtn']")).click();
		//gathering text from alarm window
		System.out.println(driver.switchTo().alert().getText());
		//accepting alarm - clicking "ok" button
		driver.switchTo().alert().accept();
		driver.findElement(By.cssSelector("input[id='confirmbtn']")).click();
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		
	}

}
