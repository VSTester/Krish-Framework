package com.policybazaar.qa.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.policybazaar.qa.base.Test_Base;
import com.policybazaar.qa.pages.PolicyBazaarLoginPage;
import com.policybazaar.qa.webUtil.TestUtil;

public class PolicyBzaarLoginPageTestCase extends Test_Base {

	private PolicyBazaarLoginPage pbLoginPage;
	TestUtil util;

	public PolicyBzaarLoginPageTestCase() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		intializationAndLaunchBrowser();
		pbLoginPage = new PolicyBazaarLoginPage(driver);

	}

	@Test(priority = 1)
	public void verifyLoginPageWithCredentials() {

		pbLoginPage.enterloginPageCredentials();

	}

	@AfterMethod
	public void tearDown() {
		util = new TestUtil(driver);
		util.browserClose();
	}

}
