import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment6 {
	
	public static void main(String []args) {
		
		System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		//selecting a checkbox
		driver.findElement(By.cssSelector("input[id='checkBoxOption2']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id='checkBoxOption2']")).isSelected());
		String selecteCheckobx = driver.findElement(By.cssSelector("input[id='checkBoxOption2']")).getAttribute("value");
		
		//choosing from dropdown list the same value as selected in previous step
		WebElement dropdown = driver.findElement(By.cssSelector("select[id='dropdown-class-example']"));
		Select optionsDropdown = new Select(dropdown);
		optionsDropdown.selectByValue(selecteCheckobx);
		Assert.assertTrue(driver.findElement(By.cssSelector("select[id='dropdown-class-example']")).getAttribute("value").contains(selecteCheckobx));
		
		//putting the value from the checkbox to edit box
		driver.findElement(By.cssSelector("input[name='enter-name']")).click();
		driver.findElement(By.cssSelector("input[name='enter-name']")).sendKeys(selecteCheckobx);
		
		//clicking on alert button
		driver.findElement(By.cssSelector("input[id='alertbtn']")).click();
		
		//checking does the text included in alert pop-up contains the same as selected as a checkbox
		if(driver.switchTo().alert().getText().contains(selecteCheckobx)) {
			System.out.println("TEST PASSED");
		} else {
			System.out.println("TEST FAILED");
		}		
	}
}
