import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class spiceJetE2E {
	
	public static void main(String []args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://spicejet.com");
		
		//selecting "Round trip" radio button
		//.findElement(By.cssSelector("input[id='ctl00_mainContent_rbtnl_Trip_1']")).click();
		//Assert.assertEquals(driver.findElement(By.cssSelector("input[id='ctl00_mainContent_rbtnl_Trip_1']")).isSelected(), true);
		
		//selecting "Senior Citizen" discount
		driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected(), true);
		
		Thread.sleep(2000);
		//selecting departure town
		driver.findElement(By.cssSelector("input[id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		driver.findElement(By.cssSelector("a[value='HBX']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id='ctl00_mainContent_ddl_originStation1_CTXT']")).getAttribute("value"));
		Assert.assertEquals(driver.findElement(By.cssSelector("input[id='ctl00_mainContent_ddl_originStation1_CTXT']")).getAttribute("value").contains("Hubli"), true);
		
		
		Thread.sleep(2000);
		//selecting destination town
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='HYD']")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("input[id='ctl00_mainContent_ddl_destinationStation1_CTXT']")).getAttribute("value").contains("Hyderabad"), true);
		System.out.println(driver.findElement(By.cssSelector("input[id='ctl00_mainContent_ddl_destinationStation1_CTXT']")).getAttribute("value"));
		
		Thread.sleep(1000);
		//driver.findElement(By.cssSelector("a[class='ui-state-default ui-state-highlight ui-state-active']")).click();
		//Assert.assertEquals(driver.findElement(By.cssSelector("span[id='view_fulldate_id_1']")).getText().contains("Feb 21 2021"), true);
		
		driver.findElement(By.cssSelector("input[id='ctl00_mainContent_rbtnl_Trip_0']")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("input[id='ctl00_mainContent_rbtnl_Trip_0']")).isSelected(), true);
		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("div[id='divpaxinfo']")).click();
		WebElement passengers = driver.findElement(By.cssSelector("select[id='ctl00_mainContent_ddl_Adult']"));
		Select adults = new Select(passengers);
		adults.selectByValue("4");
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div[id='divpaxinfo']")).getText().contains("4"), true);
		
		WebElement Currency = driver.findElement(By.cssSelector("select[id='ctl00_mainContent_DropDownListCurrency']"));
		Select currencySelection = new Select(Currency);
		currencySelection.selectByValue("GBP");
		
		driver.findElement(By.cssSelector("input[id='ctl00_mainContent_btn_FindFlights']")).click();
		
		
		
	}
}
