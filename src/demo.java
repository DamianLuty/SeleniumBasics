import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.get("https:\\facebook.com");
		System.out.println(driver.getTitle());
		
		//accepting cookies
		driver.findElement(By.cssSelector("button[data-cookiebanner='accept_button']")).click();
		//clicking on login text box and "test1" input
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("test1");
		//clicking on password and "asd2" input
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("asd2");
		//clicking on forgot password button
		driver.findElement(By.className("_6ltj")).click();
		
	}

}
