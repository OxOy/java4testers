package com.example.tests;

import java.util.List;
import static org.testng.Assert.assertEquals;

import java.util.Collections;
import org.testng.annotations.Test;

public class AbonentCreationTests extends TestBase {
  
  @Test(dataProvider = "randomValidAbonentGenerator")
  public void testNewAbonentCreation(AbonentData abonent) throws Exception {
	  app.getNavigationHelper().openMainPage();
	  //save old state
	  List<AbonentData> oldList = app.getAbonentHelper().getAbonents();
	  
	  //actions
	  app.getAbonentHelper().initNewAbonent();
	  app.getAbonentHelper().fillNewAbonentForm(abonent);
	  app.getCommonHelper().submitData("submit");
	  app.getCommonHelper().gotoHomepage();
	  
	  //save new state
	  List<AbonentData> newList = app.getAbonentHelper().getAbonents();
	  
	  // compare states  
	  oldList.add(abonent);
	  Collections.sort(oldList);
	  assertEquals(newList, oldList);
  }
}