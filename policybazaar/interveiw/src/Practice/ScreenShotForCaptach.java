package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ScreenShotForCaptach {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vikassahu\\policybazaar\\interveiw\\drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();

		options.addArguments("start-maximized");

		options.addArguments("disable-infobars");

		options.addArguments("--disable-extensions");

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://rsps100.com/vote/760");

		driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']")).click();	
	try {
		Thread.sleep(4000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//driver.close();
	}
	
}
