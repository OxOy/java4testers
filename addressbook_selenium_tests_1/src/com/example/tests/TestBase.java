package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;*/

public class TestBase {
	
	protected static ApplicationManager app;

	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager();  
	  }
	
	@AfterTest
	public void tearDown() throws Exception {
		app.stop();    
	  }
	
	@DataProvider
	  public Iterator<Object[]> randomValidGroupGenerator() {
		  List<Object[]> list = new ArrayList<Object[]>();
		  for (int i = 0; i < 5; i++) {
			GroupData group = new GroupData()
					.withName(generateRandomString("group",""))
					.withHeader(generateRandomString("group",""))
					.withFooter(generateRandomString("group",""));
			list.add(new Object[]{group});
		  }
		  return list.iterator();
	  }
	  
	  @DataProvider
	  public Iterator<Object[]> randomValidAbonentGenerator(){
		  List<Object[]> list = new ArrayList<Object[]>();
		  for (int i = 0; i < 5; i++) {
			AbonentData abonent = new AbonentData()
					.withFirstname(generateRandomString("abonent","firstname"))
					.withLastname(generateRandomString("abonent","lastname"))
					.withAddress(generateRandomString("abonent","address"))
					.withHome(generateRandomString("abonent","phone"))
					.withMobile(generateRandomString("abonent","phone"))
					.withWork(generateRandomString("abonent","phone"))
					.withEmailFirst(generateRandomString("abonent","mail"))
					.withEmailSecond(generateRandomString("abonent","mail"))
					.withBday(generateRandomString("abonent","bday"))
					.withBmonth(generateRandomString("abonent","bmonth"))
					.withByear(generateRandomString("abonent","byear"))
					.withGroup(generateRandomString("abonent","group"))
					.withAddressOther(generateRandomString("abonent","address"))
					.withHomeOther(generateRandomString("abonent","phone"));
			list.add(new Object[]{abonent});
		  }
		  return list.iterator();
	  }
	  
	  public String generateRandomString(String object_name, String add_info){
		  String rvalue = "";
		  Random rnd = new Random();
		  if (object_name.toLowerCase() == "group") {
			  if (rnd.nextInt(3) == 0) {
				  rvalue = "";
			  } else {
				  rvalue = "group_" + rnd.nextInt();
			  }
		  } else if (object_name.toLowerCase() == "abonent") {
			  if (add_info.toLowerCase() == "firstname") {
				  if (rnd.nextInt(10) == 0) {
					  rvalue = "";
				  } else {
					  rvalue = "Bob_" + rnd.nextInt();
				  }
			  } else if (add_info.toLowerCase() == "lastname") {
				  if (rnd.nextInt(10) == 0) {
					  rvalue = "";
				  } else {
					  rvalue = "Brown_" + rnd.nextInt();
				  }
			  } else if (add_info.toLowerCase() == "phone") {
				  if (rnd.nextInt(10) == 0) {
					  rvalue = "";
				  } else {
					  rvalue = "" + rnd.nextInt();
				  }
			  } else if (add_info.toLowerCase() == "mail") {
				  if (rnd.nextInt(10) == 0) {
					  rvalue = "";
				  } else {
					  rvalue = rnd.nextInt() + "@mail.ru";
				  }
			  } else if (add_info.toLowerCase() == "address") {
				  if (rnd.nextInt(10) == 0) {
					  rvalue = "";
				  } else {
					  rvalue = "street" + rnd.nextInt();
				  }
			  } else if (add_info.toLowerCase() == "bday") {
				  if (rnd.nextInt(10) == 0) {
					  rvalue = "-";
				  } else {
					  rvalue = "" + (rnd.nextInt(30) + 1);
				  }
			  } else if (add_info.toLowerCase() == "bmonth") {
				  if (rnd.nextInt(10) == 0) {
					  rvalue = "-";
				  } else {
					  switch (rnd.nextInt(11) +1) {
					  	case 1: rvalue = "January";
					  	case 2: rvalue = "February";
					  	case 3: rvalue = "March";
					  	case 4: rvalue = "April";
					  	case 5: rvalue = "May";
					  	case 6: rvalue = "June";
					  	case 7: rvalue = "July";
					  	case 8: rvalue = "August";
					  	case 9: rvalue = "September";
					  	case 10: rvalue = "October";
					  	case 11: rvalue = "November";
					  	case 12: rvalue = "December";
					  }
				  } 
			  } else if (add_info.toLowerCase() == "byear") {
				  if (rnd.nextInt(10) == 0) {
					  rvalue = "";
				  } else {
					  rvalue = "" + (rnd.nextInt(100) + 1900);
				  }
			  } else if (add_info.toLowerCase() == "group") {
				  if (rnd.nextInt(10) == 0) {
					  rvalue = "[none]";
				  } else {
					  rvalue = "group_1";
				  }
			  } 
		  }
		  return rvalue;
	  }
	  
	  /*public String jdbcData(){
		  String url = "jdbc:odbc:localhost/phpmyadmin";
	      String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
	      String user = "";
	      String password = "";
	      Class.forName(driver);
	      Connection connection = DriverManager.getConnection(url, user, password);
	      String get_data = "SELECT `group_name` FROM `group_list` WHERE `group_id` = (select max(group_id) from group_list where group_id < 25)";
	      PreparedStatement data = connection.prepareStatement(get_data);
	      connection.close();
	      return data;  //ÒÓÒ ÎØÈÁÊÀ ÊÎÍÂÅÐÒÀÖÈÈ!!!
	  }*/
}
