package com.example.fw;

import org.openqa.selenium.By;

public class CommonHelper extends HelperBase{

	public CommonHelper(ApplicationManager manager) {
		super(manager);
	}

	public void gotoHomepage() {
		click(By.linkText("home page"));
	}

	public void submitData(String name_button) {
		click(By.name(name_button));
	  }

}
