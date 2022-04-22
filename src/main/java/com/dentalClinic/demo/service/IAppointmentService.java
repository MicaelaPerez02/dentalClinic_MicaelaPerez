package com.dentalClinic.demo.service;

import com.dentalClinic.demo.entities.Appointment;
import com.dentalClinic.demo.model.AppointmentDTO;
import java.util.Set;

public interface IAppointmentService {
    void create (AppointmentDTO appointmentDTO);
    AppointmentDTO read(Long id);
    void update(AppointmentDTO appointmentDTO);
    void deleteById (Long id);

    Set<AppointmentDTO> findAll();
    Appointment findById (Long id);
}
