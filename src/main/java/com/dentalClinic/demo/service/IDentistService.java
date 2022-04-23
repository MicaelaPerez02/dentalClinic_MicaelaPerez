package com.dentalClinic.demo.service;

import com.dentalClinic.demo.entities.Dentist;
import com.dentalClinic.demo.exceptions.NotFoundException;
import com.dentalClinic.demo.model.DentistDTO;
import java.util.Set;

public interface IDentistService {
    void save (DentistDTO dentistDTO);
    DentistDTO findById(Long id) throws NotFoundException;
    void update(DentistDTO dentistDTO);
    void deleteById (Long id) throws NotFoundException;

    Set<DentistDTO> getAll();
}
