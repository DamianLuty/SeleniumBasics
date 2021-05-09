package https;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SslCerts {
	
	public static void main(String []args) {
		
		System.setProperty("webdriver.chrome.driver", "c:/chromdriver.exe");
		
		
		DesiredCapabilities chromeBrowser = DesiredCapabilities.chrome();
		chromeBrowser.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		chromeBrowser.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		ChromeOptions c = new ChromeOptions();
		c.merge(chromeBrowser);
		
		System.setProperty("webdriver.chrome.driver", "c:/chromdriver.exe");
		
		WebDriver driver = new ChromeDriver(c);
		
	}

}
