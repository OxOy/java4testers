package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.AbonentData;

public class AbonentHelper extends HelperBase{

	public AbonentHelper(ApplicationManager manager) {
		super(manager);
	}

	public void initNewAbonent() {
		click(By.linkText("add new"));
	}

	public void fillNewAbonentForm(AbonentData abonent) {
		type(By.name("firstname"),abonent.firstname);
		type(By.name("lastname"),abonent.lastname);
	    type(By.name("address"),abonent.address);
	    type(By.name("home"),abonent.home);
	    type(By.name("mobile"),abonent.mobile);
	    type(By.name("work"),abonent.work);
	    type(By.name("email"),abonent.email_first);
	    type(By.name("email2"),abonent.email_second);
	    selestByText(By.name("bday"), abonent.bday);
	    selestByText(By.name("bmonth"), abonent.bmonth);
	    type(By.name("byear"),abonent.byear);
	    selestByText(By.name("new_group"), abonent.group);
	    type(By.name("address2"),abonent.address_other);
	    type(By.name("phone2"),abonent.home_other);
	}

	public void initAbonentModification(int index) {
		click(By.xpath("(//img[@alt='Edit'])[" + (index+1) + "]"));
	}
	
	public void removeOrModification(String action) {
		click(By.xpath("//input[@name='update'][@value='" + action + "']"));
	}

	public void deleteAbonent(int index) {
		initAbonentModification(index);
		removeOrModification("Delete");
	}

	public List<AbonentData> getAbonents() {
		List<AbonentData> abonents = new ArrayList<AbonentData>();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			AbonentData abonent = new AbonentData();
			String title = checkbox.getAttribute("title");
			title = title.substring("Select (".length(), title.length() - ")".length());
			int index = title.indexOf(" ");
			abonent.firstname = title.substring(0, index);
			abonent.lastname = title.substring(index + 1);
			abonents.add(abonent);
		}
		return abonents;
	}
}
