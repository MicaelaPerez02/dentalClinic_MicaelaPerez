package com.dentalClinic.demo.service;

import com.dentalClinic.demo.entities.Dentist;
import com.dentalClinic.demo.model.DentistDTO;
import com.dentalClinic.demo.repository.IDentistRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DentistService implements IDentistService {

    @Autowired
    private IDentistRepository dentistRepository;

    @Autowired
    ObjectMapper mapper;

    public DentistService(IDentistRepository dentistRepository, ObjectMapper mapper) {
        this.dentistRepository = dentistRepository;
        this.mapper = mapper;
    }

    public void saveDentist (DentistDTO dentistDTO) {
        Dentist dentist = mapper.convertValue(dentistDTO, Dentist.class);
        dentistRepository.save(dentist);
    }

    @Override
    public void create(DentistDTO dentistDTO) {
        saveDentist(dentistDTO);
    }

    @Override
    public DentistDTO read(Long id) {
        Optional<Dentist> dentist = dentistRepository.findById(id);

        DentistDTO dentistDTO = null;
        if (dentist.isPresent())
            dentistDTO = mapper.convertValue(dentist, DentistDTO.class);

        return dentistDTO;
    }

    @Override
    public void update(DentistDTO dentistDTO) {
        saveDentist(dentistDTO);
    }

    @Override
    public void deleteById (Long id) {
        dentistRepository.deleteById(id);
    }

    @Override
    public Set<DentistDTO> getAll() {
        List<Dentist> dentists = dentistRepository.findAll();
        Set<DentistDTO> dentistDTO = new HashSet<>();

        for (Dentist dentist : dentists)
            dentistDTO.add(mapper.convertValue(dentist, DentistDTO.class));

        return dentistDTO;
    }
}
