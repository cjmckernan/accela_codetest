package com.accela.codetest.service;

import java.io.PrintStream;
import java.util.List;

import org.springframework.stereotype.Service;

import com.accela.codetest.model.Address;
import com.accela.codetest.model.Person;

@Service
public class ConsoleService {
	
	private final PrintStream out = System.out;
		
	public void printMessage(String msg) {
		this.out.println(msg);
	}
	
	public void printError(String error) {
		this.out.println("Error: "+ error);
	}
	
	public void printPeople(List<Person> people) {
		for(Person person: people) {
			this.out.println("Person Id: " + person.getId());
			this.out.println("First Name: " + person.getFirstName());
			this.out.println("Last Name: " + person.getLastName());
			if(!person.getAddresses().isEmpty()) {
				printAddressesInline(person.getAddresses());
			}
			this.out.println();
		}
	}
	
	public void printPerson(Person person) {
		this.out.println();
		this.out.println("Person Id: " + person.getId());
		this.out.println("First Name: " + person.getFirstName());
		this.out.println("Last Name: " + person.getLastName());
		this.out.println();
	}
	
	public void printAddresses(List<Address> addresses) {
		for(Address address: addresses) {
			this.out.println("Address Id: "+ address.getId());
			
			if(address.getPerson()!=null) {
				this.out.println("Person Id: "+ address.getPerson().getId());
			}
			this.out.println(address.getStreet() + ", ");
			this.out.println(address.getCity() + ", ");
			this.out.println(address.getState() + ", ");
			this.out.println(address.getPostalCode());
			this.out.println();
		}
	}
	public void printAddressesInline(List<Address> addresses) {
		for(Address address: addresses) {
			this.out.println("Address [Id:"+ address.getId() +", " + 
									address.getStreet() + ", " + 
									address.getCity() + ", " +
									address.getState() +", " +
									address.getPostalCode()+"]");
		}
	}
	public void printAddress(Address address) {
		this.out.println(address.getStreet() + ", ");
		this.out.println(address.getCity() + ", ");
		this.out.println(address.getState() + ", ");
		this.out.println(address.getPostalCode());
		this.out.println();
	}
	
	public void deletePerson(Person p) {
		this.out.println("| Deleted Person  |");
		printPerson(p);
	}
}
