import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class EnableDisableContent {
	
	public static void main (String []args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://spicejet.com");
		
		//checking does Senior Citizen is not selected 1st method
		Assert.assertEquals(!driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected(), true);
		//2nd method
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected());
		//ticking checkbox with Senior Citizen
		driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).click();
		//checking does Senior Citizen is selected 1st method
		Assert.assertEquals(driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected(), true);
		//2nd method
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected());
		
		
		
		if(driver.findElement(By.cssSelector("span[id='view_fulldate_id_1']")).getText().contains("11 2021")) 
		{
			Assert.assertTrue(true);
			System.out.println(driver.findElement(By.cssSelector("span[id='view_fulldate_id_1']")).getText());
		} else {
			Assert.assertTrue(false);
			System.out.println("niepoprawna data");
		}
		
		//checking does "Return Date" is blocked
		System.out.println(driver.findElement(By.cssSelector("div[id='Div1']")).getAttribute("style"));
		Assert.assertEquals((driver.findElement(By.cssSelector("div[id='Div1']")).getAttribute("style")).contains("opacity: 0.5"), true);
		
		//clicking "Round trip" to unlock Return Date"
		//driver.findElement(By.cssSelector("input[id='ctl00_mainContent_rbtnl_Trip_1']")).click();
		//Assert.assertTrue(driver.findElement(By.cssSelector("input[id='ctl00_mainContent_rbtnl_Trip_1']")).isSelected());
		//System.out.println(driver.findElement(By.cssSelector("input[id='ctl00_mainContent_rbtnl_Trip_1']")).isSelected());
		
		Thread.sleep(2000);
		
		if(driver.findElement(By.cssSelector("div[id='Div1']")).getAttribute("style").contains("opacity: 1"))
		{
			Assert.assertTrue(true);
			driver.findElement(By.cssSelector("input[id='ctl00_mainContent_view_date2']")).click();
		} else {
			Assert.assertTrue(false);
			System.out.println("Return date is blocked");
		}		
	}
	

}
