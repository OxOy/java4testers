package com.example.tests;

import org.testng.annotations.Test;
import com.example.utils.SortedListOf;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class AbonentCreationTests extends TestBase {
  
  @Test(dataProvider = "randomValidAbonentGenerator")
  public void testNewAbonentCreation(AbonentData abonent) throws Exception {
	  //save old state
	  SortedListOf<AbonentData> oldList = app.getAbonentHelper().getAbonents();
	  
	  //actions
	  app.getAbonentHelper().createAbonent(abonent);
	 
	  
	  //save new state
	  SortedListOf<AbonentData> newList = app.getAbonentHelper().getAbonents();
	  
	  // compare states  
	  assertThat(newList, equalTo(oldList.withAdded(abonent)));
  }
}