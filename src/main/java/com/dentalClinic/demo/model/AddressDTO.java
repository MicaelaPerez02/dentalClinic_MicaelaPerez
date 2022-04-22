package com.dentalClinic.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {

    private Long id;
    private String street;
    private String number;
    private String city;
    private String state;

    public AddressDTO() {
    }

    public AddressDTO(String street, String number, String city, String state) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.state = state;
    }

    public AddressDTO(Long id, String street, String number, String city, String state) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.city = city;
        this.state = state;
    }

}
