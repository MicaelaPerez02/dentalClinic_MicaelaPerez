package com.dentalClinic.demo.controller;

import com.dentalClinic.demo.exceptions.NotFoundException;
import com.dentalClinic.demo.model.PatientDTO;
import com.dentalClinic.demo.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    IPatientService patientService;

    @PostMapping
    public ResponseEntity<?> createPatient (@RequestBody PatientDTO patientDTO){
        patientService.save(patientDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Patient created successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> findById (@PathVariable Long id) throws NotFoundException {
        return ResponseEntity.ok(patientService.findById(id));
    }

    @PutMapping
    public ResponseEntity<?> updatePatient (@RequestBody PatientDTO patientDTO){
        patientService.update(patientDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable Long id) throws NotFoundException{
        patientService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Patient deleted successfully");
    }

    @GetMapping("/list")
    public ResponseEntity<Collection<PatientDTO>> listPatients() {
        return ResponseEntity.ok(patientService.getAll());
    }
}
