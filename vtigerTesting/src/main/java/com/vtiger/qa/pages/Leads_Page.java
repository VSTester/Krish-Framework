package com.vtiger.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.vtiger.qa.Util.TestUtil;
import com.vtiger.qa.base.Test_Base;

public class Leads_Page extends Test_Base {
	public TestUtil util;
//public	String []name= {"state","firstname","lastname","company","phone","email"};
	
	@FindBy(xpath = "//a[@class='hdrLink']")
    WebElement leadsLink;
	
	@FindBy(xpath = "//Select[@id='qccombo']")
	WebElement quick_create;

	@FindBy (name = "salutationtype")
	WebElement salutationtype;

	@FindBy(name = "firstname")
	WebElement Firstname;

	@FindBy(name = "lastname")
	WebElement Lastname;

	@FindBy(name = "company")
	WebElement Company;

	@FindBy (name = "phone")
	WebElement Phone;

	@FindBy(name = "email")
	WebElement Email;

	@FindBy(xpath = "//input[@value='T']")
	WebElement assigned;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	WebElement save;

	public Leads_Page() {
		PageFactory.initElements(driver, this);
	}

	
	
	public void ClickOnLeadsLink() {
	util.ClickOnElement(driver, leadsLink);
		
	}
	public void OpenCreateLeadAccount() {
	   util.SelectDropDownElementByValue(quick_create, "Leads");
//		 Select Se = new Select(driver.findElement(By.xpath("//Select[@id='qccombo']")));
//          Se.selectByValue("Leads");
	}
     
	public void Createnew_Lead(String salut,String first,String last,String com, String phone, String email) {	
		
	  util.SelectDropDownElementByValue(salutationtype, salut);
      Firstname.clear();
      Firstname.sendKeys(first);
      Lastname.clear();
      Lastname.sendKeys(last);
      Company.clear();
      Company.sendKeys(com);
      Phone.clear();
      Phone.sendKeys(phone);
	  Email.clear();
	  Email.sendKeys(email);
	  save.click();
	  //System.out.println(leadsLink.isDisplayed());
		  if (leadsLink.isDisplayed()==true) {
		  util.ClickOnElement(driver, leadsLink);
	}
		
	}

	
	
	
	}


