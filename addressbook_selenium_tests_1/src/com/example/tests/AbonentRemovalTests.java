package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class AbonentRemovalTests extends TestBase {
	@Test
	public void deleteSomeAbonent(){
		app.getNavigationHelper().openMainPage();
		//save old state
		List<AbonentData> oldList = app.getAbonentHelper().getAbonents();
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size()-1);  
		//actions
		app.getAbonentHelper().deleteAbonent(index);
		app.getNavigationHelper().openMainPage();
		
		//save new state
		List<AbonentData> newList = app.getAbonentHelper().getAbonents();
		  
		// compare states  
		oldList.remove(index);
		Collections.sort(oldList);
		assertEquals(newList, oldList);
	}

}
