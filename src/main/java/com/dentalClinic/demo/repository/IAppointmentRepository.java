package com.dentalClinic.demo.repository;

import com.dentalClinic.demo.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppointmentRepository extends JpaRepository<Appointment, Long> {
}
