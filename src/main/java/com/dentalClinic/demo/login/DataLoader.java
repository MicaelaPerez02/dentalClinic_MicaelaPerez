package com.dentalClinic.demo.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class DataLoader implements ApplicationRunner {

    private IUserRepository userRepository;

    @Autowired
    public void setUsuarioRepository(IUserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("password");
        String password2 = passwordEncoder.encode("password2");


        userRepository.save(new User("mica", "mica", "charli@dh.com", password, UserRoles.ROLE_ADMIN));
        userRepository.save(new User("leo", "leo", "jorgi@dh.com", password2, UserRoles.ROLE_USER));
    }
}
