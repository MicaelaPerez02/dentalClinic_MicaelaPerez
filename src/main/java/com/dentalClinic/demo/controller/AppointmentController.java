package com.dentalClinic.demo.controller;

import com.dentalClinic.demo.exceptions.NotFoundException;
import com.dentalClinic.demo.model.AppointmentDTO;
import com.dentalClinic.demo.model.PatientDTO;
import com.dentalClinic.demo.service.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    Date actualDate = new Date(System.currentTimeMillis());

    @Autowired
    IAppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<?> createAppointment (@RequestBody AppointmentDTO appointmentDTO)  {
        appointmentService.save(appointmentDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Appointment created successfully");
    }


    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDTO> findAppointmentById (@PathVariable Long id) throws NotFoundException{
        return ResponseEntity.ok(appointmentService.findById(id));
    }

    @PutMapping
    public ResponseEntity<?> updateAppointment (@RequestBody AppointmentDTO appointmentDTO){
        appointmentService.update(appointmentDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAppointment (@PathVariable Long id) throws NotFoundException {
        appointmentService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Appointment deleted successfully");
    }

    @GetMapping("/list")
    public ResponseEntity<Collection<AppointmentDTO>> listAppointments(){
        return ResponseEntity.ok(appointmentService.getAll());
    }

}
