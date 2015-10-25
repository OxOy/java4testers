package com.example.tests;

import java.util.Random;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class AbonentModificationTests extends TestBase{
	
	@Test(dataProvider = "randomValidAbonentGenerator")
	public void modifySomeAbonent(AbonentData abonent){
		//save old state
		SortedListOf<AbonentData> oldList = app.getAbonentHelper().getAbonents();
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size()-1);  
		//actions
		app.getAbonentHelper().modifyAbonent(index, abonent);
		
		//save new state
		SortedListOf<AbonentData> newList = app.getAbonentHelper().getAbonents();
		  
		// compare states
		assertThat(newList, equalTo(oldList.without(index).withAdded(abonent)));
	}

}
