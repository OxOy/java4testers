package com.example.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

import static com.example.tests.AbonentDataGenerator.loadAbonentsFromCsvFile;
import static com.example.tests.AbonentDataGenerator.loadAbonentsFromXmlFile;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class AbonentCreationTests extends TestBase {
  
  @DataProvider
  public Iterator<Object[]> abonentsFromFile() throws IOException{
	  //return wrapAbonentsForDataProvider(loadAbonentsFromCsvFile(new File("abonents.txt"))).iterator();
	  return wrapAbonentsForDataProvider(loadAbonentsFromXmlFile(new File("abonents.xml"))).iterator();
  }	

  @Test(dataProvider = "abonentsFromFile")
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