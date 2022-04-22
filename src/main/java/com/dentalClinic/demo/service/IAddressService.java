package com.dentalClinic.demo.service;

import com.dentalClinic.demo.model.AddressDTO;

import java.util.Set;

public interface IAddressService {
    AddressDTO read(Long id);
    Set<AddressDTO> findAll();
}
