package com.dentalClinic.demo;

import com.dentalClinic.demo.entities.Address;
import com.dentalClinic.demo.entities.Dentist;
import com.dentalClinic.demo.entities.Patient;
import com.dentalClinic.demo.exceptions.NotFoundException;
import com.dentalClinic.demo.model.AddressDTO;
import com.dentalClinic.demo.model.AppointmentDTO;
import com.dentalClinic.demo.model.DentistDTO;
import com.dentalClinic.demo.model.PatientDTO;
import com.dentalClinic.demo.service.AppointmentService;
import com.dentalClinic.demo.service.DentistService;
import com.dentalClinic.demo.service.PatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
class AppointmentTest {

    private AppointmentService appointmentService;

    @Autowired
    public void setTurnoService(AppointmentService appointmentService){
        this.appointmentService = appointmentService;
    }

    private PatientService patientService;
    @Autowired
    public void setPacienteService(PatientService patientService){
        this.patientService = patientService;
    }

    private DentistService dentistService;
    @Autowired
    public void setOdontologoService(DentistService dentistService){
        this.dentistService= dentistService;
    }

    @Autowired
    ObjectMapper mapper;

    @Autowired
    private MockMvc mockMvc;
/*
    @Test
    void addAndFindAppointment() throws NotFoundException {

        PatientDTO patientDTO1 = new PatientDTO(1L,"Micaela", "Perez","43103114", new Date(2021,04,29),mapper.convertValue(new AddressDTO("Reconquista", "444", "GBA", "Buenos Aires"), Address.class));
        patientService.save(patientDTO1);

        DentistDTO dentistDTO = new DentistDTO(1L,"Juan Roman", "Riquelme", "2345");
        dentistService.save(dentistDTO);

        AppointmentDTO appointmentDTO = new AppointmentDTO(1L, mapper.convertValue(patientDTO1, Patient.class), mapper.convertValue(dentistDTO, Dentist.class), new Date(2022,05,10));
        appointmentService.save(appointmentDTO);

        Assertions.assertTrue(appointmentService.findById(appointmentDTO.getId()) != null);
    }*/
}