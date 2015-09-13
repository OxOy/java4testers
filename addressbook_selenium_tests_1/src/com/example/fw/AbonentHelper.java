package com.example.fw;

import org.openqa.selenium.By;

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
}
