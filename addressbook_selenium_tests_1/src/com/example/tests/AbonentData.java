package com.example.tests;

public class AbonentData implements Comparable<AbonentData> {
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
	
	
}