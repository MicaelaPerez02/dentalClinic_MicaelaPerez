package com.dentalClinic.demo;

import com.dentalClinic.demo.exceptions.NotFoundException;
import com.dentalClinic.demo.model.DentistDTO;
import com.dentalClinic.demo.service.DentistService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class DentistTest {
        @Autowired
        private DentistService dentistService;

        @Test
        void createAndFindAllDentists(){
            DentistDTO dentistDTO = new DentistDTO("Micaela", "Perez", "1234");
            dentistService.save(dentistDTO);

            DentistDTO dentistDTO2 = new DentistDTO("Juan Roman", "Riquelme", "2345");
            dentistService.save(dentistDTO2);

            Assertions.assertNotNull(dentistService.getAll());
        }

    @Test
    void updateDentist(){
        DentistDTO dentistDTO = new DentistDTO("Juan Roman", "Riquelme", "2345");
        dentistService.save(dentistDTO);

        dentistDTO.setLastName("Luna");
        dentistService.update(dentistDTO);

        Assertions.assertTrue(dentistDTO.getLastName() == "Luna");
    }
}