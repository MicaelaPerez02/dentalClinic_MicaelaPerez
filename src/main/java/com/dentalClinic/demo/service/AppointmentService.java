package com.dentalClinic.demo.service;

import com.dentalClinic.demo.entities.Appointment;
import com.dentalClinic.demo.entities.Patient;
import com.dentalClinic.demo.exceptions.NotFoundException;
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

    public AppointmentService(IAppointmentRepository appointmentRepository, ObjectMapper mapper) {
        this.appointmentRepository = appointmentRepository;
        this.mapper = mapper;
    }

    public void saveAppointment(AppointmentDTO appointmentDTO){
        Appointment appointment = mapper.convertValue(appointmentDTO,Appointment.class);
        appointmentRepository.save(appointment);
    }

    @Override
    public void save(AppointmentDTO appointmentDTO) {
        saveAppointment(appointmentDTO);
    }

    @Override
    public AppointmentDTO findById(Long id) throws NotFoundException {
        Optional<Appointment> found = appointmentRepository.findById(id);
        if(found.isPresent()){
            return  mapper.convertValue(found, AppointmentDTO.class);
        }
        else throw new NotFoundException("Appointment Not Exist");
    }

    @Override
    public void update(AppointmentDTO appointmentDTO) {
        saveAppointment(appointmentDTO);
    }

    @Override
    public void deleteById(Long id) throws NotFoundException{
        Optional<Appointment> found = appointmentRepository.findById(id);
        if (found.isPresent())
            appointmentRepository.deleteById(id);
        else
            throw new NotFoundException("Appointment Not Exist");
    }

    @Override
    public Set<AppointmentDTO> getAll() {
        List<Appointment> appointments = appointmentRepository.findAll();
        Set<AppointmentDTO> appointmentsDTO = new HashSet<>();
        for(Appointment appointment : appointments){
            appointmentsDTO.add(mapper.convertValue(appointment, AppointmentDTO.class));
        }
        return appointmentsDTO;
    }


}
