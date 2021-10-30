package com.vtiger.qa.TestCase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vtiger.qa.base.Test_Base;
import com.vtiger.qa.pages.Calculator_Page;
import com.vtiger.qa.pages.Home_Page;
import com.vtiger.qa.pages.Login_Page;
import com.vtiger.qa.pages.Marketing_Page;

public class Marketing_Test extends Test_Base {
	
	Login_Page loginPage;
	Home_Page homePage;
	Calculator_Page cal;
	
	public Marketing_Test() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		Initialization();
		loginPage = new Login_Page();
		homePage = loginPage.loginWithValidCredantials(prop.getProperty("username"), prop.getProperty("userpassword"));
		
		
	}



//@Test
//public void 

@AfterMethod
public void tearDown() {
	driver.quit();
}
}
