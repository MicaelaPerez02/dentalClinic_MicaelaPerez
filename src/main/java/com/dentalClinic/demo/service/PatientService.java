package com.dentalClinic.demo.service;

import com.dentalClinic.demo.entities.Patient;
import com.dentalClinic.demo.exceptions.NotFoundException;
import com.dentalClinic.demo.model.PatientDTO;
import com.dentalClinic.demo.repository.IPatientRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PatientService implements IPatientService{

    @Autowired
    private IPatientRepository patientRepository;

    @Autowired
    ObjectMapper mapper;

    public PatientService(IPatientRepository patientRepository, ObjectMapper mapper) {
        this.patientRepository = patientRepository;
        this.mapper = mapper;
    }

    public void savePatient(PatientDTO patientDTO){
        Patient patient = mapper.convertValue(patientDTO,Patient.class);
        patientRepository.save(patient);
    }

    @Override
    public void save(PatientDTO patientDTO) {
        savePatient(patientDTO);
    }

    @Override
    public PatientDTO findById(Long id) throws NotFoundException {
        Optional<Patient> found = patientRepository.findById(id);
        if(found.isPresent())
            return mapper.convertValue(found, PatientDTO.class);
        else
            throw new NotFoundException("Patient Not Exist");
    }

    @Override
    public void update(PatientDTO patientDTO) {
        savePatient(patientDTO);
    }

    @Override
    public void deleteById(Long id) throws NotFoundException{
        Optional<Patient> found = patientRepository.findById(id);
        if (found.isPresent())
        patientRepository.deleteById(id);
        else
            throw new NotFoundException("Patient Not Exist");
    }

    @Override
    public Collection<PatientDTO> getAll() {
        List<Patient> allPatient = patientRepository.findAll();
        Set<PatientDTO> allPatientDto = new HashSet<PatientDTO>();
        for(Patient patient: allPatient)
            allPatientDto.add(mapper.convertValue(patient,PatientDTO.class));

        return allPatientDto;
    }

}
