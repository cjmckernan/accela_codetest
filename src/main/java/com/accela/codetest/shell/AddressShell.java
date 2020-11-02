package com.accela.codetest.shell;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import com.accela.codetest.model.Address;
import com.accela.codetest.service.AddressService;
import com.accela.codetest.service.ConsoleService;

@ShellComponent
public class AddressShell {
	
	@Autowired
	private ConsoleService consoleService;
	
	@Autowired
	private  AddressService addressService;	
	

	@ShellMethod("Add an address to person in the database")
	public void addAddress(Long userId, String street, String city, String state, String postalCode) {
		try {
			Address address = new Address(street, city, state, postalCode);
			consoleService.printAddress(addressService.addAddress(userId, address));
			consoleService.printMessage("Address successfully added!");
		} catch (EntityNotFoundException e) {
			consoleService.printError("Person not found Id: "+ userId );
		} catch (Exception e) {
			consoleService.printError(e.toString());
		}
	}
	
	@ShellMethod("Edit an existing address in the database")
	public void editAddress(Long id, String street, String city, String state, String postalCode) {
		try {
			Address address = new Address(id, street, city, state, postalCode);
			consoleService.printAddress(addressService.editAddress(address));
			consoleService.printMessage("Successfully edited address!");
			
		} catch (EntityNotFoundException e) {
			consoleService.printError("Address not found Id: "+ id);
		} catch (Exception e) {
			consoleService.printError(e.toString());
		}
	}
	
	@ShellMethod("Delete an address from the database")
	public void deleteAddress(Long id) {
		try {
			consoleService.printAddress(addressService.deleteAddress(id));
			consoleService.printMessage("Successfully deleted addresss!");
		} catch (EntityNotFoundException e) {
			consoleService.printMessage("Address not found Id: " + id );
		} catch(Exception e) {
			consoleService.printError(e.toString());
		}
	}
	
	@ShellMethod("List all addresses in the database")
	public void listAddresses() {
		consoleService.printAddresses(addressService.getAllAddresses());
	}
	
}
