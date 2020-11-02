package com.accela.codetest.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accela.codetest.model.Address;
import com.accela.codetest.model.Person;
import com.accela.codetest.repository.AddressRepository;

@Service
public class AddressService {
	
	@Autowired 
	private AddressRepository addressRepository;
	
	@Autowired
	private PersonService personService;
	
	//add address
	public Address addAddress(Long id, Address address) {
		Person p = personService.getPersonById(id);
		address.setPerson(p);
		return addressRepository.save(address);
	}
	
	//edit address
	public Address editAddress(Address address) {
		Optional<Address> existingAddress = addressRepository.findById(address.getId());
		if(existingAddress.isPresent()) {
			
			existingAddress.get().setStreet((address.getStreet()));
			existingAddress.get().setCity(address.getCity());
			existingAddress.get().setState(address.getState());
			existingAddress.get().setPostalCode(address.getPostalCode());
			
			return addressRepository.save(existingAddress.get());
		}else {
			throw new EntityNotFoundException();
		}
	}
	
	//get all addresses
	public List<Address> getAllAddresses(){
		return addressRepository.findAll();
	}
	
	//delete address
	public Address deleteAddress(Long id) {
		Optional<Address> add = addressRepository.findById(id);
		if(add.isPresent()) {
			addressRepository.delete(add.get());;
			return add.get();
		}else {
			throw new EntityNotFoundException();
		}
	}
}
