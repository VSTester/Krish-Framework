package com.vtiger.qa.TestCase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vtiger.qa.base.Test_Base;
import com.vtiger.qa.pages.Calculator_Page;
import com.vtiger.qa.pages.Home_Page;
import com.vtiger.qa.pages.Leads_Page;
import com.vtiger.qa.pages.Login_Page;
import com.vtiger.qa.pages.Marketing_Page;

public class Home_PageTest extends Test_Base {
	Login_Page loginPage;
	Home_Page homePage;
	Calculator_Page cal;
	Leads_Page lead;

	public Home_PageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		Initialization();
		loginPage = new Login_Page();
		homePage = loginPage.loginWithValidCredantials(prop.getProperty("username"), prop.getProperty("userpassword"));
	}

	@Test(priority = 1)
	public void homePageCalTest() {
		cal = homePage.ClickONCalculatorIcon();
	}

	@Test(priority = 2,dependsOnMethods = {"homePageCalTest"})

	public void ActionmarketTest() {
		homePage.movetomarketing();
	}

	@Test(priority = 3)
	public void clickonmartTest() {
		lead = homePage.clickonmarketing();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
