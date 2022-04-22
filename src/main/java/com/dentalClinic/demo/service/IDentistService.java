package com.dentalClinic.demo.service;

import com.dentalClinic.demo.entities.Dentist;
import com.dentalClinic.demo.model.DentistDTO;
import java.util.Set;

public interface IDentistService {
    void create (DentistDTO dentistDTO);
    DentistDTO read(Long id);
    void update(DentistDTO dentistDTO);
    void deleteById (Long id);

    Set<DentistDTO> findAll();
    Dentist findById (Long id);
}
