package com.dentalClinic.demo.model;

import com.dentalClinic.demo.entities.Dentist;
import com.dentalClinic.demo.entities.Patient;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AppointmentDTO {

    private Long id;
    private Patient patient;
    private Dentist dentist;
    private Date date;

    public AppointmentDTO() {
    }

    public AppointmentDTO(Patient patient, Dentist dentist, Date date) {
        this.patient = patient;
        this.dentist = dentist;
        this.date = date;
    }

    public AppointmentDTO(Long id, Patient patient, Dentist dentist, Date date) {
        this.id = id;
        this.patient = patient;
        this.dentist = dentist;
        this.date = date;
    }

}
