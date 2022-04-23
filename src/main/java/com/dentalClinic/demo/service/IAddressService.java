package com.dentalClinic.demo.service;

import com.dentalClinic.demo.exceptions.NotFoundException;
import com.dentalClinic.demo.model.AddressDTO;

import java.util.Set;

public interface IAddressService {
    AddressDTO findById(Long id) throws NotFoundException;
    Set<AddressDTO> getAll();
}
