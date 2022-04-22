package com.dentalClinic.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DentistDTO {
    private Long id;
    private String name;
    private String lastName;
    private String license;

    public DentistDTO() {
    }

    public DentistDTO(String name, String lastName, String license) {
        this.name = name;
        this.lastName = lastName;
        this.license = license;
    }

    public DentistDTO(Long id, String name, String lastName, String license) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.license = license;
    }
}
