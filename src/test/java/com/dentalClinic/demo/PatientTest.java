package com.dentalClinic.demo;

import com.dentalClinic.demo.entities.Address;

import com.dentalClinic.demo.exceptions.NotFoundException;
import com.dentalClinic.demo.model.AddressDTO;
import com.dentalClinic.demo.model.PatientDTO;
import com.dentalClinic.demo.service.AddressService;
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
    public class PatientTest {
        @Autowired
        private MockMvc mockMvc;
        @Autowired
        private PatientService patientService;
        @Autowired
        private AddressService addressService;

        @Autowired
        ObjectMapper mapper;

    @Test
    void createAndFindAllPatients(){
        PatientDTO patientDTO1 = new PatientDTO("Micaela", "Perez","43103114", new Date(2021,04,29),mapper.convertValue(new AddressDTO("Reconquista", "444", "GBA", "Buenos Aires"), Address.class));
        patientService.save(patientDTO1);

        PatientDTO patientDTO2 = new PatientDTO("Miley", "Cyrus","34456659", new Date(2018,9,11),mapper.convertValue(new AddressDTO("Av. 9 de Julio", "1234", "CABA", "Buenos Aires"), Address.class));
        patientService.save(patientDTO2);

        Assertions.assertNotNull(patientService.getAll());
    }

        @Test
        void deletePatient() throws NotFoundException {
            PatientDTO patientDTO1 = new PatientDTO(1L, "Micaela", "Perez","43103114", new Date(2021,04,29),mapper.convertValue(new AddressDTO("Reconquista", "444", "GBA", "Buenos Aires"), Address.class));
            patientService.save(patientDTO1);

            PatientDTO patientDTO2 = new PatientDTO(2L,"Miley", "Cyrus","34456659", new Date(2018,9,11),mapper.convertValue(new AddressDTO("Av. 9 de Julio", "1234", "CABA", "Buenos Aires"), Address.class));
            patientService.save(patientDTO2);

            patientService.deleteById(patientDTO2.getId());

            Assertions.assertThrows(NotFoundException.class, ()-> {patientService.findById(patientDTO2.getId());});
        }

    }
