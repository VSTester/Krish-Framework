package com.vtiger.qa.Util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

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

	public static void MouseActionWithClick(WebDriver driver, WebElement we) {
		Actions action = new Actions(driver);
		action.moveToElement(we).click().build().perform();
	}

	public static void MouseOver(WebDriver driver, WebElement we) {
		Actions action = new Actions(driver);
		Action mouseOverpassword = action.moveToElement(we).build();
		mouseOverpassword.perform();
	}

	public static void SelectDropDown(WebElement we, String ddselval) {
		// System.out.println("hello");
		Select select = new Select(we);
		// System.out.println("hello234");
		select.selectByValue(ddselval);

	}

	public void getValueDisplayed(WebElement we) {
		String DisplayedValue = we.getAttribute("value");
		System.out.println(DisplayedValue);

	}

	public static void ScreenShot(String filename) {

		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("./SnapShot/" + (filename + (int) (Math.random() * 100)) + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	

	public static void getSnapShot(String filename) {
		Date date = new Date();
	     String timeStamp = date.clone().toString().replaceAll(" ","_").replaceAll(":","_").replaceAll("_IST","");
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("./SnapShot/"
					+ (filename +timeStamp+ ".jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Object[]> getDataFromExcel() {

		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		try {
			reader = new Xls_Reader("C:\\Users\\Rinku PC\\krish workspace\\vtigerTesting\\Excel_File\\Book1.xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}
		int rowcount = reader.getRowCount("Sheet1");
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

}
