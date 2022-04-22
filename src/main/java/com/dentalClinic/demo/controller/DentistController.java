package com.dentalClinic.demo.controller;

import com.dentalClinic.demo.model.DentistDTO;
import com.dentalClinic.demo.service.IDentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/dentist")
public class DentistController {
    @Autowired
    IDentistService dentistService;

    @PostMapping
    public ResponseEntity<?> createDentist(@RequestBody DentistDTO dentistDTO){
        dentistService.create(dentistDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public DentistDTO findDentist(@PathVariable Long id){
        return dentistService.read(id);
    }

    @PutMapping
    public ResponseEntity<?> updateDentist(@RequestBody DentistDTO dentistDTO){
        dentistService.update(dentistDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeDentist(@PathVariable Long id){
        dentistService.deleteById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<Collection<DentistDTO>> listDentists(){
        return ResponseEntity.ok(dentistService.getAll());
    }
}
