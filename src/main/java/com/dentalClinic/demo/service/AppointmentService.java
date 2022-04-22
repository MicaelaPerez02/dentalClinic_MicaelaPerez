package com.dentalClinic.demo.service;

import com.dentalClinic.demo.entities.Appointment;
import com.dentalClinic.demo.model.AppointmentDTO;
import com.dentalClinic.demo.repository.IAppointmentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AppointmentService implements IAppointmentService{

    @Autowired
    private IAppointmentRepository appointmentRepository;

    @Autowired
    ObjectMapper mapper;

    public void saveAppointment(AppointmentDTO appointmentDTO){
        Appointment appointment = mapper.convertValue(appointmentDTO,Appointment.class);
        appointmentRepository.save(appointment);
    }

    @Override
    public void create(AppointmentDTO appointmentDTO) {
        saveAppointment(appointmentDTO);
    }

    @Override
    public AppointmentDTO read(Long id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        AppointmentDTO appointmentDTO = null;
        if(appointment.isPresent()){
            appointmentDTO = mapper.convertValue(appointmentDTO, AppointmentDTO.class);
        }
        return appointmentDTO;
    }

    @Override
    public void update(AppointmentDTO appointmentDTO) {
        saveAppointment(appointmentDTO);
    }

    @Override
    public void deleteById(Long id) {
        appointmentRepository.deleteById(id);
    }

    @Override
    public Set<AppointmentDTO> findAll() {
        List<Appointment> appointments = appointmentRepository.findAll();
        Set<AppointmentDTO> appointmentsDTO = new HashSet<>();
        for(Appointment appointment : appointments){
            appointmentsDTO.add(mapper.convertValue(appointment, AppointmentDTO.class));
        }
        return appointmentsDTO;
    }

    @Override
    public Appointment findById (Long id){
        Optional<Appointment> foundAppointment = appointmentRepository.findById(id);
        return foundAppointment.orElse(null);
    }

}
