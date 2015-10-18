package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class AbonentModificationTests extends TestBase{
	
	@Test(dataProvider = "randomValidAbonentGenerator")
	public void modifySomeAbonent(AbonentData abonent){
		app.getNavigationHelper().openMainPage();
		//save old state
		List<AbonentData> oldList = app.getAbonentHelper().getAbonents();
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size()-1);  
		//actions
		app.getAbonentHelper().initAbonentModification(index);
		abonent.group = null;
		app.getAbonentHelper().fillNewAbonentForm(abonent );
		app.getAbonentHelper().removeOrModification("Update");
		app.getNavigationHelper().openMainPage();
		
		//save new state
		List<AbonentData> newList = app.getAbonentHelper().getAbonents();
		  
		// compare states
		oldList.remove(index);
		oldList.add(abonent);
		Collections.sort(oldList);
		assertEquals(newList, oldList);
	}

}
