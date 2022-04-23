package com.dentalClinic.demo.controller;

import com.dentalClinic.demo.exceptions.NotFoundException;
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
        dentistService.save(dentistDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Dentist created successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<DentistDTO> findDentistById(@PathVariable Long id) throws NotFoundException {
        return ResponseEntity.ok(dentistService.findById(id));
    }


    @PutMapping
    public ResponseEntity<?> updateDentist(@RequestBody DentistDTO dentistDTO){
        dentistService.update(dentistDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDentist (@PathVariable Long id) throws NotFoundException{
        dentistService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Dentist deleted successfully");
    }

    @GetMapping("/list")
    public ResponseEntity<Collection<DentistDTO>> listDentists() {
        return ResponseEntity.ok(dentistService.getAll());
    }
}
