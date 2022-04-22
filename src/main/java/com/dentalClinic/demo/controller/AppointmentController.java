package com.dentalClinic.demo.controller;

import com.dentalClinic.demo.model.AppointmentDTO;
import com.dentalClinic.demo.service.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    IAppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<?> createAppointment (@RequestBody AppointmentDTO appointmentDTO){
        appointmentService.create(appointmentDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public AppointmentDTO findAppointmentById (@PathVariable Long id){
        return appointmentService.read(id);
    }

    @PutMapping
    public ResponseEntity<?> updateAppointment (@RequestBody AppointmentDTO appointmentDTO){
        appointmentService.update(appointmentDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAppointment (@PathVariable Long id){
        appointmentService.deleteById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<Collection<AppointmentDTO>> listAppointments(){
        return ResponseEntity.ok(appointmentService.getAll());
    }

}
