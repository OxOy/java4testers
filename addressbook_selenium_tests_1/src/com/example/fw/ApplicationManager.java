package com.example.fw;

import java.util.Properties;
//import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ApplicationManager {
	
	public WebDriver driver;
	public String baseUrl;

	private NavigationHelper navigationHelper;
	private GroupHelper groupHelper;
	private AbonentHelper abonentHelper;
	private Properties properties;
	
	public ApplicationManager(Properties properties){
		this.properties = properties;
		String browser = properties.getProperty("browser");
		if ("firefox".equals(browser)) {
			driver = new FirefoxDriver();
		} else if ("ie".equals(browser)) {
			System.setProperty("webdriver.ie.driver", "E:\\насвемхе_JAVA\\program\\library_for_java_project\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else {
			throw new Error("Unsupported browser" + browser);
		}
		
	    baseUrl = properties.getProperty("baseUrl");
	    //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get(baseUrl);
	}
	
	public void stop() {
		driver.quit();
	}
	
	public NavigationHelper navigateTo(){
		if (navigationHelper == null) {
			navigationHelper = new NavigationHelper(this);
		}
		return navigationHelper;
	}
	
	public GroupHelper getGroupHelper(){
		if (groupHelper == null) {
		    groupHelper = new GroupHelper(this);
		}
		return groupHelper;
	}
	
	public AbonentHelper getAbonentHelper(){
		if (abonentHelper == null) {
		    abonentHelper = new AbonentHelper(this);
		}
		return abonentHelper;
	}

}
