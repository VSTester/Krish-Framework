package com.vtiger.qa.Util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.vtiger.qa.base.Test_Base;

public class TestUtil extends Test_Base {

	static Xls_Reader reader;
	public static long IMPLICIT_WAIT = 40;
	public static long PAGE_LOAD_TIMEOUT = 55;
	public static Actions action = new Actions(driver);

	public static void DoubleClickOnElement(WebElement WebElement) {
		action.moveToElement(WebElement).doubleClick().build().perform();
	}

	public static void ClickOnElement(WebDriver driver, WebElement we) {
		action.moveToElement(we).click().build().perform();
	}

	public static void MouseOverOnElement(WebDriver driver, WebElement we) {
		Action mouseOverpassword = action.moveToElement(we).build();
		mouseOverpassword.perform();
	}

	public static void SelectDropDownElementByValue(WebElement we, String ddselval) {
		Select select = new Select(we);
		select.selectByValue(ddselval);
	}

	public void GetValueIsDisplayed(WebElement we) {
		String DisplayedValue = we.getAttribute("value");
		System.out.println(DisplayedValue);

	}

	public static void TakeScreenShot(String NameOfFile) {
		String FileName = "E:\\eclipse workspace\\krish workspace\\vtigerTesting\\Screen- Shots\\";
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File(FileName + (NameOfFile + (int) (Math.random() * 100)) + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void HandleFrameByIndex(int index) {
		driver.switchTo().frame(index);
	}

	public static void HandleFrameByName(String Name) {
		driver.switchTo().frame(Name);
	}

	public static void HandleFrameByWebElement(WebElement WebElement) {
		driver.switchTo().frame(WebElement);
	}

	public static void GoToParentFrame() {
		driver.switchTo().parentFrame();
	}

	public static void GoToMainFrame() {
		driver.switchTo().defaultContent();
	}

	public static void HandleWindow(String ParentWindow, Set<String> ChildWindow) {
		for (String Windowhandle : ChildWindow) {
			if (!Windowhandle.equals(ParentWindow)) {
				driver.switchTo().window(Windowhandle);
			}
		}
	}

	public static void main(String[] args) {

	}

//	public static void ExtraWaitForElements(int WaitTime ) {
//		WebDriverWait wait = new WebDriverWait(driver, WaitTime);
//			
//	}

	public static void AcceptJavaScriptAlert() {
		driver.switchTo().alert().accept();
	}

	public static void DismissJavaScriptAlert() {
		driver.switchTo().alert().dismiss();
	}

	public static void GetTitleJavaScriptAlert() {
		driver.switchTo().alert().getText();
	}

	public static ArrayList<Object[]> getDataFromExcel() {

		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		try {
			reader = new Xls_Reader("E:\\eclipse workspace\\krish workspace\\vtigerTesting\\Excel_File\\Book1.xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}
		int rowcount = reader.getRowCount("Sheet1");
		System.out.println(rowcount);
		for (int rownum = 2; rownum <= rowcount; rownum++) {

			String State = reader.getCellData("Sheet1", "state", rownum);
			System.out.println(State);

			String firstname = reader.getCellData("Sheet1", "firstname", rownum);
			System.out.println(firstname);

			String lastname = reader.getCellData("Sheet1", "lastname", rownum);
			System.out.println(lastname);

			String company = reader.getCellData("Sheet1", "company", rownum);
			System.out.println(company);

			String phone = reader.getCellData("Sheet1", "phone", rownum);
			System.out.println(phone);

			String email = reader.getCellData("Sheet1", "email", rownum);
			System.out.println(email);

			System.out.println();

			Object ob[] = { State, firstname, lastname, company, phone, email };
			myData.add(ob);
		}
		return myData;

	}

//	public static String[][] getData() {
//		ExcelReader reader = new ExcelReader("E:\\eclipse workspace\\krish workspace\\vtigerTesting\\Excel_File\\Book1.xlsx");
//		int totalrow = reader.getrowcount("Sheet1");
//		int totalcol = reader .getcellcount("Sheet1");
//		String leadsData[][] = new String [totalrow][totalcol];
//		for (int i = 1; i <= totalrow; i++) {
//			for (int j = 0; j < totalrow; j++) {
//				leadsData[i-1][j] = reader.getcelldata(i, j,"Sheet1");
//			}
//		}
//		return leadsData;
//	}
//	public static void main(String[] args) {
//		getData();
//	}

}
