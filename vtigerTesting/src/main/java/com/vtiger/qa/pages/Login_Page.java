package com.vtiger.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.vtiger.qa.Util.TestUtil;
import com.vtiger.qa.base.Test_Base;

public class Login_Page extends Test_Base {
public TestUtil tu;
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

	public Home_classPage login(String un, String pwd) {

		User_name.sendKeys(un);
		user_password.sendKeys(pwd);
	//	tu.SelectDropDown(coltheme, "bluelagoon");
		tu.MouseActionWithClick(driver,loginBtn);		
		return new Home_classPage();
	}

}
