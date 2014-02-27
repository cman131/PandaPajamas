package base;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import enums.Browser;

public class BaseTest {
	
	protected WebDriver driver;
	protected Browser browser = Browser.CHROME;
	
	@Before
	public void setUp(){
		initializeDriver();
	}
	
	/**
	 * Starts up the SeleniumWebdriver for the specified browser
	 * @author Conor Wright
	 */
	private void initializeDriver(){
		switch(this.browser){
		case FIREFOX:
			this.driver = new FirefoxDriver();
			break;
		case INTERNET_EXPLORER:
			System.setProperty(browser.getDriverProperty(), browser.getDriverPath());
			this.driver = new InternetExplorerDriver();
			break;
		case CHROME:
			System.setProperty(browser.getDriverProperty(), browser.getDriverPath());
			this.driver = new ChromeDriver();
		}
	}
	
	/**
	 * Kills the current instance of Selenium Webdriver
	 * @author Conor Wright
	 */
	private void killTheDriver(){
		try{
			driver.quit();
		}
		catch(Exception e){
		}
	}
	
	@After
	public void tearDown(){
		killTheDriver();
	}
}
