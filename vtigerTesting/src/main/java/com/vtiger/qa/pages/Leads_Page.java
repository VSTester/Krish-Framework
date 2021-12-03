package com.vtiger.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.vtiger.qa.Util.TestUtil;
import com.vtiger.qa.base.Test_Base;

public class Leads_Page extends Test_Base {
	public TestUtil tu;
public	String []name= {"state","firstname","lastname","company","phone","email"};
	@FindBy(id = "qccombo")
	WebElement quick_create;@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	@FindBy(xpath = "//select[@name='salutationtype']")
	WebElement salutationtype;

	@FindBy(name = "firstname")
	WebElement Firstname;

	@FindBy(name = "lastname")
	WebElement Lastname;

	@FindBy(name = "company")
	WebElement Company;

	@FindBy(id = "phone")
	WebElement Phone;

	@FindBy(id = "email")
	WebElement Email;

	@FindBy(xpath = "//input[@value='T']")
	WebElement assigned;

	@FindBy(className = "crmbutton small save")
	WebElement save;

	public Leads_Page() {
		PageFactory.initElements(driver, this);
	}

	public void createLead() {
		TestUtil.SelectDropDown(quick_create, "Leads");
	}
     
	public void Createnew_Lead(String name[]) {
			
		WebElement sal = driver.findElement(By.name("salutationtype"));
		Select fir = new Select(sal);
		fir.selectByValue(name[0]);
		driver.findElement(By.name("firstname")).clear();
		driver.findElement(By.name("firstname")).sendKeys(name[1]);

		driver.findElement(By.name("lastname")).clear();
		driver.findElement(By.name("lastname")).sendKeys(name[2]);

		driver.findElement(By.name("company")).clear();
		driver.findElement(By.name("company")).sendKeys(name[3]);

		driver.findElement(By.name("phone")).clear();
		driver.findElement(By.name("phone")).sendKeys(name[4]);

		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys(name[5]);

	}

	
		
	}


