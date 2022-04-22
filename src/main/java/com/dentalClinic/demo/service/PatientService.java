package com.dentalClinic.demo.service;

import com.dentalClinic.demo.entities.Patient;
import com.dentalClinic.demo.model.PatientDTO;
import com.dentalClinic.demo.repository.IPatientRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class PatientService implements IPatientService{

    @Autowired
    private IPatientRepository patientRepository;

    @Autowired
    ObjectMapper mapper;

    public void savePatient(PatientDTO patientDTO){
        Patient patient = mapper.convertValue(patientDTO,Patient.class);
        patientRepository.save(patient);
    }

    @Override
    public void create(PatientDTO patientDTO) {
        savePatient(patientDTO);
    }

    @Override
    public PatientDTO read(Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        PatientDTO patientDTO = null;
        if(patient.isPresent()){
            patientDTO = mapper.convertValue(patientDTO, PatientDTO.class);
        }
        return patientDTO;
    }

    @Override
    public void update(PatientDTO patientDTO) {
        savePatient(patientDTO);
    }

    @Override
    public void deleteById(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public Set<PatientDTO> findAll() {
        List<Patient> patients = patientRepository.findAll();
        Set<PatientDTO> patientDTO = new HashSet<>();
        for(Patient patient : patients){
            patientDTO.add(mapper.convertValue(patient, PatientDTO.class));
        }
        return patientDTO;
    }

    @Override
    public Patient findById(Long id) {
        Optional<Patient> foundAppointment = patientRepository.findById(id);
        return foundAppointment.orElse(null);
    }
}
