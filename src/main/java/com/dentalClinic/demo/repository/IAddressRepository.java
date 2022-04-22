package com.dentalClinic.demo.repository;

import com.dentalClinic.demo.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository extends JpaRepository<Address, Long> {

}
