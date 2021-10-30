package com.vtiger.qa.TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vtiger.qa.Util.TestUtil;
import com.vtiger.qa.base.Test_Base;
import com.vtiger.qa.pages.Calculator_Page;
import com.vtiger.qa.pages.Home_Page;
import com.vtiger.qa.pages.Login_Page;

public class Calculator_Test extends Test_Base {
	Login_Page loginPage;
	Home_Page homePage;
	Calculator_Page cal;
	TestUtil util;

	public Calculator_Test() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		Initialization();
		loginPage = new Login_Page();
		homePage = loginPage.loginWithValidCredantials(prop.getProperty("username"), prop.getProperty("userpassword"));
		cal = homePage.ClickONCalculatorIcon();
	}

	@Test(priority = 1)
	public void CalculatorTest() throws InterruptedException {
		cal.Calculatordigits(6); 
		
		cal.operations("minus");
		cal.Calculatordigits(4);
		cal.operations("equal");
		Thread.sleep(900);
		WebElement calAns = driver.findElement(By.name("answer"));
		String ans = calAns.getAttribute("value");
		System.out.println(ans);
	}

//	@Test(priority = 2)
//	public void CloseCalculatorTest() {
//		cal.clickOnCloseBtn();
//	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}
}
