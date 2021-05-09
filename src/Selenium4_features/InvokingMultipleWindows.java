package Selenium4_features;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvokingMultipleWindows {
	
	public static void main(String []args) {
		
		System.setProperty("webdriver.chrome.driver" , "C:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
	
	}

}
