package com.dentalClinic.demo.login;

import com.dentalClinic.demo.entities.AppUser;
import com.dentalClinic.demo.entities.AppUserRoles;
import com.dentalClinic.demo.repository.IAppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private IAppUserRepository userRepository;

    @Autowired
    public void DataLoader(IAppUserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("password");
        String password2 = passwordEncoder.encode("password2");

        userRepository.save(new AppUser("Mica", "mica", "mica@dh.com", password, AppUserRoles.ROLE_ADMIN));
        userRepository.save(new AppUser("Henry", "henry", "henry@dh.com", password2, AppUserRoles.ROLE_USER));
    }
}
