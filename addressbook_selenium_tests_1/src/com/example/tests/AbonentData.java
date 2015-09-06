package com.example.tests;

public class AbonentData {
	public String firstname;
	public String lastname;
	public String address;
	public String home;
	public String mobile;
	public String work;
	public String email_first;
	public String email_second;
	public String bday;
	public String bmonth;
	public String byear;
	public String group;
	public String address_other;
	public String home_other;

	public AbonentData() {
	}
	
	public AbonentData(String firstname, String lastname, String address, String home, String mobile, String work,
			String email_first, String email_second, String bday, String bmonth, String byear, String group,
			String address_other, String home_other) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.home = home;
		this.mobile = mobile;
		this.work = work;
		this.email_first = email_first;
		this.email_second = email_second;
		this.bday = bday;
		this.bmonth = bmonth;
		this.byear = byear;
		this.group = group;
		this.address_other = address_other;
		this.home_other = home_other;
	}
}