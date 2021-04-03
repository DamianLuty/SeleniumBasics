package https;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class MiscellaneousOptions {
	
	public static void main(String []args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//maximizing window 
		driver.manage().window().maximize();
		//cookie deletion
		driver.manage().deleteAllCookies();
	
		driver.get("https://google.pl");
		
		//creating a screenshot
		File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//saving the file to specific location
		FileUtils.copyFile(screen,new File("d:/nowyscreen.png"));
	}

}
