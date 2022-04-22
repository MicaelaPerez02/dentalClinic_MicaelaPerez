package com.dentalClinic.demo.controller;

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
        patientService.create(patientDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public PatientDTO findPatientById (@PathVariable Long id) throws Exception {
        return patientService.read(id);
    }

    @PutMapping
    public ResponseEntity<?> updatePatient (@RequestBody PatientDTO patientDTO){
        patientService.update(patientDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removePatient(@PathVariable Long id){
        patientService.deleteById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<Collection<PatientDTO>> listPatients() {
        return ResponseEntity.ok(patientService.getAll());
    }
}
