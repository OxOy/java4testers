package com.example.tests;

import org.testng.annotations.Test;

public class AbonentRemovalTests extends TestBase {
	@Test
	public void deleteSomeAbonent(){
		app.getNavigationHelper().openMainPage();
		app.getAbonentHelper().deleteAbonent(1);
		app.getNavigationHelper().openMainPage();
	}

}
