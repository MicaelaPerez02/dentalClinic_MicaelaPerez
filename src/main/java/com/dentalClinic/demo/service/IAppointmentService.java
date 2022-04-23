package com.dentalClinic.demo.service;

import com.dentalClinic.demo.exceptions.NotFoundException;
import com.dentalClinic.demo.model.AppointmentDTO;
import java.util.Set;

public interface IAppointmentService {
    void save (AppointmentDTO appointmentDTO);
    AppointmentDTO findById(Long id) throws NotFoundException;
    void update(AppointmentDTO appointmentDTO) ;
    void deleteById (Long id) throws NotFoundException;

    Set<AppointmentDTO> getAll();
}
