package com.policybazaar.qa.pages;

import org.openqa.selenium.WebDriver;

import com.policybazaar.qa.objectrepository.PolicyBazaarLoginPageObjectRepo;
import com.policybazaar.qa.webUtil.TestUtil;



public class PolicyBazaarLoginPage extends PolicyBazaarLoginPageObjectRepo {
	WebDriver driver;
	TestUtil util;

	
	//  **  we create this page class constructor or call locator in this class object Repository**//
	public PolicyBazaarLoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		//PageFactory.initElements(driver, PolicyBazaarLoginPageObjectRepo.class);
	}

	
	
	//  ** we create a method for performing action on UI   ** //
	public void enterloginPageCredentials() {
		util = new TestUtil(driver);
		util.input(loginFullNameEd, "TestName");
	}

}
