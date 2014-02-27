package enums;

public enum Browser {
	CHROME("webdriver.chrome.driver", "./drivers/chromedriver.exe"),
	FIREFOX(null, null),
	INTERNET_EXPLORER("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
	
	private String property;
	private String path;
	
	Browser(String property, String path){
		this.property = property;
		this.path = path;
	}
	
	public String getDriverProperty(){
		return this.property;
	}
	
	public String getDriverPath(){
		return this.path;
	}
}
