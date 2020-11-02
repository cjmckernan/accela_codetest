package com.accela.codetest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accela.codetest.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
