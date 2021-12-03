package com.vtiger.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vtiger.qa.Util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_Base {

	public static WebDriver driver;
	public static Properties prop;
	
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public Test_Base() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\main\\java\\com\\vtiger\\qa\\configure\\configure.Properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.getStackTrace();
		} catch (IOException e) {
			e.getStackTrace();
		}
	}

	public static void Initialization() {
		
		String browsername = prop.getProperty("browser");
		System.out.println( "browser is"  +" "+  browsername);
		if (browsername.equals("chrome")) {

//			System.setProperty("webdriver.chrome.driver",
//					"C:\\Users\\Rinku PC\\krish workspace\\vtigerTesting\\chromeDriver\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.debug("browser launch succesfull");
			

		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("URL"));
	}
//public static void main(String[] args) {
//	Test_Base bs = new Test_Base();
//	bs.Initialization();
//}
}
