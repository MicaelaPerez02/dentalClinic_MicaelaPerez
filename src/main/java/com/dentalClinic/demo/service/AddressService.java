package com.dentalClinic.demo.service;

import com.dentalClinic.demo.entities.Address;
import com.dentalClinic.demo.model.AddressDTO;
import com.dentalClinic.demo.repository.IAddressRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class AddressService implements IAddressService{

    @Autowired
    private IAddressRepository addressRepository;

    @Autowired
    ObjectMapper mapper;


    @Override
    public AddressDTO read(Long id) {
        Optional<Address> address = addressRepository.findById(id);
        AddressDTO addressDTO = null;
        if(address.isPresent()){
            addressDTO = mapper.convertValue(address, AddressDTO.class);
        }
        return addressDTO;
    }

    @Override
    public Set<AddressDTO> findAll() {
        List<Address> addresses = addressRepository.findAll();
        Set<AddressDTO> addressesDTO = new HashSet<>();
        for(Address address : addresses){
            addressesDTO.add(mapper.convertValue(address, AddressDTO.class));
        }
        return addressesDTO;
    }

}
