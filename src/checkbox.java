import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class checkbox {
	
	public static void main(String []args) {
		
		System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.spicejet.com/");
		
		//TestNG - checking does the checkbox is not selected and if its true - it will continue the test
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected());

		//checking does checkbox - "Senior Citizen" is selected
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected());
		System.out.println(driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected());
		//selecting specific checkbox
		driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).click();
		
		//TestNG 0 checking doe sthe checkbox is selected and if its true - it will continue the test
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected());
		//checking does checkbox - "Senior Citizen" is selected
		System.out.println(driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected());
		
		
		driver.findElement(By.cssSelector("div[id='divpaxinfo']")).click();
		WebElement passangersDropDown = driver.findElement(By.cssSelector("select[id='ctl00_mainContent_ddl_Adult']"));
		Select adults = new Select(passangersDropDown);
		adults.selectByValue("5");
		Assert.assertEquals(driver.findElement(By.cssSelector("div[id='divpaxinfo']")).getText(), "5 Adult");
		System.out.println("Jest OK!!");
	}

}
