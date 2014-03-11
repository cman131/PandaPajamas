import static org.junit.Assert.*;
import enums.Browser;
import base.BaseTest;

import org.apache.commons.lang3.StringUtils;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import util.SeleniumUtils;

public class CoreTests extends BaseTest {
	@Override
	@Before
	public void setUp(){
		this.browser = Browser.CHROME;
		super.setUp();
	}
	
	/**
	 * Searches for pandas and verifies the lack of results and the population of the search field
	 * @author Conor
	 */
	@Test
	public void pandaSearchTest(){
		String expectedSearchTerm = "Panda";
		String expectedTitle = "Nothing Found";
		
		String title = "";
		String searchTerm = "";
		try{
			// Wait for the search field and search for Pandas
			WebElement field = SeleniumUtils.getElement(driver, By.cssSelector("#search-2 input"));
			SeleniumUtils.setTextField(driver, field, expectedSearchTerm);
			field.sendKeys(Keys.ENTER);
			
			// Wait for results and Verify that nothing was found, but the field says "Panda"
			SeleniumUtils.waitForJavascript(driver);
			title = SeleniumUtils.getText(driver, SeleniumUtils.getElement(driver, By.cssSelector("#content .page-title")));
			searchTerm = SeleniumUtils.getText(driver, SeleniumUtils.getElement(driver, By.cssSelector("#content input[type='search']")));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			assertTrue(StringUtils.containsIgnoreCase(searchTerm, expectedSearchTerm));
			assertTrue(StringUtils.containsIgnoreCase(title, expectedTitle));
		}
	}
	
	/**
	 * Searches for pandas and verifies the lack of results and the population of the search field
	 * @author Conor
	 */
	@Test
	public void helloWorldTest(){
		String expectedTitle = "Hello World";
		
		String title = "";
		boolean present = false;
		try{
			// Get the header and then click it
			WebElement header = SeleniumUtils.getElement(driver, By.cssSelector(".entry-title a"));
			title = SeleniumUtils.getText(driver, header);
			header.click();
			
			// 
			SeleniumUtils.waitForJavascript(driver);
			present = SeleniumUtils.isDisplayed(driver, By.id("div-comment-1"));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			assertTrue(StringUtils.containsIgnoreCase(title, expectedTitle));
			assertTrue(present);
		}
	}
}
