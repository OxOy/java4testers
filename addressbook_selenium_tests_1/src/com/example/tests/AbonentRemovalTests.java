package com.example.tests;

import static org.junit.Assert.assertThat;
import java.util.Random;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;
import static org.hamcrest.Matchers.*;

public class AbonentRemovalTests extends TestBase {
	@Test
	public void deleteSomeAbonent(){
		//save old state
		SortedListOf<AbonentData> oldList = app.getAbonentHelper().getAbonents();
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size()-1);  
		//actions
		app.getAbonentHelper().deleteAbonent(index);
		//.mainPage();
		
		//save new state
		SortedListOf<AbonentData> newList = app.getAbonentHelper().getAbonents();
		  
		// compare states  
		assertThat(newList, equalTo(oldList.without(index)));
	}

}
