package com.dentalClinic.demo.repository;

import com.dentalClinic.demo.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPatientRepository extends JpaRepository<Patient, Long> {
}
