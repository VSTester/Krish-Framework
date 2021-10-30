package com.vtiger.qa.TestCase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vtiger.qa.Util.ExcelReader;
import com.vtiger.qa.Util.TestUtil;
import com.vtiger.qa.base.Test_Base;
import com.vtiger.qa.pages.Home_Page;
import com.vtiger.qa.pages.Login_Page;

public class Login_PageTest extends Test_Base {

	Login_Page loginPage;
	Home_Page homePage;
	TestUtil util;

	public Login_PageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		Initialization();
		loginPage = new Login_Page();
	}

	@Test(priority = 1, enabled = false)
	public void LoginPageTitleTest() {
		String ActualLoginTitle = loginPage.verifyLoginPageTitle();
		String ExpectedLoginTitle = "vtiger CRM 5 - Commercial Open Source CRM";
		Assert.assertEquals(ActualLoginTitle, ExpectedLoginTitle);

	}

//	@DataProvider(name = "logindata")
//	public String[][] Login_Data_Provider() {
//		ExcelReader reader = new ExcelReader(
//				System.getProperty("user.dir") + "\\src\\main\\java\\com\\vtiger\\qa\\TestData\\DATAFORLOGINPAGE.xlsx");
//		int totalrow = reader.getrowcount("Sheet1");
//		int totalcols = reader.getcellcount("Sheet1");
//		String[][] loginData = new String[totalrow][totalcols];
//		for (int i = 1; i <= totalrow; i++) {
//			for (int j = 0; j < totalcols; j++) {
//				loginData[i - 1][j] = reader.getcelldata(i, j, "Sheet1");
//			}
//		}
//		return loginData;
//	}
//
//	@Test(dataProvider = "logindata")
//	public void LogingTestWithDataProvider(String username, String password) {
//    loginPage.loginWithValidCredantials(username, password);
//    if (driver.getTitle().contains("admin - My Home Page - Home ")) {
//    	System.out.println("It is ");
//		
//	}
//	}
//	
	
	@Test(priority = 2)
	public void loginTest() {
		homePage = loginPage.loginWithValidCredantials(prop.getProperty("username"), prop.getProperty("userpassword"));
	}

//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}

}
