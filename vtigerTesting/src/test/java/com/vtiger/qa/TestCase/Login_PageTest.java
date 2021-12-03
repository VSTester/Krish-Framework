package com.vtiger.qa.TestCase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vtiger.qa.base.Test_Base;
import com.vtiger.qa.pages.Home_classPage;
import com.vtiger.qa.pages.Login_Page;

public class Login_PageTest extends Test_Base {

	Login_Page loginPage;
	Home_classPage homePage;

	public Login_PageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {

		Initialization();
		loginPage = new Login_Page();
	}

	@Test(priority = 1)
	public void LoginPageTitleTest() {
		String LoginTitle = loginPage.verifyLoginPageTitle();
		Assert.assertEquals(LoginTitle, "vtiger CRM 5 - Commercial Open Source CRM", "LoginTitle is not matched");
	}

	@Test(priority = 2)
	public void loginTest() {
		homePage =   loginPage.login(prop.getProperty("username"), prop.getProperty("userpassword"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
