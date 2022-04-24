package com.dentalClinic.demo.repository;

import com.dentalClinic.demo.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface IAppUserRepository extends JpaRepository<AppUser, Long>{

    Optional<AppUser> findByEmail(String email);
}
