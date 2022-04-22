package com.dentalClinic.demo.service;

import com.dentalClinic.demo.entities.Patient;
import com.dentalClinic.demo.model.PatientDTO;

import java.util.Collection;
import java.util.Set;

public interface IPatientService {
    void create (PatientDTO patientDTO);
    PatientDTO read(Long id) throws Exception;
    void update(PatientDTO patientDTO);
    void deleteById (Long id);

    Collection<PatientDTO> getAll();
}
