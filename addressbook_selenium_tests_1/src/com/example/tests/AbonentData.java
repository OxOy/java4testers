package com.example.tests;

public class AbonentData implements Comparable<AbonentData> {
	private String firstname;
	private String lastname;
	private String address;
	private String home;
	private String mobile;
	private String work;
	private String email_first;
	private String email_second;
	private String bday;
	private String bmonth;
	private String byear;
	private String group;
	private String address_other;
	private String home_other;

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

	@Override
	public String toString() {
		return "AbonentData [firstname=" + firstname + ", lastname=" + lastname + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		//result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbonentData other = (AbonentData) obj;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		return true;
	}

	@Override
	public int compareTo(AbonentData other) {
		int i = this.lastname.toLowerCase().compareTo(other.lastname.toLowerCase());
		if (i == 0) {
			i = this.firstname.toLowerCase().compareTo(other.firstname.toLowerCase());
		}
		return i;
	}

	//Вытягивание в цепочку: 4 урок
	public AbonentData withFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}

	public AbonentData withLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}

	public AbonentData withAddress(String address) {
		this.address = address;
		return this;
	}

	public AbonentData withHome(String home) {
		this.home = home;
		return this;
	}

	public AbonentData withMobile(String mobile) {
		this.mobile = mobile;
		return this;
	}

	public AbonentData withWork(String work) {
		this.work = work;
		return this;
	}

	public AbonentData withEmailFirst(String email_first) {
		this.email_first = email_first;
		return this;
	}

	public AbonentData withEmailSecond(String email_second) {
		this.email_second = email_second;
		return this;
	}

	public AbonentData withBday(String bday) {
		this.bday = bday;
		return this;
	}

	public AbonentData withBmonth(String bmonth) {
		this.bmonth = bmonth;
		return this;
	}

	public AbonentData withByear(String byear) {
		this.byear = byear;
		return this;
	}

	public AbonentData withGroup(String group) {
		this.group = group;
		return this;
	}

	public AbonentData withAddressOther(String address_other) {
		this.address_other = address_other;
		return this;
	}

	public AbonentData withHomeOther(String home_other) {
		this.home_other = home_other;
		return this;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getAddress() {
		return address;
	}

	public String getHome() {
		return home;
	}

	public String getMobile() {
		return mobile;
	}

	public String getWork() {
		return work;
	}

	public String getEmail_first() {
		return email_first;
	}

	public String getEmail_second() {
		return email_second;
	}

	public String getBday() {
		return bday;
	}

	public String getBmonth() {
		return bmonth;
	}

	public String getByear() {
		return byear;
	}

	public String getGroup() {
		return group;
	}

	public String getAddress_other() {
		return address_other;
	}

	public String getHome_other() {
		return home_other;
	}
	
	
}