package com.policybazaar.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.policybazaar.qa.webUtil.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_Base {

	protected WebDriver driver;
	private Properties propertiesFile;
	private TestUtil util;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	
	
	
	/*
	 * ** Create Test_base class constructor for load our configure file to fetch
	 * some common TestData **
	 */
	public Test_Base() {
		try {
			propertiesFile = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\main\\java\\com\\policybazaar\\qa\\configure\\configure.Properties");
			propertiesFile.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

//     **   create intializationAndLaunchBrowser method for launch browser and hit Url  **   //

	public void 
	intializationAndLaunchBrowser() {
		String launchBrowserName = propertiesFile.getProperty("BrowserName");
		if (launchBrowserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions chOptionObj = new ChromeOptions();
			chOptionObj.addArguments("--incognito");
			driver = new ChromeDriver(chOptionObj);
		} else if (launchBrowserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions fireFoxObj = new FirefoxOptions();
			fireFoxObj.addArguments("-private");
			driver = new FirefoxDriver(fireFoxObj);
		}
		log.debug("browser launch succesfull");
		util = new TestUtil(driver);
		util.hiturl(propertiesFile.getProperty("QATestingUrl"));

	}

}
