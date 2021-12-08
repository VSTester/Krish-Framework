package com.policybazaar.qa.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//    ** We Create this class for Store every page class locators   **  //
public class PolicyBazaarLoginPageObjectRepo   {

	
	
//  ** it is a feature provided by selenium. we use this as a driver.findElement(By.locator);  **   //
	
	@FindBy (xpath = "//input[@id='nameAdd']")
	protected WebElement loginFullNameEd;

	@FindBy (xpath = "//input[@id='mobileNo']")
	protected WebElement loginMobileEd;
	
//static {
//	System.out.println("Hello");
//}
	
	
	/*
	 * We Create constructor of this class under this we use pageFactory class
	 * method. It is initElements for initialize all @FindBy and @FindBys locator
	 */ 
	
public PolicyBazaarLoginPageObjectRepo(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
}
