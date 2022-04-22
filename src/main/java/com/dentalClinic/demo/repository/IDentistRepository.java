package com.dentalClinic.demo.repository;

import com.dentalClinic.demo.entities.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDentistRepository extends JpaRepository<Dentist, Long> {
}
