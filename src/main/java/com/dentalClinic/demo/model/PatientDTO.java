package com.dentalClinic.demo.model;

import com.dentalClinic.demo.entities.Address;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PatientDTO {
    private Long id;
    private String name;
    private String lastName;
    private String dni;
    private Date admissionDate;
    private Address address;

    public PatientDTO() {
    }

    public PatientDTO(String name, String lastName, String dni, Date admissionDate, Address address) {
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.admissionDate = admissionDate;
        this.address = address;
    }

    public PatientDTO(Long id, String name, String lastName, String dni, Date admissionDate, Address address) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.admissionDate = admissionDate;
        this.address = address;
    }

}
