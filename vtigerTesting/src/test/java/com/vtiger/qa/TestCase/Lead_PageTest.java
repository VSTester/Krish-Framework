package com.vtiger.qa.TestCase;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.vtiger.qa.Util.ExcelReader;
import com.vtiger.qa.Util.Xls_Reader;
import com.vtiger.qa.base.Test_Base;
import com.vtiger.qa.pages.Calculator_Page;
import com.vtiger.qa.pages.Home_Page;
import com.vtiger.qa.pages.Leads_Page;
import com.vtiger.qa.pages.Login_Page;

public class Lead_PageTest extends Test_Base {
	Login_Page loginPage;
	Home_Page homePage;
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
		homePage = loginPage.loginWithValidCredantials
		(prop.getProperty("username"), prop.getProperty("userpassword"));
		lead = new Leads_Page();

	}
	
	
//	@DataProvider(name= "data")
//	public static Object[][] credentials()throws Exception{
//		ExcelReader reader = new ExcelReader(
//				"E:\\eclipse workspace\\krish workspace\\vtigerTesting\\Excel_File\\Book1.xlsx");
//	 int cols=2;
//	int rows = 2;
//	Object[][] data = new Object[rows][1];
//	Hashtable<String,String>  table = null;
//	for(int i = 1; i<=rows;i++){
//	table = new Hashtable<String, String>();
//	 for(int j = 0;j<cols; j++){
//
//	try{
//	table.put(reader.getcelldata(0, j, "Sheet1"),reader.getcelldata(i,j,"Sheet1"));
//	}catch(Exception e){
//	e.printStackTrace();
//	}
//	}
//	data[i-1][0] = table;
//	}
//	return data;
//	}
//	
//	

	@DataProvider(name = "retest")
	public static String[][] getDataFromExcel() {
		ExcelReader reader = new ExcelReader(
	System.getProperty("user.dir")+"\\src\\main\\java\\com\\vtiger\\qa\\TestData\\DATA FOR LEADS PAGES.xlsx");
		int totalrow = reader.getrowcount("Sheet1");
		int totalcols = reader.getcellcount("Sheet1");
		String[][] leadsData = new String[totalrow][totalcols];
		for (int i = 1; i <= totalrow; i++) {
			for (int j = 0; j < totalcols; j++) {

				leadsData[i - 1][j] = reader.getcelldata(i, j, "Sheet1");
			}
		}
		return leadsData;
	}
	public static void main(String[] args) {
		Lead_PageTest l = new Lead_PageTest();
		l.getDataFromExcel();
	}

	
	@Test(dataProvider = "retest",priority = 2)
	public void TestCreateLeadsAccount(String salut, String first, String last, String com,
			String phone,String email) {
		lead.OpenCreateLeadAccount();
		lead.Createnew_Lead(salut, first, last, com, phone, email);

	}

	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
	
//@DataProvider(name = "LeadsData")
//	public String[][] Data() {
//		String leadsData[][] = TestUtil.getData();
//		return leadsData;
//	}
//	@Test(dataProvider = "LeadsData")
//	public void Test() {
//		Login_Page login 
//	}

//	@DataProvider(name = "Data")
//	public Iterator<Object[]> getTestData() {
//		ArrayList<Object[]> testData = TestUtil.getDataFromExcel();
//		return testData.iterator();
//	}
//	@Test(dataProvider = "Data")
//	public void Test_01(String state, String firstname, String lastname, String company,
//	String phone, String email) {
//		String []name= {state,firstname,lastname,company,phone,email};
//		lead.Createnew_Lead(name);
//	}

	// checkData by hard coded
//	@DataProvider(name = "Data")
//	public String[][] testProvider() {
//		String[][] data = {{"krish","rathore","company"},{"vikas","sahu","abcd"}};
//		return data;
//	}
//	
//	@Test(dataProvider = "Data")
//	public void Test(String firstname,String lastname, String company) {
//		driver.findElement(By.name("firstname")).sendKeys(firstname);
//		driver.findElement(By.name("lastname")).sendKeys(lastname);
//		driver.findElement(By.name("company")).sendKeys(company);
//	}


