package com.accela.codetest.shell;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import com.accela.codetest.model.Person;
import com.accela.codetest.service.ConsoleService;
import com.accela.codetest.service.PersonService;

@ShellComponent
public class PersonShell {
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private ConsoleService consoleService;


	@ShellMethod("Add a person to the database")
	public void addPerson(String firstName, String lastName) {
		Person newPerson = new Person(firstName, lastName);
		
		consoleService.printPerson(personService.addPerson(newPerson));
		consoleService.printMessage("Added User Successfully!" );
	}
	
	@ShellMethod("Edit an existing person in the database")
	public void editPerson(Long id, String firstName, String lastName) {
		try {
			Person p = new Person(id, firstName, lastName);
			consoleService.printPerson(personService.editPerson(p));
			consoleService.printMessage("Successfully edited person");
			
		} catch (EntityNotFoundException e) {
			consoleService.printError("Person not found Id: "+ id);
		} catch(Exception e) {
			
		}
	}
	
	@ShellMethod("Delete a person from the database")
	public void deletePerson(Long id) {
		try {
			consoleService.deletePerson(personService.deletePerson(id));	
		}catch(EntityNotFoundException e){
			
			consoleService.printError("Person not found Id:"+ id);
			
		} catch(Exception e) {
			consoleService.printError(e.toString());
		}
	}
	
	
	@ShellMethod("List all people in the database")
	public void listPeople() {
		consoleService.printPeople(personService.getAllPeople());
	}
	
	
}
