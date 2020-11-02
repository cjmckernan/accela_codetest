package com.accela.codetest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accela.codetest.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

	

	
}
