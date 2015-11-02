package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.thoughtworks.xstream.XStream;

public class AbonentDataGenerator {

	public static void main(String[] args) throws IOException {
		if (args.length < 3) {
			System.out.println("Please specify parameters: <amount of test data> <file> <format>");
			return;
		}
		
		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = args[2];
		
		if (file.exists()){
			System.out.println("File exists, please remote it manually: " + file);
		}
		
		List<AbonentData> abonents = generateRandomAbonents(amount);
		if ("csv".equals(format)) {
			saveAbonentsToCsvFile(abonents, file);
		} else if ("xml".equals(format)) {
			saveAbonentsToXmlFile(abonents, file);
		} else {
			System.out.println("Unknown format" + format);
			return;
		}
	}

	private static void saveAbonentsToXmlFile(List<AbonentData> abonents, File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("abonent", AbonentData.class);
		String xml = xstream.toXML(abonents);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();	
	}
	
	public static List<AbonentData> loadAbonentsFromXmlFile(File file) {
		XStream xstream = new XStream();
		xstream.alias("abonent", AbonentData.class);
		return (List<AbonentData>) xstream.fromXML(file);
	}

	private static void saveAbonentsToCsvFile(List<AbonentData> abonents, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (AbonentData abonent : abonents) {
			writer.write(abonent.getFirstname() + "," + 
						 abonent.getLastname() + "," + 
						 abonent.getAddress() + "," + 
						 abonent.getHome() + "," + 
						 abonent.getMobile() + "," + 
						 abonent.getWork() + "," + 
						 abonent.getEmail_first() + "," + 
						 abonent.getEmail_second() + "," + 
						 abonent.getBday() + "," + 
						 abonent.getBmonth() + "," + 
						 abonent.getByear() + "," + 
						 abonent.getGroup() + "," + 
						 abonent.getAddress_other() + "," + 
						 abonent.getHome_other() +
						 ",!\n");
		}
		writer.close();
	}
	
	public static List<AbonentData> loadAbonentsFromCsvFile(File file) throws IOException {
		List<AbonentData> list = new ArrayList<AbonentData>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = bufferedReader.readLine();
		while (line != null) {
			String[] part = line.split(",");
			AbonentData abonent = new AbonentData()
				.withFirstname(part[0])
				.withLastname(part[1])
				.withAddress(part[2])
				.withHome(part[3])
				.withMobile(part[4])
				.withWork(part[5])
				.withEmailFirst(part[6])
				.withEmailSecond(part[7])
				.withBday(part[8])
				.withBmonth(part[9])
				.withByear(part[10])
				.withGroup(part[11])
				.withAddressOther(part[12])
				.withHomeOther(part[13]);
			list.add(abonent);
			line = bufferedReader.readLine();
		}
		bufferedReader.close();
		return list;
	}

	public static List<AbonentData> generateRandomAbonents(int amount) {
		List<AbonentData> list = new ArrayList<AbonentData>();
		for (int i = 0; i < amount; i++) {
			AbonentData abonent = new AbonentData()
					.withFirstname(generateRandomStringForAbonents("firstname"))
					.withLastname(generateRandomStringForAbonents("lastname"))
					.withAddress(generateRandomStringForAbonents("address"))
					.withHome(generateRandomStringForAbonents("phone"))
					.withMobile(generateRandomStringForAbonents("phone"))
					.withWork(generateRandomStringForAbonents("phone"))
					.withEmailFirst(generateRandomStringForAbonents("mail"))
					.withEmailSecond(generateRandomStringForAbonents("mail"))
					.withBday(generateRandomStringForAbonents("bday"))
					.withBmonth(generateRandomStringForAbonents("bmonth"))
					.withByear(generateRandomStringForAbonents("byear"))
					.withGroup(generateRandomStringForAbonents("group"))
					.withAddressOther(generateRandomStringForAbonents("address"))
					.withHomeOther(generateRandomStringForAbonents("phone"));
			list.add(abonent);
		}
		return list;
	}
	
	public static String generateRandomStringForAbonents(String add_info){
		String rvalue = "";
		Random rnd = new Random();
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
		
		return rvalue;
	}

}
