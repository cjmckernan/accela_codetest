package com.accela.codetest.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accela.codetest.model.Person;
import com.accela.codetest.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepoisotory;

	//add  Person
	public Person addPerson(Person person) {
		return personRepoisotory.save(person);
	}
	
	//edit  Person
	public Person editPerson(Person p) {
		if(personRepoisotory.existsById(p.getId())) {
			return personRepoisotory.save(p);
		}else {
			throw new EntityNotFoundException();
		}
	}

	//get all people
	public List<Person> getAllPeople(){
		return personRepoisotory.findAll();
	}
	
	//delete person 
	public Person deletePerson(Long id) {
		Optional<Person> p = personRepoisotory.findById(id);
		if(p.isPresent()) {
			personRepoisotory.deleteById(id);	
			return p.get();
		}else {
			throw new EntityNotFoundException();
		}
	}
	
	//get by id
	public Person getPersonById(Long id) {
		Optional<Person> p = personRepoisotory.findById(id);
		if(p.isPresent()) {
			return p.get();
		}else {
			throw new EntityNotFoundException();
		}
	}
}
