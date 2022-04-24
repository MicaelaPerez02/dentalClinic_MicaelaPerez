package com.dentalClinic.demo.login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface IAppUserRepository extends JpaRepository<AppUser, Long>{

    Optional<AppUser> findByEmail(String email);
}
