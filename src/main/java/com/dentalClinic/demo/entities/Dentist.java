package com.dentalClinic.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter

@Entity
@Table(name = "dentist")
public class Dentist {

    @Id
    @SequenceGenerator(name = "dentist_sequence", sequenceName = "dentist_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String lastName;
    private String license;

    @OneToMany(mappedBy = "dentist", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Appointment> appointments = new HashSet<>();

    public Dentist() {
    }

    public Dentist(String name, String lastName, String license, Set<Appointment> appointments) {
        this.name = name;
        this.lastName = lastName;
        this.license = license;
        this.appointments = appointments;
    }

    public Dentist(Long id, String name, String lastName, String license, Set<Appointment> appointments) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.license = license;
        this.appointments = appointments;
    }

}