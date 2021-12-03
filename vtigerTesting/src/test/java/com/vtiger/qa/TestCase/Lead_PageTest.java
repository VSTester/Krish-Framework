package com.vtiger.qa.TestCase;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vtiger.qa.Util.TestUtil;
import com.vtiger.qa.Util.Xls_Reader;
import com.vtiger.qa.base.Test_Base;
import com.vtiger.qa.pages.Calculator_Page;
import com.vtiger.qa.pages.Home_classPage;
import com.vtiger.qa.pages.Leads_Page;
import com.vtiger.qa.pages.Login_Page;

public class Lead_PageTest extends Test_Base {
	Login_Page loginPage;
	Home_classPage homePage;
	Calculator_Page cal;
	Leads_Page lead;
	static Xls_Reader reader;

	public Lead_PageTest() {
		super();

	}

	@BeforeMethod
	public void setUp() {

		Initialization();
		loginPage = new Login_Page();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("userpassword"));
		WebElement quick_scr = driver.findElement(By.id("qccombo"));
		Select se = new Select(quick_scr);
		se.selectByValue("Leads");

		String value = quick_scr.getAttribute("value");
		System.out.println(value);
		

	}

	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testData = TestUtil.getDataFromExcel();
		return testData.iterator();

	}

	@Test(dataProvider = "getTestData")
	public void Test_01(String state, String firstname, String lastname, String company, String phone, String email) {
		String []name= {"state","firstname","lastname","company","phone","email"};
		lead.Createnew_Lead(name);
	}

	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}

}
