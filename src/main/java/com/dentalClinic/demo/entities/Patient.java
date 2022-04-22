package com.dentalClinic.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter

@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @SequenceGenerator(name="patient_sequence", sequenceName = "patient_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_sequence")
    private Long id;
    private String name;
    private String lastName;
    private Integer dni;
    private Date admissionDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Appointment> appointments = new HashSet<>();

    public Patient() {
    }

    public Patient(String name, String lastName, Integer dni, Date admissionDate, Address address, Set<Appointment> appointments) {
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.admissionDate = admissionDate;
        this.address = address;
        this.appointments = appointments;
    }

    public Patient(Long id, String name, String lastName, Integer dni, Date admissionDate, Address address, Set<Appointment> appointments) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.admissionDate = admissionDate;
        this.address = address;
        this.appointments = appointments;
    }
}
