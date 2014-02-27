import static org.junit.Assert.*;
import enums.Browser;
import base.BaseTest;

import org.apache.commons.lang3.StringUtils;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import util.SeleniumUtils;

public class ExampleTestClass extends BaseTest {
	@Override
	@Before
	public void setUp(){
		this.browser = Browser.CHROME;
		super.setUp();
	}
	
	/**
	 * Searches for pandas on google and verifies that the first result has a panda in it
	 * @author Conor
	 */
	@Test
	public void pandaTest(){
		String resultString = "";
		try{
			SeleniumUtils.goTo(driver, "http://www.google.com");
			SeleniumUtils.waitForElementVisible(driver, By.cssSelector("input[type='text']"), 5);
			SeleniumUtils.setTextField(driver, By.cssSelector("input[type='text']"), "Pandas");
			SeleniumUtils.getElement(driver, By.cssSelector("button.gbqfba, button.gbqfb")).click();
			WebElement result = SeleniumUtils.getElement(driver, By.cssSelector("li.g a"));
			resultString = SeleniumUtils.getText(driver, result);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			assertTrue(StringUtils.containsIgnoreCase(resultString, "Panda"));
		}
	}
}
