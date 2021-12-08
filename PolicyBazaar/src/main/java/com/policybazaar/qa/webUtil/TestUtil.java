package com.policybazaar.qa.webUtil;

import java.util.List;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class TestUtil {

	private Select select;
	private Actions actions;
	private WebDriver driver;

	/*
	 * ** Constructor ** We create for get the WebDriver reference. This reference
	 * we use in Actions class
	 */

	public TestUtil(WebDriver driver) {
		this.driver = driver;
	}

	// *** Objects Methods*** //

	public void selectClassObj(WebElement element) {
		select = new Select(element);
	}

	public void actionClassObj() {
		actions = new Actions(driver);
	}

	// ** WebElement Methods** //

	public void clickOnElement(WebElement element) {
		Assert.assertEquals(true, elementIsDisplayed(element));
		element.click();
	}

	public void input(WebElement element, String testValue) {
		Assert.assertEquals(true, elementIsDisplayed(element));
		element.sendKeys(testValue);
	}

	public void clean(WebElement element) {
		element.clear();
	}

	// ** Select Methods** //

	public void selectDropDownByIndex(WebElement element, int valueIndex) {
		selectClassObj(element);
		select.selectByIndex(valueIndex);
	}

	public void selectDropDownByValue(WebElement element, String value) {
		selectClassObj(element);
		select.selectByValue(value);
	}

	public void selectDropDownByVisibleText(WebElement element, String visibleText) {
		selectClassObj(element);
		select.selectByVisibleText(visibleText);
	}

	public void disselectDropDownByIndex(WebElement element, int valueIndex) {
		selectClassObj(element);
		select.deselectByIndex(valueIndex);
	}

	public void disselectDropDownByValue(WebElement element, String value) {
		selectClassObj(element);
		select.selectByValue(value);
	}

	public void disselectDropDownByVisibleText(WebElement element, String visibleText) {
		selectClassObj(element);
		select.selectByVisibleText(visibleText);
	}

	public List<WebElement> getAllDropDownValue(WebElement element) {
		selectClassObj(element);
		List<WebElement> allDropDownElement = select.getOptions();
		return allDropDownElement;
	}

	public void acClickOnElement(WebElement element) {
		actionClassObj();
		actions.click(element).build().perform();
	}

	public void acInput(WebElement element, String testValue) {
		actionClassObj();
		actions.sendKeys(element, testValue).build().perform();
	}

	public void acMouseOver(WebElement element) {
		actionClassObj();
		actions.moveToElement(element).build().perform();
	}

	public void twiceClick(WebElement element) {
		actionClassObj();
		actions.doubleClick(element).build().perform();
	}

	// ** Get Methods ** //

	public boolean elementIsDisplayed(WebElement element) {
		boolean displayedElement = element.isDisplayed();
		return displayedElement;
	}

	public boolean elementIsSelected(WebElement element) {
		boolean selectedElement = element.isSelected();
		return selectedElement;
	}

	public String getCurrenWindowUrl() {
		String currentWindowUrl = driver.getCurrentUrl();
		return currentWindowUrl;
	}

	public String windowTitle(WebElement element) {
		String title = driver.getTitle();
		return title;
	}

	public WebDriver getBrowserDriver() {
		return driver;
	}

	// ** Methods for Elements ** //

	public String getElementText(WebElement element) {
		String elementText = element.getText();
		return elementText;
	}

	public String getElementAttributeValue(WebElement element, String attributeName) {
		String attributeValue = element.getAttribute(attributeName);
		return attributeValue;
	}

	public Point elementLocation(WebElement element) {
		Point point = element.getLocation();
		return point;
	}

	// ** Method for Url hit in browser and close ** //

	public void hiturl(String Url) {
		driver.get(Url);
	}

	public void browserClose() {
		driver.quit();
	}

	public void currentWindowClose() {
		driver.close();
	}

}
