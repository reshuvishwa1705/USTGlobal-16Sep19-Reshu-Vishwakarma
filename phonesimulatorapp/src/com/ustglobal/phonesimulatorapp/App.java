package com.ustglobal.phonesimulatorapp;

import java.awt.Label;
import java.util.List;
import java.util.Scanner;

import com.ustglobal.phonesimulatorapp.dao.PhoneSimulatorDao;
import com.ustglobal.phonesimulatorapp.dao.PhoneSimulatorImplDao;
import com.ustglobal.phonesimulatorapp.dto.PhoneSimulatorDto;
import com.ustglobal.phonesimulatorapp.util.PhoneSimulatorManager;
public class App {
	static Scanner sc = new Scanner(System.in);
	public static void goBack() {
		System.out.println("Press 1 to Show all contacts");
		System.out.println("Press 2 to Search for contact");
		System.out.println("Press 3 to Operate on contact");

		int num = sc.nextInt();
		switch(num) {
		case 1:
			PhoneSimulatorDao dao =PhoneSimulatorManager.getInstanceOfPhoneSimulatorDao();
			List<PhoneSimulatorDto> l = dao.showAllContact();
			for (PhoneSimulatorDto dto : l) {
				System.out.println("Name is "+dto.getName());
				System.out.println("Number is "+dto.getNumber());
				System.out.println("Groups is "+dto.getGroups());
				System.out.println("----------------------");
			}
			goBack();
			break;
		case 2:
			optionTwo();
			break;
		case 3:
			optionThree();
		}
	}public static void optionThree() {
		System.out.println("Press 1 to add contact");
		System.out.println("Press 2 to delete contact");
		System.out.println("Press 3 to edit contact");
		int num3 = sc.nextInt();
		switch(num3) {
		case 1:
			System.out.println("Enter name ");
			String name1 = sc.next();
			System.out.println("Enter number ");
			int number = sc.nextInt();
			System.out.println("Enter groups ");
			String groups = sc.next();
			PhoneSimulatorDto dto2 = new PhoneSimulatorDto();
			dto2.setName(name1);
			dto2.setNumber(number);
			dto2.setGroups(groups);
			PhoneSimulatorDao dao2 = PhoneSimulatorManager.getInstanceOfPhoneSimulatorDao();
			int count1 = dao2.addContact(dto2);
			if(count1>0) {
				System.out.println("Added Contact Successfully");
			}
			else
			{
				System.out.println("Added Contact Unsuccessfully");
			}
			optionThree();
			break;
		case 2:
			System.out.println("Enter name ");
			String name2 = sc.next();
			PhoneSimulatorDao dao3 = PhoneSimulatorManager.getInstanceOfPhoneSimulatorDao();
			int count2 = dao3.deleteContact(name2);
			if(count2>0) {
				System.out.println("Deleted Successfully");
			}
			else {
				System.out.println("Deleted Unsuccessfully");
			}

			optionThree();
			break;
		case 3:
			System.out.println("Enter name ");
			String name3 = sc.next();
			System.out.println("Enter number ");
			int number3 = sc.nextInt();
			System.out.println("Enter groups ");
			String groups3 = sc.next();
			PhoneSimulatorDto dto3 = new PhoneSimulatorDto();
			PhoneSimulatorDao dao4 = PhoneSimulatorManager.getInstanceOfPhoneSimulatorDao();
			dto3.setName(name3);
			dto3.setNumber(number3);
			dto3.setGroups(groups3);
			int count3 = dao4.editContact(dto3);
			if(count3>0) {
				System.out.println("Edit Contact Successfully");
			}
			else
			{
				System.out.println("Edit Contact Unsuccessfully");
			}
			goBack();
			break;
		}

	}
	public static void optionTwo() {
		System.out.println("Search for contact");
		System.out.println("Enter Name ");
		String name = sc.next();
		PhoneSimulatorDao dao1 = PhoneSimulatorManager.getInstanceOfPhoneSimulatorDao();
		PhoneSimulatorDto dto1 = dao1.searchContact(name);
		System.out.println("Name is "+dto1.getName());
		System.out.println("Number is "+dto1.getNumber());
		System.out.println("Groups is "+dto1.getGroups());
		System.out.println("******************************");
		System.out.println("Press 1 to call ");
		System.out.println("Press 2 to message ");
		System.out.println("Press 3 to go back to the main menu ");
		int num1 = sc.nextInt();
		switch(num1) {
		case 1:
			System.out.println(dto1.getName()+" calling the contact...");
			System.out.println("End Call");
			optionTwo();
			break;
		case 2:
			System.out.println("Enter msg");
			String msg = sc.next();
			System.out.println("Sending the message...");
			optionTwo();
			break;
		case 3:
			goBack();
			break;
		}
	}

	public static void main(String[] args) {
		goBack();
	}
}
