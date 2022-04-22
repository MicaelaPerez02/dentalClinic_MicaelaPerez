package com.dentalClinic.demo.service;

import com.dentalClinic.demo.entities.Patient;
import com.dentalClinic.demo.model.PatientDTO;

import java.util.Set;

public interface IPatientService {
    void create (PatientDTO patientDTO);
    PatientDTO read(Long id);
    void update(PatientDTO patientDTO);
    void deleteById (Long id);

    Set<PatientDTO> findAll();
    Patient findById (Long id);
}
