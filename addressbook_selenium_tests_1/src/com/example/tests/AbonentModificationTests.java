package com.example.tests;

import org.testng.annotations.Test;

public class AbonentModificationTests extends TestBase{
	@Test
	public void modifySomeAbonent(){
		app.getNavigationHelper().openMainPage();
		app.getAbonentHelper().initAbonentModification(1);
		AbonentData abonent = new AbonentData();
		abonent.firstname = "Alladin";
		app.getAbonentHelper().fillNewAbonentForm(abonent );
		app.getAbonentHelper().removeOrModification("Update");
		app.getNavigationHelper().openMainPage();
	}

}
