package com.vtiger.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.qa.Util.TestUtil;
import com.vtiger.qa.base.Test_Base;

public class Calculator_Page extends Test_Base {
	TestUtil util;

	@FindBy(xpath = "//img[@onclick=\"fninvsh('calc')\"]")
	WebElement CalcloseBtn;

	

	public Calculator_Page() {
		PageFactory.initElements(driver, this);
	}

	public void Calculatordigits(int digit) {
		driver.findElement(By.name("calc" + digit));

	}

	public void operations(String CalOper) {
		driver.findElement(By.name(CalOper));

	}
	
	
	

	public void clickOnCloseBtn() {
		CalcloseBtn.click();
	}

}
