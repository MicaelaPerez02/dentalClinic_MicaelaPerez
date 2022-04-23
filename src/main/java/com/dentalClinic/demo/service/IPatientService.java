package com.dentalClinic.demo.service;

import com.dentalClinic.demo.exceptions.NotFoundException;
import com.dentalClinic.demo.model.PatientDTO;

import java.util.Collection;

public interface IPatientService {
    void save (PatientDTO patientDTO);
    PatientDTO findById(Long id) throws NotFoundException;
    void update(PatientDTO patientDTO);
    void deleteById (Long id) throws NotFoundException;

    Collection<PatientDTO> getAll();
}
