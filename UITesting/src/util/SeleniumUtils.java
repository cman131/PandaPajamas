package util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.thoughtworks.selenium.Wait;


public class SeleniumUtils {
	
	private final static int IMPLICIT_WAIT = 5;
	
	/**
	 * Sets the specified text field with given text
	 * 
	 * @author Conor Wright
	 * @param driver - the current Selenium Webdriver
	 * @param fieldBy - the identifier for the field to set
	 * @param text - the text to set to
	 */
	public static void setTextField(WebDriver driver, By fieldBy, String text){
		setTextField(driver, driver.findElement(fieldBy), text);
	}
	
	/**
	 * Sets the specified text field with given text
	 * 
	 * @author Conor Wright
	 * @param driver - the current Selenium Webdriver
	 * @param element - the WebElement of the field to set
	 * @param text - the text to set to
	 */
	public static void setTextField(WebDriver driver, WebElement element, String text){
		element.click();
		element.clear();
		element.sendKeys(text);
	}
	
	/**
	 * Navigate to specified page
	 * 
	 * @author Conor
	 * @param driver - the current Selenium Webdriver
	 * @param url - The url to go to
	 * @throws InterruptedException 
	 */
	public static void goTo(WebDriver driver, String url) throws InterruptedException{
		driver.get(url);
		waitForJavascript(driver);
	}
	
	/**
	 * Retrieves the text of given element
	 * 
	 * @author Conor
	 * @param driver - the current Selenium WebDriver
	 * @param element - the element to get the text of
	 * @return String - the resulting text
	 */
	public static String getText(WebDriver driver, WebElement element){
		switch(element.getTagName()){
		case "input":
			return element.getAttribute("value");
		case "field":
			return element.getAttribute("value");
		default:
			return element.getText();
		}
	}
	
	/**
	 * Waits for and retrieves the specified element
	 * 
	 * @author Conor
	 * @param driver - the current Selenium Webdriver
	 * @param by - the identifier of the element to get
	 * @return WebElement - the resulting WebElement
	 * @throws WebDriverException
	 * @throws InterruptedException
	 */
	public static WebElement getElement(WebDriver driver, By by) throws WebDriverException, InterruptedException{
		return waitForElementVisible(driver,by);
	}
	
	/**
	 * waits until the element is visible or the time limit is reached
	 * @param driver - the current Selenium Webdriver
	 * @param elementBy - the identifier of the element to wait for
	 * @throws WebDriverException
	 * @throws InterruptedException
	 */
	public static WebElement waitForElementVisible(final WebDriver driver,
			final By elementBy) throws WebDriverException, InterruptedException
	{
		return waitForElementVisible(driver, elementBy, SeleniumUtils.IMPLICIT_WAIT);
	}
	
	/**
	 * waits until the element is visible or the time limit is reached
	 * @param driver - the current Selenium Webdriver
	 * @param elementBy - the identifier of the element to wait for
	 * @param implicitWait - the time limit to wait(in seconds)
	 * @throws WebDriverException
	 * @throws InterruptedException
	 */
	public static WebElement waitForElementVisible(final WebDriver driver,
			final By elementBy, final int implicitWait) throws WebDriverException, InterruptedException
	{
		final WebDriverWait wait = new WebDriverWait(driver, implicitWait);
		return wait.until(ExpectedConditions
				.visibilityOfElementLocated(elementBy));
	}
	
	/**
	 * Waits until the javascript on the page is finished executing
	 * 
	 * @author Conor
	 * @param driver - The current Selenium Webdriver
	 * @param implicitWait - the amount of time to wait before timing out
	 * @throws InterruptedException 
	 */
	public static void waitForJavascript(WebDriver driver) throws InterruptedException{
		waitForJavascript(driver, SeleniumUtils.IMPLICIT_WAIT);
	}
	
	/**
	 * Waits until the javascript on the page is finished executing
	 * 
	 * @author Conor
	 * @param driver - The current Selenium Webdriver
	 * @param implicitWait - the amount of time to wait before timing out
	 * @throws InterruptedException 
	 */
	public static void waitForJavascript(final WebDriver driver, final int implicitWait) throws InterruptedException{
		Wait wait2 = new Wait("Wait for javascript") {
			public boolean until(){
				return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
			}
		};
		wait2.wait("Wait for javascript", implicitWait);
	}
}
