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

public class krish extends Test_Base {
	Login_Page loginPage;
	Home_classPage homePage;
	Calculator_Page cal;
	Leads_Page lead;
	static Xls_Reader reader;

	public krish() {
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

		WebElement sal = driver.findElement(By.name("salutationtype"));
		Select fir = new Select(sal);
		fir.selectByValue(state);
		driver.findElement(By.name("firstname")).clear();
		driver.findElement(By.name("firstname")).sendKeys(firstname);

		driver.findElement(By.name("lastname")).clear();
		driver.findElement(By.name("lastname")).sendKeys(lastname);

		driver.findElement(By.name("company")).clear();
		driver.findElement(By.name("company")).sendKeys(company);

		driver.findElement(By.name("phone")).clear();
		driver.findElement(By.name("phone")).sendKeys(phone);

		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys(email);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
