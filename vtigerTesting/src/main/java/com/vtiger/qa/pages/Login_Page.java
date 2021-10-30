package com.vtiger.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vtiger.qa.Util.ExcelReader;
import com.vtiger.qa.Util.TestUtil;
import com.vtiger.qa.base.Test_Base;

public class Login_Page extends Test_Base {
public TestUtil util;
	@FindBy(name = "user_name")
	WebElement User_name;

	@FindBy(name = "user_password")
	WebElement user_password;

	@FindBy(name = "Login")
	WebElement loginBtn;

	@FindBy(name = "login_theme")
	WebElement coltheme;

	
	
	public Login_Page() {
		PageFactory.initElements(driver, this);
	}

	public String verifyLoginPageTitle() {
		return driver.getTitle();
	}
	

	public Home_Page loginWithValidCredantials(String un, String pwd) {
		User_name.sendKeys(un);
		user_password.sendKeys(pwd);
	//	tu.SelectDropDown(coltheme, "bluelagoon");
		//util.ClickOnElement(driver,loginBtn);		
		driver.findElement(By.name("Login")).click();
		return new Home_Page();
	}

}
