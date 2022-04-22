package com.dentalClinic.demo.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter

@Entity
@Table(name="appointment")
public class Appointment {

    @Id
    @SequenceGenerator(name="appointment_sequence", sequenceName = "appointment_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_sequence")
    private Long id;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "dentist_id", nullable = false)
    private Dentist dentist;

    public Appointment() {
    }

    public Appointment(Date date, Patient patient, Dentist dentist) {
        this.date = date;
        this.patient = patient;
        this.dentist = dentist;
    }

    public Appointment(Long id, Date date, Patient patient, Dentist dentist) {
        this.id = id;
        this.date = date;
        this.patient = patient;
        this.dentist = dentist;
    }
}
