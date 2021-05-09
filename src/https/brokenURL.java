package https;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class brokenURL {
	
	public static void main (String []args) throws MalformedURLException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		SoftAssert a = new SoftAssert();
		
		List<WebElement> allURLs = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		
		for(int i = 0; i < allURLs.size(); i++) {
			
			String url = allURLs.get(i).getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int connectionCode = conn.getResponseCode();
			//softassert will store the all failures, but will not show them (a.assertAll()), have to be included to stop and show the eror
			a.assertTrue(connectionCode<400, "The broken link is: " + allURLs.get(i).getText() + " with code " + connectionCode);
							
		}
		//shows all failures in soft assert
		a.assertAll();
	}
}
