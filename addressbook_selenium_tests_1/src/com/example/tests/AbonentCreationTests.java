package com.example.tests;

import org.testng.annotations.Test;

public class AbonentCreationTests extends TestBase {
  @Test
  public void testNewAbonentCreation() throws Exception {
	  app.getNavigationHelper().openMainPage();
	  app.getAbonentHelper().initNewAbonent();
	  AbonentData abonent = new AbonentData();
	  abonent.firstname = "Bob";
	  abonent.lastname = "Brown";
	  abonent.address = "Starlite street";
	  abonent.home = "111";
	  abonent.mobile = "222";
	  abonent.work = "333";
	  abonent.email_first = "qaz@mail.ru";
	  abonent.email_second = "qwerty@mail.ru";
	  abonent.bday = "7";
	  abonent.bmonth = "July";
	  abonent.byear = "1987";
	  abonent.group = "group_1";
	  abonent.address_other = "Green street";
	  abonent.home_other = "777";
	  app.getAbonentHelper().fillNewAbonentForm(abonent);
	  app.getCommonHelper().submitData("submit");
	  app.getCommonHelper().gotoHomepage();
  }
}