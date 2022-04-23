package com.dentalClinic.demo.controller;

import com.dentalClinic.demo.exceptions.NotFoundException;
import com.dentalClinic.demo.model.AddressDTO;
import com.dentalClinic.demo.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    IAddressService addressService;

    @GetMapping("/{id}")
    public AddressDTO findAddressById (@PathVariable Long id) throws NotFoundException {
        return addressService.findById(id);
    }

    @GetMapping("/list")
    public ResponseEntity<Collection<AddressDTO>> listAppointments(){
        return ResponseEntity.ok(addressService.getAll());
    }

}
