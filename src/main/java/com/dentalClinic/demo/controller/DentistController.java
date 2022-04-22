package com.dentalClinic.demo.controller;

import com.dentalClinic.demo.model.DentistDTO;
import com.dentalClinic.demo.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dentist")
public class DentistController {
    private DentistService dentistService;

    @Autowired
    public void setDentistService (DentistService dentistService){
        this.dentistService = dentistService;
    }

    /*@GetMapping("/{id}")
    public ResponseEntity<DentistDTO> save(@RequestBody DentistDTO dentistDTO){
        return ResponseEntity.ok(dentistService.saveDentist(dentistDTO));
    }*/
}
