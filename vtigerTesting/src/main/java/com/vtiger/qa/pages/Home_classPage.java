package com.vtiger.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.qa.Util.TestUtil;
import com.vtiger.qa.base.Test_Base;

public class Home_classPage extends Test_Base {
	TestUtil util;
	@FindBy(xpath = "//img[@title=\"Open Calculator...\"]")
	WebElement calculator;

	@FindBy(linkText = "Marketing")
	WebElement marketing;

	@FindBy(linkText = "Leads")
	WebElement leads;

	public Home_classPage() {
		PageFactory.initElements(driver, this);
	}

	public Calculator_Page clickcalculatoricon() {
		calculator.click();
		return new Calculator_Page();
	}

	public void movetomarketing() {
		util.MouseOver(driver, marketing);

	}

	public Leads_Page clickonmarketing() {
		util.MouseActionWithClick(driver, leads);
		return new Leads_Page();
	}

}
