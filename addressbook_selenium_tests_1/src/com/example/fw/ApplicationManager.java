package com.example.fw;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager {
	
	public WebDriver driver;
	public String baseUrl;

	private NavigationHelper navigationHelper;
	private GroupHelper groupHelper;
	private AbonentHelper abonentHelper;
	private CommonHelper commonHelper;
	
	public ApplicationManager(){
		driver = new FirefoxDriver();
	    baseUrl = "http://localhost/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void stop() {
		driver.quit();
	}
	
	public NavigationHelper getNavigationHelper(){
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
	
	public CommonHelper getCommonHelper(){
		if (commonHelper == null) {
		    commonHelper = new CommonHelper(this);
		}
		return commonHelper;
	}
}
