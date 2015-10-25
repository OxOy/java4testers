package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.AbonentData;
import com.example.utils.SortedListOf;


public class AbonentHelper extends HelperBase{

	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;
	
	public AbonentHelper(ApplicationManager manager) {
		super(manager);
	}
	
	private SortedListOf<AbonentData> cachedAbonents;
	
	public SortedListOf<AbonentData> getAbonents() {
		if (cachedAbonents == null) {
			rebuildCache();
		}
		return cachedAbonents;
	}

	private void rebuildCache() {
		cachedAbonents = new SortedListOf<AbonentData>();
		
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			String title = checkbox.getAttribute("title");
			title = title.substring("Select (".length(), title.length() - ")".length());
			int index = title.indexOf(" ");
			String firstname = title.substring(0, index);
			String lastname = title.substring(index + 1);
			cachedAbonents.add(new AbonentData().withFirstname(firstname).withLastname(lastname));
		}
	}

	public AbonentHelper createAbonent(AbonentData abonent) {
	  	initNewAbonent();
		fillNewAbonentForm(abonent, CREATION);
		submitData("submit");
		gotoHomepage();
		rebuildCache();
		return this;
	}
	
	public AbonentHelper modifyAbonent(int index, AbonentData abonent) {
		initAbonentModification(index);
		fillNewAbonentForm(abonent, MODIFICATION);
		removeOrModification("Update");
		gotoHomepage();
		rebuildCache();
		return this;
	}
	
	public AbonentHelper deleteAbonent(int index) {
		initAbonentModification(index);
		removeOrModification("Delete");
		gotoHomepage();
		rebuildCache();
		return this;
	}
	
//----------------------------------------------------------------------------------------		
	
	public AbonentHelper initNewAbonent() {
		click(By.linkText("add new"));
		return this;
	}

	public AbonentHelper fillNewAbonentForm(AbonentData abonent, boolean formType) {
		type(By.name("firstname"),abonent.getFirstname());
		type(By.name("lastname"),abonent.getLastname());
	    type(By.name("address"),abonent.getAddress());
	    type(By.name("home"),abonent.getHome());
	    type(By.name("mobile"),abonent.getMobile());
	    type(By.name("work"),abonent.getWork());
	    type(By.name("email"),abonent.getEmail_first());
	    type(By.name("email2"),abonent.getEmail_second());
	    selectByText(By.name("bday"), abonent.getBday());
	    selectByText(By.name("bmonth"), abonent.getBmonth());
	    type(By.name("byear"),abonent.getByear());
	    if (formType == CREATION) {
	    	selectByText(By.name("new_group"), abonent.getGroup());
	    } else if (formType == MODIFICATION) {
	    	selectByText(By.name("new_group"), null);
	    }
	    type(By.name("address2"),abonent.getAddress_other());
	    type(By.name("phone2"),abonent.getHome_other());
	    return this;
	}

	public AbonentHelper initAbonentModification(int index) {
		click(By.xpath("(//img[@alt='Edit'])[" + (index+1) + "]"));
		return this;
	}
	
	public AbonentHelper removeOrModification(String action) {
		click(By.xpath("//input[@name='update'][@value='" + action + "']"));
		cachedAbonents = null;
		return this;
	}
	
	public AbonentHelper submitData(String name_button) {
		click(By.name(name_button));
		cachedAbonents = null;
		return this;
	  }
	
	public AbonentHelper gotoHomepage() {
		click(By.linkText("home page"));
		return this;
	}

}
